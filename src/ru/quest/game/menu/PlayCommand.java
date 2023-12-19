package ru.quest.game.menu;

import java.io.IOException;

public class PlayCommand implements Command{
    Menu menu;

    public PlayCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.play();
    }

}
