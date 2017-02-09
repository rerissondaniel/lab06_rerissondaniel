package main.entidade.jogo;

import java.util.Set;

public class Plataforma extends Jogo {

	public Plataforma(String nome, int preco, int maiorScore,
			Set<Jogabilidade> jogabilidade) {
		super(nome, preco, maiorScore, jogabilidade);
	}

	@Override
	public int getX2pJogada() {
		return 20;
	}

}
