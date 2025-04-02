import java.util.Scanner;

public  class Funcionario {
    private int id;
    private String nome;
    private int cod_cargo;
    public ProdutoController produtoController;
    public ClienteController clienteController;

    public Funcionario(int id, String nome, int cod_cargo) {
        this.id = id;
        this.nome = nome;
        this.cod_cargo = cod_cargo;
        produtoController = new ProdutoController();
        clienteController = new ClienteController();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
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

        System.out.println("Digite a data de nascimento do cliente:");
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


    public void removerCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o CPF do cliente que você quer deletar? ");
        String cpf = sc.nextLine();

        clienteController.removerClientePorCpf(cpf);
        System.out.println("Cliente deletado");
    }

    public void ListarClientes(){
        clienteController.listarClientes();
    }

    public void atualizarCliente(){
        Scanner sc = new Scanner(System.in);
        ClienteBuilder clienteBuilderAtualizado = new ClienteBuilder();

        System.out.println("Qual o CPF do cliente que você quer atualizar?");
        String cpf = sc.nextLine();
        clienteBuilderAtualizado.setCpf(cpf);

        System.out.println("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        clienteBuilderAtualizado.setNome(nome);

        System.out.println("Digite a data de nascimento do cliente:");
        String dataNascimento = sc.nextLine();
        clienteBuilderAtualizado.setDataNascimento(dataNascimento);

        System.out.println("Digite o telefone do cliente:");
        String telefone = sc.nextLine();
        clienteBuilderAtualizado.setTelefone(telefone);

        Cliente clienteAtualizado = clienteBuilderAtualizado.criar();

        clienteController.atualizarCliente(clienteAtualizado);
        System.out.println("Cliente atualizado");

    }

    public void imprimirClientes(){
        clienteController.imprimirClientes();
    }



    public Produto addProduto(){
        System.out.println("Criando produto");
        ProdutoBuilder produtoBuilder = new ProdutoBuilder();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o id do produto:");
        int id = sc.nextInt();
        sc.nextLine();
        produtoBuilder.setId(id);

        System.out.println("Digite o tipo do produto:");
        String tipo = sc.nextLine();
        produtoBuilder.setTipo(tipo);

        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        produtoBuilder.setNome(nome);

        System.out.println("Digite a descrição do produto:");
        String descricao = sc.nextLine();
        produtoBuilder.setDescricao(descricao);

        System.out.println("Digite o quantidade do produto:");
        int qtd = sc.nextInt();
        sc.nextLine();
        produtoBuilder.setQuantidade(qtd);

        System.out.println("Digite o valor da produto:");
        double valor = sc.nextDouble();
        sc.nextLine();
        produtoBuilder.setPreco(valor);


        Produto produto = produtoBuilder.criar();
        System.out.println("Produto criado");

        produtoController.addProduto(produto);
        return produto;
    }



    public void atualizarProduto(){
        Scanner sc = new Scanner(System.in);
        ProdutoBuilder produtoBuilderAtualizado = new ProdutoBuilder();


        System.out.println("Qual o id do produto que você quer atualizar?");
        int id = sc.nextInt();
        sc.nextLine();
        produtoBuilderAtualizado.setId(id);

        System.out.println("Digite o tipo do produto: ");
        String tipo = sc.nextLine();
        produtoBuilderAtualizado.setTipo(tipo);


        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        produtoBuilderAtualizado.setNome(nome);

        System.out.println("Digite a descrição do produto: ");
        String descricao = sc.nextLine();
        produtoBuilderAtualizado.setDescricao(descricao);

        System.out.println("Digite o preço do produto:");
        double preco = sc.nextDouble();
        produtoBuilderAtualizado.setPreco(preco);

        System.out.println("Digite a quantidade do produto:");
        int qtd = sc.nextInt();
        sc.nextLine();
        produtoBuilderAtualizado.setQuantidade(qtd);

        Produto produtoAtualizado = produtoBuilderAtualizado.criar();

        produtoController.atualizarProduto(produtoAtualizado);
        System.out.println("Produto atualizado");

    }
    public void buscarProdutoPorId(){
        System.out.println("Id do produto a procurar: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();

        produtoController.buscarProdutoPorid(id);
    }


    public void removerProdutoPorId(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o Id do produto que você quer deletar? ");
        int id = sc.nextInt();
        sc.nextLine();
        produtoController.removerProdutoPorId(id);
        System.out.println("Produto deletado");
    }
    public void imprimirProdutos(){
        produtoController.imprimirProdutos();
    }
}







