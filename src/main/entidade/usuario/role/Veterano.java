package main.entidade.usuario.role;

import main.entidade.jogo.Jogo;

/**
 * Classe que representa o Role do usuário veterano.
 * 
 * @author rerissondcsm
 *
 */
public class Veterano extends Role {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getDesconto() {
		return 0.20;
	}

	@Override
	public final int getX2pInicial() {
		return 1000;
	}

	public int getX2pCompra(Jogo jogo) {
		return (int) Math.floor(10.0 * jogo.getPreco() / 100.0);
	}

	@Override
	public String toString() {
		return "Veterano";
	}

	@Override
	public int getx2pCompra(double precoJogo) {
		return (int)precoJogo * 15;
	}
}
