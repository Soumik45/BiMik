
package logic.events;

import logic.ViewData;


public interface InputEventListener {

   
  //  ViewData onDownEvent(MoveEvent event);

    public ViewData onDownEvent(MoveEvent event);

    //ViewData onLeftEvent();

    // ViewData onLeftEvent();

    //public ViewData onLeftEvent(MoveEvent event);

    public ViewData onLeftEvent();

    public ViewData onRightEvent();
    
    
}
