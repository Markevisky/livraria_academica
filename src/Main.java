import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public class Main {
    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros();

        try {
            Livro livro1 = new Livro("123", "Java Básico", "Ana Costa");
            Livro livro2 = new Livro("456", "POO Avançado", "Carlos Silva");

            catalogo.adicionarLivro(livro1);
            catalogo.adicionarLivro(livro2);

            catalogo.listarLivros();

            System.out.println("\nBuscando livro 123:");
            System.out.println(catalogo.buscarLivro("123"));

            System.out.println("\nRemovendo livro 456:");
            catalogo.removerLivro("456");

            catalogo.salvarCatalogo("catalogo.dat");

            System.out.println("\nCatálogo salvo. Limpando e recarregando...");
            catalogo = new CatalogoLivros();
            catalogo.carregarCatalogo("catalogo.dat");
            catalogo.listarLivros();

        } catch (LivroJaExisteException | LivroNaoEncontradoException e) {
            System.err.println("Erro de catálogo: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Erro de classe: " + e.getMessage());
        }
    }
}