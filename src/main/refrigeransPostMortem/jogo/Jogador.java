package main.refrigeransPostMortem.jogo;
public class Jogador {
    private int posI;
    private int posJ;


    public Jogador(int i, int j){
        this.posI = i;
        this.posJ = j;
    }

    public String getCor(){
        return "\u001b[32m";
    }
    public void moverDir(){
        if (posJ < 15){
            posJ++;
        }
    }
    public void moverEsq(){
        if (0 < posJ){
            posJ--;
        }
    }
    public void moverCima(){
        if (0 < posI){
            posI--;
        }
    }
    public void moverBaixo(){
        if (posI < 15){
            posI++;
        }
    }

    public int getPosicaoI() {
        return posI;
    }

    public int getPosicaoJ() {
        return posJ;
    }

public void construir(){

}




}
