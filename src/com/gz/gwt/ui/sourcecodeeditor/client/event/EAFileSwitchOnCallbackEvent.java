package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.type.FileInfo;

public class EAFileSwitchOnCallbackEvent extends GwtEvent<EAFileSwitchOnCallbackHandler>{
	
	private FileInfo fileInfo;
	
	public static Type<EAFileSwitchOnCallbackHandler> TYPE = new Type<EAFileSwitchOnCallbackHandler>();
	
	public EAFileSwitchOnCallbackEvent(FileInfo fileInfo) {
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

	public FileInfo getFileInfo() {
		return fileInfo;
	}

}
