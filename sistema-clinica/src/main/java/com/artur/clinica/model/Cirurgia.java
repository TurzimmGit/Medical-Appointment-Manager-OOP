package com.artur.clinica.model;
import java.util.Arrays;
import java.util.List;

import com.artur.clinica.exception.ExcecoesProjeto;


public class Cirurgia extends Consulta{
    private String tipoAnestesia;
    private String tipoCirurgia;
    private String codTicket;

    public Cirurgia(String codTicket,Paciente paciente,String data, String horario, Medico medico ,String tipoAnestesia, String tipoCirurgia) {
        super(paciente, data, horario, medico);
        this.codTicket = codTicket;
        this.tipoAnestesia = validarAnestesia(tipoAnestesia);
        this.tipoCirurgia = validarNome(tipoCirurgia);
    }

    @Override
    public int getHorarioEmMin(){
        return 120;
    } 

    private String validarAnestesia(String tipoAnestesia){
        List<String> listaValida = Arrays.asList("Geral", "Local");
            String Tanestesia = transformarTitulo(tipoAnestesia);
            if(listaValida.contains(Tanestesia)){
                return Tanestesia;
            }else{
                throw new ExcecoesProjeto.DadosInvalidosException("Tipo inválido! Tente Novamente!\n");
            }
    }

    public String getTipoAnestesia(){
        return this.tipoAnestesia;
    }

    public void setTipoAnestesia(String tipoAnestesiaN){
        this.tipoAnestesia = validarAnestesia(tipoAnestesiaN);
    }

    public String getTipoCirurgia(){
        return this.tipoCirurgia;
    }

    public void setTipoCirurgia(String tipoCirurgiaN){
        this.tipoCirurgia = validarNome(tipoCirurgiaN);
    }

    @Override
    public String toString() {
        return super.toString() +"""
                Tipo Anestesia:     %s
                Tipo Cirurgia:      %s
                ------------------------------------------
                """.formatted(tipoAnestesia, tipoCirurgia);
            }

    public String getCodTicket() {
        return codTicket;
    }
}
