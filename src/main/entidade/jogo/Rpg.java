package main.entidade.jogo;

import java.util.Set;

public class Rpg extends Jogo {

	public static final String REPRESENTACAO_STRING = "Rpg";
	
	public Rpg(String nome, double preco, int maiorScore,
			Set<Jogabilidade> jogabilidade) throws JogoInvalidoException {
		super(nome, preco, maiorScore, jogabilidade);
	}

	@Override
	public final int getX2pJogada() {
		return 10;
	}
}
