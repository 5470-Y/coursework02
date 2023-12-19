package ru.quest.game;

import java.io.IOException;
import java.util.Scanner;

public class GamePlay /*implements Comparable<ActionProperty>*/{
    private Script script;
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

    public GamePlay(Script script) {
        this.script = script;
    }

    public GamePlay(Script script, int movePosition) {
        this.script = script;
        this.movePosition = movePosition;
    }

    public Script getScript() {
        return script;
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
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (movePosition <= script.paragraphCounter()){
            if (choice == 3) {
                script.getMenu().printMenuOptions();
                try {
                    script.getMenu().getPlayer().getMenuHandler().selectMenuCommand();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scanner.close();
                break;
            } else if (choice == 1) {
                for (ActionProperty actionProperty : actionProperties) {
                    if (movePosition == actionProperty.getActionId()) {
                        return setMovePosition(actionProperty.getFirstAction());
                    }
                }
            } else if (choice == 2) {
                for (ActionProperty actionProperty : actionProperties) {
                    if (movePosition == actionProperty.getActionId()) {
                        return setMovePosition(actionProperty.getSecondAction());
                    }
                }
            } else {
                System.out.println("Лисёнок засомневался, ещё раз подумал и решил...");
                scanner.nextInt();
            }
            setMovePosition(getMovePosition());
            showParagraphText();
        }/* while (movePosition <= script.paragraphCounter());*/
        scanner.close();
        return getMovePosition();
    }


/*    public void gamePlay(){
        showParagraphText();
        while (true) {
            compareTo(movePosition);
            setMovePosition(getMovePosition());
            showParagraphText();
        }
    }*/

    public void showParagraphText() {
        if (isNoActionDescriptions()) {
            System.out.println((getScript().getParagraphs())[movePosition].getParagraphDescription());
            printEndOfGameResult(movePosition);
            System.out.println("3. Выйти в главное меню");
        } else {
            System.out.println((getScript().getParagraphs())[movePosition].getParagraphDescription() + '\n' +
                    "1. " + (getScript().getParagraphs())[movePosition].getFirstActionDescription() + '\n' +
                    "2. " + (getScript().getParagraphs())[movePosition].getSecondActionDescription() + '\n' +
                    "3. Выйти в главное меню");
        }
    }


    public int compareTo(int movePosition) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        do {
            if (choice == 3) {
                script.getMenu().printMenuOptions();
                scanner.close();
                break;
            } else if (choice == 1) {
                for (ActionProperty actionProperty : actionProperties) {
                    if (movePosition == actionProperty.getActionId()) {
                        return setMovePosition(actionProperty.getFirstAction());
                    }
                }
            } else if (choice == 2) {
                for (ActionProperty actionProperty : actionProperties) {
                    if (movePosition == actionProperty.getActionId()) {
                        return setMovePosition(actionProperty.getSecondAction());
                    }
                }
            } else {
                System.out.println("Лисёнок засомневался, ещё раз подумал и решил...");
                scanner.nextInt();
            }
        } while (true);
        scanner.close();
        return getMovePosition();
    }

    public void printEndOfGameResult(int movePosition){
        switch (movePosition) {
            case 1 -> System.out.println(EndOfGame.WIN.getEndDescription());
            case 4, 10, 11 -> System.out.println(EndOfGame.LOSS.getEndDescription());
        }
    }

    public boolean isNoActionDescriptions() {
        return ((getScript().getParagraphs())[movePosition].getFirstActionDescription() == null
                || (getScript().getParagraphs())[movePosition].getSecondActionDescription() == null);
    }

    public boolean isMenuReturned() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //scanner.close();
        return (choice == 3);

    }
}