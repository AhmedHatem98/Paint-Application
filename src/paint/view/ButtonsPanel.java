/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import paint.view.Buttons;

public class ButtonsPanel extends JPanel 
{
    protected Buttons[] buttons;
    JRadioButton filled,border;
    
    public ButtonsPanel()
    {
        setBackground   (Color.DARK_GRAY);
        setPreferredSize(new Dimension   (192,0));
        setLayout       (new BorderLayout( 8,   8 ));
        
        JPanel toolPanel =  new JPanel();
        toolPanel.setLayout(new GridLayout(5,2));
        toolPanel.setBackground(Color.darkGray );
        toolPanel.setPreferredSize(new Dimension(292,350));
        
       filled = new JRadioButton("filled");
		filled.setBounds(0, 600, 60, 20);
		border = new JRadioButton("Hollow");
		border.setBounds(0, 640, 70, 20);
        buttons = new Buttons[8];

      
        Icon square      = new ImageIcon(getClass().getResource("square.png"));
        Icon triangle      = new ImageIcon(getClass().getResource("triangle.png"));
        Icon rectangle   = new ImageIcon(getClass().getResource("rectangle.png"));
        Icon circle       = new ImageIcon(getClass().getResource("circle.png"));
        Icon ellipse = new ImageIcon(getClass().getResource("oval.png"));
        
        Icon color     = new ImageIcon(getClass().getResource("changeColor.jpg"));
        Icon lineTool    = new ImageIcon(getClass().getResource("line-tool.png"));
        
        buttons[0] = new Buttons(square,Operation.SQUARE);
        buttons[1] = new Buttons(triangle,Operation.TRIANGLE);
        buttons[2] = new Buttons(rectangle,Operation.RECTANGLE);
        buttons[3] = new Buttons(circle,Operation.CIRCLE);
        buttons[5] = new Buttons(lineTool,Operation.LINE);
        buttons[4] = new Buttons(color,Operation.COLOR);
        buttons[6] = new Buttons(ellipse, Operation.ELLIPSE);
        buttons[7] = new Buttons();

        for(int i=0; i<buttons.length; i++)
        {
            toolPanel.add(buttons[i]);
        }
 
filled.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			border.setSelected(false);
                        Main.view.drawPanel.action.filled= true;
				}
			
		});       
border.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			filled.setSelected(false);
                        Main.view.drawPanel.action.filled = false;
				}
			
		});       
        toolPanel.add(filled);
        toolPanel.add(border);
        add(toolPanel, BorderLayout.NORTH);
       
    }

   
    
    }
