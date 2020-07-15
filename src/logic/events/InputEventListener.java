package logic.events;

import logic.DownData;
import logic.ViewData;


public interface InputEventListener {

   
 

    public DownData onDownEvent(MoveEvent event);

   
    public ViewData onRightEvent();
    public ViewData onLeftEvent();
    
    
    public ViewData onRotateEvent();
    
    
}

