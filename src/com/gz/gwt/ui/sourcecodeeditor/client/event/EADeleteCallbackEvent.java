package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EADeleteCallbackEvent extends GwtEvent<EADeleteCallbackHandler>{
	
	private String id;
	
	public static Type<EADeleteCallbackHandler> TYPE = new Type<EADeleteCallbackHandler>();
	
	public EADeleteCallbackEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public Type<EADeleteCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EADeleteCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EADeleteCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

}
