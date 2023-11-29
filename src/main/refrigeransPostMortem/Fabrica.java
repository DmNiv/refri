package main.refrigeransPostMortem;

public class Fabrica extends Construcao{
    public Fabrica(int i, int j){
        super(Tipo.FABRICA, i, j);
    };

    @Override
    void rodar(){
        for (int n = 0; n < pessoas; n++){
            RefrigeransPostMortem.refris += 1;
        }

    }

    @Override
    void destruir(){

    }

    public void aumentarPessoas(int x){
        pessoas += x;
    }


}