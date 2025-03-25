public class ClienteBuilder {
    private String nome;
    private String cpf;
    private String telefone;
    private String dataNascimento;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public Cliente criar() {
        return new Cliente(nome, cpf, dataNascimento, telefone);
    }

}
