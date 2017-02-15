package menu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import main.entidade.jogo.JogoInvalidoException;
import main.entidade.usuario.UsuarioInvalidoException;
import main.service.Loja;
import main.service.SaldoInsuficienteException;
import main.util.Entrada;

public class Menu {
    private static final String ADICIONAR_USUARIO_MSG = "Adicionar Usuário";
    private static final String ADICIONAR_DINHEIRO_USUARIO_MSG = "Adicionar dinheiro à conta de usuário";
    private static final String VENDER_JOGOS_USUARIO_MSG = "Vender jogos usuário";
    private static final String IMPRIMIR_RELATORIO_USUARIOS_MSG = "Imprimir relatório usuários";
    private static final String INSIRA_UMA_OPCAO_MSG = "Insira uma opção: ";
    private static final String SAIR_MSG = "Sair";
    private static final String OPCAO_INVALIDA_MSG = "Opção inválida";
    private static final String USUARIO_NAO_ENCONTRADO_MSG = "Usuário não encontrado";
    private static final String INSIRA_NOME_MSG = "Insira o nome: ";
    private static final String INSIRA_LOGIN_MSG = "Insira o login: ";
    private static final String INSIRA_QUANTIA_MSG = "Insira quanto deseja adicionar à conta de usuário: ";
    private static final String INSIRA_NOME_JOGO_MSG = "Insira o nome do jogo: ";
    private static final String INSIRA_JOGABILIDADE_MSG = "Insira a jogabilidade do jogo (insira \"acabou\", quando terminar): ";
    private static final String INSIRA_PRECO_JOGO_MSG = "Insira o preço do jogo: ";
    private static final String INSIRA_TIPO_JOGO_MSG = "Insira o tipo do jogo(Rpg, Luta ou Plataforma): ";

    private static final String ACABOU_OP = "acabou";

    private static final int ADICIONAR_USUARIO_OP = 1;
    private static final int ADICIONAR_DINHEIRO_USUARIO_OP = 2;
    private static final int VENDER_JOGOS_USUARIO_OP = 3;
    private static final int IMPRIMIR_RELATORIO_USUARIOS_OP = 4;
    private static final int SAIR_OP = 5;

    public static void main(String[] args) {
        int op;
        Loja loja = new Loja(new HashMap<>());
        String login;
        do {
            System.out.println(ADICIONAR_USUARIO_OP + " - "
                    + ADICIONAR_USUARIO_MSG);
            System.out.println(ADICIONAR_DINHEIRO_USUARIO_OP + " - "
                    + ADICIONAR_DINHEIRO_USUARIO_MSG);
            System.out.println(VENDER_JOGOS_USUARIO_OP + " - "
                    + VENDER_JOGOS_USUARIO_MSG);
            System.out.println(IMPRIMIR_RELATORIO_USUARIOS_OP + " - "
                    + IMPRIMIR_RELATORIO_USUARIOS_MSG);

            System.out.println(SAIR_OP + " - " + SAIR_MSG);
            op = Entrada.leInteiro(INSIRA_UMA_OPCAO_MSG);

            switch (op) {
                case ADICIONAR_USUARIO_OP:
                    String nome = Entrada.leString(INSIRA_NOME_MSG);
                    login = Entrada.leString(INSIRA_LOGIN_MSG);
                    try {
                        loja.adicionaUsuario(nome, login);
                    } catch (UsuarioInvalidoException usuarioInvalido) {
                        System.out.println(usuarioInvalido.getMessage());
                    }
                    break;

                case ADICIONAR_DINHEIRO_USUARIO_OP:
                    login = Entrada.leString(INSIRA_LOGIN_MSG);
                    double quantia = Entrada.leDouble(INSIRA_QUANTIA_MSG);
                    if (loja.adicionarDinheiroUsuario(login, quantia)) {
                        System.out.println(USUARIO_NAO_ENCONTRADO_MSG);
                    }
                    break;

                case VENDER_JOGOS_USUARIO_OP:
                    login = Entrada.leString(INSIRA_LOGIN_MSG);
                    String jogo = Entrada.leString(INSIRA_NOME_JOGO_MSG);
                    String jogabilidade;
                    Set<String> jogabilidades = new HashSet<String>();

                    do {
                        jogabilidade = Entrada.leString(INSIRA_JOGABILIDADE_MSG);
                        jogabilidades.add(jogabilidade);
                    } while (!ACABOU_OP.equals(jogabilidade));

                    double preco = Entrada.leDouble(INSIRA_PRECO_JOGO_MSG);
                    String tipo = Entrada
                            .leString(INSIRA_TIPO_JOGO_MSG);

                    try {
                        loja.vendeJogo(login, jogo, jogabilidades, preco, tipo);
                    } catch (SaldoInsuficienteException | JogoInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case IMPRIMIR_RELATORIO_USUARIOS_OP:
                    System.out.println("");
                    for (String item : loja.getRelatorioUsuarios()) {
                        System.out.println(item);
                    }
                    break;

                case SAIR_OP:
                    break;

                default:
                    System.out.println(OPCAO_INVALIDA_MSG);
            }
        } while (op != SAIR_OP);
    }
}
