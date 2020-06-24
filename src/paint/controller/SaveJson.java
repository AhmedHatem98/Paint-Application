/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import static paint.controller.Control.old;
import paint.model.Circle;
import paint.model.Ellipse;
import paint.model.Line;
import paint.model.MyShape;
import paint.model.Rect;
import paint.model.Square;
import paint.model.Triangle;
import paint.view.Menu;

/**
 *
 * @author Ahmed Hatem
 */
public class SaveJson extends Control  {
   public SaveJson(){
   super();
   
   }
    
    
    public void save(String path) {
        try{
        JsonFactory jfactory = new JsonFactory();
        JsonGenerator jGenerator;

        File f = new File(path + ".json");
        jGenerator = jfactory.createJsonGenerator(f, JsonEncoding.UTF8);

        jGenerator.writeStartArray();

        for (int i = 0; i < old.size(); i++) {
            String d = "";
            jGenerator.writeStartObject();
            if (old.get(i) instanceof Rect) {
                d += (old.get(i)).getPosition().x + ","
                        + (old.get(i)).getPosition().y + ","
                        + ((Rect) old.get(i)).getLength() + ","
                        + ((Rect) old.get(i)).getWidth() + ","
                        + ((Rect) old.get(i)).getColor().getRGB() + ","
                        + (((Rect) old.get(i)).getFilled());
                jGenerator.writeStringField("rectangle", d);

            } else if (old.get(i) instanceof Square) {
                d += (old.get(i)).getPosition().x + ","
                        + (old.get(i)).getPosition().y + ","
                        + ((Square) old.get(i)).getSideLength() + ","
                        + ((Square) old.get(i)).getSideLength() + ","
                        + ((Square) old.get(i)).getColor().getRGB() + ","
                        + (((Square) old.get(i)).getFilled());
                jGenerator.writeStringField("square", d);

            } else if (old.get(i) instanceof Ellipse) {
                d += (old.get(i)).getPosition().x + ","
                        + (old.get(i)).getPosition().y + ","
                        + ((Ellipse) old.get(i)).getBase() + ","
                        + ((Ellipse) old.get(i)).getHeight() + ","
                        + ((Ellipse) old.get(i)).getColor().getRGB() + ","
                        + (((Ellipse) old.get(i)).getFilled());
                jGenerator.writeStringField("ellipse", d);

            } else if (old.get(i) instanceof Circle) {
                d += (old.get(i)).getPosition().x + ","
                        + (old.get(i)).getPosition().y + ","
                        + ((Circle) old.get(i)).getDiameter() + ","
                        + ((Circle) old.get(i)).getDiameter() + ","
                        + ((Circle) old.get(i)).getColor().getRGB() + ","
                        + (((Circle) old.get(i)).getFilled());
                jGenerator.writeStringField("circle", d);

            } else if (old.get(i) instanceof Line) {

                d += (old.get(i)).getPosition().x + ","
                        + (old.get(i)).getPosition().y + ","
                        + ((Line) old.get(i)).getX2() + ","
                        + ((Line) old.get(i)).getY2() + ","
                        + ((Line) old.get(i)).getColor().getRGB() + ","
                        + (((Line) old.get(i)).getFilled());
                jGenerator.writeStringField("line", d);

            } else if (old.get(i) instanceof Triangle) {
                String xpoint = ((Triangle) old.get(i)).getxPoints()[0] + ","
                        + ((Triangle) old.get(i)).getxPoints()[1] + ","
                        + ((Triangle) old.get(i)).getxPoints()[2];
                String ypoint = ((Triangle) old.get(i)).getyPoints()[0] + ","
                        + ((Triangle) old.get(i)).getyPoints()[1] + ","
                        + ((Triangle) old.get(i)).getyPoints()[2];
                d += ((Triangle) old.get(i)).getPosition().x + ","
                        + ((Triangle) old.get(i)).getPosition().y + "," + xpoint
                        + "," + ypoint + ","
                        + ((Triangle) old.get(i)).getColor().getRGB() + ","
                        + (((Triangle) old.get(i)).getFilled());
                jGenerator.writeStringField("triangle", d);

            }
            jGenerator.writeEndObject();

        }
        jGenerator.writeEndArray();

        jGenerator.close();

        }catch(Exception e){System.out.println(e);}
    }

