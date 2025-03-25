public class ProdutoController {

    public ProdutoDBHandler dbHandler;

    public ProdutoController(){
        dbHandler = ProdutoDBHandler.getInstance();
    }

    public void addProduto(Produto produto) {
        dbHandler.addProduto(produto);
    }

    public void removerProdutoPorId(int id){
        dbHandler.removerProdutoPorId(id);
    }
}
