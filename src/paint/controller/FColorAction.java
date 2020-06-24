/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ahmed Hatem
 */
public class FColorAction extends FActions{
   private static FColorAction colors;
    private FColorAction(){
    
    }

    public static FColorAction getColors() {
        colors = new FColorAction();
        return colors;
    }
    
    
   

    @Override
    public void move(MouseEvent e) {
    }

    @Override
    public void delete(MouseEvent e) {
    }

    @Override
    public void copy(MouseEvent e) {
    }

    @Override
    public void color(MouseEvent e) {
        select(e);
        color = Color.BLUE;
        originator = new MementoOriginator();
        if (selectedShape != null) {
            System.out.println("working");
            state.setAction("color");
            originator.setState(selectedShape);
           state.add(originator.saveStateToMemento());
            selectedShape.setColor(color);
            selectedShape.setFillColor(color);
            System.out.println(selectedShape.getPosition());
            //item.insertNew(selectedShape);
           originator.setState(selectedShape);
           state.add(originator.saveStateToMemento());
          //  System.out.println(state.get(1).getState().getPosition());
           und.push(state);

        }

    }

    @Override
    public void resize(MouseEvent e) {
    }

    @Override
    public void save(String path) {
    }

    @Override
    public void load(String path) {
    }
    
}
