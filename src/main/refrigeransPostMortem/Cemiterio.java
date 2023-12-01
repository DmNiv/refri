package main.refrigeransPostMortem;
import main.refrigeransPostMortem.jogo.Jogo;

public class Cemiterio extends Construcao{

    public Cemiterio(int i, int j){
        super(Tipo.CEMITERIO, i, j);
    };

    @Override
    public void rodar(Jogo jogo){
        jogo.aumentarMortos();
    }



}
