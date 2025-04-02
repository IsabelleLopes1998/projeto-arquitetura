import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteDBHandler {

    private static ClienteDBHandler instance = new ClienteDBHandler();

    protected static String camainhoArquivo = "./cliente.csv";

    public static ClienteDBHandler getInstance(){
        if(instance == null){
            instance = new ClienteDBHandler();
        }
        return  instance;
    }

    public ClienteDBHandler() {
    }

    public static void addCliente(Cliente cliente) {
        try {
            boolean arquivoExiste = (new File(camainhoArquivo)).exists();
            FileWriter fw = new FileWriter(camainhoArquivo, StandardCharsets.ISO_8859_1, true);
            if (!arquivoExiste) {
                fw.write("Nome;cpf;dataNascimento;Telefone\n");
            }

            String var10001 = cliente.getNome();

            fw.write(var10001 + ";" + cliente.getCpf() + ";" + cliente.getDataNascimento() + ";" + cliente.getTelefone() + "\n");
            fw.flush();
            fw.close();

        } catch (Exception var3) {
            Exception e = var3;
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> listaCliente = new ArrayList();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(camainhoArquivo));
            boolean primeiraLinha = true;

            String linha;
            while((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                } else {
                    String[] partes = linha.split(";");

                    String nome = partes[0];
                    String cpf = partes[1];
                    String dataNascimento = partes[2];
                    String telefone = partes[3];

                    Cliente cliente = new Cliente(nome, cpf, dataNascimento, telefone);
                    listaCliente.add(cliente);
                }
            }

            leitor.close();
            return listaCliente;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void atualizarCliente(Cliente clienteAtualizado) {
        ArrayList<Cliente> clientes = listarClientes();

        try {
            FileWriter fw = new FileWriter(camainhoArquivo, StandardCharsets.ISO_8859_1);
            fw.write("Nome;cpf;dataNascimento;Telefone\n");

            for (Cliente c : clientes) {
                if (c.getCpf().equalsIgnoreCase(clienteAtualizado.getCpf())) {
                    c.setNome(clienteAtualizado.getNome());
                    c.setDataNascimento(clienteAtualizado.getDataNascimento());
                    c.setTelefone(clienteAtualizado.getTelefone());

                    System.out.println("Cliente atualizado:");
                    System.out.println("Nome: " + clienteAtualizado.getNome()
                            + ", CPF: " + clienteAtualizado.getCpf()
                            + ", Data de Nascimento: " + clienteAtualizado.getDataNascimento()
                            + ", Telefone: " + clienteAtualizado.getTelefone());

                }
                fw.write(c.getNome() + ";" + c.getCpf() + ";" + c.getDataNascimento() + ";" + c.getTelefone()  + "\n");
            }

            fw.flush();
            fw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void removerClientePorCpf(String cpfParaRemover) {
        Exception e;
        try {
            File arquivo = new File(camainhoArquivo);
            if (!arquivo.exists()) {
                System.out.println("Arquivo não encontrado.");
                return;
            }
        } catch (Exception var10) {
            e = var10;
            throw new RuntimeException("Erro ao remover cliente: " + e.getMessage(), e);
        }

        try {
            ArrayList<String> linhasAtualizadas = new ArrayList();
            BufferedReader leitor = new BufferedReader(new FileReader(camainhoArquivo));
            boolean primeiraLinha = true;

            String linha;
            while((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    linhasAtualizadas.add(linha);
                    primeiraLinha = false;
                } else {
                    String[] partes = linha.split(";");
                    String cpf = partes[1];
                    if (!cpf.equals(cpfParaRemover)) {
                        linhasAtualizadas.add(linha);
                    }
                }
            }

            leitor.close();
            BufferedWriter escritor = new BufferedWriter(new FileWriter(camainhoArquivo, StandardCharsets.ISO_8859_1, false));
            Iterator var13 = linhasAtualizadas.iterator();

            while(var13.hasNext()) {
                String linhaAtualizada = (String)var13.next();
                escritor.write(linhaAtualizada);
                escritor.newLine();
            }

            escritor.close();
        } catch (Exception var9) {
            e = var9;
            throw new RuntimeException("Erro ao remover cliente: " + e.getMessage(), e);
        }
    }


    public static Cliente buscarClientePorCPF(String cpf) {
        Cliente clienteEncontrado = null;

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(camainhoArquivo));
            boolean primeiraLinha = true;
            String linha;

            while((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                } else {
                    String[] partes = linha.split(";");
                    String cpfCliente = partes[1];

                    if (cpfCliente.equalsIgnoreCase(cpf)) {

                        String nome = partes[0];
                        String cpfC = partes[1];
                        String dataNascimento = partes[2];
                        String telefone = partes[3];


                        clienteEncontrado = new Cliente(nome, cpfC, dataNascimento, telefone);
                        break;
                    }
                }
            }

            leitor.close();


            if (clienteEncontrado != null) {
                System.out.println("Cliente encontrado: ");
                System.out.println("Nome: " + clienteEncontrado.getNome());
                System.out.println("CPF: " + clienteEncontrado.getCpf());
                System.out.println("Data de nascimento: " + clienteEncontrado.getDataNascimento());
                System.out.println("Telefone: " + clienteEncontrado.getTelefone());
            } else {
                System.out.println("Cliente não encontrado.");
            }

            return clienteEncontrado;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto por ID: " + e.getMessage(), e);
        }
    }

    public static void imprimirClientes() {
        List<Cliente> clientes = listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println("Nome: " + c.getNome()
                    + ", CPF: " + c.getCpf()
                    + ", Data de Nascimento: " + c.getDataNascimento()
                    + ", Telefone: " + c.getTelefone());
        }
    }
}
