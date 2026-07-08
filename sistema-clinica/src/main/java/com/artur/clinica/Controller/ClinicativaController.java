package com.artur.clinica.Controller;

import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import com.artur.clinica.exception.ExcecoesProjeto.ConflitoHorarioException;
import com.artur.clinica.exception.ExcecoesProjeto.DadosInvalidosException;
import com.artur.clinica.exception.ExcecoesProjeto.ErroBancoDadosException;
import com.artur.clinica.model.Cirurgia;
import com.artur.clinica.model.ConsultaClinica;
import com.artur.clinica.model.Medico;
import com.artur.clinica.model.Paciente;
import com.artur.clinica.services.ConsultaPostgresDAO;


public class ClinicativaController {
    
    private static final ConsultaPostgresDAO dao = new ConsultaPostgresDAO();

    public static boolean processarCadastroPaciente(Component telaPai, String nome, String cpf, String dataNasc, String tipoSanguineo, String alergias){
        
        try{
            if(!textoEvalido(nome)){
                throw new DadosInvalidosException("O campo 'Nome do Paciente' é obrigatório!");
            }

            if(cpf == null || cpf.trim().isEmpty()){
                throw new DadosInvalidosException("O campo 'CPF' é obrigatório!");
            }

            if(dataNasc == null || dataNasc.trim().isEmpty()){
                throw  new DadosInvalidosException("O campo 'Data de Nascimento' é obrigatório!");
            }

            if(tipoSanguineo == null || tipoSanguineo.trim().isEmpty()){
                throw new DadosInvalidosException("Por favor, selecione um 'Tipo Sanguíneo' válido!");
            }

            if (alergias == null 
            || alergias.trim().isEmpty() 
            || alergias.equals("Digite as Alergias do Paciente se tiver")) {
            
            alergias = "Nenhuma";
            }
            
            Paciente novoPaciente = new Paciente(nome, cpf, tipoSanguineo, dataNasc, alergias);

            dao.cadastrarPaciente(novoPaciente);

            JOptionPane.showMessageDialog(telaPai, "Paciente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            com.artur.clinica.view.MainFrame main = (com.artur.clinica.view.MainFrame) javax.swing.SwingUtilities.getWindowAncestor(telaPai);
            if (main != null) {
                main.atualizarEstadoMenuAgendamentos();
            }

            return true;
        }catch(DadosInvalidosException e){
            JOptionPane.showMessageDialog(telaPai, e.getMessage(), "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (ErroBancoDadosException e) {
            JOptionPane.showMessageDialog(telaPai, "Erro no Postgres:\n" + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaPai, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public static boolean processarCadastroMedico(Component telaPai, String nome, String crm, String especialidades){
        try{
            if(!textoEvalido(nome)){
                throw new DadosInvalidosException("O campo 'Nome do Médico' é obrigatório!");
            }

            if(crm == null || crm.trim().isEmpty()){
                throw new DadosInvalidosException("O campo 'CRM' é obrigatório!");
            }

            if(!textoEvalido(especialidades)){
                throw  new DadosInvalidosException("O campo 'especialidade' é obrigatório!");
            }

            Medico novoMedico = new Medico(nome, crm, especialidades);

            dao.cadastrarMedico(novoMedico);

            JOptionPane.showMessageDialog(telaPai, "Médico cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            com.artur.clinica.view.MainFrame main = (com.artur.clinica.view.MainFrame) javax.swing.SwingUtilities.getWindowAncestor(telaPai);
            if (main != null) {
                main.atualizarEstadoMenuAgendamentos();
            }

            return true;
        }catch(DadosInvalidosException e){
            JOptionPane.showMessageDialog(telaPai, e.getMessage(), "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (ErroBancoDadosException e) {
            JOptionPane.showMessageDialog(telaPai, "Erro no Postgres:\n" + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaPai, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static boolean processarCadastroConsulta(Component telaPai, String cpfPaciente, Object medicoSelecionado, String data, String horario, String tipoConsulta){
        try{
            if (cpfPaciente == null || cpfPaciente.trim().isEmpty()) {
                throw new DadosInvalidosException("O campo 'CPF' é obrigatório para localizar o paciente.");
            }

            if (medicoSelecionado == null || medicoSelecionado instanceof String) {
                throw new DadosInvalidosException("Por favor, selecione um médico válido da lista.");
            }
            if (data == null || data.trim().isEmpty()) {
                throw new DadosInvalidosException("O campo 'Data' é obrigatório.");
            }
            if (horario == null || horario.trim().isEmpty()) {
                throw new DadosInvalidosException("O campo 'Horário' é obrigatório.");
            }
            if (tipoConsulta == null || tipoConsulta.equals("Selecione...")) {
                throw new DadosInvalidosException("Selecione o tipo da consulta (Particular/Conveniado).");
            }

            Paciente pac = dao.buscarPorCpf(cpfPaciente);
            if (pac == null) {
                throw new DadosInvalidosException("Nenhum paciente encontrado com o CPF informado! Cadastre o paciente primeiro.");
            }

            Medico med = (Medico) medicoSelecionado;

            ConsultaClinica novaConsulta = new ConsultaClinica(null, pac, data, horario, med, tipoConsulta);

            dao.cadastrar(novaConsulta);

            JOptionPane.showMessageDialog(telaPai, "Consulta agendada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch (DadosInvalidosException | ConflitoHorarioException e) {
        JOptionPane.showMessageDialog(telaPai, e.getMessage(), "Validação", JOptionPane.WARNING_MESSAGE);
        return false;
        } catch (ErroBancoDadosException e) {
            JOptionPane.showMessageDialog(telaPai, "Erro de Banco:\n" + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaPai, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean processarCadastroCirurgia(Component telaPai, String cpfPaciente, Object medicoSelecionado, String data, String horario, String tipoAnestesia ,String tipoCirurgia){
        try{
            if (cpfPaciente == null || cpfPaciente.trim().isEmpty()) {
                throw new DadosInvalidosException("O campo 'CPF' é obrigatório para localizar o paciente.");
            }
            if (medicoSelecionado == null || medicoSelecionado instanceof String) {
                throw new DadosInvalidosException("Por favor, selecione um médico válido da lista.");
            }
            if (data == null || data.trim().isEmpty()) {
                throw new DadosInvalidosException("O campo 'Data' é obrigatório.");
            }
            if (horario == null || horario.trim().isEmpty()) {
                throw new DadosInvalidosException("O campo 'Horário' é obrigatório.");
            }
            if (tipoAnestesia == null || tipoAnestesia.equals("Selecione...")) {
                throw new DadosInvalidosException("Selecione o tipo da consulta (Geral/Local).");
            }

            if (tipoCirurgia == null || tipoCirurgia.equals("Selecione...")) {
                throw new DadosInvalidosException("O campo 'Tipo Cirurgia' é obrigatório.");
            }

            Paciente pac = dao.buscarPorCpf(cpfPaciente);
            if (pac == null) {
                throw new DadosInvalidosException("Nenhum paciente encontrado com o CPF informado! Cadastre o paciente primeiro.");
            }

            Medico med = (Medico) medicoSelecionado;

            Cirurgia novaCirurgia = new Cirurgia(null, pac, data, horario, med, tipoAnestesia, tipoCirurgia);

            dao.cadastrar(novaCirurgia);

            JOptionPane.showMessageDialog(telaPai, "Consulta agendada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch (DadosInvalidosException | ConflitoHorarioException e) {
        JOptionPane.showMessageDialog(telaPai, e.getMessage(), "Validação", JOptionPane.WARNING_MESSAGE);
        return false;
        } catch (ErroBancoDadosException e) {
            JOptionPane.showMessageDialog(telaPai, "Erro de Banco:\n" + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaPai, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean processarAlteracaoConsulta(Component telaPai, String ticket, String dataStr, String horaStr, Object medObj, String tipoConsulta) {
        try {
            if (medObj == null || medObj instanceof String) throw new DadosInvalidosException("Selecione um médico válido.");
            
            LocalDate data = com.artur.clinica.model.Consulta.validarEConverterData(dataStr);
            LocalTime hora = com.artur.clinica.model.Consulta.validarEconverterHora(horaStr);
            String crm = ((com.artur.clinica.model.Medico) medObj).getCrm();
            
            dao.atualizarConsultaClinicaPorTicket(ticket, data, hora, crm, tipoConsulta);
            JOptionPane.showMessageDialog(telaPai, "Consulta alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaPai, e.getMessage(), "Erro na Alteração", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean processarAlteracaoCirurgia(Component telaPai, String ticket, String dataStr, String horaStr, Object medObj, String anestesia, String tipoCirurgia) {
        try {
            if (medObj == null || medObj instanceof String) throw new DadosInvalidosException("Selecione um médico válido.");
            if (tipoCirurgia.trim().isEmpty() || tipoCirurgia.equals("Digite o tipo da Cirurgia...")) throw new DadosInvalidosException("Informe o tipo da cirurgia.");
            
            LocalDate data = com.artur.clinica.model.Consulta.validarEConverterData(dataStr);
            LocalTime hora = com.artur.clinica.model.Consulta.validarEconverterHora(horaStr);
            String crm = ((com.artur.clinica.model.Medico) medObj).getCrm();
            
            dao.atualizarCirurgiaPorTicket(ticket, data, hora, crm, anestesia, tipoCirurgia.trim());
            JOptionPane.showMessageDialog(telaPai, "Cirurgia alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(telaPai, e.getMessage(), "Erro na Alteração", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private static boolean textoEvalido(String texto){
        if(texto == null){
            return false;
        }

        String textoLimpo = texto.trim();

        return !textoLimpo.isEmpty() && !textoLimpo.equalsIgnoreCase("Digite o nome do Médico...") && !textoLimpo.equalsIgnoreCase("Digite o nome do paciente...") && !textoLimpo.equalsIgnoreCase("Digite a Especialidade do Médico...");
    }
}
