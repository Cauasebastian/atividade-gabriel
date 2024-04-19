package com.example.atividade_mvc.service;

import com.example.atividade_mvc.model.Conta;
import com.example.atividade_mvc.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;

    @Autowired
    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    @Override
    public Conta getContaById(Long id) {
        return contaRepository.findById(id).orElse(null);
    }

    @Override
    public Conta createConta(Conta conta) {
        return contaRepository.save(conta);
    }

    @Override
    public Conta updateConta(Long id, Conta conta) {
        if (contaRepository.existsById(id)) {
            conta.setId(id); // Garantindo que o ID está correto
            return contaRepository.save(conta);
        }
        return null;
    }

    @Override
    public void deleteConta(Long id) {
        contaRepository.deleteById(id);
    }
}
