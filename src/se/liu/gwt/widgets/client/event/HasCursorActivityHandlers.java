package se.liu.gwt.widgets.client.event;


import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasCursorActivityHandlers extends HasHandlers {
	HandlerRegistration addCursorActivityHandler(CursorActivityHandler handler);
}
