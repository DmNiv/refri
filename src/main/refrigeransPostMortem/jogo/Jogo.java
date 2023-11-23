package main.refrigeransPostMortem.jogo;

import main.refrigeransPostMortem.Construcao;

public class Jogo {
    private Construcao[][] mapa;

    public Jogo(){
        mapa = new Construcao[16][16];
    }

    public Construcao getConstrucao(int x, int y){
        return mapa[x][y];
    }

    public void setConstrucao(Construcao construcao, int x, int y){
        mapa[x][y] = construcao;
    }



}
