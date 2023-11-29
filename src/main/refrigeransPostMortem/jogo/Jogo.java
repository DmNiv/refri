package main.refrigeransPostMortem.jogo;
import main.refrigeransPostMortem.Construcao;
import java.io.IOException;

public class Jogo {
    private Construcao[][] mapa;
    private int linhas;
    private int colunas;
    private String Cor;
    public static int refris;
    public int mortos;

    public Jogo(int i, int j){
        this.linhas = i;
        this.colunas = j;
        mapa = new Construcao[i][j];
    }
    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Construcao[][] getMapa(){
        return mapa;
    }

    public Construcao getConstrucao(int i, int j){
        return mapa[i][j];
    }

    public void imprimirMapa(Jogador jogador){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                Construcao construcao = mapa[i][j];
                if (construcao != null){
                    Cor = construcao.getCor();
                    if (jogador.getPosicaoI() == i && jogador.getPosicaoJ() == j){
                        System.out.print(jogador.getCor() + "[" + Cor + construcao.getClass().getSimpleName().charAt(0) + jogador.getCor() + "]" + "\u001B[0m");
                    } else {
                        System.out.print("[" + Cor + construcao.getClass().getSimpleName().charAt(0) + "\u001B[0m" + "]");
                    }
                } else {
                    if (jogador.getPosicaoI() == i && jogador.getPosicaoJ() == j){
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
