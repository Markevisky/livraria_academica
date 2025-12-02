import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CatalogoLivros {
    private HashMap<String, Livro> livros = new HashMap<>();
    private Set<String> isbns = new HashSet<>();

    public void adicionarLivro(Livro livro) throws LivroJaExisteException {
        if (isbns.contains(livro.getIsbn())) {
            throw new LivroJaExisteException("Livro com ISBN já existe: " + livro.getIsbn());
        }
        livros.put(livro.getIsbn(), livro);
        isbns.add(livro.getIsbn());
    }

    public void removerLivro(String isbn) throws LivroNaoEncontradoException {
        if (!livros.containsKey(isbn)) {
            throw new LivroNaoEncontradoException("Livro com ISBN não encontrado: " + isbn);
        }
        livros.remove(isbn);
        isbns.remove(isbn);
    }

    public Livro buscarLivro(String isbn) throws LivroNaoEncontradoException {
        if (!livros.containsKey(isbn)) {
            throw new LivroNaoEncontradoException("Livro com ISBN não encontrado: " + isbn);
        }
        return livros.get(isbn);
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Catálogo vazio.");
        } else {
            livros.values().forEach(System.out::println);
        }
    }

    public void salvarCatalogo(String caminho) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminho))) {
            out.writeObject(livros);
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarCatalogo(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminho))) {
            livros = (HashMap<String, Livro>) in.readObject();
            isbns = new HashSet<>(livros.keySet());
        }
    }
}