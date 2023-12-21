package ru.quest.game.quest;

import java.io.*;
import java.util.*;

public class Script {
    private int paragraphCount;
    private final File scriptPath = new File("src/ru/quest/game/script.txt");
    private Paragraph[] paragraphs;

    public Script(){}

    public Script(Paragraph[] paragraphs) {
        this.paragraphs = paragraphs;
    }

    public Paragraph[] getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(Paragraph[] paragraphs) {
        this.paragraphs = paragraphs;
    }

    public int paragraphCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                paragraphCount++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return paragraphCount;
    }

    public Paragraph[] parseScript() throws IOException {
        Scanner scanner = new Scanner(new File(String.valueOf(scriptPath)));
        paragraphCounter();
        LinkedHashMap<Integer, Paragraph> paragraphsLinkedHashMap = new LinkedHashMap<>();
        int index = 0;
        while (scanner.hasNext()) {
            Paragraph paragraph = new Paragraph();
            String nextLine = scanner.nextLine();
            String[] scriptData = nextLine.split("::");
            for (int i = 0; i < scriptData.length; i++, index++) {
                if (scriptData[i].isEmpty()) continue;
                switch(i){
                    case 0: paragraph.setParagraphName(scriptData[i]); continue;
                    case 1: paragraph.setParagraphDescription(scriptData[i]); continue;
                    case 2: paragraph.setFirstActionDescription(scriptData[i]); continue;
                    case 3: paragraph.setSecondActionDescription(scriptData[i]);
                }
            }
            paragraphsLinkedHashMap.put(index, paragraph);
        }
        scanner.close();
        Paragraph[] paragraphs = {};
        return paragraphs = paragraphsLinkedHashMap.values().toArray(new Paragraph[paragraphCount]);
    }
}
