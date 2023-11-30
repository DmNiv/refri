package main.refrigeransPostMortem.state;

import main.refrigeransPostMortem.jogo.Jogador;
import main.refrigeransPostMortem.jogo.Jogo;

public class constructState extends State{
    private Jogo jogo;

    public constructState(Jogador jogador) {
        super(jogador);
    }

    @Override
    public String interact() {
        jogador.construir(jogo);
        return null;
    }

    @Override
    public String move() {
        return null;
    }
}
