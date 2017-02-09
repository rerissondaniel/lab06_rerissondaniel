package main.entidade.jogo;

import java.util.Set;

public class Rpg extends Jogo {

	public Rpg(String nome, int preco, int maiorScore,
			Set<Jogabilidade> jogabilidade) {
		super(nome, preco, maiorScore, jogabilidade);
	}

	@Override
	public final int getX2pJogada() {
		return 10;
	}

}
