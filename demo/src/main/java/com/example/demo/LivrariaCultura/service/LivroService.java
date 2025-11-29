package com.example.demo.LivrariaCultura.service;

import com.example.demo.LivrariaCultura.model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroService {

    private List<Livro> livros = new ArrayList<>();

    public LivroService() {
        // Adiciona Dom Casmurro automaticamente
        livros.add(Livro.DOM_CASMURRO);
    }

    public Livro adicionarLivro(Livro livro) {
        livros.add(livro);
        return livro;
    }

    public Livro buscarPorId(int id) {
        return livros.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public boolean removerLivro(int id) {
        return livros.removeIf(l -> l.getId() == id);
    }

    public Livro atualizarAvaliacao(int id, double novaAvaliacao) {
        Livro livro = buscarPorId(id);
        if (livro != null) {
            livro.setAvaliacao(novaAvaliacao);
        }
        return livro;
    }
}
