package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.LivrariaCultura.model.Usuario;
import com.example.demo.LivrariaCultura.service.UsuarioService;

public class UsuarioTest {

    @Test
    @DisplayName("Verifica se o email é válido")
    void testEmailValido() {
        Usuario usuario = new Usuario();
        assertTrue(usuario.isEmailValido());
    }

    @Test
    @DisplayName("Verifica se a senha possui no mínimo 6 caracteres")
    void testSenhaValida() {
        Usuario usuario = new Usuario();
        assertTrue(usuario.isSenhaValida());
    }

    @Test
    @DisplayName("Adicionar usuário ao serviço")
    void testAdicionarUsuario() {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario();

        service.adicionarUsuario(usuario);

        assertEquals(1, service.quantidade());
    }

    @Test
    @DisplayName("Buscar usuário por email")
    void testBuscarPorEmail() {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario();

        service.adicionarUsuario(usuario);

        Usuario encontrado = service.buscarPorEmail("joao.silva@example.com");

        assertNotNull(encontrado);
        assertEquals("João Silva", encontrado.getNome());
    }

    @Test
    @DisplayName("Remover usuário pelo email")
    void testRemoverUsuario() {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario();

        service.adicionarUsuario(usuario);

        boolean removido = service.removerPorEmail("joao.silva@example.com");

        assertTrue(removido);
        assertEquals(0, service.quantidade());
    }

    @Test
    @DisplayName("Validar login com dados corretos")
    void testLoginCorreto() {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario();

        service.adicionarUsuario(usuario);

        assertTrue(service.validarLogin("joao.silva@example.com", "senha123"));
    }

    @Test
    @DisplayName("Validar login com email incorreto")
    void testLoginEmailErrado() {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario();

        service.adicionarUsuario(usuario);

        assertFalse(service.validarLogin("emailerrado@example.com", "senha123"));
    }

    @Test
    @DisplayName("Validar login com senha incorreta")
    void testLoginSenhaErrada() {
        UsuarioService service = new UsuarioService();
        Usuario usuario = new Usuario();

        service.adicionarUsuario(usuario);

        assertFalse(service.validarLogin("joao.silva@example.com", "senhaErrada"));
    }
}
