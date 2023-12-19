package ru.quest.game.menu;

public class BackCommand implements Command{
    Menu menu;

    public BackCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.back();
    }

}
