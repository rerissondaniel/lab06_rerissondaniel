package main.entidade.jogo;

import java.util.Set;

public class Luta extends Jogo {

    public static final String REPRESENTACAO_STRING = "Luta";
    private static final int FATOR_PONTUACAO_LUTA = 1000;

    private int maiorScoreAnterior;

    public Luta(final String nome, final double preco,
                final Set<Jogabilidade> jogabilidade) throws JogoInvalidoException {
        super(nome, preco, jogabilidade);
        maiorScoreAnterior = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX2pJogada() {
        if (this.maiorScoreAnterior < getMaiorScore()) {
            maiorScoreAnterior = getMaiorScore();
            return getMaiorScore() / FATOR_PONTUACAO_LUTA;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Luta{{" +
                "maiorScoreAnterior=" + maiorScoreAnterior +
                '}' + super.toString() + "}";
    }
}
