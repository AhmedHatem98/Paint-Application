/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

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
public class FResizeAction extends FActions{
private static FResizeAction resize;
    
    
    private FResizeAction(){}

    public static FResizeAction getResize() {
        resize = new FResizeAction();
        return resize;
    }
    
    
    
   
    public void resize(MouseEvent e){
   if(selectedShape !=null){
       state.setAction("resize");
   if(selectedShape instanceof Circle)
   {
		
		int x =  selectedShape.getPosition().x;
		int y =  selectedShape.getPosition().y;
		if (e.getX() >= x && e.getY() >= y) {
			((Circle) selectedShape).setDiameter((e.getX() - x));
		    // state.insertNew(selectedShape);
                    originator.setState(selectedShape);
                
                }
   
   }
   else if (selectedShape instanceof Rect){
		int x = ( selectedShape).getPosition().x;
		int y= ( selectedShape).getPosition().y;
		if (e.getX()>= x && e.getY() >= y) {
			((Rect) selectedShape).setLength(e.getX() - x);
			((Rect) selectedShape).setWidth(e.getY() - y);
                    originator.setState(selectedShape);

		}}

                else if(selectedShape instanceof Square){
               
		int x = selectedShape.getPosition().x;
		int y =  selectedShape.getPosition().y;
		if (e.getX() >= x && e.getY() >= y) {
			((Square) selectedShape).setSideLength(e.getX() - x);	
                    originator.setState(selectedShape);

		}
                
             }
              else if (selectedShape instanceof Ellipse){
  
		int x = selectedShape.getPosition().x;
		int y=  selectedShape.getPosition().y;
		if (e.getX()>= x && e.getY() >= y) {
			((Ellipse) selectedShape).setBase(e.getX() - x);
			((Ellipse) selectedShape).setHeight(e.getY() - y);
                    originator.setState(selectedShape);

		}}
   
                else if (selectedShape instanceof Line){
  
			((Line) selectedShape).setX2(e.getX());
			((Line) selectedShape).setY2(e.getY());
                    originator.setState(selectedShape);

			
		}
                else if(selectedShape instanceof Triangle){
               
		int tX1 = ((Triangle) selectedShape).getPosition().x;
		int tY1 = ((Triangle) selectedShape).getPosition().y;
		int width = e.getX() - tX1;
		int[] xPoints = { tX1 + (width / 2), tX1, e.getX() };
		int[] yPoints = { tY1, e.getY(), e.getY() };
		((Triangle) selectedShape).setxPoints(xPoints);
		((Triangle) selectedShape).setyPoints(yPoints);
                    originator.setState(selectedShape);


                
                
                }
   
   }
   
   }

   

    
}
