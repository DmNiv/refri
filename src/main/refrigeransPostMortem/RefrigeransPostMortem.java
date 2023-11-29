package main.refrigeransPostMortem;
import java.io.IOException;
import java.lang.reflect.Method;
import main.Engine.Game;

public class RefrigeransPostMortem implements Game{
    private Construcao[][] mapa;
    private Jogador jogador;
    public String gameState = "run";
    private int linhas;
    private int colunas;
    private String Cor;
    public static int refris;
    public int mortos;
    private boolean gameOver = false;

    @Override
    public void init(){
        Class<?> fabricaClasse = Fabrica.class;
        Class<?> cemiterioClasse = Cemiterio.class;
        Class<?> lojaClasse = Loja.class;
        Class<?> temploClasse = Templo.class;
        Method[] metodosFabrica = fabricaClasse.getDeclaredMethods();
        Method[] metodosCemiterio = cemiterioClasse.getDeclaredMethods();
        Method[] metodosLoja = lojaClasse.getDeclaredMethods();
        Method[] metodosTemplo = temploClasse.getDeclaredMethods();

        this.linhas = 16;
        this.colunas = 16;
        mapa = new Construcao[linhas][colunas];
        jogador = new Jogador(0, 0);
    }
    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Construcao[][] getMapa(){
        return mapa;
    }

    public Construcao getConstrucao(int i, int j){
        return mapa[i][j];
    }

    @Override
    public void update(){
        try {
            limparTerminal();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
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

    public void limparTerminal() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

}
