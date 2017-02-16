package main.controller.implementation;

import main.controller.LojaController;
import main.entidade.jogo.Jogabilidade;
import main.entidade.jogo.Jogo;
import main.entidade.jogo.exception.JogoInvalidoException;
import main.entidade.jogo.tipo.Luta;
import main.entidade.jogo.tipo.Plataforma;
import main.entidade.jogo.tipo.Rpg;
import main.entidade.usuario.Usuario;
import main.entidade.usuario.UsuarioInvalidoException;
import main.entidade.usuario.role.Noob;
import main.entidade.usuario.role.Role;
import main.entidade.usuario.role.Veterano;
import main.service.Formatadora;
import main.service.exception.SaldoInsuficienteException;
import main.service.exception.UsuarioInaptoException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by rerisson on 15/02/17.
 */
public class LojaControllerImpl implements LojaController {

    private Map<String, Usuario> usuarios;
    private Formatadora formatadora;


    public LojaControllerImpl(Map<String, Usuario> usuarios, Formatadora formatadora) {
        this.usuarios = usuarios;
        this.formatadora = formatadora;
    }

    @Override
    public void adicionaUsuario(final String nome, final String login)
            throws UsuarioInvalidoException {
        Usuario usuario = new Usuario(nome, login, null, new Noob());
        usuarios.put(login, usuario);
    }

    @Override
    public boolean adicionarDinheiroUsuario(final String login, final double quantia) {
        Usuario usuario = usuarios.get(login);
        if (usuario == null) {
            return false;
        }
        double quantiaAtual = usuario.getDinheiro();
        usuario.setDinheiro(quantiaAtual + quantia);
        return true;
    }

    @Override
    public List<String> getRelatorioUsuarios() {
        return this.formatadora.formataDadosUsuario(usuarios.values());
    }

    @Override
    public void upgrade(final String login) throws UsuarioInvalidoException, UsuarioInaptoException {
        Usuario usuario = usuarios.get(login);
        verificaValidadeUsuario(usuario);

        if (verificaUsuarioAptoUpgrade(usuario)) {
            usuario.setRole(new Veterano());
        } else {
            throw new UsuarioInaptoException("Usuário já é veterano.");
        }
    }

    @Override
    public void vendeJogo(final String login, final String nomeJogo, final Set<String> jogabilidadesStr,
                          final double preco, final String tipo)
            throws JogoInvalidoException, SaldoInsuficienteException, UsuarioInvalidoException {
        Usuario usuario = usuarios.get(login);
        verificaValidadeUsuario(usuario);

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

    private void verificaValidadeUsuario(final Usuario usuario) throws UsuarioInvalidoException {
        if (Objects.isNull(usuario)) {
            throw new UsuarioInvalidoException("O usuário não pode ser encontrado.");
        }
    }

    /**
     * Verifica se {@code usuario} tem saldo suficiente para a compra de um jogo.
     *
     * @param usuario
     * @param jogo
     * @throws SaldoInsuficienteException
     */
    private void verificaSaldoSuficiente(final Usuario usuario, final Jogo jogo) throws SaldoInsuficienteException {
        if (usuario.getDinheiro() < jogo.getPreco() * (1 - usuario.getDesconto())) {
            throw new SaldoInsuficienteException("Saldo do usuário insuficiente");
        }
    }

    private boolean verificaUsuarioAptoUpgrade(Usuario usuario) {
        Role papel = usuario.getRole();
        return papel.getClass().equals(Noob.class) && usuario.getX2p() >= X2P_MINIMO_VETERANO;
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
