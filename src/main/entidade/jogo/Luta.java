package main.entidade.jogo;

import java.util.Set;

public class Luta extends Jogo {
	
	public static final String REPRESENTACAO_STRING = "Luta";

	private int maiorScoreAnterior;

	public Luta(String nome, double preco, int maiorScore,
			Set<Jogabilidade> jogabilidade) throws JogoInvalidoException {
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
