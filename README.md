# 📚 Sistema de Gerenciamento de Catálogo de Livros em Java

Este projeto implementa um sistema simplificado de gerenciamento de um catálogo de livros utilizando **coleções avançadas** da linguagem Java e um **robusto sistema de tratamento de exceções**.  

O sistema foi desenvolvido com foco em boas práticas de Programação Orientada a Objetos (POO), manipulação de dados e persistência via serialização.

---

## ✨ Funcionalidades

- Adicionar livros ao catálogo utilizando **HashMap** (ISBN como chave única).
- Remover livros do catálogo com validação de existência.
- Buscar livros por ISBN.
- Listar todos os livros cadastrados.
- Salvar e carregar o catálogo em arquivo (`catalogo.dat`) usando **serialização**.
- Tratamento de exceções:
  - `FileNotFoundException` e `IOException` em operações de I/O.
  - Exceções personalizadas (`LivroJaExisteException`, `LivroNaoEncontradoException`) para regras de negócio.
- Validação de ISBN duplicado com uso de **Set**.

---

## 🗂 Estrutura do Projeto

src/  
├─ Livro.java  
├─ CatalogoLivros.java  
├─ LivroJaExisteException.java  
├─ LivroNaoEncontradoException.java  
└─ Main.java

---

## ⚙️ Como Compilar e Executar

### 🔹 Windows (PowerShell ou CMD)
```powershell
javac -d bin src\*.java ; java -cp bin Main
```
### Linux / macOS (bash/zsh)
```Linux / macOS (bash/zsh)
mkdir -p bin
```
```
javac -d bin src\*.java && java -cp bin Main
```

📤 Saída Esperada
O programa demonstra:
- Inclusão de livros no catálogo.
- Busca e remoção de livros por ISBN.
- Persistência do catálogo em arquivo e recarregamento posterior.
Exemplo de saída:
```
ISBN: 123, Título: Java Básico, Autor: Ana Costa
ISBN: 456, Título: POO Avançado, Autor: Carlos Silva

Buscando livro 123:
ISBN: 123, Título: Java Básico, Autor: Ana Costa

Removendo livro 456...
Catálogo salvo. Limpando e recarregando...
ISBN: 123, Título: Java Básico, Autor: Ana Costa
```
🎯 Objetivo
Este sistema reforça conceitos de POO, coleções avançadas e tratamento de exceções em Java, demonstrando como construir aplicações mais seguras, organizadas e fáceis de manter.
