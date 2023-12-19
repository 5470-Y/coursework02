package ru.quest.game.menu;

public class ExitCommand implements Command{
    Menu menu;

    public ExitCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.exit();
    }

}
