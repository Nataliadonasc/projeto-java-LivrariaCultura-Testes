package com.example.demo.LivrariaCultura.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.LivrariaCultura.model.Resenha;

public class ResenhaService {

    private List<Resenha> resenhas = new ArrayList<>();

    public void adicionarResenha(Resenha resenha) {
        resenhas.add(resenha);
    }

    public Resenha buscarPorId(int id) {
        return resenhas.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean removerPorId(int id) {
        return resenhas.removeIf(r -> r.getId() == id);
    }

    public List<Resenha> listarTodas() {
        return resenhas;
    }

    public int quantidade() {
        return resenhas.size();
    }

    // Valida se o comentário tem no máximo 500 caracteres
    public boolean validarTamanhoComentario(String comentario) {
        return comentario != null && comentario.length() <= 500;
    }
}
