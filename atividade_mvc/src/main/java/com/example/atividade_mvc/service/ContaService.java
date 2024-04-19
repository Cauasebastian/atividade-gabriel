package com.example.atividade_mvc.service;

import com.example.atividade_mvc.model.Conta;

import java.util.List;

public interface ContaService {
    List<Conta> getAllContas();
    Conta getContaById(Long id);
    Conta createConta(Conta conta);
    Conta updateConta(Long id, Conta conta);
    void deleteConta(Long id);
}
