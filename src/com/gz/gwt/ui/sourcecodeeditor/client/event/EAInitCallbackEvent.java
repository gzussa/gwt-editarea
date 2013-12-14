package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EAInitCallbackEvent extends GwtEvent<EAInitCallbackHandler>{
	
	private String id;
	
	public static Type<EAInitCallbackHandler> TYPE = new Type<EAInitCallbackHandler>();
	
	public EAInitCallbackEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public Type<EAInitCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EAInitCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EAInitCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

}
