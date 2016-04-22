package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.type.FileInfo;

public class EAFileSwitchOffCallbackEvent extends GwtEvent<EAFileSwitchOffCallbackHandler>{
	
	private FileInfo fileInfo;
	
	public static Type<EAFileSwitchOffCallbackHandler> TYPE = new Type<EAFileSwitchOffCallbackHandler>();
	
	public EAFileSwitchOffCallbackEvent(FileInfo fileInfo) {
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

	public FileInfo getFileInfo() {
		return fileInfo;
	}

}
