package com.example.atividade_mvc.controller;

import com.example.atividade_mvc.model.Conta;
import com.example.atividade_mvc.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getAllContas() {
        List<Conta> contas = contaService.getAllContas();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
        Conta conta = contaService.getContaById(id);
        if (conta != null) {
            return new ResponseEntity<>(conta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Conta> createConta(@RequestBody Conta conta) {
        Conta createdConta = contaService.createConta(conta);
        return new ResponseEntity<>(createdConta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody Conta contaDetails) {
        Conta updatedConta = contaService.updateConta(id, contaDetails);
        if (updatedConta != null) {
            return new ResponseEntity<>(updatedConta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long id) {
        contaService.deleteConta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
