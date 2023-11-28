package main.refrigeransPostMortem;
public abstract class Construcao {


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

    public static void criarConstrucao(Tipo tipo, Construcao[][] matriz, int x, int y) {
        switch (tipo) {
            case TEMPLO -> matriz[x][y] = new Templo(x, y);
            case CEMITERIO -> matriz[x][y] = new Cemiterio(x, y);
            case FABRICA -> matriz[x][y] = new Fabrica(x, y);
            case LOJA -> matriz[x][y] = new Loja(x, y);
        }
    }

    public String getCor(){
        return switch (this.tipo) {
            case LOJA -> "\u001B[34m";
            case TEMPLO -> "\u001B[33m";
            case FABRICA -> "\u001B[31m";
            case CEMITERIO -> "\u001B[35m";
        };
    }

    abstract void rodar();
    abstract void destruir();

    public Tipo getTipo() {
        return tipo;
    }

    public void moverPessoas(int x, Construcao y){
        if (x > pessoas){
            System.out.println("Você não pode transferir mais pessoas do que há na construção.");
        } else {
            pessoas = pessoas - x;
            y.pessoas = y.pessoas + x;
        }
    }
    public void descricao(){
        System.out.println("Tipo da Construção: " + this.tipo + "\nPosição x da Construção: " + this.x + "\nPosição y da Construção: " + this.y + "\nNúmero de pessoas: " + this.pessoas);
    }


}