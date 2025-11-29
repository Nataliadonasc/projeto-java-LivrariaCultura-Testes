package com.example.demo.LivrariaCultura.model;

public class Resenha {

    private int id;
    private int livroId;
    private int usuarioId;
    private String comentario;

    // 🔥 Resenha fictícia de Dom Casmurro já incluída no modelo
    public Resenha() {
        this.id = 1;
        this.livroId = 101;    // ID fictício do livro
        this.usuarioId = 500;  // ID fictício do usuário
        this.comentario = 
                "Dom Casmurro é uma obra-prima de Machado de Assis. "
                + "A narrativa de Bentinho é envolvente e traz a dúvida eterna "
                + "sobre a possível traição de Capitu. A escrita irônica e "
                + "reflexiva transforma o romance em uma das obras mais "
                + "importantes da literatura brasileira.";
    }

    // Construtor opcional caso queira criar manualmente
    public Resenha(int id, int livroId, int usuarioId, String comentario) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.comentario = comentario;
    }

    // GETTERS E SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
