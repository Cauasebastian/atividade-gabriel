package facade;

import entity.Conta;
import java.util.ArrayList;
import repository.IRepositorioConta;

public class Fachada implements IFachada {

    private IRepositorioConta rep;

     //inserir contar
        public void inserirConta(Conta c) {
            rep.inserirConta(c);
        }
    //alterarConta
        public void alterarConta(Conta c) {
            rep.alterarConta(c);
        }
    //removerConta
        public void removerConta(int numero) {
            rep.verificarExistenciaDeConta(numero);
            if (rep.verificarExistenciaDeConta(numero)) {
                rep.removerConta(rep.buscarConta(numero));
            }
        }
    //buscarConta
    public Conta buscarConta(int numero) {
        try {
            return rep.buscarConta(numero);
        } catch (Exception e) {
            e.printStackTrace();
            return null;  // Adicione esta linha
        }
    }
        //buscarTodas
            public ArrayList<Conta> buscarTodas() {
                return rep.buscarTodas();
            }

}