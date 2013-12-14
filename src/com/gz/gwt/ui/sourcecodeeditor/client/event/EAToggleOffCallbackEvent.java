package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EAToggleOffCallbackEvent extends GwtEvent<EAToggleOffCallbackHandler>{
	
	private String id;
	
	public static Type<EAToggleOffCallbackHandler> TYPE = new Type<EAToggleOffCallbackHandler>();
	
	public EAToggleOffCallbackEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public Type<EAToggleOffCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EAToggleOffCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EAToggleOffCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

}
