/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ahmed Hatem
 */
public class Rect extends MyShape{
    private double length,width;
    private static Rect rectangle;
    
    private Rect() {
        
    }

    public static Rect getRectangle() {
       rectangle = new Rect();
        return rectangle;
    }

    
    

    
   
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
 
    
 

        public void setProperties(java.util.Map<String, Double> properties)
    {
       length = properties.get("Length");
       width = properties.get("Width");
    }
            
            
public java.util.Map<String, Double> getProperties(){
    Map <String ,Double> properties = new HashMap <>();
    properties.put("Length", length);
    properties.put("Width" , width);
    return properties;
    
}



public void draw(Object canvas){
Graphics2D g = (Graphics2D)canvas;
    g.setStroke(new BasicStroke(3));
   
if(!filled){
   g.setColor(color);
    g.drawRect(position.x, position.y, (int)length,(int)width);
 
}else{
      g.setColor(getFillColor());
    g.fillRect(position.x, position.y, (int)length,(int)width);
}
}

public Object clone() throws CloneNotSupportedException{
Shape s = new Rect();
s.setPosition(position);
s.setColor(color);
s.setColor(fillColor);
((Rect)s).setLength(length);
((Rect)s).setWidth(width);
((MyShape)s).setFilled(filled);

return s;
}

    
}
