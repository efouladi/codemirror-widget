package se.liu.gwt.widgets.client.event;

import se.liu.gwt.widgets.client.CodeMirror2;
import se.liu.gwt.widgets.client.Cursor;

import com.google.gwt.event.shared.GwtEvent;

public class CursorActivityEvent extends GwtEvent<CursorActivityHandler>
	{
	public static Type<CursorActivityHandler> TYPE = 
			new Type<CursorActivityHandler>();

	@Override
	public Type<CursorActivityHandler> getAssociatedType() {
		
		return TYPE;
	}

	@Override
	protected void dispatch(CursorActivityHandler handler) {
		handler.onCursorActivity(this);
	}
	public Cursor getCursorPos(){
		CodeMirror2 c = (CodeMirror2)this.getSource();
		return c.getCursor();
		
	}
	
	
	
	
	
	
	
	
	

	
	
	 
}
