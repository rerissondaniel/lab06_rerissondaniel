package main.entidade.usuario;

import java.util.Map;

import main.entidade.jogo.Jogo;
import main.entidade.jogo.Luta;

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
	 * Login utilizado para acesso ao sistema. É único para cada usuário.
	 */
	private String login;

	/**
	 * Lista dos jogos comprados por este usuário.
	 */
	private Map<String, Jogo> jogosComprados;

	/**
	 * Quantidade de experiência deste usuário.
	 */
	private int x2p;

	/**
	 * Score máximo em jogos de luta.
	 */
	private int scoreMaximoLuta;

	/**
	 * Papel deste usuário.
	 */
	private RoleUsuario role;

	public Usuario(String nome, String login, Map<String, Jogo> jogosComprados,
			RoleUsuario role) {
		super();
		this.nome = nome;
		this.login = login;
		this.jogosComprados = jogosComprados;
		this.role = role;
		this.x2p = role.getX2pInicial();
	}

	public void registraJogada(String nomeJogo, int score, boolean zerou) {
		Jogo jogo = jogosComprados.get(nomeJogo);
		this.x2p += jogo.registraJogada(score, zerou);
		if (jogo instanceof Luta) {
			this.scoreMaximoLuta = Math.max(scoreMaximoLuta, score);
		}
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

	public RoleUsuario getRole() {
		return role;
	}

	public void setRole(RoleUsuario role) {
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
}
