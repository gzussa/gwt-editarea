package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EAToggleOnCallbackEvent extends GwtEvent<EAToggleOnCallbackHandler>{
	
	private String id;
	
	public static Type<EAToggleOnCallbackHandler> TYPE = new Type<EAToggleOnCallbackHandler>();
	
	public EAToggleOnCallbackEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public Type<EAToggleOnCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EAToggleOnCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EAToggleOnCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

}
