package main.entidade.usuario;

import java.util.*;

import main.entidade.jogo.Jogo;
import main.entidade.usuario.role.Role;
import main.util.Util;

/**
 * Classe que representa um usuário.
 *
 * @author rerissondcsm
 */
public class Usuario {
    /**
     * Nome deste usuário.
     */
    private String nome;

    /**
     * Quantia disponível para a conta deste usuário.
     */
    private double dinheiro;

    /**
     * Login utilizado para acesso ao sistema. É único para cada usuário.
     */
    private String login;

    /**
     * Conjunto dos jogos comprados por este usuário.
     */
    private Map<String, Jogo> jogosComprados;

    /**
     * Quantidade de experiência deste usuário.
     */
    private int x2p;

    /**
     * Papel deste usuário.
     */
    private Role role;

    /**
     * Construtor.
     *
     * @param nome
     * @param login
     * @param jogosComprados
     * @param role
     * @throws UsuarioInvalidoException
     */
    public Usuario(String nome, String login, Map<String, Jogo> jogosComprados,
                   Role role) throws UsuarioInvalidoException {
        if (Util.ehNulaOuVazia(login)) {
            throw new UsuarioInvalidoException("O login do usuário é inválido!");
        }
        if (Util.ehNulaOuVazia(nome)) {
            throw new UsuarioInvalidoException("O nome do usuário é inválido!");
        }
        this.nome = nome;
        this.login = login;
        this.jogosComprados = jogosComprados;
        this.role = role;
        this.x2p = role.getX2pInicial();
    }

    /**
     * Registra uma jogada deste jogo.
     *
     * @param nomeJogo - Nome do jogo que foi jogado.
     * @param score    - Score do jogo que foi jogado.
     * @param zerou    - Indica se o jogo foi zerado.
     */
    public void registraJogada(final String nomeJogo, final int score, final boolean zerou) {
        Jogo jogo = jogosComprados.get(nomeJogo);
        this.x2p += jogo.registraJogada(score, zerou);
    }

    /**
     * Adiciona um jogo ao jogos comprados por este usuário.
     * Assume que esta é uma venda válida, isto é, este usuário pode comprar {@code jogo}, independentemente de
     * seu saldo ficar negativo ou não.
     *
     * @param jogo
     */
    public void adicionaJogo(final Jogo jogo) {
        this.dinheiro -= jogo.getPreco();
        jogosComprados.put(jogo.getNome(), jogo);
        this.x2p += role.getx2pCompra(jogo.getPreco());
    }

    /**
     * @return os jogos comprados por este usuário.
     */
    public Collection<Jogo> getJogosComprados() {
        return jogosComprados.values();
    }

    public double getDesconto() {
        return role.getDesconto();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public int getX2p() {
        return x2p;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(final double dinheiro) {
        this.dinheiro = dinheiro;
    }
}
