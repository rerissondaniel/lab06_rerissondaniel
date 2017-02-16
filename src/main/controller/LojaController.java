package main.controller;

import main.entidade.jogo.exception.JogoInvalidoException;
import main.entidade.usuario.UsuarioInvalidoException;
import main.service.exception.SaldoInsuficienteException;
import main.service.exception.UsuarioInaptoException;

import java.util.List;
import java.util.Set;

public interface LojaController {

    int X2P_MINIMO_VETERANO = 1000;

    void adicionaUsuario(final String nome, final String login)
            throws UsuarioInvalidoException;

    boolean adicionarDinheiroUsuario(final String login, final double quantia);


    List<String> getRelatorioUsuarios();


    void vendeJogo(final String login, final String nomeJogo, final Set<String> jogabilidadesStr,
                   final double preco, final String tipo)
            throws JogoInvalidoException, SaldoInsuficienteException, UsuarioInvalidoException;


    void upgrade(final String login) throws UsuarioInvalidoException, UsuarioInaptoException;

}
