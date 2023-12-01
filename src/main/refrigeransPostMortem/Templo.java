package main.refrigeransPostMortem;

import main.refrigeransPostMortem.jogo.Jogo;

public class Templo extends Construcao{
    public Templo(int i, int j){
        super(Tipo.TEMPLO, i, j);
    };

    @Override
    public void rodar(Jogo jogo){
        jogo.aumentarFieis();
    }

}
