package main.refrigeransPostMortem.jogo;
import main.refrigeransPostMortem.Construcao;

public class Jogo {
    private Construcao[][] mapa;
    private String Cor;
    public static int refris;
    public int mortos;

    public Jogo(){
        mapa = new Construcao[16][16];
    }

    public Construcao[][] getMapa(){
        return mapa;
    }

    public Construcao getConstrucao(int x, int y){
        return mapa[x][y];
    }

    public void setConstrucao(Construcao construcao, int x, int y){
        mapa[x][y] = construcao;
    }
    public void imprimirMapa(){
        for (Construcao[] construcoes : mapa){
            for (int j = 0; j < construcoes.length; j++){
                Construcao construcao = construcoes[j];
                if (construcao != null){
                    Cor = construcao.getCor();
                    System.out.print("[" + Cor + construcao.getClass().getSimpleName().charAt(0) + "\u001B[0m" + "]");
                } else{
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }


}
