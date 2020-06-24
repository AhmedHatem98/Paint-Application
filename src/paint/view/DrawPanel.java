package paint.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import paint.controller.DrawingEngine;
import paint.controller.Factory;
import paint.controller.FActions;


public class DrawPanel extends JPanel implements MouseListener,MouseMotionListener {
       public Factory edit;
        DrawingEngine control;
        public FActions action ;
	Point start,fPoint;
	Color color;
		int flag;
	
	boolean isFilled;
	

	public DrawPanel() {
          
            start = new Point();
           fPoint = new Point();
           edit = new Factory();
           control = new FActions();
         action = edit.getAction("draw");
           
		setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1024, 768));
       	
		
		addMouseListener(this);
		addMouseMotionListener(this);
		

	}

	@Override
	public void mousePressed(MouseEvent ev) {
		try {  
			start.x = ev.getX();
			start.y = ev.getY();
                        
                        if(flag==1)
                            action.add("rectangle");
                        else if(flag==2)
                            action.add("circle");
                        else if(flag==3)
			action.add("line");
                        else if(flag == 4)
                            action.add("square");
                        else if(flag == 5)
                            action.add("triangle");
                        else if(flag==6)
                            action.add("ellipse");
                        else if (flag==7 || flag==9 || flag==11)
                        { 
                           action.select(ev);
                        }
                        else if(flag==8){
                            action.delete(ev);
                        repaint();
                        }
                         if(flag == 9){
                            action.copy(ev);
                            
                        }
                         if(flag==10){
                             action.color(ev);
                             System.out.println("works");
                             repaint();
                         }
    
		} catch (Exception eee) {
                    System.out.println(eee);
		}
	}

	@Override      
	public void mouseDragged(MouseEvent e) {
		try { 
                    
                     	if(flag == 7 || flag ==9){
                        
                            action.move(e);
                             
                        }
                        else if(flag==11){
                            action.resize(e);
                        }
                        else if(flag>0 && flag <7)
                        { fPoint.x = e.getX();
                        fPoint.y = e.getY();
                       action.draw(start, fPoint);}
                       
                    repaint();
                   		
                }catch(Exception ee){System.out.println(ee);}
        
        
        
        
        }
         @Override
    public void mouseReleased(MouseEvent e) {
   try{ 
    action.addAll();
 //   action.printAll();
    
         
             System.out.println("released");
   }catch(Exception c){System.out.println(c);} 
   }

	public void paintComponent(Graphics g) {
	         super.paintComponents(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 900, 900);
               control.refresh(g);

                      
                  }	                       

	
	

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

    @Override
    public void mouseClicked(MouseEvent me) {
   
    }

   
}
