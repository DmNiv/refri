package main.refrigeransPostMortem.jogo;
public class Jogador {
    private int posX;
    private int posY;


    public Jogador(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public String getCor(){
        return "\u001b[32m";
    }
    public void moverDir(){
        if (posX < 15){
            posX++;
        }
    }
    public void moverEsq(){
        if (0 < posX){
            posX--;
        }
    }
    public void moverCima(){
        if (0 < posY){
            posY--;
        }
    }
    public void moverBaixo(){
        if (posY < 15){
            posY++;
        }
    }

    public int getPosicaoX() {
        return posX;
    }

    public int getPosicaoY() {
        return posY;
    }

}
