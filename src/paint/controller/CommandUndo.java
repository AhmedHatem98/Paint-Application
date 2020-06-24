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
public class CommandUndo implements Command{
private CommandEdit command;
public CommandUndo(CommandEdit command){
this.command = command;
}

    @Override
    public void execute() {
        command.undo();
    }
   
    
}
