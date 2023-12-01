package main;

import main.refrigeransPostMortem.*;
import main.refrigeransPostMortem.jogo.Jogo;
import main.refrigeransPostMortem.jogo.Jogador;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class  Main{
    public static void main(String[] args) throws IOException, InterruptedException {
        Jogo novoJogo = new Jogo(16, 16);
        Jogador jogador = new Jogador(0, 0);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            novoJogo.imprimirMapa(jogador);
            System.out.println("Posição I: " + jogador.getPosicaoI() + "\nPosição J: " + jogador.getPosicaoJ());
            if (scanner.hasNext()) {
                char input = scanner.next().charAt(0);

                switch (input) {
                    case 'p':
                        System.out.println("Saindo...");
                        System.exit(0);
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
                        novoJogo.getState().interact(jogador, novoJogo);
                        break;
                    case 'n':
                        novoJogo.getState().nextState(novoJogo);
                        System.out.println();
                        break;
                    default:
                        System.out.println("Tecla inválida.\nUse W, A, S, D para mover \nUse P ou C para outros comandos.");
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