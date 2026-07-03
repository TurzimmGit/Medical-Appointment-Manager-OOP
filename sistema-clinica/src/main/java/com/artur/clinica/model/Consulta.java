package com.artur.clinica.model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.artur.clinica.exception.ExcecoesProjeto;

public abstract class Consulta{
    protected int idConsulta;
    protected Paciente paciente;
    protected LocalDate data;
    protected LocalTime horario;
    protected Medico medico;

    public Consulta(Paciente paciente, String Data, String Horario, Medico medico){
        this.paciente = paciente;
        this.data = validarEConverterData(Data);
        this.horario = validarEconverterHora(Horario);
        this.medico = medico;
    }
    
    public static LocalDate validarEConverterData(String data){
        DateTimeFormatter seletorData = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                                                     .withResolverStyle(java.time.format.ResolverStyle.STRICT);
        try {
            LocalDate data_obj = LocalDate.parse(data, seletorData);
            return data_obj;
        }catch (Exception e) {
            throw new ExcecoesProjeto.DadosInvalidosException("Data inválido para o calendário!\n");
        }
    }
    public static LocalTime validarEconverterHora(String Horario){
        DateTimeFormatter seletorHorario = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime horario_obj = LocalTime.parse(Horario, seletorHorario);
            return horario_obj;
        } catch (Exception e) {
            throw new ExcecoesProjeto.DadosInvalidosException("Horário inválido!\n");
        }
    }

    public static final String transformarTitulo(String tipoConsulta){
        String minuscula = tipoConsulta.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        String[] palavras = minuscula.split(" ");
       for (String p : palavras) {
        if(!p.isEmpty())
        {sb.append(p.substring(0, 1).toUpperCase()).append(p.substring(1).toLowerCase()).append(" ");}
       }
       return sb.toString().trim();
    
    }
    
    protected final String validarNome(String nome){
        for(int i = 0; i< nome.length(); i++){
        char c = nome.charAt(i);
            if(Character.isDigit(c)){
                throw new ExcecoesProjeto.DadosInvalidosException("Nome inválido! Tente Novamente!\n");
            } 
        }return transformarTitulo(nome);
    }

    @Override
    public String toString() {

        DateTimeFormatter fmtData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmtHora = DateTimeFormatter.ofPattern("HH:mm");
        
        String dStr = this.data.format(fmtData);
        String hStr = this.horario.format(fmtHora);

        return String.format("""
            
            [ Código: %03d ]
            ------------------------------------------
            Paciente: %s
            Médico:   %s
            Data:     %s às %s
            """, 
            this.idConsulta, this.paciente, this.medico, dStr, hStr
        );
    }

    public int getidConsulta() {
        return idConsulta;
    }

    public void setidConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public LocalDate getData() {
        return data;
    }

    public Medico getMedico() {
        return medico;
    }


    public LocalTime getHorario() {
        return horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public void setData(String dataN){
        this.data = validarEConverterData(dataN); 
    }

    public void setHorario(String horarioN){
        this.horario = validarEconverterHora(horarioN); 
    }

    public void setMedico(Medico nomeMedicoN){
        this.medico = nomeMedicoN; 
    }

    public abstract int getHorarioEmMin();
    public abstract String getCodTicket();
}
