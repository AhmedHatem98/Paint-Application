

package paint.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import java.awt.event.*;
import paint.model.*;

public class Buttons extends JButton implements ActionListener
{
  
    JLabel label;
    Shape shape;
Operation tool;
    public Buttons()
    {
        
        addActionListener(this);
        setVisible(false);
    }

    public Buttons(Icon icon,Operation tool)
    {
        label = new JLabel(icon);
        this.setLayout(new BorderLayout());
        add(label);
        this.tool = tool;
        addActionListener(this);
        setBackground(Color.WHITE);
    }
    

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    @Override
   public void actionPerformed(ActionEvent event)
    {
       
        if(tool == Operation.RECTANGLE){
          Main.view.drawPanel.flag =1;  
         Main.view.drawPanel.action =  Main.view.drawPanel.edit.getAction("draw");
        }
        else if(tool ==Operation.CIRCLE){
          Main.view.drawPanel.flag =2;  
           Main.view.drawPanel.action =  Main.view.drawPanel.edit.getAction("draw"); 
        }
        else if(tool==Operation.LINE){
          Main.view.drawPanel.flag =3;
          Main.view.drawPanel.action =  Main.view.drawPanel.edit.getAction("draw");
        }
        else if(tool == Operation.SQUARE){
          Main.view.drawPanel.flag =4; 
           Main.view.drawPanel.action =  Main.view.drawPanel.edit.getAction("draw"); 
        }
        else if(tool == Operation.TRIANGLE){
          Main.view.drawPanel.flag =5; 
            Main.view.drawPanel.action =  Main.view.drawPanel.edit.getAction("draw");
        }
          
       else if(tool == Operation.ELLIPSE){
         Main.view.drawPanel.flag =6;  
          Main.view.drawPanel.action =  Main.view.drawPanel.edit.getAction("draw"); 
       }
        else if(tool ==Operation.COLOR)
            Main.view.drawPanel.action.color = JColorChooser.showDialog( Main.view.drawPanel , "Choose a color",
						 Main.view.drawPanel.action.color );

        System.out.println("Your Tool has been changed to "+this.tool);
    }
}
