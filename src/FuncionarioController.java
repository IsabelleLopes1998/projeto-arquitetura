public class FuncionarioController {
    public FuncionarioDBHandler dbHandler;

    public FuncionarioController(){
        dbHandler = FuncionarioDBHandler.getInstance();
    }

    public void criarFuncionario(Funcionario funcionario){
        dbHandler.addFuncionario(funcionario);
    }

    public void atualizarFuncionario(Funcionario funcionario){
        dbHandler.atualizarFuncionario(funcionario);
    }

    public void imprimirFuncionarios(){
        dbHandler.imprimirFuncionarios();
    }

    public void deletarFuncionarioPorId(int id){
        dbHandler.removerFuncionarioPorId(id);
    }

}