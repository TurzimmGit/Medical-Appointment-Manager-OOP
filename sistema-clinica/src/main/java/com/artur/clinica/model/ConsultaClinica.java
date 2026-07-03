package com.artur.clinica.model;
import java.util.Arrays;
import java.util.List;

import com.artur.clinica.exception.ExcecoesProjeto;

public class ConsultaClinica extends Consulta{
    private String tipoConsulta;
    private String codTicket;

    public ConsultaClinica(String codTicket, Paciente paciente,String data, String horario, Medico medico ,String tipoConsulta) {
        super(paciente, data, horario, medico);
        this.codTicket = codTicket;
        this.tipoConsulta = validarConsulta(tipoConsulta);
    }

    @Override
    public int getHorarioEmMin(){
        return 30;
    } 

    private String validarConsulta(String tipoConsulta){
        List<String> listaValida = Arrays.asList("Particular", "Conveniado");
            String Tconsulta = transformarTitulo(tipoConsulta);
            if(listaValida.contains(Tconsulta)){
                return Tconsulta;
            }else{
                throw new ExcecoesProjeto.DadosInvalidosException("Tipo inválido! Tente Novamente!\n");
            }
    }

    public String getTipoConsulta(){
        return this.tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsultaR){
        this.tipoConsulta = validarConsulta(tipoConsultaR);
    }

    @Override
    public String toString() {
        return super.toString() +"""
                Tipo:     %s
                ------------------------------------------
                """.formatted(this.tipoConsulta);
            }

    @Override
    public String getCodTicket() {
        return codTicket;
    }
}
