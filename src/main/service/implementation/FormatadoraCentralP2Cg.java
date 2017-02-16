package main.service.implementation;

import main.entidade.jogo.Jogo;
import main.entidade.usuario.Usuario;
import main.service.Formatadora;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by rerissondcsm on 15/02/17.
 */
public class FormatadoraCentralP2Cg implements Formatadora {

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<String> formataDadosUsuario(final Collection<Usuario> usuarios) {
        List<String> relatorio = new ArrayList<>();
        double total = 0;

        for (Usuario usuario : usuarios) {
            String dadosUsuario = getStringFormatadaUsuario(usuario);
            for (Jogo jogo : usuario.getJogosComprados()) {
                dadosUsuario += getStringFormatadaJogo(jogo);
                total += jogo.getPreco();
            }
            relatorio.add(dadosUsuario);
        }

        String totalStr = "Total de preço dos jogos: " + String.format("%.2f", total) + System.lineSeparator();
        relatorio.add(totalStr);
        return relatorio;
    }

    private final String getStringFormatadaUsuario(final Usuario usuario) {
        String dadosUsuario = usuario.getLogin() + System.lineSeparator();
        dadosUsuario += usuario.getNome() + " - " + usuario.getRole() + System.lineSeparator() + System.lineSeparator();
        dadosUsuario += "Lista de Jogos:" + System.lineSeparator();
        return dadosUsuario;
    }

    private final String getStringFormatadaJogo(final Jogo jogo) {
        String dadosUsuario = "";
        dadosUsuario += "+ " + jogo.getNome() + System.lineSeparator();
        dadosUsuario += "==> Jogou " + jogo.getQtdeVezesJogadas() + "vez(es)" + System.lineSeparator();
        dadosUsuario += "==> Zerou " + jogo.getQtdeVezesJogadas() + "vez(es)" + System.lineSeparator();
        dadosUsuario += "==> Maior score: " + jogo.getQtdeVezesJogadas() + "vez(es)" + System.lineSeparator();
        return dadosUsuario;
    }
}
