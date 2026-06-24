package com.artur.clinica.app;

import java.io.IOException;
import java.util.Scanner;


public class ConsoleUtils {
    public static final Scanner leitor = new Scanner(System.in);

    public static void limparTela(){
        try {
            String os = System.getProperty("os.name");

            if(os.contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
            
        } catch (IOException | InterruptedException e) {
            System.err.println("\nErro:"+ e.getMessage());
        }
    }

    public static int lerInteiro(){
        try {
            int n = Integer.parseInt(leitor.nextLine());
            return n;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void pausa(){
        System.out.println("\nPressione ENTER para continuar...");
        leitor.nextLine();
    }

}
