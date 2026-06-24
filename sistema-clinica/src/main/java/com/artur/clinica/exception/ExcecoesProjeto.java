package com.artur.clinica.exception;

public class ExcecoesProjeto {
    
    public static class ConflitoHorarioException extends RuntimeException{
        public ConflitoHorarioException(String mensagem){
            super(mensagem);
        }
    }

    public static class DadosInvalidosException extends  RuntimeException{
        public DadosInvalidosException(String mensagem){
            super(mensagem);
        }
    }

    public static class ConsultaNaoEncontradaException extends RuntimeException{
        public ConsultaNaoEncontradaException(String mensagem){
            super(mensagem);
        }
    }

    public static class ErroBancoDadosException extends RuntimeException{
        public ErroBancoDadosException(String mensagem){
            super(mensagem);
        }
    }

    public static class ElementoNaoEncontradoException extends RuntimeException{
        public ElementoNaoEncontradoException(String mensagem){
            super(mensagem);
        }
    } 
}
