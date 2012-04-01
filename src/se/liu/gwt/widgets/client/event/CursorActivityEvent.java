package se.liu.gwt.widgets.client.event;

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

	

	
	
	 
}
