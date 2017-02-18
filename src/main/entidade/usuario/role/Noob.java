package main.entidade.usuario.role;

import main.entidade.jogo.Jogo;

/**
 * Classe que representa o role do usuário noob.
 *
 * @author rerissondcsm
 */
public class Noob implements Role {

    private static final int X2P_INICIAL_NOOB = 0;
    private static final double DESCONTO_NOOB = 0.10;

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDesconto() {
        return DESCONTO_NOOB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int getX2pInicial() {
        return X2P_INICIAL_NOOB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Noob";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getx2pCompra(double precoJogo) {
        return (int) precoJogo * 10;
    }
}
