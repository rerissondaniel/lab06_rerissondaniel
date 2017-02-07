package main.entidade;
import java.util.List;

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
	private List<Jogo> jogosComprados;
	
	private RoleUsuario role;
}
