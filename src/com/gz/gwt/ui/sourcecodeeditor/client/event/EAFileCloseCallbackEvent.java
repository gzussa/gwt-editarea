package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.type.FileInfo;

public class EAFileCloseCallbackEvent extends GwtEvent<EAFileCloseCallbackHandler>{
	
	private FileInfo fileInfo;
	
	public static Type<EAFileCloseCallbackHandler> TYPE = new Type<EAFileCloseCallbackHandler>();
	
	public EAFileCloseCallbackEvent(FileInfo fileInfo) {
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

	public FileInfo getFileInfo() {
		return fileInfo;
	}
	
}
