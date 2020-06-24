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
import java.util.*;

/**
 *
 * @author Ahmed Hatem
 */
public class Circle extends MyShape {
    private double diameter;
    private static Circle circle;
    
     private Circle() {
      
    }

    public static Circle getCircle() {
        circle = new Circle();
        return circle;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

   

   
    
    
    
    public void setProperties(java.util.Map<String, Double> properties)
    {
       diameter = properties.get("Diameter");
    }
            
            
public java.util.Map<String, Double> getProperties(){
    Map <String ,Double> properties = new HashMap <>();
    properties.put("Diameter", diameter);
    return properties;
    
}


public void draw(Object canvas){
    Graphics2D g = (Graphics2D)canvas;
    
        
g.setStroke(new BasicStroke(3));
if(!filled) 
{    
    g.setColor(getColor());
  g.drawOval(position.x, position.y, (int)diameter,(int)diameter);
  
}
else{
g.setColor(getFillColor());
    g.fillOval(position.x, position.y, (int)diameter,(int)diameter);

}
}
 
public Object clone() throws CloneNotSupportedException{
Shape s = new Circle();
s.setPosition(position);
s.setColor(color);
s.setFillColor(color);
((MyShape)s).setFilled(filled);
((Circle)s).setDiameter(diameter);

return s;
}

    
}
