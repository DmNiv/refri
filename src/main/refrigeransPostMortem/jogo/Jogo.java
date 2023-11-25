package main.refrigeransPostMortem.jogo;
import main.refrigeransPostMortem.Construcao;

public class Jogo {
    private Construcao[][] mapa;
    private String Cor;

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
                    if (construcao.getTipo() == Construcao.Tipo.TEMPLO){
                        Cor = "\u001B[33m";}
                    if (construcao.getTipo() == Construcao.Tipo.LOJA){
                        Cor = "\u001B[32m";}
                    if (construcao.getTipo() == Construcao.Tipo.FABRICA){
                        Cor = "\u001B[31m";}
                    if (construcao.getTipo() == Construcao.Tipo.CEMITERIO){
                        Cor = "\u001B[35m";}
                    System.out.print("[" + Cor + construcao.getClass().getSimpleName().charAt(0) + "\u001B[0m" + "]");
                } else{
                    System.out.print("[N]");
                }
            }
            System.out.println();
        }
    }


}
