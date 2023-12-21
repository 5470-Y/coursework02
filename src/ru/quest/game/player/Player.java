package ru.quest.game.player;

import ru.quest.game.menu.MenuHandler;

import java.io.File;

public class Player {
    private String nickName;
    private File save;
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

}
