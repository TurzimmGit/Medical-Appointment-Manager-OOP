package com.artur.clinica.app;

import java.util.List;

import com.artur.clinica.exception.ExcecoesProjeto.ConflitoHorarioException;
import com.artur.clinica.exception.ExcecoesProjeto.DadosInvalidosException;
import com.artur.clinica.exception.ExcecoesProjeto.ElementoNaoEncontradoException;
import com.artur.clinica.exception.ExcecoesProjeto.ErroBancoDadosException;
import com.artur.clinica.model.Cirurgia;
import com.artur.clinica.model.Consulta;
import com.artur.clinica.model.ConsultaClinica;
import com.artur.clinica.model.Medico;
import com.artur.clinica.model.Paciente;
import com.artur.clinica.services.ConsultaPostgresDAO;

public class MenuController {
    private static final ConsultaPostgresDAO dao = new ConsultaPostgresDAO();

    public void exibirMenuPrincipal(){
        ConsoleUtils.limparTela();
        System.out.println("=== CLINICAVITA - SISTEMA DE CONSULTAS ===");
        System.out.println("1. Agendar Consulta Clínica");
        System.out.println("2. Listar Todas as Consultas");
        System.out.println("3. Buscar Consultas por Paciente");
        System.out.println("4. Alterar Horário de Consulta");
        System.out.println("5. Cancelar/Remover Consulta");
        System.out.println("6. Agendar Cirurgia");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static Paciente coletarDadosPaciente(){
        System.out.println("\n--- DADOS DO PACIENTE ---");
        System.out.print("Nome do Paciente: ");
        String nome = ConsoleUtils.leitor.nextLine();
        System.out.print("CPF (000.000.000-00): ");
        String cpf = ConsoleUtils.leitor.nextLine();
        System.out.print("Tipo Sanguíneo (A+, O-, etc): ");
        String sangue = ConsoleUtils.leitor.nextLine();
        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String nasc = ConsoleUtils.leitor.nextLine();
        System.out.print("Alergias (Separadas por vírgula ou em branco): ");
        String alergias = ConsoleUtils.leitor.nextLine();
        return new Paciente(nome, cpf, sangue, nasc, alergias);
    }

    private static Medico coletarDadosMedico(){
        System.out.println("\n--- DADOS DO MÉDICO ---");
        System.out.print("Nome do Médico: ");
        String nome = ConsoleUtils.leitor.nextLine();
        System.out.print("CRM (ex: 123456-7/SP): ");
        String crm = ConsoleUtils.leitor.nextLine();
        System.out.print("Especialidade: ");
        String esp = ConsoleUtils.leitor.nextLine();
        return new Medico(nome, crm, esp);
    } 

    public void marcarClinica(){
        try{
            Paciente pac = coletarDadosPaciente();
            Medico med = coletarDadosMedico();

            try {
                dao.cadastrarPaciente(pac);
            } catch (Exception e) {
            // Se o paciente já existir (por causa do CPF UNIQUE), o banco pode chiar, 
            // mas deixamos passar ou tratamos depois. Para o teste, vai rodar liso!
            }
        
            try {
                dao.cadastrarMedico(med);
            } catch (Exception e) {
                // Se o médico já existir (CRM UNIQUE), ignora o erro e segue em frente
            }

            System.out.println("\n--- DETALHES DA CONSULTA ---");
            System.out.print("Data da Consulta (dd/mm/aaaa): ");
            String data = ConsoleUtils.leitor.nextLine();
            System.out.print("Horário da Consulta (hh:mm): ");
            String hora = ConsoleUtils.leitor.nextLine();
            System.out.print("Tipo de Consulta (Ex: Conveniado, Paricular): ");
            String tipo = ConsoleUtils.leitor.nextLine();

            ConsultaClinica cc = new ConsultaClinica("", pac, data, hora, med, tipo);
            dao.cadastrar(cc);
            ConsoleUtils.pausa();
        }catch(DadosInvalidosException | ConflitoHorarioException | ErroBancoDadosException e ){
            System.err.println("\nErro no agendamento:"+e.getMessage());
            ConsoleUtils.pausa();
     
        }
    }

    public void marcarCirurgia() {
        try {
            Paciente pac = coletarDadosPaciente();
            Medico med = coletarDadosMedico();

            System.out.println("\n--- DETALHES DA CIRURGIA ---");
            System.out.print("Data da Cirurgia (dd/mm/aaaa): ");
            String data = ConsoleUtils.leitor.nextLine();
            System.out.print("Horário da Cirurgia (hh:mm): ");
            String hora = ConsoleUtils.leitor.nextLine();
            System.out.print("Tipo de Anestesia: ");
            String anestesia = ConsoleUtils.leitor.nextLine();
            System.out.print("Tipo de Cirurgia: ");
            String tipoCirurgia = ConsoleUtils.leitor.nextLine();

            Cirurgia cir = new Cirurgia("", pac, data, hora, med, tipoCirurgia, anestesia);
            dao.cadastrar(cir);
            ConsoleUtils.pausa();
        } catch (DadosInvalidosException | ConflitoHorarioException | ErroBancoDadosException e) {
            System.err.println("\nErro no agendamento da cirurgia: " + e.getMessage());
            ConsoleUtils.pausa();
        }
    }

    public void listarTodas(){
        System.out.println("\n=== TODAS AS CONSULTAS NO BANCO ===");
        try{
            List<Consulta> lista = dao.listarTodas();
            if(lista.isEmpty()){
                System.out.println("Nenhum agendamento encontrado.");
            }else{
                for(Consulta c : lista){
                    System.out.println(c);
                    System.out.println("------------------------------------------------");
                }
            }
        }catch(ErroBancoDadosException e){
            System.err.println("Erro ao listar: " + e.getMessage());
        }
        ConsoleUtils.pausa();
    }

    public void buscar(){
        System.out.print("\nDigite o nome do paciente para buscar: ");
        String nome = ConsoleUtils.leitor.nextLine();

        List<Consulta> salvas = dao.buscarPorNomePaciente(nome);

        if(salvas.isEmpty()){
            System.out.println("Nenhum registro encontrado para este nome.");
        }else{
            System.out.println("\nAgendamento(s) encontrado(s):");
            for (Consulta c : salvas) {
                System.out.println(c);
                System.out.println("------------------------------------------------");
            }
        }
        ConsoleUtils.pausa();
    }

    public void alterar(){
        System.out.print("\\nDigite o nome do paciente que deseja remarcar:");
        String nome = ConsoleUtils.leitor.nextLine();

        List<Consulta> salvas = dao.buscarPorNomePaciente(nome);

        if(salvas.isEmpty()){
            System.out.println("Nenhum registro encontrado para este nome.");
            ConsoleUtils.pausa();
            return;
        }

        System.out.println("\nEscolha qual consulta deseja REMARCAR:");
        for (int i = 0; i < salvas.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + salvas.get(i).getMedico().getNome() + " - " + salvas.get(i).getData());
        }
        System.out.print("Escolha o número: ");
        int escolha = ConsoleUtils.lerInteiro() - 1;

        if(escolha>=0 && escolha<salvas.size()){
            Consulta selecionada = salvas.get(escolha);
            try{
                System.out.print("Nova Data (dd/mm/aaaa): ");
                String novaData = ConsoleUtils.leitor.nextLine();
                System.out.print("Novo Horário (hh:mm): ");
                String novoHorario = ConsoleUtils.leitor.nextLine();

                selecionada.setData(novaData);
                selecionada.setHorario(novoHorario);

                dao.atualizar(selecionada);
            }catch(DadosInvalidosException | ConflitoHorarioException | ErroBancoDadosException e) {
                System.err.println("Erro ao atualizar: " + e.getMessage());
            }
        }else{
                System.out.println("Opção inválida.");
            }
            ConsoleUtils.pausa();
    }

    public void remover(){
        System.out.print("\nDigite o nome do paciente que deseja cancelar a consulta: ");
        String nome = ConsoleUtils.leitor.nextLine();

        List<Consulta> salvas = dao.buscarPorNomePaciente(nome);
        if (salvas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
            ConsoleUtils.pausa();
            return;
        }

        System.out.println("\nEscolha qual consulta deseja CANCELAR:");
        for (int i = 0; i < salvas.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + salvas.get(i).getMedico().getNome() + " - " + salvas.get(i).getData());
        }
        System.out.print("Escolha o número: ");
        int escolha = ConsoleUtils.lerInteiro() - 1;

        if (escolha >= 0 && escolha < salvas.size()) {
            Consulta selecionada = salvas.get(escolha);
            try {
                dao.remover(selecionada.getidConsulta());
            } catch (ElementoNaoEncontradoException | ErroBancoDadosException e) {
                System.err.println("Erro ao remover: " + e.getMessage());
            }
        } else {
            System.out.println("Opção inválida.");
        }
        ConsoleUtils.pausa();
    }
}
