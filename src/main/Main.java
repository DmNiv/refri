package main;


import main.Engine.*;
import main.refrigeransPostMortem.*;
import main.refrigeransPostMortem.jogo.Jogo;
import main.refrigeransPostMortem.jogo.Jogador;
import java.io.IOException;
import java.lang.reflect.Method;
import java.awt.event.KeyEvent;
import java.util.Scanner;


public class  Main{
    public static void main(String[] args) throws IOException, InterruptedException {
        Class<?> fabricaClasse = Fabrica.class;
        Class<?> cemiterioClasse = Cemiterio.class;
        Class<?> lojaClasse = Loja.class;
        Class<?> temploClasse = Templo.class;
        Method[] metodosFabrica = fabricaClasse.getDeclaredMethods();
        Method[] metodosCemiterio = cemiterioClasse.getDeclaredMethods();
        Method[] metodosLoja = lojaClasse.getDeclaredMethods();
        Method[] metodosTemplo = temploClasse.getDeclaredMethods();
        Jogo novoJogo = new Jogo(16, 16);
        Jogador jogador = new Jogador(0, 0);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            novoJogo.imprimirMapa(jogador);
            System.out.println("Posição X: " + jogador.getPosicaoX() + "\nPosição Y: " + jogador.getPosicaoY());
            if (scanner.hasNext()) {
                char input = scanner.next().charAt(0);

                switch (input) {
                    case 'w':
                        jogador.moverCima();
                        break;
                    case 'a':
                        jogador.moverEsq();
                        break;
                    case 's':
                        jogador.moverBaixo();
                        break;
                    case 'd':
                        jogador.moverDir();
                        break;
                    case 'c':
                        System.out.println("Escolha o que construir:\nF: Fábrica\nC: Cemitério\nL: Loja\nT: Templo");
                        input = scanner.next().charAt(0);
                        switch (input) {
                            case 'f':
                                Construcao.criarConstrucao(Construcao.Tipo.FABRICA, novoJogo.getMapa(), jogador.getPosicaoX(), jogador.getPosicaoY());
                                break;
                            case 'c':
                                Construcao.criarConstrucao(Construcao.Tipo.CEMITERIO, novoJogo.getMapa(), jogador.getPosicaoX(), jogador.getPosicaoY());
                                break;
                            case 'l':
                                Construcao.criarConstrucao(Construcao.Tipo.LOJA, novoJogo.getMapa(), jogador.getPosicaoX(), jogador.getPosicaoY());
                                break;
                            case 't':
                                Construcao.criarConstrucao(Construcao.Tipo.TEMPLO, novoJogo.getMapa(), jogador.getPosicaoX(), jogador.getPosicaoY());
                                break;
                            default:
                                System.out.println("Tecla inválida. Use F, C, L ou T.");
                        }
                    default:
                        System.out.println("Tecla inválida. Use W, A, S, D ou C.");
                }
            }
        }


    }

}
/*
import java.util.Scanner;

// Interface for Commands
interface Command {
    void execute();
}

// Concrete Command classes
class Option1Command implements Command {
    @Override
    public void execute() {
        System.out.println("Option 1: Perform action for Option 1");
        // Add functionality for Option 1 here
    }
}

class Option2Command implements Command {
    @Override
    public void execute() {
        System.out.println("Option 2: Perform action for Option 2");
        // Add functionality for Option 2 here
    }
}

class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Exiting the program. Goodbye!");
        // Add any necessary cleanup or exit code here
        System.exit(0);
    }
}

// Invoker class
class Menu {
    private Command[] commands;

    public Menu(Command[] commands) {
        this.commands = commands;
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < commands.length; i++) {
            System.out.println((i + 1) + ". " + commands[i].getClass().getSimpleName());
        }
    }

    public void processChoice(int choice) {
        if (choice >= 1 && choice <= commands.length) {
            commands[choice - 1].execute();
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }
}

public class TextUserInterfaceWithCommandPattern {
    public static void main(String[] args) {
        Command[] commands = {new Option1Command(), new Option2Command(), new ExitCommand()};
        Menu menu = new Menu(commands);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            menu.displayMenu();
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                menu.processChoice(choice);
            } else {
                System.out.println("Please enter a valid option.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
}

 */