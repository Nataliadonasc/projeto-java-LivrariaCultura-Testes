package com.example.demo.LivrariaCultura.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.LivrariaCultura.model.Usuario;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    // Adiciona usuário
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Retorna todos
    public List<Usuario> listarTodos() {
        return usuarios;
    }

    // Remove por email (já que seu modelo não tem ID)
    public boolean removerPorEmail(String email) {
        return usuarios.removeIf(u -> u.getEmail().equalsIgnoreCase(email));
    }

    // Busca por email
    public Usuario buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    // Quantidade de usuários cadastrados
    public int quantidade() {
        return usuarios.size();
    }

    // Validar login
    public boolean validarLogin(String email, String senha) {
        Usuario usuario = buscarPorEmail(email);

        if (usuario == null) return false;

        return usuario.getSenha().equals(senha);
    }
}
