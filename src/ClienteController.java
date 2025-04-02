public class ClienteController {

    public ClienteDBHandler clienteDbHandler;

    public ClienteController(){
        clienteDbHandler = ClienteDBHandler.getInstance();

    }
    public void addCliente(Cliente cliente){
        clienteDbHandler.addCliente(cliente);
    }
    public void listarClientes(){
        clienteDbHandler.listarClientes();
    }
    public void removerClientePorCpf(String cpf){
        clienteDbHandler.removerClientePorCpf(cpf);
    }
    public void atualizarCliente(Cliente cliente){clienteDbHandler.atualizarCliente(cliente);}
    public void imprimirClientes(){clienteDbHandler.imprimirClientes();}

}
