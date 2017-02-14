package main.entidade.usuario;

import java.util.Map;

import main.entidade.jogo.Jogo;
import main.util.Util;

/**
 * Classe que representa um usuário.
 * 
 * @author rerissondcsm
 *
 */
public class Usuario {
	/**
	 * Nome deste usuário.
	 */
	private String nome;

	/**
	 * Quantia disponível para a conta deste usuário.
	 */
	private int dinheiro;

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
	 * @param nomeJogo
	 *            - Nome do jogo que foi jogado.
	 * @param score
	 *            - Score do jogo que foi jogado.
	 * @param zerou
	 *            - Indica se o jogo foi zerado.
	 */
	public void registraJogada(String nomeJogo, int score, boolean zerou) {
		Jogo jogo = jogosComprados.get(nomeJogo);
		this.x2p += jogo.registraJogada(score, zerou);
	}

	public void adicionaJogo(Jogo jogo) {
		jogosComprados.put(jogo.getNome(), jogo);
		this.x2p += role.getx2pCompra(jogo.getPreco());
	}

	public int getQuantidadeDeJogosComprados() {
		return jogosComprados.size();
	}

	public double getDesconto() {
		return role.getDesconto();
	}

	public int getX2pInicial() {
		return role.getX2pInicial();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
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

	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
}
