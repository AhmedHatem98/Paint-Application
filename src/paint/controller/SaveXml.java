/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import paint.model.Circle;
import paint.model.Ellipse;
import paint.model.Line;
import paint.model.MyShape;
import paint.model.Rect;
import paint.model.Shape;
import paint.model.Square;
import paint.model.Triangle;
import paint.view.Menu;

/**
 *
 * @author Ahmed Hatem
 */
public class SaveXml extends Control {
    public SaveXml(){


}
    
    public void save(String path) {
        
        try{
            
        DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();

        Element rootElement = doc.createElement("shapes");
        doc.appendChild(rootElement);

        for (int i = 0; i < old.size(); i++) {
            if ((old.get(i)) instanceof Rect) {
                Element rectangle = doc.createElement("rectangle");
                rootElement.appendChild(rectangle);

                // xpoint elements
                Element x = doc.createElement("x");
                x.appendChild(doc.createTextNode(""
                        + (old.get(i)).getPosition().x));
                rectangle.appendChild(x);

                // ypoint elements
                Element y = doc.createElement("y");
                y.appendChild(doc.createTextNode(""
                        + (old.get(i)).getPosition().y));
                rectangle.appendChild(y);

                // Width elements
                Element wr = doc.createElement("length");
                wr.appendChild(doc.createTextNode(""
                        + ((Rect) old.get(i)).getLength()));
                rectangle.appendChild(wr);

                // hight elements
                Element hr = doc.createElement("width");
                hr.appendChild(doc.createTextNode(""
                        + ((Rect) old.get(i)).getWidth()));
                rectangle.appendChild(hr);

                // color elements
                Element color = doc.createElement("color");
                color.appendChild(doc.createTextNode(Integer
                        .toString((old.get(i)).getColor()
                                .getRGB())));
                rectangle.appendChild(color);

                // filled elements
                Element filled = doc.createElement("filled");
                filled.appendChild(doc.createTextNode(""
                        + ((MyShape) old.get(i)).getFilled()));
                rectangle.appendChild(filled);

            } else if ((old.get(i)) instanceof Square) {
                Element square = doc.createElement("square");
                rootElement.appendChild(square);

                // xpoint elements
                Element xpos = doc.createElement("x");
                xpos.appendChild(doc.createTextNode(""
                        + (old.get(i)).getPosition().x));
                square.appendChild(xpos);

                // ypoint elements
                Element ypos = doc.createElement("y");
                ypos.appendChild(doc.createTextNode(""
                        + (old.get(i)).getPosition().y));
                square.appendChild(ypos);

                // Width elements
                Element l = doc.createElement("sideLength");
                l.appendChild(doc.createTextNode(""
                        + ((Square) old.get(i)).getSideLength()));
                square.appendChild(l);

                // color elements
                Element color = doc.createElement("color");
                color.appendChild(doc.createTextNode(Integer
                        .toString((old.get(i)).getColor().getRGB())));
                square.appendChild(color);

                // filled elements
                Element filled = doc.createElement("filled");
                filled.appendChild(doc.createTextNode(""
                        + ((MyShape) old.get(i)).getFilled()));
                square.appendChild(filled);

            } else if ((old.get(i)) instanceof Ellipse) {

                Element Ellipse = doc.createElement("ellipse");
                rootElement.appendChild(Ellipse);

                // xpoint elements
                Element xc = doc.createElement("x");
                xc.appendChild(doc.createTextNode(""
                        + ((Ellipse) old.get(i)).getPosition().x));
                Ellipse.appendChild(xc);

                // ypoint elements
                Element yc = doc.createElement("y");
                yc.appendChild(doc.createTextNode(""
                        + ((Ellipse) old.get(i)).getPosition().y));
                Ellipse.appendChild(yc);

                // Width elements
                Element wc = doc.createElement("base");
                wc.appendChild(doc.createTextNode(""
                        + ((Ellipse) old.get(i)).getBase()));
                Ellipse.appendChild(wc);

                // hight elements
                Element hc = doc.createElement("height");
                hc.appendChild(doc.createTextNode(""
                        + ((Ellipse) old.get(i)).getHeight()));
                Ellipse.appendChild(hc);

                // color elements
                Element ccolor = doc.createElement("color");
                ccolor.appendChild(doc.createTextNode(Integer
                        .toString(( old.get(i)).getColor().getRGB())));
                Ellipse.appendChild(ccolor);

                // filled elements
                Element cfilled = doc.createElement("filled");
                cfilled.appendChild(doc.createTextNode(""
                        + ((MyShape) old.get(i)).getFilled()));
                Ellipse.appendChild(cfilled);

            } else if (( old.get(i)) instanceof Circle) {

                Element circle = doc.createElement("circle");
                rootElement.appendChild(circle);

                // xpoint elements
                Element xc = doc.createElement("x");
                xc.appendChild(doc.createTextNode(""
                        + ((Circle) old.get(i)).getPosition().x));
                circle.appendChild(xc);

                // ypoint elements
                Element yc = doc.createElement("y");
                yc.appendChild(doc.createTextNode(""
                        + ((Circle) old.get(i)).getPosition().y));
                circle.appendChild(yc);

                // Width elements
                Element radius = doc.createElement("diameter");
                radius.appendChild(doc.createTextNode(""
                        + ((Circle) old.get(i)).getDiameter()));
                circle.appendChild(radius);

                // color elements
                Element ccolor = doc.createElement("color");
                ccolor.appendChild(doc.createTextNode(Integer
                        .toString(( old.get(i)).getColor().getRGB())));
                circle.appendChild(ccolor);

                // filled elements
                Element cfilled = doc.createElement("filled");
                cfilled.appendChild(doc.createTextNode(""
                        + ((MyShape) old.get(i)).getFilled()));
                circle.appendChild(cfilled);

            } else if (((Shape) old.get(i)) instanceof Line) {

                Element line = doc.createElement("line");
                rootElement.appendChild(line);

                // xpoint elements
                Element x1 = doc.createElement("x1");
                x1.appendChild(doc.createTextNode(""
                        + ((Line) old.get(i)).getPosition().x));
                line.appendChild(x1);

                Element x2 = doc.createElement("x2");
                x2.appendChild(doc.createTextNode(""
                        + ((Line) old.get(i)).getX2()));
                line.appendChild(x2);

                Element y1 = doc.createElement("y1");
                y1.appendChild(doc.createTextNode(""
                        + ((Line) old.get(i)).getPosition().y));
                line.appendChild(y1);

                Element y2 = doc.createElement("y2");
                y2.appendChild(doc.createTextNode(""
                        + ((Line) old.get(i)).getY2()));
                line.appendChild(y2);

                // color elements
                Element lcolor = doc.createElement("color");
                lcolor.appendChild(doc.createTextNode(Integer
                        .toString(((Line) old.get(i)).getColor().getRGB())));
                line.appendChild(lcolor);

                // filled elements
                Element lfilled = doc.createElement("filled");
                lfilled.appendChild(doc.createTextNode(""
                        + ((MyShape) old.get(i)).getFilled()));
                line.appendChild(lfilled);

            } else if (((Shape) old.get(i)) instanceof Triangle) {

                Element triangle = doc.createElement("triangle");
                rootElement.appendChild(triangle);

                Element x = doc.createElement("x");
                x.appendChild(doc.createTextNode(""
                        + ((Triangle) old.get(i)).getPosition().x));
                triangle.appendChild(x);

                Element y = doc.createElement("y");
                y.appendChild(doc.createTextNode(""
                        + ((Triangle) old.get(i)).getPosition().y));
                triangle.appendChild(y);

                Element xpoints = doc.createElement("xpoints");
                String temp = "" + ((Triangle) old.get(i)).getxPoints()[0]
                        + "," + ((Triangle) old.get(i)).getxPoints()[1]
                        + "," + ((Triangle) old.get(i)).getxPoints()[2];
                xpoints.appendChild(doc.createTextNode(temp));
                triangle.appendChild(xpoints);

                String temp2 = "" + ((Triangle) old.get(i)).getyPoints()[0]
                        + "," + ((Triangle) old.get(i)).getyPoints()[1]
                        + "," + ((Triangle) old.get(i)).getyPoints()[2];
                Element ypoints = doc.createElement("ypoints");
                ypoints.appendChild(doc.createTextNode(temp2));
                triangle.appendChild(ypoints);

                Element tcolor = doc.createElement("color");
                tcolor.appendChild(doc.createTextNode(Integer
                        .toString(((Triangle) old.get(i)).getColor()
                                .getRGB())));
                triangle.appendChild(tcolor);

                // filled elements
                Element tfilled = doc.createElement("filled");
                tfilled.appendChild(doc.createTextNode(""
                        + ((Triangle) old.get(i)).getFilled()));
                triangle.appendChild(tfilled);

            }

        }

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(path + ".xml"));
        transformer.transform(source, result);
        }catch(Exception e){System.out.println(e);}
    }

    public void load(String path) {
        
        try{
        shapes.clear();
        old.clear();
        File Xml = new File(path);
        Point p;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(Xml);
        doc.getDocumentElement().normalize();
        Color co;
        NodeList tList = doc.getElementsByTagName("triangle");

        	for (int i = 0; i < tList.getLength(); i++) {

			Node tNode = tList.item(i);
			if (tNode != null) {
				if (tNode.getNodeType() == Node.ELEMENT_NODE) {
                                      p = new Point();
					Element eElement = (Element) tNode;
					s = Triangle.getTriangle();
                                          p.x = (Integer.parseInt(getTagValue("x", eElement)));
                                          p.y = (Integer.parseInt(getTagValue("y", eElement)));
					s.setPosition(p);
                                          
					((Triangle)s).setxPoints(convert((getTagValue("xpoints", eElement))));
					((Triangle)s).setyPoints(convert((getTagValue("ypoints", eElement))));

					co = new Color(Integer.parseInt(getTagValue("color",
							eElement)));
					s.setColor(co);
					String tempp = getTagValue("filled", eElement);
					if (tempp.charAt(0) == 'f') {
						((MyShape)s).setFilled(false);
					} else {
						((MyShape)s).setFilled(true);
					}
					shapes.add(s);
					old.add(s);

										
				}
			}
		}
        NodeList rList = doc.getElementsByTagName("rectangle");

        for (int i = 0; i < rList.getLength(); i++) {

            Node rNode = rList.item(i);
            if (rNode != null) {
                if (rNode.getNodeType() == Node.ELEMENT_NODE) {
                    p = new Point();
                    Element eElement = (Element) rNode;
                    s = Rect.getRectangle();
                    p.x = (Integer.parseInt(getTagValue("x", eElement)));
                    p.y = (Integer.parseInt(getTagValue("y", eElement)));
                    s.setPosition(p);
                    ((Rect) s).setLength(Double.parseDouble(getTagValue("length", eElement)));
                    ((Rect) s).setWidth(Double.parseDouble(getTagValue("width", eElement)));

                    co = new Color(Integer.parseInt(getTagValue("color",
                            eElement)));

                    s.setColor(co);
                    String tempp = getTagValue("filled", eElement);
                    if (tempp.charAt(0) == 'f') {
                        ((MyShape) s).setFilled(false);
                    } else {
                        ((MyShape) s).setFilled(true);
                    }

                    old.add(s);
                    shapes.add(s);
                    
                }
            }
        }
        NodeList sList = doc.getElementsByTagName("square");

        for (int i = 0; i < sList.getLength(); i++) {

            Node sNode = sList.item(i);
            if (sNode != null) {
                if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                    p = new Point();

                    Element eElement = (Element) sNode;

                    s = Square.getSquare();
                    p.x = (Integer.parseInt(getTagValue("x", eElement)));
                    p.y = (Integer.parseInt(getTagValue("y", eElement)));
                    s.setPosition(p);
                    ((Square) s).setSideLength(Double.parseDouble(getTagValue("sideLength", eElement)));

                    co = new Color(Integer.parseInt(getTagValue("color",
                            eElement)));

                    s.setColor(co);
                    String tempp = getTagValue("filled", eElement);
                    if (tempp.charAt(0) == 'f') {
                        ((MyShape) s).setFilled(false);
                    } else {
                        ((MyShape) s).setFilled(true);
                    }

                    old.add(s);
                    shapes.add(s);
                   
                }
            }
        }
        NodeList cList = doc.getElementsByTagName("ellipse");

        for (int i = 0; i < cList.getLength(); i++) {

            Node cNode = cList.item(i);

            if (cNode != null) {

                if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                    p = new Point();

                    Element eElement = (Element) cNode;
                    s = Ellipse.getEllipse();
                    p.x = (Integer.parseInt(getTagValue("x", eElement)));
                    p.y = (Integer.parseInt(getTagValue("y", eElement)));
                    s.setPosition(p);
                    ((Ellipse) s).setBase(Double.parseDouble(getTagValue("base", eElement)));
                    ((Ellipse) s).setHeight(Double.parseDouble(getTagValue("height", eElement)));
                    co = new Color(Integer.parseInt(getTagValue("color",
                            eElement)));
                    s.setColor(co);

                    String tempp = getTagValue("filled", eElement);
                    if (tempp.charAt(0) == 'f') {
                        ((MyShape) s).setFilled(false);
                    } else {
                        ((MyShape) s).setFilled(true);
                    }

                    old.add(s);
                    shapes.add(s);
                   
                }
            }
        }
        NodeList cirList = doc.getElementsByTagName("circle");

        for (int i = 0; i < cirList.getLength(); i++) {

            Node cirNode = cirList.item(i);

            if (cirNode != null) {

                if (cirNode.getNodeType() == Node.ELEMENT_NODE) {
                    p = new Point();

                    Element eElement = (Element) cirNode;
                    s = Circle.getCircle();
                    p.x = (Integer.parseInt(getTagValue("x", eElement)));
                    p.y = (Integer.parseInt(getTagValue("y", eElement)));
                    s.setPosition(p);
                    ((Circle) s).setDiameter(Double.parseDouble(getTagValue("diameter",
                            eElement)));
                    co = new Color(Integer.parseInt(getTagValue("color",
                            eElement)));
                    s.setColor(co);

                    String tempp = getTagValue("filled", eElement);
                    if (tempp.charAt(0) == 'f') {
                        ((MyShape) s).setFilled(false);
                    } else {
                        ((MyShape) s).setFilled(true);
                    }

                    old.add(s);
                    shapes.add(s);
                   
                }
            }
        }

        NodeList lList = doc.getElementsByTagName("line");

        for (int i = 0; i < lList.getLength(); i++) {

            Node lNode = lList.item(i);
            if (lNode != null) {
                if (lNode.getNodeType() == Node.ELEMENT_NODE) {
                    p = new Point();

                    Element eElement = (Element) lNode;
                    s = Line.getLine();
                    p.x = (Integer.parseInt(getTagValue("x1", eElement)));
                    p.y = (Integer.parseInt(getTagValue("y1", eElement)));
                    ((Line) s).setX2(Integer.parseInt(getTagValue("x2", eElement)));

                    ((Line) s).setY2(Integer.parseInt(getTagValue("y2", eElement)));
                    co = new Color(Integer.parseInt(getTagValue("color",
                            eElement)));
                    s.setColor(co);

                    String tempp = getTagValue("filled", eElement);
                    if (tempp.charAt(0) == 'f') {
                        ((MyShape) s).setFilled(false);
                    } else {
                        ((MyShape) s).setFilled(true);
                    }
                    old.add(s);
                    shapes.add(s);
                   
                }
            }
        }}catch(Exception e){System.out.println(e);}
    }

    private int[] convert(String a) {

        String[] s = a.split(",");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        return array;
    }

    // method return the value of the taag
    private String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
                .getChildNodes();

        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();

    }

    
    
    

    
}
