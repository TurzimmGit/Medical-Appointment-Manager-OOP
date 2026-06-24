package com.artur.clinica;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.artur.clinica.model.Consulta;
import com.artur.clinica.model.ConsultaClinica;
import com.artur.clinica.model.Medico;
import com.artur.clinica.model.Paciente;
import com.artur.clinica.services.ConsultaPostgresDAO;

public class ConsultaIntegracaoTest {

    private final ConsultaPostgresDAO dao = new ConsultaPostgresDAO();
    //Fluxo completo testando com dados corretos
    @Test
    public void testCaminhoDasFloresFluxoCompletoDoCrud() {
        // Cenário perfeito: Dados redondos
        Paciente pac = new Paciente("Artur Caminho Perfeito", "000.111.222-33", "O+", "06/09/2006", "Nenhuma");
        Medico med = new Medico("Dr. Florindo", "123456-9/SP", "Clínico Geral");
        
        assertDoesNotThrow(() -> {
            // Inserções iniciais
            dao.cadastrarPaciente(pac);
            dao.cadastrarMedico(med);
            
            // Agendando a consulta clínica de sucesso
            ConsultaClinica cc = new ConsultaClinica("", pac, "12/12/2026", "14:00", med, "Particular");
            dao.cadastrar(cc);
        });

        // Testando a Listagem e Busca
        List<Consulta> lista = dao.listarTodas();
        assertFalse(lista.isEmpty(), "A lista de consultas não deveria estar vazia!");

        List<Consulta> busca = dao.buscarPorNomePaciente("Caminho Perfeito");
        assertEquals(1, busca.size(), "Deveria achar exatamente 1 consulta para o paciente fake!");
        
        Consulta consultaSalva = busca.get(0);
        int idConsulta = consultaSalva.getidConsulta();

        // --- TESTANDO A ALTERAÇÃO (UPDATE) ---
        assertDoesNotThrow(() -> {
            // Mudando o horário da consulta para as 15:00
            consultaSalva.setHorario("15:00");
            dao.atualizar(consultaSalva);
        });

        // --- TESTANDO A REMOÇÃO (DELETE) ---
        assertDoesNotThrow(() -> {
            dao.remover(idConsulta);
        });

        // Valida se limpou mesmo do banco após o delete
        List<Consulta> listaAposDeletar = dao.buscarPorNomePaciente("Caminho Perfeito");
        assertTrue(listaAposDeletar.isEmpty(), "A consulta deveria ter sido removida completamente!");
    }

    // 100 registros sendo inseridos e deletados

    @Test
    public void testTesteDeCargaCemConsultasComLimpezaAutomatica() {
        assertDoesNotThrow(() -> {
            System.out.println("🚀 Iniciando teste de carga no banco (100 registros)...");
            ArrayList<Integer> idsGerados = new ArrayList<>();
            
            Medico med = new Medico("Dr. Carga Pesada", "999999-9/RJ", "Geral");
            dao.cadastrarMedico(med);

            // Inserindo 100 caras em massa
            for (int i = 1; i <= 100; i++) {
                String nome = "Paciente Carga";
                String cpf = String.format("%03d.888.888-88", i);
                Paciente pac = new Paciente(nome, cpf, "A+", "10/10/2000", "Nenhuma");
                
                dao.cadastrarPaciente(pac);
                

                int dia = (i / 4) + 1; 
                int hora = 8 + (i % 4); 

                String dataFake = String.format("%02d/12/2026", dia);
                String horarioFake = String.format("%02d:00", hora); 
                ConsultaClinica cc = new ConsultaClinica("", pac, dataFake, horarioFake, med, "Conveniado");
                
                dao.cadastrar(cc);
            }

            // Coleta os IDs gerados para limpar o banco
            List<Consulta> cadastradas = dao.buscarPorNomePaciente("Carga");
            for (Consulta c : cadastradas) {
                idsGerados.add(c.getidConsulta());
            }

            System.out.println("✅ " + idsGerados.size() + " consultas inseridas com sucesso. Iniciando limpeza em massa...");

            // Limpa o banco de dados rodando o delete para cada um
            for (int id : idsGerados) {
                dao.remover(id);
            }
            
            System.out.println("🧹 Banco de dados de testes limpo e zerado!");
        });
    }
}