/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import static paint.controller.Control.old;
import paint.model.Circle;
import paint.model.Ellipse;
import paint.model.Line;
import paint.model.Rect;
import paint.model.Shape;
import paint.model.Square;
import paint.model.Triangle;

/**
 *
 * @author Ahmed Hatem
 */
public class FActions extends Control {
      public Color color =Color.BLACK ;
   public Boolean filled = false;

    Point sPoint, fPoint;
    Graphics g2;
    Shape selectedShape;
    public int choice;
   
    public FActions() {
    
 
      
           
      
    }
    
    
public void draw(Point p1,Point p2){}
public  void move(MouseEvent e){

}

public void delete(MouseEvent e){}
 
 public void copy(MouseEvent e){}
 
 public  void color(MouseEvent e){}
 
 public  void resize(MouseEvent e){}
  public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void add(String choice) {

        if (choice.equalsIgnoreCase("rectangle")) {
            this.choice = 1;
            s = Rect.getRectangle();

        } else if (choice.equalsIgnoreCase("circle")) {
            this.choice = 2;
            s = Circle.getCircle();
        } else if (choice.equalsIgnoreCase("line")) {
            this.choice = 3;
            s = Line.getLine();

        } else if (choice.equalsIgnoreCase("square")) {
            this.choice = 4;
            s = Square.getSquare();

        } else if (choice.equalsIgnoreCase("triangle")) {
            this.choice = 5;
            s = Triangle.getTriangle();
        } else if (choice.equalsIgnoreCase("ellipse")) {
            this.choice = 6;
            s = Ellipse.getEllipse();

        }
    }

    public void addAll()  {

        old.add(s);
        //System.out.println(old.size());
        if (state.getAction().equalsIgnoreCase("draw") ) {
            originator.setState(s);
            state.add(originator.saveStateToMemento());
           

        }
        if(state.getAction().equalsIgnoreCase("move") || state.getAction().equalsIgnoreCase("resize")  )
        { 
        state.add(originator.saveStateToMemento());
         
        
         
        
        }

        if (state.getAction().equalsIgnoreCase("move") || state.getAction().equalsIgnoreCase("draw")||state.getAction().equalsIgnoreCase("resize")) {
            und.push(state);
         
        }

        //System.out.println(old.get(0).getPosition());
    }


    
    
    public void select(MouseEvent e) {
        try {
            selectedShape = null;
            System.out.println("select");
            state = new MementoCareTaker();
            originator = new MementoOriginator();
            for (int i = 0; i < old.size(); i++) {

                if (old.get(i) instanceof Circle) {
                    int x = old.get(i).getPosition().x;
                    int y = old.get(i).getPosition().y;
                    double diameter = ((Circle) (old.get(i))).getDiameter();
                    if ((e.getX() >= x && e.getX() <= (x + diameter)) && (e.getY() >= y && e.getY() <= (y + diameter))) {
                        selectedShape = old.get(i);
                           System.out.println("occurs");
                   originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                        break;
                    }

                }
                if (old.get(i) instanceof Rect) {
                    int x = old.get(i).getPosition().x;
                    int y = old.get(i).getPosition().y;
                    double length = ((Rect) (old.get(i))).getLength();
                    double width = ((Rect) (old.get(i))).getWidth();

                    if ((e.getX() >= x && e.getX() <= (x + length)) && (e.getY() >= y && e.getY() <= (y + width))) {
                                               selectedShape = old.get(i);
    System.out.println("occurs");

                                               originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                   break;
                    }

                }
                if (old.get(i) instanceof Square) {
                    int x = old.get(i).getPosition().x;
                    int y = old.get(i).getPosition().y;
                    double length = ((Square) (old.get(i))).getSideLength();

                    if ((e.getX() >= x && e.getX() <= (x + length)) && (e.getY() >= y && e.getY() <= (y + length))) {

                        selectedShape = old.get(i);
                       originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                        break;
                    }

                }
                if (old.get(i) instanceof Ellipse) {
                    int x = old.get(i).getPosition().x;
                    int y = old.get(i).getPosition().y;
                    double base = ((Ellipse) (old.get(i))).getBase();
                    double height = ((Ellipse) (old.get(i))).getHeight();

                    if ((e.getX() >= x && e.getX() <= (x + base)) && (e.getY() >= y && e.getY() <= (y + height))) {

                        selectedShape = old.get(i);
                        originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                        break;
                    }

                }
                if (old.get(i) instanceof Line) {
                    int x = e.getX();
                    int y = e.getY();
                    int x1 = (old.get(i)).getPosition().x;
                    int x2 = ((Line) old.get(i)).getX2();
                    int y1 = (old.get(i)).getPosition().y;
                    int y2 = ((Line) old.get(i)).getY2();
                    if ((x >= x1 && x <= x2) && (y >= y1 && y <= y2)) {
                        selectedShape = old.get(i);
                      originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());

                    } else if ((x <= x1 && x >= x2) && (y <= y1 && y >= y2)) {
                        selectedShape = old.get(i);
                      originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());

                    } else if ((x >= x1 && x <= x2) && (y <= y1 && y >= y2)) {
                        selectedShape = old.get(i);
                      originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                    } else if ((x <= x1 && x >= x2) && (y >= y1 && y <= y2)) {
                        selectedShape = old.get(i);
                       originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                    } else if ((x1 == x2) && (y >= y1 && y <= y2)) {
                        selectedShape = old.get(i);
                      originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                    } else if ((x <= x1 && x >= x2) && (y1 == y2)) {
                        selectedShape = old.get(i);
                    originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                    }
                }
                if (old.get(i) instanceof Triangle) {
                    int x = e.getX();
                    int y = e.getY();
                    int tX1 = ((Triangle) old.get(i)).getPosition().x;
                    int tY1 = ((Triangle) old.get(i)).getPosition().y;
                    int tX2 = ((Triangle) old.get(i)).getxPoints()[2];
                    int tY2 = ((Triangle) old.get(i)).getyPoints()[2];
                    if ((x >= tX1 && x <= tX2) && (y >= tY1 && y <= tY2)) {
                        selectedShape = old.get(i);
                         originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());

                    } else if ((x <= tX1 && x >= tX2) && (y <= tY1 && y >= tY2)) {
                        selectedShape = old.get(i);
                       originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                    } else if ((x >= tX1 && x <= tX2) && (y <= tY1 && y >= tY2)) {
                        selectedShape = old.get(i);
                        originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                    } else if ((x <= tX1 && x >= tX2) && (y >= tY1 && y <= tY2)) {
                        selectedShape = old.get(i);
                       originator.setState((Shape) selectedShape.clone());
                   state.add(originator.saveStateToMemento());
                    }

                }

            }
        } catch (Exception c) {
            System.out.println(c);
        }
    }

    

    
    
   

   
 
    
}
