package main;


import main.Engine.*;
import main.refrigeransPostMortem.Construcao;

import java.io.IOException;

public class  Main{

    public static void main(String[] args) throws IOException {
        Construcao templo = Construcao.criarConstrucao(Construcao.Tipo.TEMPLO, 10, 20);
        templo.descricao();
    }

}