/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static paint.controller.Control.state;
import paint.model.Circle;
import paint.model.Ellipse;
import paint.model.Line;
import paint.model.MyShape;
import paint.model.Rect;
import paint.model.Square;
import paint.model.Triangle;

/**
 *
 * @author Ahmed Hatem
 */
public class FDrawAction extends FActions{
private static FDrawAction draw;
private FDrawAction(){

}

    public static FDrawAction getDraw() {
        draw = new FDrawAction();
        return draw;
    }
    
    
    
    
    public void draw(Point p1, Point p2) {
        Point p = new Point();
       state = new MementoCareTaker();
        state.setAction("draw");
        if (choice == 1) {
            p.x = Math.min(p1.x, p2.x);
            p.y = Math.min(p1.y, p2.y);
            
            s.setPosition(p);
            s.setColor(color);
            s.setFillColor(color);
            ((MyShape) s).setFilled(filled);
            ((Rect) s).setLength(Math.abs(p1.x - p2.x));
            ((Rect) s).setWidth(Math.abs(p1.y - p2.y));
        } else if (choice == 2) {
            p.x = Math.min(p1.x, p2.x);
            p.y = Math.min(p1.y, p2.y);
            s.setPosition(p);
            ((MyShape) s).setFilled(filled);

            s.setColor(color);
            s.setFillColor(color);
            ((Circle) s).setDiameter(Math.abs(p1.x - p2.x));

        } else if (choice == 3) {
            p.x = p1.x;
            p.y = p1.y;
            s.setPosition(p);
            ((MyShape) s).setFilled(filled);

            s.setColor(color);
            s.setFillColor(color);
            ((Line) s).setX2(p2.x);
            ((Line) s).setY2(p2.y);
            ((Line) s).setLength(sqrt(pow((abs(p2.y - p1.y)), 2) + pow((abs(p2.x - p1.x)), 2)));

        } else if (choice == 4) {
            p.x = Math.min(p1.x, p2.x);
            p.y = Math.min(p1.y, p2.y);
            s.setPosition(p);
            ((MyShape) s).setFilled(filled);

            s.setFillColor(color);
            s.setColor(color);
            ((Square) s).setSideLength(Math.abs(p1.x - p2.x));

        } else if (choice == 5) {
            s.setColor(color);
            s.setFillColor(color);
            p = new Point();
            p.x =p1.x;
            p.y = p1.y;
            s.setPosition(p);
            int base = p2.x - p.x;
            int height = p2.y - p.y;
            int[] xPoints = {(p.x + base / 2), p.x,
                p2.x};
            int[] yPoints = {p.y, (p.y + height),
                p2.y};
            ((MyShape) s).setFilled(filled);

            ((Triangle) s).setBase((double) base);
            ((Triangle) s).setBase((double) height);
            ((Triangle) s).setxPoints(xPoints);
            ((Triangle) s).setyPoints(yPoints);

        } else if (choice == 6) {
            p.x = Math.min(p1.x, p2.x);
            p.y = Math.min(p1.y, p2.y);
            s.setPosition(p);
            ((MyShape) s).setFilled(filled);

            s.setColor(color);
            s.setFillColor(color);
            ((Ellipse) s).setBase(Math.abs(p1.x - p2.x));
            ((Ellipse) s).setHeight(Math.abs(p1.y - p2.y));

        }
        shapes.add(s);

    }

    
}
