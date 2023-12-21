package ru.quest.game.quest;

public record ActionProperty (int actionId, int firstActionId, int secondActionId) {

    public ActionProperty(int actionId, int firstActionId, int secondActionId) {
        this.actionId = actionId;
        this.firstActionId = firstActionId;
        this.secondActionId = secondActionId;
    }

    public int getActionId() {
        return actionId;
    }

    public int getFirstAction() {
        return firstActionId;
    }

    public int getSecondAction() {
        return secondActionId;
    }

    @Override
    public String toString() {
        return "ActionProperty{" +
                "actionId=" + actionId +
                ", firstActionId=" + firstActionId +
                ", secondActionId=" + secondActionId +
                '}';
    }
}
