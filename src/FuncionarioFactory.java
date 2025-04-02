public class FuncionarioFactory {
    public final int COD_VENDEDOR = 1;
    public final int COD_GERENTE = 2;

    public Funcionario criarFuncionario(int id, String nome,int cod) throws ClassNotFoundException {
        switch (cod){
            case COD_VENDEDOR:
                System.out.println("Vendedor "+nome+" criado com sucesso");
                return new Vendedor(id, nome, cod);
            case COD_GERENTE:
                System.out.println("Gerente "+nome+" criado com sucesso");
                return new Gerente(id,nome, cod);
            default:
                throw new ClassNotFoundException("Código Inválido");
        }
    }
}