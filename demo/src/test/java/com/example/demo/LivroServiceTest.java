package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.LivrariaCultura.model.Livro;
import com.example.demo.LivrariaCultura.service.LivroService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LivroServiceTest {

    private LivroService service;

    @BeforeEach
    void setup() {
        service = new LivroService();
    }

    // 1
    @Test
    void testAdicionarLivro() {
        Livro novo = new Livro(2, "O Alienista", "Machado de Assis", 1882, 4.5,
                "Uma sátira sobre ciência e loucura.");

        service.adicionarLivro(novo);

        assertEquals(2, service.listarLivros().size());
    }

    // 2
    @Test
    void testBuscarPorId() {
        Livro livro = service.buscarPorId(1);

        assertNotNull(livro);
        assertEquals("Dom Casmurro", livro.getTitulo());
    }

    // 3
    @Test
    void testRemoverLivro() {
        boolean removido = service.removerLivro(1);

        assertTrue(removido);
        assertEquals(0, service.listarLivros().size());
    }

    // 4
    @Test
    void testAtualizarAvaliacao() {
        Livro atualizado = service.atualizarAvaliacao(1, 4.0);

        assertNotNull(atualizado);
        assertEquals(4.0, atualizado.getAvaliacao());
    }

    // 5
    @Test
    void testListarLivros() {
        List<Livro> lista = service.listarLivros();

        assertFalse(lista.isEmpty());
        assertEquals("Dom Casmurro", lista.get(0).getTitulo());
    }

    // NOVOS TESTES ==========================

    // 6 — Buscar livro inexistente
    @Test
    void testBuscarLivroInexistente() {
        Livro livro = service.buscarPorId(999); // não existe
        assertNull(livro);
    }

    // 7 — Atualizar avaliação de livro inexistente
    @Test
    void testAtualizarAvaliacaoLivroInexistente() {
        Livro atualizado = service.atualizarAvaliacao(999, 3.0);
        assertNull(atualizado);
    }

    // 8 — Remover livro inexistente
    @Test
    void testRemoverLivroInexistente() {
        boolean removido = service.removerLivro(999);
        assertFalse(removido);
    }
}
