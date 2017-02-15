/**
 *
 */
package test.entidade;

import java.util.HashSet;
import java.util.Set;

import main.entidade.jogo.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author rerissondcsm
 */
public class JogoTest {

    Jogo jogo1, jogo2, aux;
    Set<Jogabilidade> jogabilidades1;

    @Before
    public void setup() throws JogoInvalidoException {
        jogabilidades1 = new HashSet();
        jogabilidades1.add(Jogabilidade.COMPETITIVO);
        jogabilidades1.add(Jogabilidade.MULTIPLAYER);
        jogabilidades1.add(Jogabilidade.OFFLINE);
        jogo1 = new Rpg("Final Fantasy XIV", 5000, jogabilidades1);

        jogabilidades1 = new HashSet();
        jogabilidades1.add(Jogabilidade.OFFLINE);
        jogo2 = new Plataforma("Valkyrie Profile", 20000, jogabilidades1);
    }

    @Test(expected = JogoInvalidoException.class)
    public void testaCriacaoNomeNulo() throws JogoInvalidoException {
        Jogo jogo = new Luta(null, 50.00, jogabilidades1);
    }

    @Test(expected = JogoInvalidoException.class)
    public void testaCriacaoNomeVazio() throws JogoInvalidoException {
        Jogo jogo = new Luta("", 50.00, jogabilidades1);
    }

    @Test(expected = JogoInvalidoException.class)
    public void testaCriacaoJogabilidadeNula() throws JogoInvalidoException {
        Jogo jogo = new Luta(null, 50.00, null);
    }

    @Test
    public void testHashCodeEquals() throws JogoInvalidoException {
        Assert.assertNotSame(jogo1, jogo2);
        aux = new Rpg(jogo1.getNome(), jogo1.getPreco(), jogo1.getJogabilidade());
        Assert.assertEquals(jogo1, aux);
        Assert.assertEquals(jogo1.hashCode(), aux.hashCode());
    }

    public void testaGetX2p() throws JogoInvalidoException {
        jogo1 = new Rpg("Final Fantasy XIV", 5000, jogabilidades1);
        Assert.assertEquals(jogo1.getX2pJogada());
    }

    @Test
    public void testaRegistraJogada() {
        jogo1.registraJogada(2, true);
        jogo1.registraJogada(5, false);
        jogo1.registraJogada(1, true);
        Assert.assertEquals(5, jogo1.getMaiorScore());
        Assert.assertEquals(2, jogo1.getQtdeZerado());
        Assert.assertEquals(3, jogo1.getQtdeVezesJogadas());
    }

}
