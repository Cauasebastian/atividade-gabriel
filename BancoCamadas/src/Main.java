

import controller.ControllerBanco;
import entity.Conta;
import repository.IRepositorioConta;
import repository.RepositorioContaArrayList;

public class Main {
    public static void main(String[] args) {
        // Criar um novo repositório de contas
        IRepositorioConta repositorioConta = new RepositorioContaArrayList();

        // Criar um novo controlador de banco
        ControllerBanco controllerBanco = new ControllerBanco(repositorioConta);

        // Criar uma nova conta
        Conta novaConta = controllerBanco.criarConta("João", 1000.0, 123, 456);
        System.out.println("Conta criada: " + novaConta.getTitular());

        // Depositar dinheiro na nova conta
        controllerBanco.depositar(novaConta.getNumero(), 500.0);
        System.out.println("Saldo da conta: " + novaConta.getSaldo());


        // Sacar dinheiro da nova conta
        controllerBanco.sacar(novaConta.getNumero(), 200.0);
        System.out.println("Saldo da conta: " + novaConta.getSaldo());

        // Verificar a existência da nova conta
        boolean existe = controllerBanco.verificarExistenciaDeConta(novaConta.getNumero());
        System.out.println("A conta existe? " + existe);

        // Remover a nova conta
        controllerBanco.removerConta(novaConta.getNumero());

        // Verificar novamente a existência da nova conta
        existe = controllerBanco.verificarExistenciaDeConta(novaConta.getNumero());
        System.out.println("A conta existe? " + existe);
    }
}