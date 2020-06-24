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
public class Ellipse extends MyShape{
    private double base,height;
    private static Ellipse ellipse;
    private Ellipse(){}

    public static Ellipse getEllipse() {
        ellipse = new Ellipse();
        return ellipse;
    }
    
    
    public void setProperties(java.util.Map<String, Double> properties)
    {
 base = properties.get("Base");
       height = properties.get("Height");    }

            
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
     g.setColor(getColor());
        g.drawOval(position.x,position.y,(int)base, (int)height);
       
    
    
    }else{
                g.setColor(getFillColor());

    g.fillOval(position.x,position.y,(int)base, (int)height);

    }
}
 
public Object clone() throws CloneNotSupportedException{
Shape s = new Ellipse();
s.setPosition(position);
s.setColor(color);
s.setFillColor(fillColor);
((Ellipse)s).setBase(base);
((Ellipse)s).setHeight(height);

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

    
}
