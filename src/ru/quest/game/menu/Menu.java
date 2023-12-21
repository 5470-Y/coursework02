package ru.quest.game.menu;

// Переписать заглушки на реальные методы

import ru.quest.game.quest.GamePlay;
import ru.quest.game.quest.Quest;
import ru.quest.game.player.Player;
import ru.quest.game.quest.Script;

import java.io.*;
import java.util.Scanner;

public class Menu {
    GamePlay gamePlay;
    Player player;

    public Menu() {}

    public Menu(GamePlay gamePlay, Player player) {
        this.gamePlay = gamePlay;
        this.player = player;
    }



    public GamePlay getGamePlay() {
        return gamePlay;
    }

    public void setGamePlay(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Menu(Player player) {
        this.player = player;
    }

    public void play() throws IOException {
        this.gamePlay = null;
        Quest quest = new Quest();
        Script script = new Script();
        script.setParagraphs(script.parseScript());
        Menu menu = new Menu();
        MenuHandler menuHandler = new MenuHandler(
                new PlayCommand(menu),
                new BackCommand(menu),
                new ExitCommand(menu),
                new SaveCommand(menu),
                new LoadCommand(menu));
        GamePlay gamePlay = new GamePlay(quest, 0);
        menu.setGamePlay(gamePlay);
        menu.setPlayer(player);
        quest.setScript(script);
        quest.setMenu(menu);
        quest.setMenuHandler(menuHandler);
        quest.setPlayer(player);
        quest.setGamePlay(gamePlay);
        gamePlay.gamePlay();
    }

    public void back(){
        gamePlay.gamePlay();
    }

    public void exit(){
        System.out.println("Вы вышли из игры");
    }

    public void save(){
        try(FileWriter writer = new FileWriter(player.getNickName() + ".txt")) {
            writer.append(String.valueOf(gamePlay.getMovePosition()));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Игра сохранена на главе " + gamePlay.getMovePosition());
    }

    public int load(){
        int a = 0;
        try (Scanner scanner = new Scanner(new File(player.getNickName() + ".txt"))){
            a = scanner.nextInt();
            gamePlay.setMovePosition(a);
        } catch (FileNotFoundException e) {
            System.out.println("Не найдено сохранения для игрока " + player.getNickName());
        }
        return gamePlay.gamePlay();
    }

    public void printFirstMenuOptions(){
        File file = new File(player.getNickName() + ".txt");
        Quest quest = new Quest();
        Script script = new Script();
        try {
            script.setParagraphs(script.parseScript());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Menu menu = new Menu();
        MenuHandler menuHandler = new MenuHandler(
                new PlayCommand(menu),
                new BackCommand(menu),
                new ExitCommand(menu),
                new SaveCommand(menu),
                new LoadCommand(menu));
        menu.setPlayer(player);
        GamePlay gamePlay = new GamePlay(quest, 0);
        menu.setGamePlay(gamePlay);
        menu.setPlayer(player);
        quest.setScript(script);
        quest.setMenu(menu);
        quest.setMenuHandler(menuHandler);
        quest.setPlayer(player);
        quest.setGamePlay(gamePlay);
        System.out.println("/play — Начать игру");
        if (file.exists()) {
            System.out.println("/load — Загрузить игру");
        }
        System.out.println("/exit — Выйти из игры");
        try {
            gamePlay.getQuest().selectMenuCommand();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printMenuOptions(){
        File file = new File(player.getNickName() + ".txt");
        System.out.println("/play — Начать игру");
        System.out.println("/back — Вернуться к игре");
        System.out.println("/save — Сохранить игру");
        if (file.exists()) {
            System.out.println("/load — Загрузить игру");
        }
        System.out.println("/exit — Выйти из игры");
        try {
            gamePlay.getQuest().selectMenuCommand();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
