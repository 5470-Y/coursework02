package ru.quest.game;

public enum EndOfGame {

    WIN ("Игра завершилась успехом"),
    LOSS ("Игра завершилась неудачей");

    private final String endDescription;

    EndOfGame(String endDescription) {
        this.endDescription = endDescription;
    }

    public String getEndDescription() {
        return endDescription;
    }
}
