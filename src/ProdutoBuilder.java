public class ProdutoBuilder {
    private int id;
    private String tipo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        if (descricao.length() > 200){
            this.descricao = descricao.substring(0,200) + "...";
        } else {
            this.descricao = descricao;
        }
    }

    public void setPreco(double preco) throws IllegalArgumentException{
        if (preco < 0){
            throw new IllegalArgumentException("Preço invalido");
        }
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto criar(){
        return new Produto(id, tipo, nome, descricao, preco, quantidade);
    }
}
