package main.refrigeransPostMortem;

import main.refrigeransPostMortem.jogo.Jogo;


public abstract class Construcao {

    public enum Tipo{
        TEMPLO,
        CEMITERIO,
        FABRICA,
        LOJA
    }

    private Tipo tipo;
    protected int pessoas;
    private int i;
    private int j;

    public Construcao(Tipo tipo, int i, int j){
        this.tipo = tipo;
        this.i = i;
        this.j = j;
        this.pessoas = 0;
    }

    public static void criarConstrucao(Tipo tipo, Construcao[][] matriz, int i, int j) {
        switch (tipo) {
            case TEMPLO -> matriz[i][j] = new Templo(i, j);
            case CEMITERIO -> matriz[i][j] = new Cemiterio(i, j);
            case FABRICA -> matriz[i][j] = new Fabrica(i, j);
            case LOJA -> matriz[i][j] = new Loja(i, j);
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

    public abstract void rodar(Jogo jogo);

    public void moverPessoas(int x, Construcao y){
        if (x > pessoas){
            System.out.println("Você não pode transferir mais pessoas do que há na construção.");
        } else {
            pessoas = pessoas - x;
            y.pessoas = y.pessoas + x;
        }
    }

    public void aumentarPessoas(Jogo jogo, int x){
        if (x <= jogo.getPessoas()){
            pessoas += x;
            jogo.diminuiPessoas(x);
        } else {
            System.out.println("Você não pode adicionar mais pessoas que o disponível nessa construção");
        }

    }

    public int getPessoas(){
        return pessoas;
    }

    public void descricao(){
        System.out.println("Tipo da Construção: " + this.tipo + "\nNúmero de pessoas: " + this.pessoas);
    }
}