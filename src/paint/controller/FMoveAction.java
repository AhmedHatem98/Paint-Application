/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import static paint.controller.Control.state;
import paint.model.Circle;
import paint.model.Ellipse;
import paint.model.Line;
import paint.model.Rect;
import paint.model.Square;
import paint.model.Triangle;

/**
 *
 * @author Ahmed Hatem
 */
public class FMoveAction extends FActions{
private static FMoveAction move;
private FMoveAction(){

}

    public static FMoveAction getMove() {
        move = new FMoveAction();
        return move;
    }




    @Override
   public void move(MouseEvent e) {
        try {
            
            System.out.println("workkk");
            Point p = new Point();
            if (selectedShape != null) {
                state.setAction("move");
                if (selectedShape instanceof Circle) {

                   
                    int diameter = (int) ((Circle) (selectedShape)).getDiameter();
                    p.x = e.getX() - (diameter / 2);
                    p.y = e.getY() - (diameter / 2);
                    selectedShape.setPosition(p);
                   // state.insertNew(selectedShape);
 originator.setState(selectedShape);
                   
                } else if (selectedShape instanceof Rect) {
                    
                    int length = (int) ((Rect) (selectedShape)).getLength();
                    int width = (int) ((Rect) (selectedShape)).getWidth();
                    p.x = e.getX() - (length / 2);
                    p.y = e.getY() - (width / 2);
                    selectedShape.setPosition(p);
                    //item.insertNew(selectedShape);
 originator.setState(selectedShape);
                   
                } else if (selectedShape instanceof Square) {

                    int length = (int) ((Square) (selectedShape)).getSideLength();
                    p.x = e.getX() - (length / 2);
                    p.y = e.getY() - (length / 2);
                    selectedShape.setPosition(p);
                    //item.insertNew(selectedShape);
 originator.setState(selectedShape);
                 
                } else if (selectedShape instanceof Ellipse) {
                    
                    int base = (int) ((Ellipse) (selectedShape)).getBase();
                    int height = (int) ((Ellipse) (selectedShape)).getHeight();
                    p.x = e.getX() - (base / 2);
                    p.y = e.getY() - (height / 2);
                    selectedShape.setPosition(p);
                    //item.insertNew(selectedShape);
 originator.setState(selectedShape);
                  
                } else if (selectedShape instanceof Line) {
                   
                    int x1 = (selectedShape).getPosition().x;
                    int x2 = ((Line) selectedShape).getX2();
                    int y1 = (selectedShape).getPosition().y;
                    int y2 = ((Line) selectedShape).getY2();
                    int xDiff = (x2 - x1);
                    int yDiff = (y2 - y1);

                    p.x = (e.getX() - xDiff / 2);
                    p.y = (e.getX() - yDiff / 2);
                    (selectedShape).setPosition(p);
                    ((Line) selectedShape).setX2((selectedShape).getPosition().x + xDiff);
                    ((Line) selectedShape).setY2((selectedShape).getPosition().y + yDiff);
                    //item.insertNew(selectedShape);
 originator.setState(selectedShape);
                  
                }
                else if(selectedShape instanceof Triangle){
		
		int x1 = ((Triangle) selectedShape).getPosition().x;
		int y1 = ((Triangle) selectedShape).getPosition().y;
		int x2 = ((Triangle) selectedShape).getxPoints()[2];
		int y2 = ((Triangle) selectedShape).getyPoints()[2];
		int base= x2 - x1;
		int height = y2 - y1;
                p.x = e.getX() - base / 2;
                p.y = e.getY() - height / 2;
                 selectedShape.setPosition(p);
		int[] xPoints = { (( selectedShape).getPosition().x+ base / 2),
				( selectedShape).getPosition().x,
				(( selectedShape).getPosition().x + base) };
		int[] yPoints = { ( selectedShape).getPosition().y,
				(( selectedShape).getPosition().y + height),
				(( selectedShape).getPosition().y + height) };
		((Triangle) selectedShape).setxPoints(xPoints);
		((Triangle) selectedShape).setyPoints(yPoints);
                    //item.insertNew(selectedShape);
 originator.setState(selectedShape);
                  
}
            }
        } catch (Exception c) {
            System.out.println(c);
        }
    }


    
    
}
