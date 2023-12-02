package main.refrigeransPostMortem;

import main.refrigeransPostMortem.jogo.Jogo;


public class Fabrica extends Construcao{

    public Fabrica(int i, int j){
        super(Tipo.FABRICA, i, j);
    };

    @Override
    public void rodar(Jogo jogo){
        for (int n = 0; n < pessoas; n++){
            jogo.aumentarRefris();
        }
    }
}