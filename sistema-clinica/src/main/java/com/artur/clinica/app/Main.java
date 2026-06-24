package com.artur.clinica.app;

public class Main {
    
    public static void main(String[] args) {
        MenuController menu = new MenuController();
        int op;

        do { 
            menu.exibirMenuPrincipal();

            op = ConsoleUtils.lerInteiro();

            switch (op) {
                case 1 -> menu.marcarClinica();
                case 2 -> menu.listarTodas();
                case 3 -> menu.buscar();
                case 4 -> menu.alterar();
                case 5 -> menu.remover();
                case 6 -> menu.marcarCirurgia();
                case 0 -> System.out.println("Saindo...");
                default -> {
                    System.out.println("Opção inválida!");
                    ConsoleUtils.pausa();
                }
            }
        } while (op!=0);
    }

}