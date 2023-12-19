package ru.quest.game;

import ru.quest.game.menu.*;
import ru.quest.game.player.Player;

import java.io.IOException;


public class Test {
    public static void main(String[] args) throws IOException {
        /*Menu menu = new Menu();
        MenuHandler menuHandler = new MenuHandler(
                new PlayCommand(menu),
                new BackCommand(menu),
                new ExitCommand(menu),
                new SaveCommand(menu),
                new LoadCommand(menu));
        Player player = new Player();
        player.setMenuHandler(menuHandler);
        player.createPlayer();
        menu.setPlayer(player);
        Script script = new Script();
        script.setParagraphs(script.parseScript());
        GamePlay gamePlay = new GamePlay(player, script, 0);
        gamePlay.setMenu(menu);
        menu.setGamePlay(gamePlay);
        menu.play();*/

        Script script = new Script();
        Menu menu = new Menu();
        MenuHandler menuHandler = new MenuHandler(
                new PlayCommand(menu),
                new BackCommand(menu),
                new ExitCommand(menu),
                new SaveCommand(menu),
                new LoadCommand(menu));
        Player player = new Player("sdfsd", menuHandler);
        script.setParagraphs(script.parseScript());
        GamePlay gamePlay = new GamePlay(script, 0);
        menu.setGamePlay(gamePlay);
        menu.setPlayer(player);
        script.setMenu(menu);
        gamePlay.gamePlay(/*gamePlay.getMovePosition()*/);


        //menu.printMenuOptions();
        /*Script script = new Script();
        script.setParagraphs(script.parseScript());
        GamePlay gamePlay = new GamePlay(player, script, 0);*/
        //gamePlay.gamePlay(/*gamePlay.getMovePosition()*/);



    }







}
