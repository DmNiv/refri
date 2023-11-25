package main;


import main.Engine.*;
import main.refrigeransPostMortem.Construcao;
import main.refrigeransPostMortem.jogo.Jogo;

import java.io.IOException;

public class  Main{

    public static void main(String[] args) throws IOException {
        Jogo novoJogo = new Jogo();



        Construcao.criarConstrucao(Construcao.Tipo.TEMPLO, novoJogo.getMapa(), 10, 15);
        Construcao.criarConstrucao(Construcao.Tipo.LOJA, novoJogo.getMapa(), 0, 0);
        Construcao.criarConstrucao(Construcao.Tipo.CEMITERIO, novoJogo.getMapa(), 6, 6);
        Construcao.criarConstrucao(Construcao.Tipo.FABRICA, novoJogo.getMapa(), 12, 4);
        Construcao.criarConstrucao(Construcao.Tipo.TEMPLO, novoJogo.getMapa(), 1, 3);
        Construcao.criarConstrucao(Construcao.Tipo.FABRICA, novoJogo.getMapa(), 7, 2);
        Construcao.criarConstrucao(Construcao.Tipo.LOJA, novoJogo.getMapa(), 2, 2);

        novoJogo.imprimirMapa();
    }

}