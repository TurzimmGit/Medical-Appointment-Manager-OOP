package com.artur.clinica.app;

import com.artur.clinica.Controller.TerminalMenuView;
import com.artur.clinica.view.MainFrame;

public class Main {
    
    public static void main(String[] args) {
        TerminalMenuView menu = new TerminalMenuView();
        int op;
        
        do{
            System.out.println("0 - Sair\n");
            System.out.println("1 - GUI Interface\n");
            System.out.println("2 - Terminal Menu\n");
            System.out.println("Qual sistema deseja?\n");
            op = ConsoleUtils.lerInteiro();

            switch(op){
                case 1 ->
                    {
                    try {
                        javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
                    }
                case 2->{
                    do{ 
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

                case 0 -> System.out.println("Saindo...");
                default -> {
                    System.out.println("Opção inválida!");
                    ConsoleUtils.pausa();
                }
            }
        }while(op!=0);
    }
}