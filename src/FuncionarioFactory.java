public class FuncionarioFactory {
    public final int COD_VENDEDOR = 1;
    public final int COD_GERENTE = 2;

    public Funcionario criarFuncionario(int cod) throws ClassNotFoundException {
        switch (cod){
            case COD_VENDEDOR:
                return new Vendedor();
            case COD_GERENTE:
                return new Gerente();
            default:
                throw new ClassNotFoundException("Código Inválido");
        }
    }
}
