package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SaveCallbackEvent extends GwtEvent<SaveCallbackHandler>{
	
	private String id;
	private String content;
	
	public static Type<SaveCallbackHandler> TYPE = new Type<SaveCallbackHandler>();
	
	public SaveCallbackEvent(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	@Override
	public Type<SaveCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<SaveCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(SaveCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	

}
