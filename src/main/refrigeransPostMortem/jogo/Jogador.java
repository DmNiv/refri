package main.refrigeransPostMortem.jogo;
import main.refrigeransPostMortem.Construcao;
import java.util.Scanner;

public class Jogador {
    private int posI;
    private int posJ;
    Scanner scanner = new Scanner(System.in);


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

    public boolean espacoDisponivel(Jogo jogo){
        if (jogo.getConstrucao(getPosicaoI(), getPosicaoJ()) == null){
            return true;
        }
        return false;
    }

public void construir(Jogo jogo){
    System.out.println("Escolha o que construir:\nF: Fábrica\nC: Cemitério\nL: Loja\nT: Templo");
    if (scanner.hasNext()) {
        char input = scanner.next().charAt(0);
        switch (input) {
            case 'f':
                Construcao.criarConstrucao(Construcao.Tipo.FABRICA, jogo.getMapa(), getPosicaoI(), getPosicaoJ());
                break;
            case 'c':
                Construcao.criarConstrucao(Construcao.Tipo.CEMITERIO, jogo.getMapa(), getPosicaoI(), getPosicaoJ());
                break;
            case 'l':
                Construcao.criarConstrucao(Construcao.Tipo.LOJA, jogo.getMapa(), getPosicaoI(), getPosicaoJ());
                break;
            case 't':
                Construcao.criarConstrucao(Construcao.Tipo.TEMPLO, jogo.getMapa(), getPosicaoI(), getPosicaoJ());
                break;
            default:
                System.out.println("Tecla inválida. \n Use F, C, L ou T.");
        }
    }

}




}
