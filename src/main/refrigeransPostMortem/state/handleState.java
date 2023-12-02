package main.refrigeransPostMortem.state;

import main.refrigeransPostMortem.jogo.Jogo;
import main.refrigeransPostMortem.jogo.Jogador;


public class handleState extends State{

    public handleState() {
        super();
    }

    @Override
    public String interact(Jogador jogador, Jogo jogo) {
        jogador.mostrarDescricao(jogo);
        return null;
    }

    @Override
    public String toString() {
        return "Estado de Manipulação";
    }

    @Override
    public String nextState(Jogo jogo) {
        jogo.setState(new constructState());
        jogo.proxDia();
        return null;
    }
}