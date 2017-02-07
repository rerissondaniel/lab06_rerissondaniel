package main.entidade;
/**
 * Classe que representa o role do usuário noob.
 * 
 * @author rerissondcsm
 *
 */
public class Noob extends RoleUsuario{

	@Override
	public double getDesconto() {
		return 0.10;
	}	
}
