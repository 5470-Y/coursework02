package ru.quest.game;

import ru.quest.game.menu.*;
import ru.quest.game.player.Player;
import ru.quest.game.quest.GamePlay;
import ru.quest.game.quest.Quest;
import ru.quest.game.quest.Script;

import java.io.IOException;


public class Test {
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();
        MenuHandler menuHandler = new MenuHandler(
                new PlayCommand(menu),
                new BackCommand(menu),
                new ExitCommand(menu),
                new SaveCommand(menu),
                new LoadCommand(menu));
        Player player = new Player("user123", menuHandler);
        menu.setPlayer(player);
        menu.printFirstMenuOptions();






    }







}
