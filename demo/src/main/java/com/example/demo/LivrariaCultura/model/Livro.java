package com.example.demo.LivrariaCultura.model;

public class Livro {
    
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private double avaliacao;
    private String resenha;

    // Livro padrão (Machado de Assis)
    public static final Livro DOM_CASMURRO = new Livro(
        1,
        "Dom Casmurro",
        "Machado de Assis",
        1899,
        5.0,
        "Um dos mais importantes romances brasileiros, marcado pela narrativa irônica e pela dúvida sobre a traição de Capitu."
    );

    // Construtor completo
    public Livro(int id, String titulo, String autor, int anoPublicacao, double avaliacao, String resenha) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        setAvaliacao(avaliacao);
        this.resenha = resenha;
    }

    // Construtor simples
    public Livro(String titulo, String autor, double avaliacao) {
        this.titulo = titulo;
        this.autor = autor;
        setAvaliacao(avaliacao);
    }

    // GETTERS E SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public double getAvaliacao() { return avaliacao; }
    public void setAvaliacao(double avaliacao) {
        if (avaliacao < 0 || avaliacao > 5) {
            throw new IllegalArgumentException("A avaliação deve ser entre 0 e 5.");
        }
        this.avaliacao = avaliacao;
    }

    public String getResenha() { return resenha; }
    public void setResenha(String resenha) { this.resenha = resenha; }
}
