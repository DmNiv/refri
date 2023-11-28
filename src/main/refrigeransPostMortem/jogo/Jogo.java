package main.refrigeransPostMortem.jogo;
import main.refrigeransPostMortem.Construcao;
import java.io.IOException;

public class Jogo {
    private Construcao[][] mapa;
    private int tamanhoX;
    private int tamanhoY;
    private String Cor;
    public static int refris;
    public int mortos;

    public Jogo(int x, int y){
        this.tamanhoX = x;
        this.tamanhoY = y;
        mapa = new Construcao[x][y];
    }
    public int getTamanhoX() {
        return tamanhoX;
    }

    public int getTamanhoY() {
        return tamanhoY;
    }

    public Construcao[][] getMapa(){
        return mapa;
    }

    public Construcao getConstrucao(int x, int y){
        return mapa[x][y];
    }

    public void imprimirMapa(Jogador jogador){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                Construcao construcao = mapa[i][j];
                if (construcao != null){
                    Cor = construcao.getCor();
                    if (jogador.getPosicaoX() == j && jogador.getPosicaoY() == i){
                        System.out.print(jogador.getCor() + "[" + Cor + construcao.getClass().getSimpleName().charAt(0) + jogador.getCor() + "]");
                    } else {
                        System.out.print("[" + Cor + construcao.getClass().getSimpleName().charAt(0) + "\u001B[0m" + "]");
                    }
                } else {
                    if (jogador.getPosicaoX() == j && jogador.getPosicaoY() == i){
                        System.out.print(jogador.getCor() + "[ ]" + "\u001B[0m");
                    } else {
                        System.out.print("[ ]");
                    }
                }
            }
            System.out.println();
        }
    }

    public void limparTerminal() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

}
