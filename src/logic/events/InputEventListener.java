package logic.events;

import logic.DownData;
import logic.ViewData;


public interface InputEventListener {

   
  //  ViewData onDownEvent(MoveEvent event);

    DownData onDownEvent(MoveEvent event);

    //ViewData onLeftEvent();

    // ViewData onLeftEvent();

    //public ViewData onLeftEvent(MoveEvent event);

    public ViewData onLeftEvent();

    public ViewData onRightEvent();
     public ViewData onRotateEvent();
   
    
    
}

