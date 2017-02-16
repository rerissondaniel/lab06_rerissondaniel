package main.util.io;

/**
 * Created by rerisson on 15/02/17.
 */
public interface Entrada {
    Integer leInteiro();

    Integer leInteiro(String prompt);

    String leString();

    String leString(String prompt);

    Double leDouble();

    Double leDouble(String prompt);
}
