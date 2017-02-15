package main.entidade.jogo;

import java.util.Set;

public class Plataforma extends Jogo {

    public static final String REPRESENTACAO_STRING = "Plataforma";
    private static final int FATOR_PONTUACAO_PLATAFORMA = 20;

    private int qtdeZerouAnterior;

    public Plataforma(final String nome, final double preco,
                      final Set<Jogabilidade> jogabilidade) throws JogoInvalidoException {
        super(nome, preco, jogabilidade);
        this.qtdeZerouAnterior = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX2pJogada() {
        if (qtdeZerouAnterior < getQtdeZerado()) {
            qtdeZerouAnterior = getQtdeZerado();
            return FATOR_PONTUACAO_PLATAFORMA;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Plataforma{{" +
                "qtdeZerouAnterior=" + qtdeZerouAnterior +
                '}' + super.toString() + "}";
    }
}
