package main;

import main.controller.LojaController;
import main.controller.implementation.LojaControllerImpl;
import main.service.implementation.FormatadoraCentralP2Cg;
import main.util.io.implementation.Monitor;
import main.util.io.implementation.Teclado;
import menu.Menu;

import java.util.HashMap;

/**
 * Created by rerisson on 15/02/17.
 */
public class Main {

    public static void main(String[] args) {
        LojaController controller = new LojaControllerImpl(new HashMap<>(), new FormatadoraCentralP2Cg());
        Menu menu = new Menu(new Teclado(), new Monitor(), controller);
        menu.iniciarSistema();
    }

}
