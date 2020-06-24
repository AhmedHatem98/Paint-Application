/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import paint.model.Shape;

/**
 *
 * @author Ahmed Hatem
 */
public  class Control implements DrawingEngine{
protected  static ArrayList<Shape> shapes = new ArrayList<>();
 protected  static ArrayList<Shape> old = new ArrayList<>();
protected Shape s;
    protected static Stack<MementoCareTaker> und = new Stack<>();
    protected static Stack<MementoCareTaker> red= new Stack<>();
   protected static MementoCareTaker state = new MementoCareTaker();
   protected  MementoOriginator originator = new MementoOriginator();
    Boolean filled;
    public Color color;
public Control(){
 

}
   



public void refresh(Object canvas) {
    Graphics g = ((Graphics)canvas);
       if(shapes.size()!=  0){
        for (int i = 0; i < shapes.size(); i++) {
             //g.setColor(color);
            shapes.get(i).draw(g);

        }}

    }

public void addShape(Shape shape){
old.add(shape);
shapes.add(shape);

}
public Shape[] getShapes(){
    return (Shape[]) old.toArray();
}
public void removeShape(Shape shape) {

        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i).toString().equals(shape.toString())) {
                shapes.remove(i);
            }
        }
        for (int i = 0; i < old.size(); i++) {
            if (old.get(i).toString().equals(shape.toString())) {
                old.remove(i);
            }
        }
    }
public void updateShape(Shape oldShape, Shape newShape){}

public void undo(){}
public void redo(){}

public  void save(String path){}
public  void load(String path){}

// *************** bonus functions ****************
/* return the classes (types) of supported shapes already exist and the
* ones that can be dynamically loaded at runtime (see Part 4) */



//public java.util.List<Class<? extends Shape>> getSupportedShapes(){}
/* add to the supported shapes the new shape class (see Part 4) */
public void installPluginShape(String jarPath){}
    
}
