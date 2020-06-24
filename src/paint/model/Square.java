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
public class Square extends MyShape{
    private double sideLength;
    private static Square square;
    
    private Square(){}

    public static Square getSquare() {
        square = new Square();
        return square;
    }
    
    
public void setProperties(java.util.Map<String, Double> properties)
    {
       sideLength = properties.get("SideLength");
    }
            
            
public java.util.Map<String, Double> getProperties(){
    Map <String ,Double> properties = new HashMap <>();
    properties.put("SideLength", sideLength);
    return properties;
    
}

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }



public void draw(Object canvas){
Graphics2D g = (Graphics2D)canvas;
    g.setStroke(new BasicStroke(3));


    if(!filled){
            g.setColor(color);

g.drawRect(position.x,position.y, (int)sideLength,(int)sideLength);

    }else{
    g.setColor(fillColor);

        g.fillRect(position.x,position.y, (int)sideLength,(int)sideLength);

}}
 
public Object clone() throws CloneNotSupportedException{

Shape s = new Square();
s.setPosition(position);
s.setColor(color);
s.setFillColor(fillColor);
((Square)s).setSideLength(sideLength);

((MyShape)s).setFilled(filled);

return s;
}

        
}
