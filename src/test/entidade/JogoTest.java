/**
 * 
 */
package test.entidade;

import java.util.HashSet;
import java.util.Set;

import main.entidade.jogo.Jogabilidade;
import main.entidade.jogo.Jogo;
import main.entidade.jogo.TipoJogo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author rerissondcsm
 *
 */
public class JogoTest {

	Jogo jogo1, jogo2, aux;

	@Before
	public void setup() {
		Set<Jogabilidade> jogabilidade = new HashSet();
		jogabilidade.add(Jogabilidade.COMPETITIVO);
		jogabilidade.add(Jogabilidade.MULTIPLAYER);
		jogabilidade.add(Jogabilidade.OFFLINE);
		jogo1 = new Rpg("Final Fantasy X", 50.00, 0, jogabilidade);

		jogabilidade = new HashSet();
		jogabilidade.add(Jogabilidade.OFFLINE);
		jogo1 = new Plataforma("Valkyrie Profile", 20.00, 0, null);
	}

	@Test
	public void testHashCodeEquals() {
		Assert.assertNotSame(jogo1, jogo2);
		aux = new Luta(jogo1.getNome(), jogo1.getPreco(), jogo1.getMaiorScore(), jogo1.getJogabilidade());
		Assert.assertEquals(jogo1, aux);
		Assert.assertEquals(jogo1.hashCode(), aux.hashCode());
	}
	
	@Test
	public void testaRegistraJogada(){
		jogo1.registraJogada(2, true);
		jogo1.registraJogada(5, false);
		jogo1.registraJogada(1, true);
		Assert.assertEquals(5, jogo1.getMaiorScore());
		Assert.assertEquals(2, jogo1.getQtdeZerado());
		Assert.assertEquals(3, jogo1.getQtdeVezesJogadas());
	}

}
