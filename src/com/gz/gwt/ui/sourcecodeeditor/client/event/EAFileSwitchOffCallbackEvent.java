package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;

public class EAFileSwitchOffCallbackEvent extends GwtEvent<EAFileSwitchOffCallbackHandler>{
	
	private JavaScriptObject fileInfo;
	
	public static Type<EAFileSwitchOffCallbackHandler> TYPE = new Type<EAFileSwitchOffCallbackHandler>();
	
	public EAFileSwitchOffCallbackEvent(JavaScriptObject fileInfo) {
		super();
		this.fileInfo = fileInfo;
	}

	@Override
	public Type<EAFileSwitchOffCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EAFileSwitchOffCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EAFileSwitchOffCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}

}
