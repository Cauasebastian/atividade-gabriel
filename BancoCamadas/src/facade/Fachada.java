package facade;

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
                rep.removerConta(numero);
            }
        }
    //buscarConta
            public Conta buscarConta(int numero) {
                try {
                    return rep.buscarConta(numero);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        //buscarTodas
            public ArrayList<Conta> buscarTodas() {
                return rep.buscarTodas();
            }

}