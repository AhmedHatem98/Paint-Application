/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

/**
 *
 * @author Ahmed Hatem
 */
public class StrategyContext {
     private DrawingEngine strategy;

   public StrategyContext(DrawingEngine strategy){
      this.strategy = strategy;
   }

   public void save(String path){
      strategy.save(path);
}
  public void load(String path){
      strategy.load(path);
}  
}