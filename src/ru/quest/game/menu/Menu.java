package ru.quest.game.menu;

// Переписать заглушки на реальные методы

import ru.quest.game.GamePlay;
import ru.quest.game.player.Player;

import java.io.*;
import java.util.Scanner;

public class Menu {
    GamePlay gamePlay;
    Player player;
    //MenuHandler menuHandler;

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
        gamePlay.gamePlay();
    }

    public void back(){
        gamePlay.gamePlay();
    }

    public void exit(){
        System.out.println("Вы вышли из игры");
    }

    public void save(){
        try(FileWriter writer = new FileWriter(player.getNickName() + ".txt"/*, false*/)) {
            writer.append(String.valueOf(gamePlay.getMovePosition())); // Записываем число в файл, конвертируя число в строку https://ru.hexlet.io/qna/java/questions/kak-zapisat-chislo-v-fayl-java
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Игра сохранена на главе " + gamePlay.getMovePosition());
    }

    public int load(){
        int a = 0;
        try {
            Scanner scanner = new Scanner(new File(player.getNickName() + ".txt"));
            a = scanner.nextInt();
            gamePlay.setMovePosition(a);
        } catch (FileNotFoundException e) {
            System.out.println("Не найдено сохранения для игроква " + player.getNickName());
        }
        return gamePlay.gamePlay();
    }


    public void printMenuOptions(){
        File file = new File(player.getNickName() + ".txt");
        System.out.println("/play — Начать игру");
        // Дописать условие вывода (должно отображаться только после запуска игры)
        System.out.println("/back — Вернуться к игре");
        System.out.println("/exit — Выйти из игры");
        System.out.println("/save — Сохранить игру");
        if (file.exists()) {
            System.out.println("/load — Загрузить игру");
        }
    }


}
