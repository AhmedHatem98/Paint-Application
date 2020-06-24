
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
import static java.lang.Math.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ahmed Hatem
 */
public class Line extends MyShape{
    private double length;
    private int x2,y2;
    private static Line line;
    private Line(){
    
    }

    public static Line getLine() {
        line = new Line();
        return line;
    }

    public double getLength() {
        return length;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    
    @Override
    public void setProperties(Map<String, Double> properties) {
    length = properties.get("Length");
    
    }

    @Override
    public Map<String, Double> getProperties() {
    Map <String ,Double> properties = new HashMap <>();
    properties.put("Length", length);
    return properties;
    
    }

    @Override
    public void draw(Object canvas) {
       Graphics2D g = (Graphics2D)canvas;
    g.setStroke(new BasicStroke(3));
    g.setColor(color);
        g.drawLine(position.x, position.y, getX2(), getY2());
    
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
    Shape s = new Line();
    s.setPosition(position);
s.setColor(color);
    ((Line)s).setX2(getX2());
    ((Line)s).setY2(getY2());
        ((Line)s).setLength(length);

    return s;
    }
    
}
