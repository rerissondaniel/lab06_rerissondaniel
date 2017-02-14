package main.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import main.entidade.jogo.Jogabilidade;
import main.entidade.jogo.Jogo;
import main.entidade.jogo.JogoInvalidoException;
import main.entidade.jogo.Luta;
import main.entidade.jogo.Plataforma;
import main.entidade.jogo.Rpg;
import main.entidade.usuario.Noob;
import main.entidade.usuario.Usuario;
import main.entidade.usuario.UsuarioInvalidoException;

public class Loja {

	private Map<String, Usuario> usuarios;

	public void adicionaUsuario(String nome, String login)
			throws UsuarioInvalidoException {
		Usuario usuario = new Usuario(nome, login, null, new Noob());
		usuarios.put(login, usuario);
	}

	public boolean adicionarDinheiroUsuario(String login, double quantia) {
		Usuario usuario = usuarios.get(login);
		if (usuario == null) {
			return false;
		}
		int quantiaInteira = (int) (quantia * 100);
		int quantiaAtual = usuario.getDinheiro();
		usuario.setDinheiro(quantiaAtual + quantiaInteira);
		return true;
	}

	public String getRelatorioUsuarios() {
		String relatorio = "=== Central P2-CG ===";
		for (Usuario usuario : usuarios.values()) {
			
		}
		return null;
	}

	public void vendeJogo(String login, String nomeJogo,
			Set<String> jogabilidadesStr, double preco, String tipo)
			throws JogoInvalidoException {
		Usuario usuario = usuarios.get(login);

		Set<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();

		for (String jogabilidade : jogabilidadesStr) {
			Jogabilidade jogabilidadeAux = Jogabilidade
					.getPorEstilo(jogabilidade);
			if (jogabilidadeAux == null) {
				throw new JogoInvalidoException(
						"Jogo inválido, a jogabilidade " + jogabilidade
								+ " não existe.");
			}
			jogabilidades.add(jogabilidadeAux);
		}

		Jogo jogo = criaJogo(nomeJogo, preco, tipo, jogabilidades);
		usuario.adicionaJogo(jogo);
	}

	private Jogo criaJogo(String nomeJogo, double preco, String tipo,
			Set<Jogabilidade> jogabilidade) throws JogoInvalidoException {
		Jogo jogo;

		if (tipo.equalsIgnoreCase(Luta.REPRESENTACAO_STRING)) {
			jogo = new Luta(nomeJogo, preco, 0, jogabilidade);
		} else if (tipo.equalsIgnoreCase(Rpg.REPRESENTACAO_STRING)) {
			jogo = new Rpg(nomeJogo, preco, 0, jogabilidade);
		} else if (tipo.equalsIgnoreCase(Plataforma.REPRESENTACAO_STRING)) {
			jogo = new Plataforma(nomeJogo, preco, 0, jogabilidade);
		} else {
			throw new JogoInvalidoException("Não há o tipo de jogo indicado");
		}

		return jogo;
	}
}
