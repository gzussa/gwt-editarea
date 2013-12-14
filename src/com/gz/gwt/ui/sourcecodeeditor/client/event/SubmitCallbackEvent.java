package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SubmitCallbackEvent extends GwtEvent<SubmitCallbackHandler>{
	
	private String id;
	
	public static Type<SubmitCallbackHandler> TYPE = new Type<SubmitCallbackHandler>();
	
	public SubmitCallbackEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public Type<SubmitCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<SubmitCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(SubmitCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}

	public String getId() {
		return id;
	}
}
