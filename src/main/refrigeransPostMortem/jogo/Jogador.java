package main.refrigeransPostMortem.jogo;
import main.refrigeransPostMortem.Construcao;
import main.refrigeransPostMortem.Templo;

import java.lang.reflect.Method;
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

public void construir(Jogo jogo) {
    if (espacoDisponivel(jogo)) {
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
                    System.out.println("Tecla inválida. \nUse F, C, L ou T.");
            }
        }
    } else {
        System.out.println("\u001B[31m" + "Posição já ocupada. Deseja destruir essa construção?\nSim: s\nNão: n" + "\u001B[0m");
        if (scanner.hasNext()) {
            char input = scanner.next().charAt(0);
            switch (input) {
                case 's':
                    jogo.removerConstrucao(this);
                    break;
                case 'n':
                    System.out.println("Nesse caso aguarde o Estado de Manipulação para interagir com essa célula.");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
    }

    }

    public void mostrarDescricao (Jogo jogo) {
        if (jogo.getConstrucao(getPosicaoI(), getPosicaoJ()) != null) {
            jogo.getConstrucao(getPosicaoI(), getPosicaoJ()).descricao();
            Construcao.Tipo construcao = jogo.getConstrucao(getPosicaoI(), getPosicaoJ()).getTipo();
            switch (construcao) {
                case TEMPLO:
                    for (Method metodo : jogo.metodosTemplo) {
                        if (metodo.getDeclaringClass() != Object.class) {
                            System.out.println(" - " + metodo.getName());
                        }
                    }
                    break;
                case CEMITERIO:
                    for (Method metodo : jogo.metodosCemiterio) {
                        if (metodo.getDeclaringClass() != Object.class) {
                            System.out.println(" - " + metodo.getName());
                        }
                    }
                    break;
                case LOJA:
                    for (Method metodo : jogo.metodosLoja) {
                        if (metodo.getDeclaringClass() != Object.class) {
                            System.out.println(" - " + metodo.getName());
                        }
                    }
                    break;
                case FABRICA:
                    for (Method metodo : jogo.metodosFabrica) {
                        if (metodo.getDeclaringClass() != Object.class) {
                            System.out.println(" - " + metodo.getName());
                        }
                    }
                    break;
            }
        } else {
            System.out.println("Posição vazia, interaja com essa célula para construir no Estado de Construção");
        }
    }


}
