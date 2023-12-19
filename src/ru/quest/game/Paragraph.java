package ru.quest.game;

public class Paragraph {
    private String paragraphName;
    private String paragraphDescription;
    private String firstActionDescription;
    private String secondActionDescription;

    public Paragraph(){}

    public Paragraph(String paragraphName, String paragraphDescription, String firstActionDescription, String secondActionDescription) {
        this.paragraphName = paragraphName;
        this.paragraphDescription = paragraphDescription;
        this.firstActionDescription = firstActionDescription;
        this.secondActionDescription = secondActionDescription;
    }

    public String getParagraphName() {
        return paragraphName;
    }

    public void setParagraphName(String paragraphName) {
        this.paragraphName = paragraphName;
    }

    public String getParagraphDescription() {
        return paragraphDescription;
    }

    public void setParagraphDescription(String paragraphDescription) {
        this.paragraphDescription = paragraphDescription;
    }

    public String getFirstActionDescription() {
        return firstActionDescription;
    }

    public void setFirstActionDescription(String firstActionDescription) {
        this.firstActionDescription = firstActionDescription;
    }

    public String getSecondActionDescription() {
        return secondActionDescription;
    }

    public void setSecondActionDescription(String secondActionDescription) {
        this.secondActionDescription = secondActionDescription;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "Название = " + paragraphName +
                "; Описание = " + paragraphDescription +
                "; Выбор 1 = " + firstActionDescription +
                "; Выбор 2 = " + secondActionDescription + "}";
    }
}