    public void load(String path) {
        try{
        Point p;
        shapes.clear();
        old.clear();
       Color col;
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createJsonParser(new File(path));

        while (parser.nextToken() != JsonToken.END_ARRAY) {
            String type = parser.getCurrentName();
            if ("rectangle".equals(type) == true) {
                parser.nextToken();
                s = Rect.getRectangle();
                p = new Point();
                String[] temp = conv(parser.getText());
                p.x = Integer.parseInt(temp[0]);
                p.y = Integer.parseInt(temp[1]);
                s.setPosition(p);
                ((Rect) s).setLength(Double.parseDouble(temp[2]));
                ((Rect) s).setWidth((Double.parseDouble(temp[3])));
                s.setColor(new Color(Integer.parseInt(temp[4])));
                ((MyShape) s).setFilled(((Boolean.parseBoolean(temp[5]))));
               
                shapes.add(s);
                old.add(s);

            } else if ("square".equals(type) == true) {
                 parser.nextToken();
                s = Square.getSquare();
                p = new Point();
                String[] temp = conv(parser.getText());
                p.x = Integer.parseInt(temp[0]);
                p.y = Integer.parseInt(temp[1]);
                s.setPosition(p);
                ((Square) s).setSideLength(Double.parseDouble(temp[2]));
                ((Square) s).setSideLength((Double.parseDouble(temp[3])));
                s.setColor(new Color(Integer.parseInt(temp[4])));
                ((MyShape) s).setFilled(((Boolean.parseBoolean(temp[5]))));
                
                shapes.add(s);
                old.add(s);

            } else if ("ellipse".equals(type) == true) {
                parser.nextToken();
                s =  Ellipse.getEllipse();
                p = new Point();
                String[] temp = conv(parser.getText());
                p.x = Integer.parseInt(temp[0]);
                p.y = Integer.parseInt(temp[1]);
                s.setPosition(p);
                ((Ellipse) s).setBase(Double.parseDouble(temp[2]));
                ((Ellipse) s).setHeight((Double.parseDouble(temp[3])));
                s.setColor(new Color(Integer.parseInt(temp[4])));
                ((MyShape) s).setFilled(((Boolean.parseBoolean(temp[5]))));
                
                shapes.add(s);
                old.add(s);

            } else if ("circle".equals(type) == true) {
                 parser.nextToken();
                s =  Circle.getCircle();
                p = new Point();
                String[] temp = conv(parser.getText());
                p.x = Integer.parseInt(temp[0]);
                p.y = Integer.parseInt(temp[1]);
                s.setPosition(p);
                ((Circle) s).setDiameter(Double.parseDouble(temp[2]));
                ((Circle) s).setDiameter((Double.parseDouble(temp[3])));
                s.setColor(new Color(Integer.parseInt(temp[4])));
                ((MyShape) s).setFilled(((Boolean.parseBoolean(temp[5]))));
                
                shapes.add(s);
                old.add(s);
            } else if ("line".equals(type) == true) {
                  parser.nextToken();
                s = Line.getLine();
                p = new Point();
                String[] temp = conv(parser.getText());
                p.x = Integer.parseInt(temp[0]);
                p.y = Integer.parseInt(temp[1]);
                s.setPosition(p);
                ((Line) s).setX2(Integer.parseInt(temp[2]));
                ((Line) s).setY2((Integer.parseInt(temp[3])));
                s.setColor(new Color(Integer.parseInt(temp[4])));
                ((MyShape) s).setFilled(((Boolean.parseBoolean(temp[5]))));
                
                shapes.add(s);
                old.add(s);
            }
            else if ("triangle".equals(type) == true) {
				parser.nextToken();
				 s =Triangle.getTriangle();
				 p = new Point();
                String[] temp = conv(parser.getText());
                p.x = Integer.parseInt(temp[0]);
                p.y = Integer.parseInt(temp[1]);
                s.setPosition(p);
				
				((Triangle)s).setxPoints(new int[] { Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]) });
				((Triangle)s).setyPoints(new int[] { Integer.parseInt(temp[5]), Integer.parseInt(temp[6]),Integer.parseInt(temp[7])});
				s.setColor(new Color((Integer.parseInt(temp[8]))));

				((MyShape) s).setFilled(((Boolean.parseBoolean(temp[9]))));
				shapes.add(s);
				old.add(s);

				
				
			}

        }

    }catch(Exception e){System.out.println(e);}
    
    }

    
   
    private String[] conv(String a) {
        String[] s = a.split(",");
        return s;

    }

    
}
