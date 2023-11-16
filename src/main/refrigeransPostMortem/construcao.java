package main.refrigeransPostMortem;
abstract class construcao {
    protected String nome;
    protected int num;
    public construcao(String nome, int num){
        this.nome = nome;
        this.num = num;
    }
}

class Templo extends construcao {
    private String religiao;
    public Templo(String nome, int num, String religiao){
        super(nome, num);
        this.religiao = religiao;
    }
    public String getReligiao(){
        return religiao;
    }
    public String toString(){
        return "Nome: " + this.nome +
                "\nNumero: " + this.num +
                "\nReligiao: " + this.religiao;
    }
}

class Loja extends construcao {
    public Loja(String nome, int num){
        super(nome, num);
    }
    public String toString() {
        return "Nome: " + this.nome +
                "\nNumero: " + this.num;
    }
}