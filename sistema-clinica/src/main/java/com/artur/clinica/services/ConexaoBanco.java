package com.artur.clinica.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBanco {

    private static final String URL = "jdbc:postgresql://localhost:5433/clinica_db";
    private static final String USUARIO =  "turzimm";
    private static final String SENHA = "POSTGRES@DB_POO";

    public static Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL,USUARIO,SENHA);

        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver do Postgres não encontrado!");
            throw new RuntimeException(e);
        }catch(SQLException e){
            throw new RuntimeException("Erro crítico de banco de dados:" + e.getMessage(), e);
        }
    }
}   
