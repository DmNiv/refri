package main.refrigeransPostMortem;
abstract class Construcao {
    public enum Tipo{
        TEMPLO,
        CEMITERIO,
        FABRICA,
        LOJA
    }

    private Tipo tipo;
    private int x;
    private int y;

    public Construcao(Tipo tipo, int x, int y){
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }

    abstract void rodar();
    abstract void destruir();


}