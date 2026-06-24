package com.artur.clinica.model;

import java.time.LocalDate;

public class Paciente extends Pessoa{
    private String cpf;
    private String tipoSanguineo;
    private LocalDate dataNascimento;
    private String alergias;

    public Paciente(String nome, String cpf, String tipoSanguineo,String dataNascimento,String alergias){
        super(nome);
        this.cpf = validarCPF(cpf);
        this.tipoSanguineo = validarTipoSangue(tipoSanguineo);
        this.dataNascimento = Consulta.validarEConverterData(dataNascimento);
        this.alergias = validarAlergias(alergias);
    }

    private String validarCPF(String cpf){
        String cpfLimpo = cpf.trim();

        String regexCpf = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

        if (!cpfLimpo.matches(regexCpf)) {
        throw new com.artur.clinica.exception.ExcecoesProjeto.DadosInvalidosException(
            "CPF inválido! O formato correto deve ser 000.000.000-00\n"
            );
        }
        return cpfLimpo;
    }


    private String validarTipoSangue(String tipoSanguineo){
        String tipoSanguineoLimpo = tipoSanguineo.toUpperCase();

        java.util.List<String> tiposValidos = java.util.Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

        if(!tiposValidos.contains(tipoSanguineoLimpo)){
            throw new com.artur.clinica.exception.ExcecoesProjeto.DadosInvalidosException(
            "Tipo sanguíneo inválido! Use padrões como A+, O-, AB+, etc.\n"
            );
        }

        return tipoSanguineoLimpo;
    }

    private String validarAlergias(String alergias) {
        if (alergias == null || alergias.isBlank()) {
            return "Nenhuma"; 
        }
        return Consulta.transformarTitulo(alergias);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpfN) {
        this.cpf = validarCPF(cpfN);
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineoN) {
        this.tipoSanguineo = validarTipoSangue(tipoSanguineoN);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimentoN) {
        this.dataNascimento = Consulta.validarEConverterData(dataNascimentoN);
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergiasN) {
        this.alergias = validarAlergias(alergiasN);
    }

    @Override
    public String obterDadosFormatados() {
        return this.getNome() + " (CPF: " + this.getCpf() + ")";
    }

    @Override
    public String toString() {
        return obterDadosFormatados();
    }
}
