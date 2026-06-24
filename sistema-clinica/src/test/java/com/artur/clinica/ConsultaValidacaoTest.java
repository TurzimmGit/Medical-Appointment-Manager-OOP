package com.artur.clinica;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.artur.clinica.exception.ExcecoesProjeto.DadosInvalidosException;
import com.artur.clinica.model.Cirurgia;
import com.artur.clinica.model.ConsultaClinica;
import com.artur.clinica.model.Medico;
import com.artur.clinica.model.Paciente;

public class ConsultaValidacaoTest {
    // TESTE PACIENTE

    @Test
    public void testCpfInvalidoDeveBarra(){
        assertThrows(DadosInvalidosException.class, () -> {
            //Cpf errado
            new Paciente("Artur Silva", "123.456", "O-", "06/09/2006", "Nenhuma");
        });
    }

    @Test
    public void testNomeComNumeroDeveBarrar(){
        assertThrows(DadosInvalidosException.class, () -> {
            //Nome inválido com números
            new Paciente("Artur123 Silva", "090.000.999-88", "O-", "06/09/2006", "Nenhuma");
        });
    }

    @Test
    public void testDataNascimentoInvalidoDeveBarrar(){
        assertThrows(DadosInvalidosException.class, () -> {
            // Testando data que não existe no calendário (31 de fevereiro)
            new Paciente("Artur Silva", "090.000.999-88", "O-", "31/02/2006", "Nenhuma");
        });
    }

    @Test
    public void testPacienteComAlergiaDeveInstanciarComSucesso() {
        assertDoesNotThrow(() -> {
            // Cenário onde os dados estão certos e contém alergia real
            Paciente p = new Paciente("Artur Silva", "090.000.999-88", "O-", "06/09/2006", "Dipirona, Poeira");
            assertEquals("Dipirona, Poeira", p.getAlergias());
        });
    }

    @Test
    public void testDiaVinteENoveDeFevereiroEmAnoNormalDeveBarrar() {
        assertThrows(DadosInvalidosException.class, () -> {
            // 2026 NÃO é ano bissexto, então 29/02/2026 NÃO EXISTE! O sistema deve barrar.
            new Paciente("Artur Silva", "090.000.999-88", "O-", "29/02/2026", "Nenhuma");
        });
    }

    @Test
    public void testDiaVinteENoveDeFevereiroEmAnoBissextoDevePassar() {
        assertDoesNotThrow(() -> {
            // 2024 FOI ano bissexto, então 29/02/2024 EXISTE e o sistema deve aceitar de boa!
            new Paciente("Artur Silva", "090.000.999-88", "O-", "29/02/2024", "Nenhuma");
        });
    }

    // TESTE MEDICO

    @Test
    public void testCrmInvalidoDeveBarrar() {
        assertThrows(DadosInvalidosException.class, () -> {
            // Testando CRM sem a UF ou fora do padrão de máscara
            new Medico("Dr. Pedro", "123456", "Cardiologista");
        });
    }

    // TESTE DETALHES CONSULTA/CIRURGIA

    @Test
    public void testDataConsultaInvalidaDeveBarrar() {
        assertThrows(DadosInvalidosException.class, () -> {
            // Testando mês que não existe (Mês 13)
            new ConsultaClinica("", null, "09/13/2026", "19:00", null, "Conveniado");
        });
    }

    @Test
    public void testHorarioConsultaInvalidoDeveBarrar() {
        assertThrows(DadosInvalidosException.class, () -> {
            // Testando hora inválida no formato de relógio
            new ConsultaClinica("", null, "09/09/2026", "25:61", null, "Conveniado");
        });
    }

    @Test
    public void testTipoConsultaInvalidoDeveBarrar() {
        assertThrows(DadosInvalidosException.class, () -> {
            // Supondo que seu modelo valide Strings vazias ou nulas para o tipo
            new ConsultaClinica("", null, "09/09/2026", "19:00", null, "   ");
        });
    }

    @Test
    public void testTipoAnestesiaOuCirurgiaInvalidoDeveBarrar() {
        assertThrows(DadosInvalidosException.class, () -> {
            // Testando se a classe filha Cirurgia barra campos inválidos de anestesia
            new Cirurgia("", null, "09/09/2026", "19:00", null, "", "Geral");
        });
    }
    
    @Test
    public void testDiaTrintaDeFevereiroSempreDeveBarrar() {
        assertThrows(DadosInvalidosException.class, () -> {
            // 30 de fevereiro não existe em ano nenhum da história, deve dar erro na hora!
            new ConsultaClinica("", null, "30/02/2026", "19:00", null, "Conveniado");
        });
    }
}
