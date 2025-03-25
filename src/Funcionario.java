import java.util.Scanner;

public abstract class Funcionario {

    public ProdutoController produtoController;

    public Funcionario(){
        produtoController = new ProdutoController();
        clienteController = new ClienteController();
    }

    ClienteController clienteController;


    public Produto addProduto(){
        System.out.println("Criando produto");
        ProdutoBuilder produtoBuilder = new ProdutoBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        produtoBuilder.setNome(nome);
        System.out.println("Digite o tipo do produto:");
        String tipo = sc.nextLine();
        produtoBuilder.setTipo(tipo);
        System.out.println("Digite a descrição do produto:");
        String descricao = sc.nextLine();
        produtoBuilder.setDescricao(descricao);
        System.out.println("Digite o quantidade do produto:");
        produtoBuilder.setQuantidade(sc.nextInt());
        System.out.println("Digite o valor da produto:");
        double valor = sc.nextDouble();
        sc.nextLine();
        produtoBuilder.setPreco(valor);
        System.out.println("Digite o id do produto:");
        int id = sc.nextInt();
        produtoBuilder.setId(id);
        Produto produto = produtoBuilder.criar();
        System.out.println("Produto criado");
        produtoController.addProduto(produto);
        return produto;
    }

    public Cliente addCliente(){
        System.out.println("Cadastrando cliente");
        ClienteBuilder clienteBuilder = new ClienteBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        clienteBuilder.setNome(nome);

        System.out.println("Digite o cpf do cliente:");
        String cpf = sc.nextLine();
        clienteBuilder.setCpf(cpf);

        System.out.println("Digite a deta de nascimento do cliente:");
        String dataNascimento = sc.nextLine();
        clienteBuilder.setDataNascimento(dataNascimento);

        System.out.println("Digite o telefone do cliente:");
        String telefone = sc.nextLine();
        clienteBuilder.setTelefone(telefone);

        Cliente cliente = clienteBuilder.criar();

        System.out.println("Cliente criado");
        clienteController.addCliente(cliente);

        return cliente;
    }

    public void deletarProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o Id do produto que você quer deletar? ");
        int id = sc.nextInt();
        sc.nextLine();
        produtoController.removerProdutoPorId(id);
        System.out.println("Produto deletado");
    }

    public void deletarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o CPF do cliente que você quer deletar? ");
        String cpf = sc.nextLine();

        clienteController.removerClientePorCpf(cpf);
        System.out.println("Cliente deletado");
    }

    


}
