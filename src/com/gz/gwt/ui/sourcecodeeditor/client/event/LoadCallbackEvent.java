package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class LoadCallbackEvent extends GwtEvent<LoadCallbackHandler>{
	
	private String id;
	
	public static Type<LoadCallbackHandler> TYPE = new Type<LoadCallbackHandler>();
	
	public LoadCallbackEvent(String id){
		super();
		this.id = id;
	}
	
	@Override
	public Type<LoadCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<LoadCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(LoadCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

}
