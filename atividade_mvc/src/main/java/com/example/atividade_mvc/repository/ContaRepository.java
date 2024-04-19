package com.example.atividade_mvc.repository;

import com.example.atividade_mvc.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    // Não é necessário definir métodos CRUD aqui, pois o JpaRepository já fornece esses métodos
}
