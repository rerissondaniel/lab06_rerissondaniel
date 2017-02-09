package main.entidade.jogo;

import java.util.Set;

public class Luta extends Jogo {

	private int maiorScoreAnterior;

	public Luta(String nome, int preco, int maiorScore,
			Set<Jogabilidade> jogabilidade) {
		super(nome, preco, maiorScore, jogabilidade);
	}

	@Override
	public int getX2pJogada() {
		if (this.maiorScoreAnterior < getMaiorScore()) {
			maiorScoreAnterior = getMaiorScore();
			return (int) (getMaiorScore() / 1000);
		}
		return 0;
	}

}
