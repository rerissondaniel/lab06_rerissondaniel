package main.entidade.jogo;

import java.util.Set;

public class Plataforma extends Jogo {

	public static final String REPRESENTACAO_STRING = "Plataforma";

	private int qtdeZerouAnterior;

	public Plataforma(String nome, double preco, int maiorScore,
			Set<Jogabilidade> jogabilidade) throws JogoInvalidoException {
		super(nome, preco, maiorScore, jogabilidade);
	}

	@Override
	public int getX2pJogada() {
		if (qtdeZerouAnterior < getQtdeZerado()) {
			return 20;
		}
		return 0;
	}
}
