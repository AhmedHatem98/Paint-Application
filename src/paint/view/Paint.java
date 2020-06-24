/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Ahmed Hatem
 */
public class Paint extends JFrame{
    public Menu menuBar;
    public DrawPanel drawPanel;
    
    public ButtonsPanel tools;
    public Paint(){
        setSize(1024,786);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        menuBar = Menu.getObj();
        drawPanel = new DrawPanel();
        
        tools = new ButtonsPanel();
       
        add(menuBar,BorderLayout.NORTH);
add(new JScrollPane(drawPanel),  BorderLayout.CENTER);        
        add(tools,BorderLayout.EAST);
        setVisible(true);
    
    
    }
    
}
