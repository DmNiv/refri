package main.refrigeransPostMortem;

import main.refrigeransPostMortem.jogo.Jogo;

public class Fabrica extends Construcao{
    public Fabrica(int x, int y){
        super(Tipo.FABRICA, x, y);
    };

    @Override
    void rodar(){
        for (int n = 0; n < pessoas; n++){
            Jogo.refris += 1;
        }

    }

    @Override
    void destruir(){

    }

    public void aumentarPessoas(int x){
        pessoas += x;
    }


}