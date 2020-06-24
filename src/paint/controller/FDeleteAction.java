/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.event.MouseEvent;
import static paint.controller.Control.state;
import paint.model.Shape;

/**
 *
 * @author Ahmed Hatem
 */
public class FDeleteAction extends FActions{
private static FDeleteAction delete;
private FDeleteAction(){

}

    public static FDeleteAction getDelete() {
        delete = new FDeleteAction();
        return delete;
    }
    


    @Override
   public void delete(MouseEvent e) {
        try {
            //  state.setBefore(shapes);

            select(e);
            if (selectedShape != null) {

                removeShape(selectedShape);
                Shape x = selectedShape;
              
               originator.setState(x);
               state.add(originator.saveStateToMemento());
                state.setAction("delete");
                und.push(state);
                System.out.println("stack size " + und.size());
            }
        } catch (Exception c) {
            System.out.println(c);
        }

    }


    
    @Override
    public void save(String path) {
    }

    @Override
    public void load(String path) {
    }
    
}
