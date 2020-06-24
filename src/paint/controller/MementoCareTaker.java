/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.util.ArrayList;
import paint.model.Shape;

/**
 *
 * @author Ahmed Hatem
 */
public class MementoCareTaker {
    private final  ArrayList <Memento> mementoList = new ArrayList <Memento>();
    private String action;
   public void add(Memento state){
      mementoList.add(state);
      
   }

   public Shape get(int index){
       System.out.println(mementoList.size());
      return mementoList.get(index).getState();
   
   }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
