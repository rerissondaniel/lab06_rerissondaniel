package main.entidade;
/**
 * Classe que representa o Role do usuário veterano.
 * 
 * @author rerissondcsm
 *
 */
public class Veterano extends RoleUsuario {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getDesconto() {
		return 0.20;
	}

}
