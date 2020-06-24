/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.util.Stack;
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
public class CommandEdit extends Control{

    public CommandEdit(){
    

    }
public void undo() {
        try {
            MementoCareTaker it = new MementoCareTaker();
            MementoCareTaker state = new MementoCareTaker();
            originator = new MementoOriginator();
            it = und.peek();
            Shape temp = null;
            Shape temp2 = null;
            if(it.getAction().equalsIgnoreCase("delete") || it.getAction().equalsIgnoreCase("draw") )
            { temp = it.get(0);}
            else
            {
            temp = it.get(0);
            temp2 = it.get(1);
            }
          
           

            if (it.getAction().equalsIgnoreCase("move")) {
                und.pop();
               
                originator.setState((Shape) temp2.clone());
                state.add(originator.saveStateToMemento());
                state.setAction("move");
                temp2.setPosition(temp.getPosition());
                if(temp instanceof Triangle){
                    System.out.println("qwq");
                    ((Triangle)temp2).setxPoints(((Triangle)temp).getxPoints());
                    ((Triangle)temp2).setyPoints(((Triangle)temp).getyPoints());
                }
                 originator.setState(temp2);
                state.add(originator.saveStateToMemento());                
                red.push(state);

            } else if ((it.getAction().equalsIgnoreCase("color"))) {
                und.pop();
                //item.insertShape(temp2);
 originator.setState((Shape) temp2.clone());
 state.add(originator.saveStateToMemento());
                state.setAction("color");
                temp2.setColor(temp.getColor());
                temp2.setFillColor(temp.getFillColor());
                 originator.setState(temp2);
                state.add(originator.saveStateToMemento());               
// state.insertNew(temp2);
                red.push(state);
            }
            if (it.getAction().equalsIgnoreCase("draw")) {
                und.pop();

                Shape x = old.get(old.size() - 1);
               originator.setState(temp);
                state.add(originator.saveStateToMemento()); 
               state.setAction("draw");
                removeShape(x);
                

                red.push(state);
            } else if (it.getAction().equalsIgnoreCase("delete")) {
                und.pop();
                System.out.println("works");
                shapes.add(temp);
                old.add(temp);
               originator.setState(temp);
                state.add(originator.saveStateToMemento()); 
               state.setAction("delete");
                red.push(state);
            } else if ((it.getAction().equalsIgnoreCase("copy"))) {
                und.pop();
                Shape x = temp2;
                removeShape(x);

            }
            else if(it.getAction().equalsIgnoreCase("ReSize")){
            und.pop();
               // state.insertShape(temp2);
                originator.setState((Shape) temp2.clone());
                state.add(originator.saveStateToMemento()); 
               state.setAction("resize");
                if(temp2 instanceof Circle)
                    ((Circle) temp2).setDiameter(((Circle)temp).getDiameter());
                else if(temp2 instanceof Rect)  {
                      ((Rect) temp2).setLength(((Rect)temp).getLength());
                    ((Rect) temp2).setWidth(((Rect)temp).getWidth());
                }              
                else if(temp2 instanceof Ellipse){
                    ((Ellipse) temp2).setBase(((Ellipse)temp).getBase());
                    ((Ellipse) temp2).setHeight(((Ellipse)temp).getHeight());
                }
                else if(temp2 instanceof Line){
                    ((Line) temp2).setX2(((Line)temp).getX2());
                    ((Line) temp2).setY2(((Line)temp).getY2());
                }
                 else if(temp2 instanceof Square){
                    ((Square) temp2).setSideLength(((Square)temp).getSideLength());
                    
                }
                
                 else if(temp2 instanceof Triangle){
                    ((Triangle)temp2).setxPoints(((Triangle)temp).getxPoints());
                    ((Triangle)temp2).setyPoints(((Triangle)temp).getyPoints());
                }
               // state.insertNew(temp2);
               originator.setState(temp2);
                state.add(originator.saveStateToMemento()); 
               red.push(state);
            
            
            
            }

//it.insertShape(temp2);
//und.push(it);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

   public void redo() {
        try {
            MementoCareTaker it = new MementoCareTaker();
            MementoCareTaker state = new MementoCareTaker();
            originator = new MementoOriginator();
it = red.pop();
Shape temp = null;
            Shape temp2 = null;
            if(it.getAction().equalsIgnoreCase("delete") || it.getAction().equalsIgnoreCase("draw") )
            { temp = it.get(0);}
            else
            {
            temp = it.get(0);
            temp2 = it.get(1);
            }
          

          
            

            if (it.getAction().equalsIgnoreCase("move")) {
               originator.setState((Shape) temp2.clone());
                state.add(originator.saveStateToMemento());
                state.setAction("move");
                temp2.setPosition(temp.getPosition());
                if(temp instanceof Triangle){
                  
                    ((Triangle)temp2).setxPoints(((Triangle)temp).getxPoints());
                    ((Triangle)temp2).setyPoints(((Triangle)temp).getyPoints());
                }
                 originator.setState(temp2);
                state.add(originator.saveStateToMemento());                
               
                und.push(state);
            } else if (it.getAction().equalsIgnoreCase("draw")) {
                state.setAction("draw");
                shapes.add(temp);
                old.add(temp);
               // state.insertNew(temp2);
               originator.setState(temp);
               state.add(originator.saveStateToMemento());
                und.push(state);

            } else if (it.getAction().equalsIgnoreCase("color")) {
 originator.setState((Shape) temp2.clone());
 state.add(originator.saveStateToMemento());
                state.setAction("color");
                temp2.setColor(temp.getColor());
                temp2.setFillColor(temp.getFillColor());
                originator.setState(temp2);
                state.add(originator.saveStateToMemento());                
                und.push(state);

            } else if (it.getAction().equalsIgnoreCase("delete")) {
                state.setAction("delete");
               removeShape( temp);
                
               originator.setState(temp);
               state.add(originator.saveStateToMemento());
                und.push(state);

            }
            else if (it.getAction().equalsIgnoreCase("resize")){
            
             
              originator.setState((Shape) temp2.clone());
                state.add(originator.saveStateToMemento()); 
               state.setAction("resize");
                if(temp2 instanceof Circle)
                    ((Circle) temp2).setDiameter(((Circle)temp).getDiameter());
                else if(temp2 instanceof Rect)  {
                      ((Rect) temp2).setLength(((Rect)temp).getLength());
                    ((Rect) temp2).setWidth(((Rect)temp).getWidth());
                }              
                else if(temp2 instanceof Ellipse){
                    ((Ellipse) temp2).setBase(((Ellipse)temp).getBase());
                    ((Ellipse) temp2).setHeight(((Ellipse)temp).getHeight());
                }
                else if(temp2 instanceof Line){
                    ((Line) temp2).setX2(((Line)temp).getX2());
                    ((Line) temp2).setY2(((Line)temp).getY2());
                }
                 else if(temp2 instanceof Square){
                    ((Square) temp2).setSideLength(((Square)temp).getSideLength());
                    
                }
                
                 else if(temp2 instanceof Triangle){
                    ((Triangle)temp2).setxPoints(((Triangle)temp).getxPoints());
                    ((Triangle)temp2).setyPoints(((Triangle)temp).getyPoints());
                }
               // state.insertNew(temp2);
               originator.setState(temp2);
                state.add(originator.saveStateToMemento()); 
                und.push(state);
                
            
            
            
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }








    @Override
    public void save(String path) {
    }

    @Override
    public void load(String path) {
    }

    
    
}
