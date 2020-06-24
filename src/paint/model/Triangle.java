/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ahmed Hatem
 */
public class Triangle extends MyShape{
   private double base,height;
   int[] xPoints,yPoints;
   private static Triangle triangle;
   
   private Triangle(){}

    public static Triangle getTriangle() {
        triangle = new Triangle();
        return triangle;
    }
   
   
   public void setProperties(java.util.Map<String, Double> properties)
    {
       base = properties.get("Base");
       height = properties.get("Height");

    }
            
            
public java.util.Map<String, Double> getProperties(){
    Map <String ,Double> properties = new HashMap <>();
        properties.put("Base", base);
        properties.put("Height", height);
    return properties;
    
}



public void draw(Object canvas){
Graphics2D g = (Graphics2D)canvas;
    g.setStroke(new BasicStroke(3));
if(!filled){
        g.setColor(color);
 g.drawPolygon(xPoints, yPoints, 3);

}else{
        g.setColor(fillColor);
    g.fillPolygon(xPoints, yPoints, 3);
}
}
 
public Object clone() throws CloneNotSupportedException{
MyShape s = new Triangle();
s.setPosition(position);
s.setColor(color);
s.setFillColor(fillColor);
((Triangle)s).setxPoints(xPoints);
((Triangle)s).setyPoints(yPoints);
((MyShape)s).setFilled(filled);


return s;
}

    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public void setxPoints(int[] xPoints) {
        this.xPoints = xPoints;
    }

    public void setyPoints(int[] yPoints) {
        this.yPoints = yPoints;
    }

    public int[] getxPoints() {
        return xPoints;
    }

    public int[] getyPoints() {
        return yPoints;
    }

    
}
