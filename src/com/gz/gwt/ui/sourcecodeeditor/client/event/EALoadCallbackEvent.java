package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EALoadCallbackEvent extends GwtEvent<EALoadCallbackHandler>{
	
	private String id;
	
	public static Type<EALoadCallbackHandler> TYPE = new Type<EALoadCallbackHandler>();
	
	public EALoadCallbackEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public Type<EALoadCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EALoadCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EALoadCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

}
