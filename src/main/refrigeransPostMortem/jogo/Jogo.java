package main.refrigeransPostMortem.jogo;

import main.refrigeransPostMortem.*;
import main.refrigeransPostMortem.state.*;
import java.lang.reflect.Method;


public class Jogo {
    private Construcao[][] mapa;
    private String Cor;
    private static int refris;
    private static int mortos;
    private static int dinheiros;
    private static int fieis;
    private static int pessoas = 10;
    private State state;
    private static int dia = 1;
    Class<?> fabricaClasse = Fabrica.class;
    Class<?> cemiterioClasse = Cemiterio.class;
    Class<?> lojaClasse = Loja.class;
    Class<?> temploClasse = Templo.class;
    Method[] metodosFabrica = fabricaClasse.getDeclaredMethods();
    Method[] metodosCemiterio = cemiterioClasse.getDeclaredMethods();
    Method[] metodosLoja = lojaClasse.getDeclaredMethods();
    Method[] metodosTemplo = temploClasse.getDeclaredMethods();

    public Jogo(int i, int j){
        state = new constructState();
        mapa = new Construcao[i][j];
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public Construcao[][] getMapa(){
        return mapa;
    }

    public Construcao getConstrucao(int i, int j){
        return mapa[i][j];
    }

    public void imprimirMapa(Jogador jogador){
        System.out.println("\n\n▂▃▅▇█▓▒░۩۞۩    † ☨ ✞ ✝ ☥ ☦ ☓ ♁ ☩    ۩۞۩░▒▓█▇▅▃▂\n");
        System.out.println("Estado do jogo: " + "\u001B[33m" + state.toString() + "\u001B[0m");
        System.out.println("Dia: " + dia);
        System.out.println("Pessoas disponíveis: " + pessoas + "\n\nRefrigerantes: " + refris + "\nMortos: " + mortos + "\nDinheiros: " + dinheiros + "\nFieis: " + fieis);
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                Construcao construcao = mapa[i][j];
                if (construcao != null){
                    Cor = construcao.getCor();
                    if (jogador.getPosicaoI() == i && jogador.getPosicaoJ() == j){
                        System.out.print(jogador.getCor() + "[" + Cor + construcao.getClass().getSimpleName().charAt(0) + jogador.getCor() + "]" + "\u001B[0m");
                    } else {
                        System.out.print("[" + Cor + construcao.getClass().getSimpleName().charAt(0) + "\u001B[0m" + "]");
                    }
                } else {
                    if (jogador.getPosicaoI() == i && jogador.getPosicaoJ() == j){
                        System.out.print(jogador.getCor() + "[ ]" + "\u001B[0m");
                    } else {
                        System.out.print("[ ]");
                    }
                }
            }
            System.out.println();
        }
    }

    public void removerConstrucao(Jogador jogador){
        pessoas += mapa[jogador.getPosicaoI()][jogador.getPosicaoJ()].getPessoas();
        mapa[jogador.getPosicaoI()][jogador.getPosicaoJ()] = null;
        System.gc();
    }

    public void proxDia(){
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                Construcao construcao = mapa[i][j];
                if (construcao != null){
                    construcao.rodar(this);
                }
            }
        }
        pessoas += 20;
        dia++;
    }

    public void aumentarRefris(){
        refris++;
    }

    public void aumentarMortos(){
        mortos++;
    }

    public void aumentarDinheiros(){
        dinheiros++;
    }

    public void aumentarFieis(){
        fieis++;
    }

    public int getPessoas(){
        return pessoas;
    }

    public void diminuiPessoas(int n){
        pessoas = pessoas - n;
    }
}