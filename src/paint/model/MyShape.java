/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;
import java.awt.*;
import java.util.*;
/**
 *
 * @author Ahmed Hatem
 */
public abstract class MyShape implements Shape {
    protected Point position ;
    protected Color color,fillColor;
    protected Point fPoint,sPoint,cPoint;
     Boolean isDrawing = true;
     Boolean filled;
    	protected String name;
protected int x,y;

    public Boolean getFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }
    
    public void setPosition(java.awt.Point position){
    this.position = position;
    }
public java.awt.Point getPosition(){
return position;

}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getFPoint() {
        return fPoint;
    }

    public void setFPoint(Point fPoint) {
        this.fPoint = fPoint;
    }

    public Point getSPoint() {
        return sPoint;
    }

    public void setSPoint(Point sPoint) {
        this.sPoint = sPoint;
    }

    public Point getCPoint() {
        return cPoint;
    }

    public void setCPoint(Point cPoint) {
        this.cPoint = cPoint;
    }
 public void setDrawing(Boolean isDrawing) {
        this.isDrawing = isDrawing;
    }
  public Boolean isDrawing() {
        return isDrawing;
    }
public void setColor(java.awt.Color color){
this.color = color;

}
public java.awt.Color getColor(){
return color;

}
public void setFillColor(java.awt.Color color){
fillColor=color;
}
public java.awt.Color getFillColor(){
    return fillColor;
}
    


public abstract void setProperties(java.util.Map<String, Double> properties);
public abstract java.util.Map<String, Double> getProperties();
public abstract void draw(Object canvas);
 
public abstract Object clone() throws CloneNotSupportedException;

}
