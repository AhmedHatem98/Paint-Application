/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import paint.model.Shape;

/**
 *
 * @author Ahmed Hatem
 */
public class Memento {
     private Shape state;

   public Memento(Shape state){
      this.state = state;
   }

   public Shape getState(){
      return state;
}


}
