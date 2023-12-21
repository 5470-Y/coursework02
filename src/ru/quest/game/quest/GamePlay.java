package ru.quest.game.quest;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GamePlay {
    private Quest quest;
    private int movePosition = 0;
    private  final  ActionProperty[] actionProperties = {
            new ActionProperty (0,1,2),
            new ActionProperty (2,3,4),
            new ActionProperty (3,5,6),
            new ActionProperty (5,7,4),
            new ActionProperty (6,1,4),
            new ActionProperty (7,4,8),
            new ActionProperty (8,9,10),
            new ActionProperty (9,11,12),
            new ActionProperty (12,4,1)};


    public GamePlay() {}

    public GamePlay(Quest quest, int movePosition) {
        this.quest = quest;
        this.movePosition = movePosition;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public int getMovePosition() {
        return movePosition;
    }

    public int setMovePosition(int movePosition) {
        this.movePosition = movePosition;
        return movePosition;
    }

    public ActionProperty[] getActionProperties() {
        return actionProperties;
    }

    public int gamePlay(){
        showParagraphText();
        while (true) {
            compareTo(movePosition);
            showParagraphText();
        }
    }

    public void showParagraphText() {
        if (isNoActionDescriptions()) {
            System.out.println((quest.getScript().getParagraphs())[movePosition].getParagraphDescription());
            printEndOfGameResult(movePosition);
            System.out.println("3. Выйти в главное меню");
        } else {
            System.out.println((quest.getScript().getParagraphs())[movePosition].getParagraphDescription() + '\n' +
                    "1. " + (quest.getScript().getParagraphs())[movePosition].getFirstActionDescription() + '\n' +
                    "2. " + (quest.getScript().getParagraphs())[movePosition].getSecondActionDescription() + '\n' +
                    "3. Выйти в главное меню");
        }
    }

    public int compareTo(int movePosition) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                for (ActionProperty actionProperty : actionProperties) {
                    if (movePosition == actionProperty.getActionId()) {
                        return setMovePosition(actionProperty.getFirstAction());
                    }
                }
            }
            case 2 -> {
                for (ActionProperty actionProperty : actionProperties) {
                    if (movePosition == actionProperty.getActionId()) {
                        return setMovePosition(actionProperty.getSecondAction());
                    }
                }
            }
            case 3 -> {
                quest.getMenu().printMenuOptions();

            }
            default -> {
                System.out.println("Лисёнок засомневался, ещё раз подумал и решил...");
                scanner.nextInt();

            }
        }
        scanner.close();
        return setMovePosition(movePosition);
    }

    public void printEndOfGameResult(int movePosition){
        switch (movePosition) {
            case 1 -> System.out.println(EndOfGame.WIN.getEndDescription());
            case 4, 10, 11 -> System.out.println(EndOfGame.LOSS.getEndDescription());
        }
    }

    public boolean isNoActionDescriptions() {
        return ((quest.getScript().getParagraphs())[movePosition].getFirstActionDescription() == null
                || (quest.getScript().getParagraphs())[movePosition].getSecondActionDescription() == null);
    }
}