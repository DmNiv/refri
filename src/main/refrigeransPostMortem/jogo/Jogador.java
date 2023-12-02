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
        return jogo.getConstrucao(getPosicaoI(), getPosicaoJ()) == null;
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

    public void moverPessoas(Jogo jogo) {
        System.out.println("Informe a posição (linha coluna) da construção para onde deseja mover as pessoas:");
        if (scanner.hasNextInt()) {
            int linha = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int coluna = scanner.nextInt();
                Construcao construcaoDestino = jogo.getConstrucao(linha, coluna);
                if (construcaoDestino != null) {
                    System.out.println("Quantas pessoas você quer mover dessa construção?");
                    if (scanner.hasNextInt()) {
                        int numPessoas = scanner.nextInt();
                        jogo.getConstrucao(getPosicaoI(), getPosicaoJ()).moverPessoas(numPessoas, construcaoDestino);
                        System.out.println(numPessoas + " pessoas movidas para a construção na posição (" + linha + ", " + coluna + ").");
                    } else {
                        System.out.println("Entrada inválida para o número de pessoas.");
                    }
                } else {
                    System.out.println("Construção de destino não existe.");
                }
            } else {
                System.out.println("Entrada inválida para a coluna.");
            }
        } else {
            System.out.println("Entrada inválida para a linha.");
        }
    }

    public void mostrarDescricao (Jogo jogo) {
        if (jogo.getConstrucao(getPosicaoI(), getPosicaoJ()) != null) {
            jogo.getConstrucao(getPosicaoI(), getPosicaoJ()).descricao();
            Construcao construcao = jogo.getConstrucao(getPosicaoI(), getPosicaoJ());
            System.out.println("Você deseja aumentar ou mover o número de pessoas nessa construção?\n1: Aumentar\n2: Mover\n3: Sair");
            if (scanner.hasNext()) {
                char input = scanner.next().charAt(0);
                switch (input){
                    case '1':
                        System.out.println("Quantas pessoas você quer adicionar nessa construção?");
                        if (scanner.hasNext()) {
                            int num = Integer.parseInt(scanner.next());
                            construcao.aumentarPessoas(jogo, num);
                        }
                        break;
                    case '2':
                        moverPessoas(jogo);
                        break;
                    case '3':
                        break;
                }
            }
        } else {
            System.out.println("Posição vazia, interaja com essa célula para construir no Estado de Construção");
        }
    }
}