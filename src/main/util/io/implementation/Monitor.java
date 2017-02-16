package main.util.io.implementation;

import main.util.io.Saida;

import java.io.PrintStream;

/**
 * Created by rerissondcsm on 15/02/17.
 */
public class Monitor implements Saida {
    private PrintStream console;

    public Monitor() {
        this.console = System.out;
    }

    public void escreve(String str) {
        console.println(str);
    }
}
