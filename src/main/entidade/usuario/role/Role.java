package main.entidade.usuario.role;

/**
 * Classe que representa o papel deste usuário no sistema.
 * 
 * @author rerissondcsm
 *
 */
public interface Role {
	/**
	 * Método que retorna o desconto para este usuário.
	 * 
	 * @return O desconto para este usuário.
	 */
	double getDesconto();
	
	/**
	 * Retorna o x2p para determinada compra.
	 * @param precoJogo
	 * @return
	 */
	int getx2pCompra(final double precoJogo);
	
	/**
	 * Altera o valor inicial do x2p do Usuário.
	 */
	int getX2pInicial();
}
