package com.artur.clinica.model;

public class Medico extends Pessoa {
    private String crm;
    private String Especialidade;

    public Medico(String nome, String crm, String especialidade){
        super(nome);
        this.crm = validarCrm(crm);
        this.Especialidade = validarNome(especialidade);
    }

    private String validarCrm(String crm){
        String regexCrm="\\d{4,8}-\\d/[A-Z]{2}";
        String crmFormatado = crm.toUpperCase().trim();
        if(!crmFormatado.matches(regexCrm)){
            throw new com.artur.clinica.exception.ExcecoesProjeto.DadosInvalidosException(
            "CRM inválido! O formato correto deve ser 000000-0/UF (Ex: 123456-7/SP)\n"
        );
        }
        return crmFormatado;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String Especialidade) {
        this.Especialidade = Especialidade;
    }

    @Override
    public String obterDadosFormatados() {
        return "Dr(a). " + this.getNome() + " [" + this.getEspecialidade() + " - CRM: " + this.getCrm() + "]";
    }

    @Override
    public String toString() {
        return obterDadosFormatados();
    }

}
