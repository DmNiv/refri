package main.refrigeransPostMortem;
abstract class Construcao {
    public enum Tipo{
        TEMPLO,
        CEMITERIO,
        FABRICA,
        LOJA
    }

    private Tipo tipo;
    protected int pessoas;
    private int x;
    private int y;

    public Construcao(Tipo tipo, int x, int y){
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.pessoas = 0;
    }

    public static Construcao criarConstrucao(){

    }


    abstract void rodar();
    abstract void destruir();
    void moverPessoas(int x, Construcao y){
        if (x > pessoas){
            System.out.println("você não pode trasferir mais pessoas do que há na construção");
        } else {
            pessoas = pessoas - x;
            y.pessoas = y.pessoas + x;
        }
    }
}