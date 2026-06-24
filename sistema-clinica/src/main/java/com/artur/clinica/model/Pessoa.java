package com.artur.clinica.model;
import com.artur.clinica.exception.ExcecoesProjeto;
public abstract class Pessoa {
    protected  int IDPessoa;
    protected String Nome;

    public Pessoa(String nome){
        this.Nome = validarNome(nome);
    }

    protected final String validarNome(String nome){

        if (nome == null || nome.isBlank()) {
            throw new ExcecoesProjeto.DadosInvalidosException("O nome não pode ser vazio ou conter apenas espaços!\n");
        }
        
        for(int i = 0; i< nome.length(); i++){
        char c = nome.charAt(i);
            if(Character.isDigit(c)){
                throw new ExcecoesProjeto.DadosInvalidosException("Nome inválido! Tente Novamente!\n");
            } 
        }return Consulta.transformarTitulo(nome);
    }

    protected int getIDPessoa(){
        return IDPessoa;
    }

    protected void setNome(String nome){
        this.Nome = nome;
    }

    public String getNome(){
        return Nome;
    }

    public abstract String obterDadosFormatados();

}
