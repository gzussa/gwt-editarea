package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;

public class EAFileCloseCallbackEvent extends GwtEvent<EAFileCloseCallbackHandler>{
	
	private JavaScriptObject fileInfo;
	
	public static Type<EAFileCloseCallbackHandler> TYPE = new Type<EAFileCloseCallbackHandler>();
	
	public EAFileCloseCallbackEvent(JavaScriptObject fileInfo) {
		super();
		this.fileInfo = fileInfo;
	}

	@Override
	public Type<EAFileCloseCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EAFileCloseCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EAFileCloseCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}

}
