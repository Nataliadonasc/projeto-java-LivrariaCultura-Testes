package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.LivrariaCultura.model.Resenha;
import com.example.demo.LivrariaCultura.service.ResenhaService;

public class ResenhaTest {

    @Test
    @DisplayName("Criar resenha padrão e verificar se o comentário não é vazio")
    void testComentarioPadrao() {
        Resenha r = new Resenha();
        assertNotNull(r.getComentario());
        assertFalse(r.getComentario().isEmpty());
    }

    @Test
    @DisplayName("Adicionar resenha ao service")
    void testAdicionarResenha() {
        ResenhaService service = new ResenhaService();
        Resenha r = new Resenha();

        service.adicionarResenha(r);

        assertEquals(1, service.quantidade());
    }

    @Test
    @DisplayName("Buscar resenha por ID")
    void testBuscarPorId() {
        ResenhaService service = new ResenhaService();
        Resenha r = new Resenha();

        service.adicionarResenha(r);

        Resenha encontrada = service.buscarPorId(1);

        assertNotNull(encontrada);
        assertEquals(1, encontrada.getId());
    }

    @Test
    @DisplayName("Remover resenha por ID")
    void testRemoverPorId() {
        ResenhaService service = new ResenhaService();
        Resenha r = new Resenha();

        service.adicionarResenha(r);

        boolean removida = service.removerPorId(1);

        assertTrue(removida);
        assertEquals(0, service.quantidade());
    }

    @Test
    @DisplayName("Listar todas as resenhas")
    void testListarTodas() {
        ResenhaService service = new ResenhaService();
        service.adicionarResenha(new Resenha());
        service.adicionarResenha(new Resenha());

        assertEquals(2, service.listarTodas().size());
    }

    @Test
    @DisplayName("Validar tamanho da resenha: válido")
    void testValidarTamanhoValido() {
        ResenhaService service = new ResenhaService();
        String comentario = "Ótimo livro! Muito envolvente.";

        assertTrue(service.validarTamanhoComentario(comentario));
    }

    @Test
    @DisplayName("Validar tamanho da resenha: inválido (>500 chars)")
    void testValidarTamanhoInvalido() {
        ResenhaService service = new ResenhaService();

        String comentario = "a".repeat(501);
        assertFalse(service.validarTamanhoComentario(comentario));
    }

    @Test
    @DisplayName("Criar resenha manualmente e verificar os campos")
    void testCriarResenhaManual() {
        Resenha r = new Resenha(10, 200, 300, "Comentário teste");

        assertEquals(10, r.getId());
        assertEquals(200, r.getLivroId());
        assertEquals(300, r.getUsuarioId());
        assertEquals("Comentário teste", r.getComentario());
    }
}
