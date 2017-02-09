package menu;

import main.util.Entrada;

public class Menu {
	private static final String ADICIONAR_USUARIO_MSG = null;
	private static final String ADICIONAR_DINHEIRO_USUARIO_MSG = null;
	private static final String VENDER_JOGOS_USUARIO_MSG = null;
	private static final String IMPRIMIR_RELATORIO_USUARIOS_MSG = null;
	private static final String SAIR_OP = null;
	private static final String INSIRA_UMA_OPCAO_MSG = null;

	public static void main(String[] args) {
		String op = "";
		do {
			System.out.println(ADICIONAR_USUARIO_MSG);
			System.out.println(ADICIONAR_DINHEIRO_USUARIO_MSG);
			System.out.println(VENDER_JOGOS_USUARIO_MSG);
			System.out.println(IMPRIMIR_RELATORIO_USUARIOS_MSG);
			op = Entrada.leString(INSIRA_UMA_OPCAO_MSG);
			switch(op){
			case :
				break;
			}
		} while (!op.equals(SAIR_OP));
	}
}
