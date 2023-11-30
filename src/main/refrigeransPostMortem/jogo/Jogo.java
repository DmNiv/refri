package main.refrigeransPostMortem.jogo;
import main.refrigeransPostMortem.Construcao;
import main.refrigeransPostMortem.state.*;


public class Jogo {
    private Construcao[][] mapa;
    private String Cor;
    public static int refris;
    public int mortos;
    private State state;

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
        System.out.println("Estado do jogo: " + "\u001B[33m" + state.toString());
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


}
