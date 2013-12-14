package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;

public class EAFileSwitchOnCallbackEvent extends GwtEvent<EAFileSwitchOnCallbackHandler>{
	
	private JavaScriptObject fileInfo;
	
	public static Type<EAFileSwitchOnCallbackHandler> TYPE = new Type<EAFileSwitchOnCallbackHandler>();
	
	public EAFileSwitchOnCallbackEvent(JavaScriptObject fileInfo) {
		super();
		this.fileInfo = fileInfo;
	}

	@Override
	public Type<EAFileSwitchOnCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EAFileSwitchOnCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EAFileSwitchOnCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}

}
