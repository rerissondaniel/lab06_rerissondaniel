package main.entidade.usuario;

/**
 * Classe que representa o papel deste usuário no sistema.
 * 
 * @author rerissondcsm
 *
 */
public abstract class Role {
	/**
	 * Método que retorna o desconto para este usuário.
	 * 
	 * @return O desconto para este usuário.
	 */
	public abstract double getDesconto();
	
	/**
	 * Retorna o x2p para determinada compra.
	 * @param precoJogo
	 * @return
	 */
	public abstract int getx2pCompra(double precoJogo);
	
	/**
	 * Altera o valor inicial do x2p do Usuário.
	 */
	protected abstract int getX2pInicial();
}
