package main.refrigeransPostMortem;

import main.refrigeransPostMortem.jogo.Jogo;

public class Fabrica extends Construcao{
    public Fabrica(int i, int j){
        super(Tipo.FABRICA, i, j);
    };

    @Override
    void rodar(){
        for (int n = 0; n < pessoas; n++){
            Jogo.refris += 1;
        }

    }


    public void aumentarPessoas(int x){
        pessoas += x;
    }


}