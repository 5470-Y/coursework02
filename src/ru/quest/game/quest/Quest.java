package ru.quest.game.quest;

import ru.quest.game.menu.Menu;
import ru.quest.game.menu.MenuHandler;
import ru.quest.game.player.Player;

import java.io.IOException;
import java.util.Scanner;

public class Quest {
    Script script;
    Menu menu;
    MenuHandler menuHandler;
    Player player;
    GamePlay gamePlay;

    public Quest(){}

    public Quest(Menu menu, MenuHandler menuHandler, Script script, Player player, GamePlay gamePlay) {
        this.menu = menu;
        this.menuHandler = menuHandler;
        this.script = script;
        this.player = player;
        this.gamePlay = gamePlay;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public MenuHandler getMenuHandler() {
        return menuHandler;
    }

    public void setMenuHandler(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public Script getScript() {
        return script;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GamePlay getGamePlay() {
        return gamePlay;
    }

    public void setGamePlay(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    public void selectMenuCommand() throws IOException {
        while (true) {
            Scanner stringScanner = new Scanner(System.in);
            try {
                String input = stringScanner.next();
                switch (input.toLowerCase()) {
                    case "/play" -> menuHandler.playGame();
                    case "/back" -> menuHandler.backToGame();
                    case "/exit" -> {
                        try {
                            menuHandler.exitGame();
                            stringScanner.close();
                        } catch (IllegalStateException e) {
                            System.out.println("Вы вышли из игры");
                            stringScanner.close();
                        }
                    }
                    case "/save" -> {
                        menuHandler.saveGame();
                    }
                    case "/load" -> menuHandler.loadGame();
                    default -> {
                        System.out.println("Команда отсутствует. Повторите ввод:");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
