package menu;

import main.controller.LojaController;
import main.entidade.jogo.exception.JogoInvalidoException;
import main.entidade.usuario.UsuarioInvalidoException;
import main.service.exception.SaldoInsuficienteException;
import main.service.exception.UsuarioInaptoException;
import main.util.io.Entrada;
import main.util.io.Saida;

import java.util.HashSet;
import java.util.Set;

public class Menu {
    private static final String ADICIONAR_USUARIO_MSG = "Adicionar Usuário";
    private static final String ADICIONAR_DINHEIRO_USUARIO_MSG = "Adicionar dinheiro à conta de usuário";
    private static final String VENDER_JOGOS_USUARIO_MSG = "Vender jogos usuário";
    private static final String IMPRIMIR_RELATORIO_USUARIOS_MSG = "Imprimir relatório usuários";
    private static final String INSIRA_UMA_OPCAO_MSG = "Insira uma opção: ";
    private static final String SAIR_MSG = "Sair";
    private static final String OPCAO_INVALIDA_MSG = "Opção inválida";
    private static final String USUARIO_NAO_ENCONTRADO_MSG = "Usuário não encontrado";
    private static final String UPGRADE_USUARIO_MSG = "Fazer upgrade de usuário: ";
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
    private static final int UPGRADE_USUARIO_OP = 5;
    private static final int SAIR_OP = 6;

    private final Entrada entrada;
    private final Saida saida;
    private final LojaController loja;

    public Menu(final Entrada entrada, final Saida saida, LojaController loja) {
        this.entrada = entrada;
        this.saida = saida;
        this.loja = loja;
    }

    public void iniciarSistema() {
        int op;
        do {
            imprimeOpcoes();

            saida.escreve(SAIR_OP + " - " + SAIR_MSG);
            op = entrada.leInteiro(INSIRA_UMA_OPCAO_MSG);

            trataOpcaoInserida(op);
        } while (op != SAIR_OP);
    }

    private void trataOpcaoInserida(final int op) {
        String login;
        switch (op) {
            case ADICIONAR_USUARIO_OP:
                String nome = entrada.leString(INSIRA_NOME_MSG);
                login = entrada.leString(INSIRA_LOGIN_MSG);
                try {
                    loja.adicionaUsuario(nome, login);
                } catch (UsuarioInvalidoException usuarioInvalido) {
                    saida.escreve(usuarioInvalido.getMessage());
                }
                break;

            case ADICIONAR_DINHEIRO_USUARIO_OP:
                login = entrada.leString(INSIRA_LOGIN_MSG);
                double quantia = entrada.leDouble(INSIRA_QUANTIA_MSG);
                if (loja.adicionarDinheiroUsuario(login, quantia)) {
                    saida.escreve(USUARIO_NAO_ENCONTRADO_MSG);
                }
                break;

            case VENDER_JOGOS_USUARIO_OP:
                login = entrada.leString(INSIRA_LOGIN_MSG);
                String jogo = entrada.leString(INSIRA_NOME_JOGO_MSG);
                String jogabilidade;
                Set<String> jogabilidades = new HashSet<String>();

                do {
                    jogabilidade = entrada.leString(INSIRA_JOGABILIDADE_MSG);
                    jogabilidades.add(jogabilidade);
                } while (!ACABOU_OP.equals(jogabilidade));

                double preco = entrada.leDouble(INSIRA_PRECO_JOGO_MSG);
                String tipo = entrada
                        .leString(INSIRA_TIPO_JOGO_MSG);

                try {
                    loja.vendeJogo(login, jogo, jogabilidades, preco, tipo);
                } catch (UsuarioInvalidoException | SaldoInsuficienteException | JogoInvalidoException e) {
                    saida.escreve(e.getMessage());
                }
                break;

            case IMPRIMIR_RELATORIO_USUARIOS_OP:
                saida.escreve("=== Central P2-CG ===");
                for (String item : loja.getRelatorioUsuarios()) {
                    saida.escreve(item);
                }
                break;
            case UPGRADE_USUARIO_OP:
                login = entrada.leString(INSIRA_LOGIN_MSG);
                try {
                    loja.upgrade(login);
                } catch (UsuarioInvalidoException | UsuarioInaptoException e) {
                    saida.escreve(e.getMessage());
                }
            case SAIR_OP:
                break;

            default:
                saida.escreve(OPCAO_INVALIDA_MSG);
        }
    }

    private void imprimeOpcoes() {
        saida.escreve(ADICIONAR_USUARIO_OP + " - "
                + ADICIONAR_USUARIO_MSG);
        saida.escreve(ADICIONAR_DINHEIRO_USUARIO_OP + " - "
                + ADICIONAR_DINHEIRO_USUARIO_MSG);
        saida.escreve(VENDER_JOGOS_USUARIO_OP + " - "
                + VENDER_JOGOS_USUARIO_MSG);
        saida.escreve(IMPRIMIR_RELATORIO_USUARIOS_OP + " - "
                + IMPRIMIR_RELATORIO_USUARIOS_MSG);
        saida.escreve(UPGRADE_USUARIO_OP + " - "
                + UPGRADE_USUARIO_MSG);
    }
}
