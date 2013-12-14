package com.gz.gwt.ui.sourcecodeeditor.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;

public class EAPluginKeyDownCallbackEvent extends GwtEvent<EAPluginKeyDownCallbackHandler>{
	
	private String plugin;
	private String id;
	private JavaScriptObject event;
	
	public static Type<EAPluginKeyDownCallbackHandler> TYPE = new Type<EAPluginKeyDownCallbackHandler>();
	
	public EAPluginKeyDownCallbackEvent(String plugin, String id/*, JavaScriptObject event*/) {
		super();
		this.plugin = plugin;
		this.id = id;
//		this.event = event;
	}

	@Override
	public Type<EAPluginKeyDownCallbackHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static Type<EAPluginKeyDownCallbackHandler> getType(){
		return TYPE;
	}

	@Override
	protected void dispatch(EAPluginKeyDownCallbackHandler handler) {
		handler.onCallbackEvent(this);		
	}
	
	public String getId() {
		return id;
	}

	public String getPlugin() {
		return plugin;
	}
	

}
