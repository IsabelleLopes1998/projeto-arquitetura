//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Funcionario funcionario;

        FuncionarioFactory ff = new FuncionarioFactory();

        try {
            funcionario = ff.criarFuncionario(ff.COD_VENDEDOR);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //funcionario.addCliente();

        //funcionario.ListarClientes();

       //funcionario.atualizarCliente();

        funcionario.removerCliente();
    }

}