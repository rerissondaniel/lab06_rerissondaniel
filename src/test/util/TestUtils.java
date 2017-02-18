package test.util;

import main.entidade.jogo.Jogabilidade;
import main.entidade.jogo.Jogo;
import main.entidade.jogo.exception.JogoInvalidoException;
import main.entidade.jogo.tipo.Luta;
import main.entidade.jogo.tipo.Plataforma;
import main.entidade.jogo.tipo.Rpg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Classe utilitária para geração de objetos comuns entre os testes, etc.
 * Created by rerisson on 18/02/17.
 */
public class TestUtils {
    public static Set<Jogabilidade> getJogabilidades1() {
        Set<Jogabilidade> jogabilidades = new HashSet();
        jogabilidades.add(Jogabilidade.COMPETITIVO);
        jogabilidades.add(Jogabilidade.MULTIPLAYER);
        jogabilidades.add(Jogabilidade.OFFLINE);
        return jogabilidades;
    }

    public static Set<Jogabilidade> getJogabilidades2() {
        Set<Jogabilidade> jogabilidades = new HashSet();
        jogabilidades.add(Jogabilidade.OFFLINE);
        jogabilidades.add(Jogabilidade.COOPERATIVO);
        jogabilidades.add(Jogabilidade.ONLINE);
        return jogabilidades;
    }

    public static Map<String, Jogo> getJogos() throws JogoInvalidoException {
        Map<String, Jogo> jogos = new HashMap<>();
        Set<Jogabilidade> jogabilidades1 = new HashSet();
        jogabilidades1.add(Jogabilidade.COMPETITIVO);
        jogabilidades1.add(Jogabilidade.MULTIPLAYER);
        jogabilidades1.add(Jogabilidade.OFFLINE);

        Set<Jogabilidade> jogabilidades2 = new HashSet();
        jogabilidades2.add(Jogabilidade.OFFLINE);
        jogabilidades2.add(Jogabilidade.COOPERATIVO);
        jogabilidades2.add(Jogabilidade.ONLINE);
        Jogo jogo1 = new Luta("Tekken", 25.00, jogabilidades1);
        Jogo jogo2 = new Rpg("Legend Of Mana", 35.00, jogabilidades2);
        Jogo jogo3 = new Plataforma("GameX", 560.00, jogabilidades1);
        Jogo jogo4 = new Luta("MK ultimate", 30.00, jogabilidades2);
        Jogo jogo5 = new Rpg("Final Fantasy X", 10.00, jogabilidades1);

        jogos.put("Tekken", jogo1);
        jogos.put("Legend Of Mana", jogo2);
        jogos.put("GameX", jogo3);
        jogos.put("MK ultimate", jogo4);
        jogos.put("Final Fantasy X", jogo5);

        return jogos;
    }
}
