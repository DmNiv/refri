package main.Engine;

import main.Engine.Keyboard;

public class engine implements Runnable{
    public static Keyboard keyboard;
    private Game game;
    private boolean running;

    public engine() {
        keyboard = new Keyboard();
    }

    public void start(Game game) {
        this.game = game;

        running = true;
        game.init();

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run(){

        while (running) {

        }
    game.end();
    }

}