package test.controlador;

import main.controlador.LojaControlador;
import main.controlador.implementacao.LojaControladorImpl;
import main.entidade.jogo.Jogo;
import main.entidade.jogo.exception.JogoInvalidoException;
import main.entidade.usuario.exception.UsuarioInvalidoException;
import main.service.exception.SaldoInsuficienteException;
import main.service.exception.UsuarioInaptoException;
import org.junit.Assert;
import org.junit.Test;
import test.util.TestUtils;

import java.util.HashSet;

/**
 * Testes para {@link LojaControladorImpl}
 * Created by rerissondcsm on 17/02/17.
 */
public class LojaControllerImplTest {

    private LojaControlador controlador;

    @Test
    public void testaAdicionaUsuario() throws UsuarioInvalidoException {
        controlador = new LojaControladorImpl(TestUtils.getMapaUsuarios(), TestUtils.getFormatadora());
        String login = "marcos";
        String nome = "Marcos";
        controlador.adicionaUsuario(nome, login, "Noob");
    }

    @Test
    public void testaAdicionarDinheiroUsuario() throws JogoInvalidoException, SaldoInsuficienteException, UsuarioInvalidoException {
        controlador = new LojaControladorImpl(TestUtils.getMapaUsuarios(), TestUtils.getFormatadora());
        Assert.assertTrue(controlador.adicionarDinheiroUsuario("mauro", 25.00));
        Jogo tekken = TestUtils.getJogos().get("Tekken");
        controlador.vendeJogo("mauro", tekken.getNome(), new HashSet<>(), tekken.getPreco(), "luta");
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testaVendeJogoSaldoInsuficiente() throws JogoInvalidoException, SaldoInsuficienteException, UsuarioInvalidoException {
        controlador = new LojaControladorImpl(TestUtils.getMapaUsuarios(), TestUtils.getFormatadora());
        Assert.assertTrue(controlador.adicionarDinheiroUsuario("mauro", 25.00));
        Jogo tekken = TestUtils.getJogos().get("Tekken");
        controlador.vendeJogo("mauro", tekken.getNome(), new HashSet<>(), tekken.getPreco(), "luta");
        Jogo finalFantasy = TestUtils.getJogos().get("Final Fantasy X");
        controlador.vendeJogo("mauro", finalFantasy.getNome(), new HashSet<>(), finalFantasy.getPreco(), "luta");
    }

    @Test
    public void testaVendeJogo() throws JogoInvalidoException, SaldoInsuficienteException, UsuarioInvalidoException {
        controlador = new LojaControladorImpl(TestUtils.getMapaUsuarios(), TestUtils.getFormatadora());
        Assert.assertTrue(controlador.adicionarDinheiroUsuario("mauro", 40.00));
        Jogo tekken = TestUtils.getJogos().get("Tekken");
        controlador.vendeJogo("mauro", tekken.getNome(), new HashSet<>(), tekken.getPreco(), "luta");
        Jogo finalFantasy = TestUtils.getJogos().get("Final Fantasy X");
        controlador.vendeJogo("mauro", finalFantasy.getNome(), new HashSet<>(), finalFantasy.getPreco(), "luta");
    }

    @Test
    public void testaUpgrade() throws UsuarioInvalidoException, UsuarioInaptoException {
        controlador = new LojaControladorImpl(TestUtils.getMapaUsuarios(), TestUtils.getFormatadora());
    }

    @Test
    public void testaRegistraJogada() throws JogoInvalidoException, UsuarioInvalidoException {

    }
}
