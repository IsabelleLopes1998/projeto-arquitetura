import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FuncionarioDBHandler{
    public static FuncionarioDBHandler instance = new FuncionarioDBHandler();
    private HashMap<Integer, Funcionario> funcionarios;

    public static FuncionarioDBHandler getInstance(){
        if(instance==null){
            instance = new FuncionarioDBHandler();
        }
        return instance;
    }
    protected static String caminhoArquivo = "./funcionarios.csv";

    public FuncionarioDBHandler() {
    }

    public static void addFuncionario(Funcionario funcionario) {
        try {
            boolean arquivoExiste = (new File(caminhoArquivo)).exists();
            FileWriter fw = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, true);
            if (!arquivoExiste) {
                fw.write("Id;Nome;Cargo\n");
            }

            String var10001 = funcionario.getNome();
            fw.write(funcionario.getId() + ";" + var10001 + ";" + funcionario.getCod_cargo() +"\n");
            fw.flush();
            fw.close();
        } catch (Exception var3) {
            Exception e = var3;
            throw new RuntimeException(e);
        }
    }

    public static void atualizarFuncionario(Funcionario funcionarioAtualizado) {
        ArrayList<Funcionario> funcionarios = listarFuncionarios();

        try {
            FileWriter fw = new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1);
            fw.write("Id;Nome;Cargo\n"); // Ajuste os campos conforme sua necessidade real

            for (Funcionario f : funcionarios) {
                if (f.getId() == (funcionarioAtualizado.getId())) {
                    f.setNome(funcionarioAtualizado.getNome());
                    f.setCod_cargo(funcionarioAtualizado.getCod_cargo());

                    System.out.println("Funcionário atualizado:");
                    System.out.println("ID: " + f.getId() +
                            ", Nome: " + f.getNome() +
                            ", Cargo: " + f.getCod_cargo());
                }
                fw.write(f.getId() + ";" + f.getNome() + ";" + f.getCod_cargo() + "\n");
            }

            fw.flush();
            fw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Funcionario> listarFuncionarios() {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
            boolean primeiraLinha = true;

            String linha;
            while((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                } else {
                    String[] partes = linha.split(";");

                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    int cargo = Integer.parseInt(partes[2]);

                    Funcionario funcionario = new Funcionario(id, nome, cargo);
                    listaFuncionarios.add(funcionario);
                }
            }

            leitor.close();
            return listaFuncionarios;
        } catch (Exception var13) {
            Exception e = var13;
            throw new RuntimeException(e);
        }
    }

    public static void removerFuncionarioPorId(int idParaRemover) {
        Exception e;
        try {
            File arquivo = new File(caminhoArquivo);
            if (!arquivo.exists()) {
                System.out.println("Arquivo não encontrado.");
                return;
            }
        } catch (Exception var10) {
            e = var10;
            throw new RuntimeException("Erro ao remover funcionario: " + e.getMessage(), e);
        }

        try {
            ArrayList<String> linhasAtualizadas = new ArrayList();
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
            boolean primeiraLinha = true;

            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    linhasAtualizadas.add(linha);
                    primeiraLinha = false;
                } else {
                    String[] partes = linha.split(";");
                    int id = Integer.parseInt(partes[0]);
                    if (id != idParaRemover) {
                        linhasAtualizadas.add(linha);
                    }
                }
            }

            leitor.close();
            BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo, StandardCharsets.ISO_8859_1, false));
            Iterator var13 = linhasAtualizadas.iterator();

            while (var13.hasNext()) {
                String linhaAtualizada = (String) var13.next();
                escritor.write(linhaAtualizada);
                escritor.newLine();
            }

            escritor.close();
        } catch (Exception var9) {
            e = var9;
            throw new RuntimeException("Erro ao remover vendedor: " + e.getMessage(), e);
        }
    }

    public static void imprimirFuncionarios() {
        List<Funcionario> funcionarios = listarFuncionarios();

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum cliente encontrado.");
            return;
        }

        for (Funcionario c : funcionarios) {
            System.out.println("Id: " + c.getId()
                    + ", Nome: " + c.getNome()
                    + ", Cargo: " + c.getCod_cargo());
        }
    }
}

