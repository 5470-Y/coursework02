package ru.quest.game.menu;

import java.io.IOException;

// или public abstract class? Хотя тогда абстрактный метод должен быть реализован в каждом дочернем классе
public interface Command {

    void execute() throws IOException;

}
