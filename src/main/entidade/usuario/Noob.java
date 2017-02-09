package main.entidade.usuario;

import main.entidade.jogo.Jogo;

/**
 * Classe que representa o role do usuário noob.
 * 
 * @author rerissondcsm
 *
 */
public class Noob extends RoleUsuario {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getDesconto() {
		return 0.10;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final int getX2pInicial() {
		return 0;
	}
	
	public int getX2pCompra(Jogo jogo) {
		return (int) Math.floor(10.0 * jogo.getPreco() / 100.0);
	}
}
