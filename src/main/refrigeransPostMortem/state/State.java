package main.refrigeransPostMortem.state;

import main.refrigeransPostMortem.jogo.Jogador;


public abstract class State {

    Jogador jogador;

    State (Jogador jogador){
        this.jogador = jogador;
    }

    public abstract String interact();
    public abstract String move();



}
