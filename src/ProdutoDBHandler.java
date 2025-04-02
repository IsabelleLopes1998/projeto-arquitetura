import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ProdutoDBHandler {
    public static ProdutoDBHandler instance = new ProdutoDBHandler();
    private HashMap<Integer, Produto> produtos;

    protected static String camainhoArquivo = "./produtos.csv";

    private ProdutoDBHandler(){}


    public static ProdutoDBHandler getInstance() {
        if (instance == null){
            instance = new ProdutoDBHandler();
        }
        return instance;
    }

    public static void addProduto(Produto produto) {
        try {
            boolean arquivoExiste = (new File(camainhoArquivo)).exists();
            FileWriter fw = new FileWriter(camainhoArquivo, StandardCharsets.ISO_8859_1, true);
            if (!arquivoExiste) {
                fw.write("Id;tipo;nome;descricao;preco;quantidade\n");
            }

            String var10001 = produto.getNome();

            fw.write(produto.getId() + ";" + produto.getTipo() + ";" + var10001 + ";" +  produto.getDescricao()  + ";" + produto.getPreco() + ";" + produto.getQuantidade() + "\n");
            fw.flush();
            fw.close();

        } catch (Exception var3) {
            Exception e = var3;
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Produto> listarProduto() {
        ArrayList<Produto> listaProduto = new ArrayList();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(camainhoArquivo));
            boolean primeiraLinha = true;

            String linha;
            while((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                } else {
                    String[] partes = linha.split(";");

                    int id = Integer.parseInt(partes[0]);
                    String tipo = partes[1];
                    String nome = partes[2];
                    String descricao = partes[3];
                    double valor = Double.parseDouble(partes[4]);
                    int quantidade = Integer.parseInt(partes[5]);

                    Produto produto = new Produto(id, tipo, nome, descricao, valor, quantidade);
                    listaProduto.add(produto);
                }
            }

            leitor.close();
            return listaProduto;
        } catch (Exception var13) {
            Exception e = var13;
            throw new RuntimeException(e);
        }
    }

    public static void atualizarProduto(Produto produtoAtualizado) {
        ArrayList<Produto> produtos = listarProduto();

        try {
            FileWriter fw = new FileWriter(camainhoArquivo, StandardCharsets.ISO_8859_1);
            fw.write("Id;tipo;nome;descricao;preco;quantidade\n");

            for (Produto p : produtos) {
                if (p.getId() == produtoAtualizado.getId()) {
                    p = produtoAtualizado;
                }
                fw.write(p.getId() + ";" + p.getTipo() + ";" + p.getNome() + ";" + p.getDescricao() + ";" + p.getPreco() + ";" + p.getQuantidade() + "\n");
            }

            fw.flush();
            fw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void removerProdutoPorId(int idProduto) {
        Exception e;
        try {
            File arquivo = new File(camainhoArquivo);
            if (!arquivo.exists()) {
                System.out.println("Arquivo não encontrado.");
                return;
            }
        } catch (Exception var10) {
            e = var10;
            throw new RuntimeException("Erro ao remover produto: " + e.getMessage(), e);
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
                    int id = Integer.parseInt(partes[0]);
                    if (id != idProduto) {
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
            throw new RuntimeException("Erro ao remover produto: " + e.getMessage(), e);
        }
    }

    public static Produto buscarProdutoPorId(int id) {
        Produto produtoEncontrado = null;

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(camainhoArquivo));
            boolean primeiraLinha = true;
            String linha;

            while((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                } else {
                    String[] partes = linha.split(";");
                    int idProduto = Integer.parseInt(partes[0]);

                    if (idProduto == id) {

                        String tipo = partes[1];
                        String nome = partes[2];
                        String descricao = partes[3];
                        double preco = Double.parseDouble(partes[4]);
                        int quantidade = Integer.parseInt(partes[5]);

                        produtoEncontrado = new Produto(idProduto, tipo, nome, descricao, preco, quantidade);
                        break;
                    }
                }
            }

            leitor.close();


            if (produtoEncontrado != null) {
                System.out.println("Produto encontrado: ");
                System.out.println("Id: " + produtoEncontrado.getId());
                System.out.println("Tipo: " + produtoEncontrado.getTipo());
                System.out.println("Nome: " + produtoEncontrado.getNome());
                System.out.println("Descrição: " + produtoEncontrado.getDescricao());
                System.out.println("Preço: " + produtoEncontrado.getPreco());
                System.out.println("Quantidade: " + produtoEncontrado.getQuantidade());
            } else {
                System.out.println("Produto não encontrado.");
            }

            return produtoEncontrado;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto por ID: " + e.getMessage(), e);
        }
    }


    public static void imprimirProdutos() {
        List<Produto> produtos = listarProduto();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }

        for (Produto c : produtos) {
            System.out.println(
                    "Id: " + c.getId()
                            + ", tipo: " + c.getTipo()
                            + ", Nome: " + c.getNome()
                            + ", Descrição: " + c.getDescricao()
                            + ", Preço: " + c.getPreco()
                            + ", quantidade: " + c.getQuantidade());
        }
    }

}
