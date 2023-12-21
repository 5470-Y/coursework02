package ru.quest.game.menu;

import java.io.IOException;
import java.util.Scanner;

public class MenuHandler {
    Command play;
    Command back;
    Command exit;
    Command save;
    Command load;

    public MenuHandler(Command play, Command back, Command exit, Command save, Command load) {
        this.play = play;
        this.back = back;
        this.exit = exit;
        this.save = save;
        this.load = load;
    }

    public MenuHandler() {

    }

    public void playGame() throws IOException {
        play.execute();
    }

    public void backToGame() throws IOException {
        back.execute();
    }

    public void exitGame() throws IOException {
        exit.execute();
    }

    public void saveGame() throws IOException {
        save.execute();
    }

    public void loadGame() throws IOException {
        load.execute();
    }


}
