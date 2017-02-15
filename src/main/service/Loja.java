package main.service;

import java.util.*;

import main.entidade.jogo.Jogabilidade;
import main.entidade.jogo.Jogo;
import main.entidade.jogo.JogoInvalidoException;
import main.entidade.jogo.Luta;
import main.entidade.jogo.Plataforma;
import main.entidade.jogo.Rpg;
import main.entidade.usuario.role.Noob;
import main.entidade.usuario.Usuario;
import main.entidade.usuario.UsuarioInvalidoException;

public class Loja {

    private Map<String, Usuario> usuarios;

    public Loja(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionaUsuario(final String nome, final String login)
            throws UsuarioInvalidoException {
        Usuario usuario = new Usuario(nome, login, null, new Noob());
        usuarios.put(login, usuario);
    }

    public boolean adicionarDinheiroUsuario(final String login, final double quantia) {
        Usuario usuario = usuarios.get(login);
        if (usuario == null) {
            return false;
        }
        double quantiaAtual = usuario.getDinheiro();
        usuario.setDinheiro(quantiaAtual + quantia);
        return true;
    }

    public List<String> getRelatorioUsuarios() {
        List<String> relatorio = new ArrayList<>();
        double total = 0;

        for (Usuario usuario : usuarios.values()) {
            String dadosUsuario = getStringFormatadaUsuario(usuario);
            for (Jogo jogo : usuario.getJogosComprados()) {
                dadosUsuario = getStringFormatadaJogo(dadosUsuario, jogo);
                total += jogo.getPreco();
            }
            relatorio.add(dadosUsuario);
        }

        String totalStr = "Total de preço dos jogos: " + String.format("%.2f", total) + System.lineSeparator();
        relatorio.add(totalStr);

        return relatorio;
    }

    private String getStringFormatadaUsuario(Usuario usuario) {
        String dadosUsuario = usuario.getLogin() + System.lineSeparator();
        dadosUsuario += usuario.getNome() + " - " + usuario.getRole() + System.lineSeparator() + System.lineSeparator();
        dadosUsuario += "Lista de Jogos:" + System.lineSeparator();
        return dadosUsuario;
    }

    private String getStringFormatadaJogo(String dadosUsuario, Jogo jogo) {
        dadosUsuario += "+ " + jogo.getNome() + System.lineSeparator();
        dadosUsuario += "==> Jogou " + jogo.getQtdeVezesJogadas() + "vez(es)" + System.lineSeparator();
        dadosUsuario += "==> Zerou " + jogo.getQtdeVezesJogadas() + "vez(es)" + System.lineSeparator();
        dadosUsuario += "==> Maior score: " + jogo.getQtdeVezesJogadas() + "vez(es)" + System.lineSeparator();
        return dadosUsuario;
    }

    public void vendeJogo(final String login, final String nomeJogo, final Set<String> jogabilidadesStr,
                          final double preco, final String tipo)
            throws JogoInvalidoException, SaldoInsuficienteException {
        Usuario usuario = usuarios.get(login);

        Set<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();

        for (String jogabilidade : jogabilidadesStr) {
            Jogabilidade jogabilidadeAux = Jogabilidade.getPorEstilo(jogabilidade);
            if (jogabilidadeAux == null) {
                throw new JogoInvalidoException("Jogo inválido, a jogabilidade " + jogabilidade + " não existe.");
            }
            jogabilidades.add(jogabilidadeAux);
        }

        Jogo jogo = criaJogo(nomeJogo, preco, tipo, jogabilidades);
        verificaSaldoSuficiente(usuario, jogo);
        usuario.adicionaJogo(jogo);
    }

    /**
     * Verifica se {@code usuario} tem saldo suficiente para a compra de um jogo.
     *
     * @param usuario
     * @param jogo
     * @throws SaldoInsuficienteException
     */
    private void verificaSaldoSuficiente(Usuario usuario, Jogo jogo) throws SaldoInsuficienteException {
        if (usuario.getDinheiro() < jogo.getPreco() * (1 - usuario.getDesconto())) {
            throw new SaldoInsuficienteException("Saldo do usuário insuficiente");
        }
    }

    private Jogo criaJogo(final String nomeJogo, final double preco, final String tipo,
                          final Set<Jogabilidade> jogabilidade) throws JogoInvalidoException {
        Jogo jogo;

        if (tipo.equalsIgnoreCase(Luta.REPRESENTACAO_STRING)) {
            jogo = new Luta(nomeJogo, preco, jogabilidade);
        } else if (tipo.equalsIgnoreCase(Rpg.REPRESENTACAO_STRING)) {
            jogo = new Rpg(nomeJogo, preco, jogabilidade);
        } else if (tipo.equalsIgnoreCase(Plataforma.REPRESENTACAO_STRING)) {
            jogo = new Plataforma(nomeJogo, preco, jogabilidade);
        } else {
            throw new JogoInvalidoException("Não há o tipo de jogo indicado");
        }

        return jogo;
    }
}
