import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario;

        FuncionarioFactory ff = new FuncionarioFactory();

        try {
            funcionario = ff.criarFuncionario(ff.COD_VENDEDOR);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Adicionar Produto");
            System.out.println("6. Listar Produtos");
            System.out.println("7. Atualizar Produto");
            System.out.println("8. Buscar Produto por ID");
            System.out.println("9. Remover Produto por ID");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    funcionario.addCliente();
                    break;
                case 2:
                    funcionario.imprimirClientes();
                    break;
                case 3:
                    funcionario.atualizarCliente();
                    break;
                case 4:
                    funcionario.removerCliente();
                    break;
                case 5:
                    funcionario.addProduto();
                    break;
                case 6:
                    funcionario.imprimirProdutos();
                    break;
                case 7:
                    funcionario.atualizarProduto();
                    break;
                case 8:
                    funcionario.buscarProdutoPorId();
                    break;
                case 9:
                    funcionario.removerProdutoPorId();
                    break;
                case 10:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
