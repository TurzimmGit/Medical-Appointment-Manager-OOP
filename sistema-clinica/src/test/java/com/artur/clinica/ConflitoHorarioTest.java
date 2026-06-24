package com.artur.clinica;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.artur.clinica.exception.ExcecoesProjeto.ConflitoHorarioException;
import com.artur.clinica.model.Cirurgia;
import com.artur.clinica.model.ConsultaClinica;
import com.artur.clinica.model.Medico;
import com.artur.clinica.model.Paciente;
import com.artur.clinica.services.ConsultaPostgresDAO;

public class ConflitoHorarioTest {

    private final ConsultaPostgresDAO dao = new ConsultaPostgresDAO();

    //Medicos diferentes mesmo horario

    @Test
    public void testDoisAgendamentosDeClinicaNoMesmoHorarioComMedicosDiferentesDevePassar() {
        Medico med1 = new Medico("Dr. Pedro Cardio", "111111-1/SP", "Cardiologista");
        Medico med2 = new Medico("Dr. Marcos Geral", "222222-2/SP", "Clínico Geral");
        Paciente pac = new Paciente("Artur Silva", "090.000.999-88", "O-", "06/09/2006", "Nenhuma");

        assertDoesNotThrow(() -> {
            dao.cadastrarMedico(med1);
            dao.cadastrarMedico(med2);
            dao.cadastrarPaciente(pac);

            ConsultaClinica c1 = new ConsultaClinica("", pac, "15/10/2026", "14:00", med1, "Particular");
            ConsultaClinica c2 = new ConsultaClinica("", pac, "15/10/2026", "14:00", med2, "Conveniado");

            dao.cadastrar(c1);
            dao.cadastrar(c2);
        });
    }

    // 1 CONSULTA CLINICA E 1 CONSULTA CIRURGICA

    @Test
    public void testClinicaECirurgiaNoMesmoHorarioComMedicosDiferentesDevePassar() {
        Medico medClinico = new Medico("Dr. Lucas Neto", "333333-3/SP", "Pediatra");
        Medico medCirurgiao = new Medico("Dr. Andre Faca", "444444-4/SP", "Cirurgião");
        Paciente pac = new Paciente("Carlos Santos", "111.222.333-44", "A+", "10/05/1995", "Poeira");

        assertDoesNotThrow(() -> {
            dao.cadastrarMedico(medClinico);
            dao.cadastrarMedico(medCirurgiao);
            dao.cadastrarPaciente(pac);

            ConsultaClinica cc = new ConsultaClinica("", pac, "20/10/2026", "09:00", medClinico, "Particular");
            Cirurgia cir = new Cirurgia("", pac, "20/10/2026", "09:00", medCirurgiao, "Geral", "Cardiaca");

            dao.cadastrar(cc);
            dao.cadastrar(cir);
        });
    }

    // Cirurgia que Conflita com a Consulta Clinica mesmo médico

    @Test
    public void testCirurgiaNovaConflitandoComClinicaExistenteDoMesmoMedicoDeveBarrar() {
        Medico med = new Medico("Dra. Juliana", "555555-5/SP", "Dermatologista");
        Paciente pac = new Paciente("Mariana Costa", "555.666.777-88", "B+", "22/02/1992", "Nenhuma");

        assertDoesNotThrow(() -> {
            dao.cadastrarMedico(med);
            dao.cadastrarPaciente(pac);

            // Primeiro salva uma consulta clínica comum às 10:00
            ConsultaClinica cc = new ConsultaClinica("", pac, "25/10/2026", "10:00", med, "Conveniado");
            dao.cadastrar(cc);
        });

        // Agora tenta enfiar uma CIRURGIA pro mesmo médico às 10:15 (menos de 30 min de intervalo ou choque direto)
        Cirurgia cirConflitante = new Cirurgia("", pac, "25/10/2026", "10:15", med, "Geral", "Cardio");

        assertThrows(ConflitoHorarioException.class, () -> {
            dao.cadastrar(cirConflitante);
        });
    }

    //Clinica conflita com cirurgia mesmo médico

    @Test
    public void testClinicaNovaConflitandoComCirurgiaExistenteDoMesmoMedicoDeveBarrar() {
        Medico med = new Medico("Dr. Roberto", "666666-6/SP", "Ortopedista");
        Paciente pac = new Paciente("Rodrigo Lima", "999.888.777-66", "AB-", "01/01/1980", "Nenhuma");

        assertDoesNotThrow(() -> {
            dao.cadastrarMedico(med);
            dao.cadastrarPaciente(pac);

            // Primeiro salva uma CIRURGIA às 16:00 (que costuma demorar mais)
            Cirurgia cir = new Cirurgia("", pac, "30/10/2026", "16:00", med, "Local", "Cardiaca");
            dao.cadastrar(cir);
        });

        // Tenta marcar uma consulta de clínica comum para as 16:20 com o mesmo médico enquanto ele estaria operando
        ConsultaClinica ccConflitante = new ConsultaClinica("", pac, "30/10/2026", "16:20", med, "Particular");

        // O banco tem que travar e jogar a exceção limpa!
        assertThrows(ConflitoHorarioException.class, () -> {
            dao.cadastrar(ccConflitante);
        });
    }
}