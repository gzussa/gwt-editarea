package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EAUnloadCallbackEvent extends GwtEvent<EAUnloadCallbackHandler>{
	
	private String id;
	
	public static Type<EAUnloadCallbackHandler> TYPE = new Type<EAUnloadCallbackHandler>();
	
	public EAUnloadCallbackEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public Type<EAUnloadCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EAUnloadCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EAUnloadCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

}
