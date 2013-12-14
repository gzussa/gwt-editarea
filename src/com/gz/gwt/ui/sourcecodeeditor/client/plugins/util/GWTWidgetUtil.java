package com.gz.gwt.ui.sourcecodeeditor.client.plugins.util;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class GWTWidgetUtil {

	public static void setWidgetPosition(Widget w, int left, int top) { 
		Element h = w.getElement(); 
		if ((left == -1) && (top == -1)) { 
			DOM.setStyleAttribute(h, "left", ""); 
			DOM.setStyleAttribute(h, "top", ""); 
			DOM.setStyleAttribute(h, "position", "static"); 
		} else { 
			DOM.setStyleAttribute(h, "position", "absolute"); 
			DOM.setStyleAttribute(h, "left", left + "px"); 
			DOM.setStyleAttribute(h, "top", top + "px"); 
		} 
	}
}
