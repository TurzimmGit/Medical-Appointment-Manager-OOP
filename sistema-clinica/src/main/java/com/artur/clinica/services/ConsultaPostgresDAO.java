package com.artur.clinica.services;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.artur.clinica.exception.ExcecoesProjeto;
import com.artur.clinica.exception.ExcecoesProjeto.ElementoNaoEncontradoException;
import com.artur.clinica.exception.ExcecoesProjeto.ErroBancoDadosException;
import com.artur.clinica.model.Cirurgia;
import com.artur.clinica.model.Consulta;
import com.artur.clinica.model.ConsultaClinica;
import com.artur.clinica.model.Medico;
import com.artur.clinica.model.Paciente;

public class ConsultaPostgresDAO {
    
    private boolean temConflito(LocalDate DataR, LocalTime horarioR, int idDaConsultaSendoAlterada, String crmMedico){
        String sql = "SELECT Horario FROM consulta WHERE Data = ? AND CRM= ? AND IDConsulta <> ?";

        try(Connection conn = ConexaoBanco.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setDate(1,Date.valueOf(DataR));
            stmt.setString(2,crmMedico);
            stmt.setInt(3,idDaConsultaSendoAlterada);

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    LocalTime horarioExistente = rs.getTime("Horario").toLocalTime();
                    long diferenca = Math.abs(Duration.between(horarioExistente, horarioR).toMinutes());

                    if (diferenca<30){
                        return true;
                    }
                }
            }
        }catch(SQLException e){
            throw new ErroBancoDadosException("Erro ao verificar conflito de horário:" + e.getMessage());
        }
        return false;
    }

    public void cadastrar(Consulta c){

        if(temConflito(c.getData(), c.getHorario(), 0, c.getMedico().getCrm())){
            throw new ExcecoesProjeto.ConflitoHorarioException("O médico:"+c.getMedico().getNome()+ "já possui uma consulta nesse horário/intervalo!");
        }

        String sqlConsulta = "INSERT INTO consulta(Data,Horario,CPF, CRM) VALUES (?,?,?,?) RETURNING IDConsulta";
        try(Connection conn = ConexaoBanco.conectar()){
            conn.setAutoCommit(false);

            int idGerado=0;
            try(PreparedStatement stmtC = conn.prepareStatement(sqlConsulta)){
                stmtC.setDate(1, Date.valueOf(c.getData()));
                stmtC.setTime(2, Time.valueOf(c.getHorario()));
                stmtC.setString(3,c.getPaciente().getCpf());
                stmtC.setString(4,c.getMedico().getCrm());

                try(ResultSet rs = stmtC.executeQuery()){
                    if(rs.next()) idGerado = rs.getInt(1);
                }
                if(c instanceof ConsultaClinica){
                    ConsultaClinica cc = (ConsultaClinica) c;
                    
                    String sqlTicket = "SELECT nextval('seq_consulta_clinica')";
                    String ticketFormatado = "";
                    
                    try(Statement stmtT = conn.createStatement(); ResultSet rsT = stmtT.executeQuery(sqlTicket)){
                        if(rsT.next()){
                            ticketFormatado = String.format("CC-%04d",rsT.getInt(1));
                        }
                    }
                    String sqlFilha = "INSERT INTO consulta_clinica(IDConsulta, CodTicket, TipoConsulta) VALUES(?, ?, ?)";
                    try(PreparedStatement stmtF = conn.prepareStatement(sqlFilha)){
                        stmtF.setInt(1,idGerado);
                        stmtF.setString(2,ticketFormatado);
                        stmtF.setString(3,cc.getTipoConsulta());
                        stmtF.executeUpdate();
                    }
                }
                else if(c instanceof Cirurgia){
                    Cirurgia cir = (Cirurgia) c;
                    String sqlTicket = "SELECT nextval('seq_cirurgia')";
                    String ticketFormatado = "";

                    try(Statement stmtT = conn.createStatement(); ResultSet rsT = stmtT.executeQuery(sqlTicket)){
                        if(rsT.next()){
                            ticketFormatado = String.format("CR-%04d",rsT.getInt(1));
                        }
                    }

                    String sqlFilha = "INSERT INTO cirurgia(IDConsulta, CodTicket, TipoAnestesia, TipoCirurgia) VALUES (?,?,?,?)";
                    try(PreparedStatement stmtF = conn.prepareStatement(sqlFilha)){
                        stmtF.setInt(1,idGerado);
                        stmtF.setString(2,ticketFormatado);
                        stmtF.setString(3,cir.getTipoAnestesia());
                        stmtF.setString(4,cir.getTipoCirurgia());
                        stmtF.executeUpdate();
                    }
                }
                conn.commit();
                System.out.println("Consulta Cadastrada com Sucesso!");
            }catch(SQLException e){
                conn.rollback();
                throw new ErroBancoDadosException("Falha ao Salvar Consulta:"+ e.getMessage());
            }
        }catch(SQLException e){
            throw new ErroBancoDadosException("Erro de conexão:"+ e.getMessage());
        }
    }

    public void cadastrarPaciente(Paciente p){
        String sqlPessoa = "INSERT INTO pessoa(Nome) VALUES (?) RETURNING IDPessoa";
        String sqlPaciente = "INSERT INTO paciente(IDPessoa,CPF,TipoSanguineo,data_nascimento) VALUES(?,?,?,?)";
        String sqlAlergias = "INSERT INTO alergias(IDPessoa,Alergias) VALUES(?,?) ON CONFLICT DO NOTHING";

        try(Connection conn = ConexaoBanco.conectar()){
            conn.setAutoCommit(false);
            int idPessoaGerado =0;

            try(PreparedStatement stmtP = conn.prepareStatement(sqlPessoa)){
                stmtP.setString(1,p.getNome());
                try(ResultSet rs = stmtP.executeQuery()){
                    if(rs.next()) idPessoaGerado = rs.getInt(1);
                }
            }

            try(PreparedStatement stmtPac = conn.prepareStatement(sqlPaciente)){
                stmtPac.setInt(1, idPessoaGerado);
            stmtPac.setString(2, p.getCpf());
            stmtPac.setString(3, p.getTipoSanguineo());
            stmtPac.setDate(4, Date.valueOf(p.getDataNascimento()));
            stmtPac.executeUpdate();
            }

            if(!p.getAlergias().equals("Nenhuma")){
                try(PreparedStatement stmtAle = conn.prepareStatement(sqlAlergias)){
                    stmtAle.setInt(1, idPessoaGerado);
                    stmtAle.setString(2, p.getAlergias());
                    stmtAle.executeUpdate();
                }

            }
            conn.commit();
            System.out.println("Paciente cadastrado com sucesso no banco!");
        }catch (SQLException e) {
            throw new ErroBancoDadosException("Erro ao salvar paciente: " + e.getMessage());
        }
    }
    
    public void remover(int id){
        String sql = "DELETE FROM consulta WHERE IDConsulta = ?";

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

                stmt.setInt(1,id);
                int linhasAfetadas = stmt.executeUpdate();

                if(linhasAfetadas == 0){
                    throw new ElementoNaoEncontradoException("Nenhuma consulta Encontrada com ID: "+id);
                }
                System.out.println("Consulta Removida com Sucesso!");
            }catch(SQLException e){
                throw new ErroBancoDadosException("Erro ao deletar Consulta:"+ e.getMessage());
            }
    }

    public void atualizar(Consulta c){
        
        if(temConflito(c.getData(), c.getHorario(), 0, c.getMedico().getCrm())){
            throw new ExcecoesProjeto.ConflitoHorarioException("Não é possível remarcar: o médico já tem compromisso neste horário!");
        }

        String sql = "UPDATE consulta SET Data = ?, Horario = ? WHERE IDConsulta = ? ";

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setDate(1,Date.valueOf(c.getData()));
                stmt.setTime(2,Time.valueOf(c.getHorario()));
                stmt.setInt(3,c.getidConsulta());
                
                int linhas = stmt.executeUpdate();

                if(linhas==0){
                    throw new ElementoNaoEncontradoException("Nenhuma consulta Encontrada com ID "+c.getidConsulta()+"para ser atulizada!");
                }
                System.out.println("Consulta remarcada com sucesso!");

            }catch(SQLException e){
                throw new ErroBancoDadosException("Erro ao atulizar Consulta:"+ e.getMessage());
            }
    }
    
    public void cadastrarMedico(Medico m) {
        String sqlPessoa = "INSERT INTO pessoa (Nome) VALUES (?) RETURNING IDPessoa";
        String sqlMedico = "INSERT INTO medico (IDPessoa, CRM, Especialidade) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBanco.conectar()) {
            conn.setAutoCommit(false);
            int idPessoaGerado = 0;

            try (PreparedStatement stmtP = conn.prepareStatement(sqlPessoa)) {
                stmtP.setString(1, m.getNome());
                try (ResultSet rs = stmtP.executeQuery()) {
                    if (rs.next()) idPessoaGerado = rs.getInt(1);
                }
            }

            try (PreparedStatement stmtMed = conn.prepareStatement(sqlMedico)) {
                stmtMed.setInt(1, idPessoaGerado);
                stmtMed.setString(2, m.getCrm());
                stmtMed.setString(3, m.getEspecialidade());
                stmtMed.executeUpdate();
            }

            conn.commit();
            System.out.println("Médico cadastrado com sucesso no banco!");
        }catch (SQLException e) {
            throw new ErroBancoDadosException("Erro ao salvar médico: " + e.getMessage());
        }
    }
    
    public List<Consulta> buscarPorNomePaciente(String nomeBusca) { 
        List<Consulta> consultasFound = new ArrayList<>();

        String sql = """
                SELECT c.IDConsulta, c.Data, c.Horario,
                    pes_p.Nome AS NomePaciente, p.CPF AS CPFPaciente, p.TipoSanguineo, p.data_nascimento AS DataNascimento,
                    pes_m.Nome AS NomeMedico, m.CRM, m.Especialidade,
                    cc.CodTicket AS TicketClinica, cc.TipoConsulta,
                    cir.CodTicket AS TicketCirurgia, cir.TipoAnestesia, cir.TipoCirurgia,
                    (SELECT string_agg(Alergias, ', ') FROM alergias WHERE IDPessoa = p.IDPessoa) AS Alergias
                FROM consulta c
                INNER JOIN paciente p ON c.CPF = p.CPF
                INNER JOIN pessoa pes_p ON p.IDPessoa = pes_p.IDPessoa
                INNER JOIN medico m ON c.CRM = m.CRM
                INNER JOIN pessoa pes_m ON m.IDPessoa = pes_m.IDPessoa
                LEFT JOIN consulta_clinica cc ON c.IDConsulta = cc.IDConsulta
                LEFT JOIN cirurgia cir ON c.IDConsulta = cir.IDConsulta
                WHERE UPPER(pes_p.Nome) LIKE UPPER(?)
                ORDER BY c.Data, c.Horario
                """;

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,"%"+nomeBusca+"%");

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){

                    java.time.format.DateTimeFormatter fmtBr = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataNascBr = rs.getDate("DataNascimento").toLocalDate().format(fmtBr);
                    Paciente pac = new Paciente(
                    rs.getString("NomePaciente"), rs.getString("CPFPaciente"),
                    rs.getString("TipoSanguineo"), dataNascBr,
                    rs.getString("Alergias")
                    );

                    Medico med = new Medico(
                    rs.getString("NomeMedico"),
                    rs.getString("CRM"), 
                    rs.getString("Especialidade")
                    );

                    int idConsulta = rs.getInt("IDConsulta");

                    java.time.format.DateTimeFormatter fmtBrConsulta = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataBr = rs.getDate("Data").toLocalDate().format(fmtBrConsulta);
                    String horario = rs.getTime("Horario").toLocalTime().toString();

                    if(rs.getString("TicketClinica")!=null){
                        ConsultaClinica cc = new ConsultaClinica(
                            rs.getString("TicketClinica"),
                            pac,
                            dataBr,
                            horario,
                            med, 
                            rs.getString("TipoConsulta")
                            );
                                
                            cc.setidConsulta(idConsulta);
                            consultasFound.add(cc);
                    }else if(rs.getString("TicketCirurgia")!=null){
                        Cirurgia cir = new Cirurgia(
                            rs.getString("TicketCirurgia"),
                            pac, dataBr, horario, med,
                            rs.getString("TipoCirurgia"),
                            rs.getString("TipoAnestesia")
                            );
                        cir.setidConsulta(idConsulta);
                        consultasFound.add(cir);
                    }
                }
            }
        }catch(SQLException e){
            throw new ErroBancoDadosException("Erro ao buscar consultas por nome: " + e.getMessage());
        }
        return consultasFound;
    }
    public List<Consulta> listarTodas() {
        List<Consulta> todas = new ArrayList<>();

        String sql = """
                SELECT c.IDConsulta, c.Data, c.Horario,
                    pes_p.Nome AS NomePaciente, p.CPF AS CPFPaciente, p.TipoSanguineo, p.data_nascimento AS DataNascimento,
                    pes_m.Nome AS NomeMedico, m.CRM, m.Especialidade,
                    cc.CodTicket AS TicketClinica, cc.TipoConsulta,
                    cir.CodTicket AS TicketCirurgia, cir.TipoAnestesia, cir.TipoCirurgia,
                    (SELECT string_agg(Alergias, ', ') FROM alergias WHERE IDPessoa = p.IDPessoa) AS Alergias
                FROM consulta c
                INNER JOIN paciente p ON c.CPF = p.CPF
                INNER JOIN pessoa pes_p ON p.IDPessoa = pes_p.IDPessoa
                INNER JOIN medico m ON c.CRM = m.CRM
                INNER JOIN pessoa pes_m ON m.IDPessoa = pes_m.IDPessoa
                LEFT JOIN consulta_clinica cc ON c.IDConsulta = cc.IDConsulta
                LEFT JOIN cirurgia cir ON c.IDConsulta = cir.IDConsulta
                ORDER BY c.Data, c.Horario
                """;

        try(Connection conn = ConexaoBanco.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {

                    java.time.format.DateTimeFormatter fmtBr = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataNascBr = rs.getDate("DataNascimento").toLocalDate().format(fmtBr);
                Paciente pac = new Paciente(
                    rs.getString("NomePaciente"), rs.getString("CPFPaciente"),
                    rs.getString("TipoSanguineo"), dataNascBr,
                    rs.getString("Alergias")
                );

                Medico med = new Medico(rs.getString("NomeMedico"), rs.getString("CRM"), rs.getString("Especialidade"));
                
                int idConsulta = rs.getInt("IDConsulta");

                java.time.format.DateTimeFormatter fmtBrConsulta = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataBr = rs.getDate("Data").toLocalDate().format(fmtBrConsulta);
                String horario = rs.getTime("Horario").toLocalTime().toString();

                if (rs.getString("TicketClinica") != null) {
                    ConsultaClinica cc = new ConsultaClinica(rs.getString("TicketClinica"),pac, dataBr, horario, med, rs.getString("TipoConsulta"));
                    cc.setidConsulta(idConsulta);
                    todas.add(cc);
                } else if (rs.getString("TicketCirurgia") != null) {
                    Cirurgia cir = new Cirurgia(rs.getString("TicketCirurgia"),pac, dataBr, horario, med, rs.getString("TipoAnestesia"), rs.getString("TipoCirurgia"));
                    cir.setidConsulta(idConsulta);
                    todas.add(cir);
                }
            }
            }catch(SQLException e){
                throw new RuntimeException("Erro ao listar todas as consultas: " + e.getMessage(), e);
            }
            return todas;
    }
}
