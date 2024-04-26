package controller;

import entity.Conta;
import repository.IRepositorioConta;

public class ControllerBanco {
    private IRepositorioConta repositorioConta;

    public ControllerBanco(IRepositorioConta repositorioConta) {
        this.repositorioConta = repositorioConta;
    }

    public Conta criarConta(String titular, double saldo, int agencia, int numero) {
        Conta novaConta = new Conta(numero, agencia, saldo, titular);
        repositorioConta.inserirConta(novaConta);
        return novaConta;
    }
    // Buscar uma conta
    public Conta buscarConta(int numero) {
        return repositorioConta.buscarConta(numero);
    }
    // Depositar dinheiro em uma conta
    public void depositar(int numero, double valor) {
        Conta conta = repositorioConta.buscarConta(numero);
        conta.setSaldo(conta.getSaldo() + valor);
    }
    // Sacar dinheiro de uma conta
    public void sacar(int numero, double valor) {
        Conta conta = repositorioConta.buscarConta(numero);
        conta.setSaldo(conta.getSaldo() - valor);
    }
    //removerConta
    public void removerConta(int numero) {
        repositorioConta.removerConta(repositorioConta.buscarConta(numero));
    }
    //alterarConta
    public void alterarConta(Conta c) {
        repositorioConta.alterarConta(c);
    }
    //verificarExistenciaDeConta
    public boolean verificarExistenciaDeConta(int numero) {
        return repositorioConta.verificarExistenciaDeConta(numero);
    }
    //buscarTodas
    public void buscarTodas() {
        repositorioConta.buscarTodas();
    }
    
}