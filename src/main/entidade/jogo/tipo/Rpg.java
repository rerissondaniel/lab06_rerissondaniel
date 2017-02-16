package main.entidade.jogo.tipo;

import main.entidade.jogo.Jogabilidade;
import main.entidade.jogo.Jogo;
import main.entidade.jogo.exception.JogoInvalidoException;

import java.util.Set;

public class Rpg extends Jogo {

    public static final String REPRESENTACAO_STRING = "Rpg";
    private static final int FATOR_PONTUACAO_RPG = 10;

    public Rpg(final String nome, final double preco,
               final Set<Jogabilidade> jogabilidade) throws JogoInvalidoException {
        super(nome, preco, jogabilidade);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int getX2pJogada() {
        return FATOR_PONTUACAO_RPG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Rpg{" + super.toString() + "}";
    }
}
