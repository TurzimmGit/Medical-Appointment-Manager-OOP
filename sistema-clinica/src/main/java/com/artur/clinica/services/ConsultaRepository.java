package com.artur.clinica.services;

import java.util.List;

import com.artur.clinica.model.Consulta;

public interface ConsultaRepository {
    void cadastrar(Consulta c);
    Consulta buscarPorId(int id);
    Consulta buscarPorNomePaciente(String nome);
    void atualizar(Consulta c);
    void remover(int id);
    List<Consulta> listarTodas();
}