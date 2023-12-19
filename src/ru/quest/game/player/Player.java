package ru.quest.game.player;

import ru.quest.game.menu.MenuHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player {
    private String nickName;
    private File save;
    //private File players;
    //int playersCounter;
    MenuHandler menuHandler;

    public Player() {}

    public Player(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public Player(String nickName, MenuHandler menuHandler) {
        this.nickName = nickName;
        this.menuHandler = menuHandler;
    }

    public Player(String nickName, File save) {
        this.nickName = nickName;
        this.save = save;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public File getSave() {
        return save;
    }

    public void setSave(File save) {
        this.save = save;
    }

    public MenuHandler getMenuHandler() {
        return this.menuHandler;
    }

    public void setMenuHandler(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public void createPlayer() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите никнейм пользователя, нажмите Enter");
        String nickNameChecker = scanner.next();
        if (isExists(nickNameChecker)) {
            System.out.println("Игрок с таким ником уже существует");
            scanner.next();
        } else nickName = nickNameChecker;
        scanner.close();
        try(FileWriter writer = new FileWriter("players.txt", true)) {
            writer.write(nickName + '\n');
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Создан игрок с ником " + nickName);
    }


    public boolean isExists(String string) throws FileNotFoundException {
        try {
            String[] nickNames = Files.newBufferedReader(Paths.get("players.txt")).lines().toArray(String[]::new);
            for (int i = 0; i < nickNames.length; i++) {
                nickNames[i] = nickName;
                if (string.equalsIgnoreCase(nickName)) return true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
        
        
        /*Scanner scanner = new Scanner(new File("players.txt"));
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            for (int i = 0; i < nickNames.length; i++) {
                if (nickNames[i].isEmpty()) continue;
                switch(i){
                    case 0: event.setEventTime(LocalDateTime.parse(eventData[i])); continue;
                    case 1: event.setPriority(Integer.parseInt(eventData[i])); continue;
                    case 2: event.setDescription(eventData[i]);
                }
            }
            events.put(event.getEventTime(), event);
        }
    }*/

    /*public int playersCounter(){
        try (Scanner scanner = new Scanner(new File("players.txt"))) {
            while (scanner.hasNextLine()) {
                playersCounter++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } return
                playersCounter;
    }*/
}
