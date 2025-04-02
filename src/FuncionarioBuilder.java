public class FuncionarioBuilder {
    private int id;
    private String nome;
    private int cod_cargo;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public Funcionario criar(){
        return new Funcionario(id, nome, cod_cargo);
    }
}