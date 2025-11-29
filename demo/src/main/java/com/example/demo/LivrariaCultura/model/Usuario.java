package com.example.demo.LivrariaCultura.model;

public class Usuario {

    private String nome = "João Silva";               // Exemplo de nome
    private String email = "joao.silva@example.com"; // Exemplo de email
    private String senha = "senha123";               // Exemplo de senha

    public Usuario() {
        // construtor padrão mantém os dados fictícios acima
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // GETTERS e SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // VALIDAÇÕES
    public boolean isEmailValido() {
        return email != null && email.contains("@") && email.contains(".");
    }

    public boolean isSenhaValida() {
        return senha != null && senha.length() >= 6;
    }
}
