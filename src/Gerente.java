import java.util.Scanner;

public class Gerente extends Funcionario{


    public Gerente(int id, String nome, int cod_cargo) {
        super(id, nome, cod_cargo);
    }

    @Override
    public Produto addProduto() {
        return super.addProduto();
    }

    @Override
    public void atualizarProduto() {
        super.atualizarProduto();
    }

    @Override
    public void removerProdutoPorId() {
        super.removerProdutoPorId();
    }

    @Override
    public void buscarProdutoPorId() {
        super.buscarProdutoPorId();
    }

    @Override
    public void imprimirProdutos() {
        super.imprimirProdutos();
    }
}
