package main;

import main.refrigeransPostMortem.jogo.Jogo;
import main.refrigeransPostMortem.jogo.Jogador;
import java.io.IOException;
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