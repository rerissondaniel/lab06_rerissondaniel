package main.entidade.usuario.role;

import main.entidade.jogo.Jogo;

/**
 * Classe que representa o Role do usuário veterano.
 *
 * @author rerissondcsm
 */
public class Veterano implements Role {

    private static final double DESCONTO_VETERANO = 0.20;
    private static final int X2P_INICIAL_VETERANO = 1000;

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDesconto() {
        return DESCONTO_VETERANO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int getX2pInicial() {
        return X2P_INICIAL_VETERANO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Veterano";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getx2pCompra(double precoJogo) {
        return (int) precoJogo * 15;
    }
}