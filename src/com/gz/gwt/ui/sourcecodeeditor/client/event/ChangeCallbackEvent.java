package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ChangeCallbackEvent extends GwtEvent<ChangeCallbackHandler>{
	
	private String id;
	
	public static Type<ChangeCallbackHandler> TYPE = new Type<ChangeCallbackHandler>();
	
	
	public ChangeCallbackEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public Type<ChangeCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<ChangeCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(ChangeCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}
}
