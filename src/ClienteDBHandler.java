import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

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

                    Cliente cliente = new Cliente(nome, cpf, dataNascimento,telefone);

                    listaCliente.add(cliente);
                    PrintStream var10000 = System.out;
                    String var10001 = cliente.getNome();

                    var10000.println("Nome: " + var10001 + ", cpf: " + cliente.getCpf() + ", Data de Nascimento: " + cliente.getDataNascimento() + ", Telefone: " + cliente.getTelefone());
                }
            }

            leitor.close();
            return listaCliente;
        } catch (Exception var13) {
            Exception e = var13;
            throw new RuntimeException(e);
        }
    }

    public static void atualizarProduto(Cliente clienteAtualizado) {
        ArrayList<Cliente> cliente = listarClientes();

        try {
            FileWriter fw = new FileWriter(camainhoArquivo, StandardCharsets.ISO_8859_1);
            fw.write("Id;tipo;nome;descricao;preco;quantidade\n");

            for (Cliente c : cliente) {
                if (c.getCpf().equalsIgnoreCase(clienteAtualizado.getCpf())) {
                    c = clienteAtualizado;
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
}
