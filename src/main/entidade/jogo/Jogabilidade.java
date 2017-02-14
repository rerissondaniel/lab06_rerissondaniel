package main.entidade.jogo;

/**
 * Enum que representa as possíveis jogabilidades para um jogo.
 * 
 * @author rerissondcsm
 *
 */
public enum Jogabilidade {
	ONLINE("Online"), OFFLINE("Offline"), MULTIPLAYER("Multiplayer"), COOPERATIVO(
			"Cooperativo"), COMPETITIVO("Competitivo");

	/**
	 * Estilo da jogabilidade.
	 */
	private String estilo;

	/**
	 * Construtor privado.
	 * 
	 * @param estilo
	 *            - Estilo deste jogabilidade.
	 */
	Jogabilidade(String estilo) {
		this.estilo = estilo;
	}

	/**
	 * Recupera o estilo desta jogabilidade.
	 * 
	 * @return - {@link String} representando o estilo desse jogo.
	 */
	public String getEstilo() {
		return estilo;
	}

	public static final Jogabilidade getPorEstilo(String estilo) {
		for (Jogabilidade jogabilidade : values()) {
			if (jogabilidade.getEstilo().equals(estilo)) {
				return jogabilidade;
			}
		}
		return null;
	}
}
