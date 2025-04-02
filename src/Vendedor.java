public class Vendedor extends Funcionario{
    public Vendedor(int id, String nome, int cod_cargo) {
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
