package com.example.kongoji.reanimationtest;

/**
 * Created by danielreinhardt on 20.10.14.
 */
public interface CommandManager {

    public void executeCommand(ReanimationCommand command);

    public void undoCommand();
}
