package main.refrigeransPostMortem;
import main.refrigeransPostMortem.jogo.Jogo;

public class Loja extends Construcao{
    public Loja(int i, int j){
        super(Tipo.LOJA, i, j);
    };

    @Override
    public void rodar(Jogo jogo){
        jogo.aumentarDinheiros();
    }




}