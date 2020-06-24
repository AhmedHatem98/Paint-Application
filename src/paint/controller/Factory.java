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
public class Factory {
  
public FActions getAction(String choice){
if(choice.equalsIgnoreCase("draw"))
    return FDrawAction.getDraw();

else if(choice.equalsIgnoreCase("move"))
return FMoveAction.getMove();

else if(choice.equalsIgnoreCase("copy"))
    return FCopyAction.getCopy();

else if(choice.equalsIgnoreCase("delete"))
    return FDeleteAction.getDelete();

else if(choice.equalsIgnoreCase("color"))
    return FColorAction.getColors();

else if(choice.equalsIgnoreCase("resize"))
    return FResizeAction.getResize();

else 
    return null;

}
}