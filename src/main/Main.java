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
                char direcao = scanner.next().charAt(0);

                switch (direcao) {
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
                    default:
                        System.out.println("Tecla inválida. Use W, A, S ou D.");
                }
            }
        }


    }

}