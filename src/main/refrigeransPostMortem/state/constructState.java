package main.refrigeransPostMortem.state;

import main.refrigeransPostMortem.jogo.Jogador;
import main.refrigeransPostMortem.jogo.Jogo;

public class constructState extends State{

    public constructState() {
        super();
    }

    @Override
    public String interact(Jogador jogador, Jogo jogo) {
        jogador.construir(jogo);
        return null;
    }

    @Override
    public String toString() {
        return "Estado de Construção";
    }

    @Override
    public String nextState(Jogo jogo) {
        jogo.setState(new handleState());
        return null;
    }

}
