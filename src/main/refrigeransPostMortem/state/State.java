package main.refrigeransPostMortem.state;

import main.refrigeransPostMortem.jogo.*;


public abstract class State {

    State (){
    }

    public abstract String interact(Jogador jogador, Jogo jogo);
    public abstract String toString();
    public abstract String nextState(Jogo jogo);
}