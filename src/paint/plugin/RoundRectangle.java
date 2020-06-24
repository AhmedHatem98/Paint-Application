package paint.plugin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import paint.model.Shape;

/**
 *
 * @author Plugin
 */
public class RoundRectangle {

    protected Point p;
    protected Map<String, Double> prop;
    protected Color c;
    protected Color fc;

    public RoundRectangle() {
        prop = new HashMap<>();
        prop.put("Width", 0.0);
        prop.put("Length", 0.0);
        prop.put("ArcWidth", 0.0);
        prop.put("ArcLength", 0.0);
    }

    public void setPosition(Point position) {
        p = position;
    }

    public Point getPosition() {
        return p;
    }

    public void setProperties(Map<String, Double> properties) {
        prop = properties;
    }

    public Map<String, Double> getProperties() {
        return prop;
    }

    public void setColor(Color color) {
        c = color;
    }

    public Color getColor() {
        return c;
    }

    public void setFillColor(Color color) {
        fc = color;
    }

    public Color getFillColor() {
        return fc;
    }

    public void draw(Object canvas) {
        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).fillRoundRect((int) p.getX(),
                (int) p.getY(),
                (int) prop.get("Width").intValue(),
                (int) prop.get("Length").intValue(), 
                (int) prop.get("ArcWidth").intValue(), 
                (int) prop.get("ArcLength").intValue());

        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawRoundRect((int) p.getX(),
                (int) p.getY(),
                (int) prop.get("Width").intValue(),
                (int) prop.get("Length").intValue(), 
                (int) prop.get("ArcWidth").intValue(), 
                (int) prop.get("ArcLength").intValue());
    }

    public Object clone() throws CloneNotSupportedException {
        Shape r = (Shape) new RoundRectangle();
        r.setColor(c);
        r.setFillColor(fc);
        r.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s: prop.entrySet())
            newprop.put(s.getKey(), s.getValue());
        r.setProperties(newprop);
        return r;
    }
}
