package main;


import main.Engine.*;
import main.refrigeransPostMortem.*;
import main.refrigeransPostMortem.jogo.Jogo;
import java.io.IOException;
import java.lang.reflect.Method;

public class  Main{
    public static void main(String[] args) throws IOException {
        Class<?> fabricaClasse = Fabrica.class;
        Class<?> cemiterioClasse = Cemiterio.class;
        Class<?> lojaClasse = Loja.class;
        Class<?> temploClasse = Templo.class;
        Method[] metodosFabrica = fabricaClasse.getDeclaredMethods();
        Method[] metodosCemiterio = cemiterioClasse.getDeclaredMethods();
        Method[] metodosLoja = lojaClasse.getDeclaredMethods();
        Method[] metodosTemplo = temploClasse.getDeclaredMethods();

        Jogo novoJogo = new Jogo();
        Construcao.criarConstrucao(Construcao.Tipo.TEMPLO, novoJogo.getMapa(), 10, 15);
        Construcao.criarConstrucao(Construcao.Tipo.LOJA, novoJogo.getMapa(), 0, 0);
        Construcao.criarConstrucao(Construcao.Tipo.CEMITERIO, novoJogo.getMapa(), 6, 6);
        Construcao.criarConstrucao(Construcao.Tipo.FABRICA, novoJogo.getMapa(), 12, 4);
        Construcao.criarConstrucao(Construcao.Tipo.TEMPLO, novoJogo.getMapa(), 1, 3);
        Construcao.criarConstrucao(Construcao.Tipo.FABRICA, novoJogo.getMapa(), 7, 2);
        Construcao.criarConstrucao(Construcao.Tipo.LOJA, novoJogo.getMapa(), 2, 2);

        if (novoJogo.getConstrucao(12, 4) instanceof Fabrica fabrica){
            fabrica.aumentarPessoas(13);
        }

        novoJogo.getConstrucao(12, 4).descricao();
        novoJogo.getConstrucao(7, 2).descricao();
        novoJogo.getConstrucao(12, 4).moverPessoas(3, novoJogo.getConstrucao(7, 2));
        novoJogo.getConstrucao(12, 4).descricao();
        novoJogo.getConstrucao(7, 2).descricao();

        novoJogo.imprimirMapa();

        for (Method metodo : metodosFabrica) {
            if (metodo.getDeclaringClass() != Object.class) {
                System.out.println("Método implementado: " + metodo.getName());
            }
        }


    }

}