/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFileChooser;
import paint.controller.CommandEdit;
import paint.controller.CommandRedo;
import paint.controller.CommandUndo;
import paint.controller.StrategyContext;
import paint.controller.Control;
import paint.controller.FMoveAction;
import paint.controller.SaveJson;
import paint.controller.SaveXml;
/**
 *
 * @author Ahmed Hatem
 */
public class Menu extends JMenuBar{
    JMenu file;
    JMenu edit;
    JMenu options; 
    JMenu help;
    JMenuItem newFile;
    JMenu load;
    JMenuItem loadXml;
    JMenuItem loadJson;
    JMenu save;
    JMenuItem saveXml;
    JMenuItem saveJson;
    JMenuItem exit;
     JMenuItem move;
    JMenuItem resize;
    JMenuItem delete;
    JMenuItem copy;
    JMenuItem color;
    JMenuItem undo;
    JMenuItem redo;
    JFileChooser SLfile;
    StrategyContext context;
    public static String url;
    private static Menu obj = new Menu();
    // singeleton dp;
    private Menu(){
        url = "";
       ItemHandler action = new ItemHandler();
        file = new JMenu("File");
        newFile= new JMenuItem("New");
        load = new JMenu("Load");
        loadXml = new JMenuItem("XML File");
        loadJson = new JMenuItem("JSON File");

        save = new JMenu("Save as");
        saveXml = new JMenuItem("XML File");
        saveJson = new JMenuItem("JSON File");
        exit = new JMenuItem("Exit");
        newFile.addActionListener(action);
        loadXml.addActionListener(action);
        loadJson.addActionListener(action);

        save.add(saveXml);
        save.add(saveJson);
        load.add(loadXml);
        load.add(loadJson);
        saveXml.addActionListener(action);
        saveJson.addActionListener(action);
        exit.addActionListener(action);
            
        edit = new JMenu("Edit");
        move= new JMenuItem("Move");
        resize = new JMenuItem("Resize");
        delete = new JMenuItem("Delete");
        copy = new JMenuItem("Copy");
        color = new JMenuItem("Color");
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
        move.addActionListener(action);
        resize.addActionListener(action);
        delete.addActionListener(action);
        copy.addActionListener(action);
        color.addActionListener(action);
        undo.addActionListener(action);
        redo.addActionListener(action);
        options = new JMenu("Options");
        help = new JMenu("Help");
        
        file.add(newFile);
        file.add(load);
        file.add(save);
        file.add(exit);
 
        edit.add(move);
        edit.add(resize);
        edit.add(copy);
        edit.add(delete);
        edit.add(color);
        edit.add(undo);
        edit.add(redo);
        add(file);
        add(edit);
        add(options);
        add(help);
        
    
    
    
    }

    public static Menu getObj() {
        return obj;
    }
   
    

private class ItemHandler implements ActionListener{
@Override
public void actionPerformed(ActionEvent e){
    if(e.getSource()== move){
        Main.view.drawPanel.flag=7;
     Main.view.drawPanel.action = Main.view.drawPanel.edit.getAction("move");
    }
    else if(e.getSource()==delete){
        Main.view.drawPanel.flag=8;
      Main.view.drawPanel.action = Main.view.drawPanel.edit.getAction("delete");
    }
    else if(e.getSource() == copy){
        Main.view.drawPanel.flag=9;
       Main.view.drawPanel.action = Main.view.drawPanel.edit.getAction("copy");   
    }
    else if(e.getSource() == color){
        Main.view.drawPanel.flag=10;
     Main.view.drawPanel.action = Main.view.drawPanel.edit.getAction("color");
    }
    else if(e.getSource() == resize){
        Main.view.drawPanel.flag =11;
       Main.view.drawPanel.action = Main.view.drawPanel.edit.getAction("resize");   
    }
    else if (e.getSource() == undo){
        CommandEdit com = new CommandEdit();
        CommandUndo und = new CommandUndo(com);
        
        und.execute();
       Main.view.drawPanel.repaint();
    
    
    
    }
    else if(e.getSource() == redo){
     CommandEdit com = new CommandEdit();
        CommandRedo red = new CommandRedo(com);
        
        red.execute();
       Main.view.drawPanel.repaint();
    
    }
        else if(e.getSource() == saveXml)
    {
    	int retval = 0;
				FileChooserSave(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
                                            context = new StrategyContext(new SaveXml());
                                            context.save(url);                                                //System.out.println(paint.old.get(0).getColor());
                                                System.out.println(url);
					} catch (Exception e1) {
                                            System.out.println(e1);
					}
				}
    
    }
        else if(e.getSource() == saveJson){
        int retval = 0;
				FileChooserSave(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
                                           context = new StrategyContext(new SaveJson());
                                            context.save(url);                                                System.out.println(url);
					
                                        } catch (Exception e1) {
                                            System.out.println(e1);
                                        }
					}
        
        
        
        }
    else if(e.getSource() == loadXml)
    {
    
int retval = 0;
				OpenFile(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
					    context = new StrategyContext(new SaveXml());
                                            context.load(url);
                                            Main.view.drawPanel.repaint();
					} catch (Exception e1) {
                                            System.out.println(e1);
					}    
    
    
    }}
      
    else if(e.getSource() ==  loadJson)
    {
    
int retval = 0;
				OpenFile(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
                                           context = new StrategyContext(new SaveJson());
                                            context.load(url);						
                                                Main.view.drawPanel.repaint();
					} catch (Exception e1) {
                                            System.out.println(e1);
					}    
    
    
    }


}}
private void OpenFile(int retval) {
		SLfile = new JFileChooser();
		retval = SLfile.showOpenDialog(null);
		SLfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		SLfile.setBackground(Color.white);
	}
private void FileChooserSave(int retval) {
		SLfile = new JFileChooser();
		retval = SLfile.showSaveDialog(null);
		SLfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		SLfile.setBackground(Color.white);
	}


}



}
