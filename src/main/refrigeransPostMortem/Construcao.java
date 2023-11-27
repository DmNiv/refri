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

    public static Construcao criarConstrucao(Tipo tipo, Construcao[][] matriz, int x, int y){
        Construcao novaConstrucao = switch (tipo) {
            case TEMPLO -> new Templo(x, y);
            case CEMITERIO -> new Cemiterio(x, y);
            case FABRICA -> new Fabrica(x, y);
            case LOJA -> new Loja(x, y);
        };

        matriz[x][y] = novaConstrucao;

        return novaConstrucao;
    }

    public String getCor(){
        return switch (this.tipo) {
            case LOJA -> "\u001B[32m";
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

    public void aumentarPessoas(int x){
        pessoas += x;
    }

}