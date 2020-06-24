/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

/**
 *
 * @author Ahmed Hatem
 */
public class CommandRedo implements Command {
private CommandEdit command;
public CommandRedo(CommandEdit command){
this.command = command;
}

    @Override
    public void execute() {
        command.redo();
    }
    
}
