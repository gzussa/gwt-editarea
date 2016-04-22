package com.gz.gwt.ui.sourcecodeeditor.client.type;

import com.google.gwt.core.client.JavaScriptObject;

public class FileInfo extends JavaScriptObject {

	protected FileInfo() { }
	
	public static native FileInfo create(String id, 
			String title, 
			String text, 
			String syntax, 
			String doHighlight) /*-{
    	var result =  {};
    	result.id = id;
    	result.title = title == null ? '' : title;
    	result.text = text == null ? '' : text;
    	result.syntax = syntax == null ? '' : syntax;
    	result.do_highlight = doHighlight == null ? '' : doHighlight;
    	return result;
  	}-*/;
	
	public final native String getId() /*-{ return this.id; }-*/;
	
	public final native String getTitle()  /*-{ return this.title;  }-*/;
	
	public final native String getText()  /*-{ return this.text;  }-*/;
	
	public final native String getSyntax()  /*-{ return this.syntax;  }-*/;
	
	public final native String getDoHighlight()  /*-{ return this.do_highlight;  }-*/;
}
