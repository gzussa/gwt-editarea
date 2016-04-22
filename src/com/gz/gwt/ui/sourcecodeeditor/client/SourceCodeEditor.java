package com.gz.gwt.ui.sourcecodeeditor.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gz.gwt.ui.sourcecodeeditor.client.event.ChangeCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.ChangeCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EADeleteCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EADeleteCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAFileCloseCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAFileCloseCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAFileSwitchOffCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAFileSwitchOffCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAFileSwitchOnCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAFileSwitchOnCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAInitCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAInitCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EALoadCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EALoadCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAToggleOffCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAToggleOffCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAToggleOnCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAToggleOnCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAUnloadCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EAUnloadCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.LoadCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.LoadCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.SaveCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.SaveCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.SubmitCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.SubmitCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.type.FileInfo;

/**
 * A TextArea prepared to edit source code in a variety of formats.
 * @author gzussa
 */
public class SourceCodeEditor extends Composite {
	
	/* Config variables */
	
	private final String syntax;
	
	private final String language;
	
	private final String syntaxSelectionAllow;
	
	private final boolean startHighlight;
	
	private final boolean isMultiFiles;
	
	private final int minWidth;
	
	private final int minHeight;
	
	private final String allowResize;
	
	private final boolean allowToggle;
	
	private final String plugins;
	
	private final String browsers;
	
	private final String display;
	
	private final String toolbar;
	
	private final String beginToolbar;
	
	private final String endToolbar;
	
	private final int fontSize;
	
	private final String fontFamily;
	
	private final String cursorPosition;
	
	private final boolean geckoSpellcheck;
	
	private final int maxUndo;
	
	private final boolean fullScreen;
	
	private final boolean isEditable;
	
	private final boolean wordWrap;
	
	private final Integer replaceTabBySpaces;
	
	private final boolean debug;
	
	private final boolean showLineColors;
	
	private final Map<String, Object> additionalArgs;
	
	/* [end] Config variables */
	
	private final String id;
	
	public TextArea editAreaContent;
	
	private final VerticalPanel main = new VerticalPanel();

	private boolean initialized = false;
	
	private String text = "";

	/**
	 * Constructs a SourceCodeEditor to edit code written in the specified syntax
	 * @param syntax the syntax the editor highlights
	 */
	public SourceCodeEditor(String syntax){
		this("en", // language
				syntax, // syntax
				"", // syntaxSelectionAllow
				false, 	// startHighlight
				false, 	// isMultiFiles
				400,	// minWidth
				100,	// minHeight
				"both", // allowResize
				true,	// allowToggle
				"",		// plugins
				"known",// browsers
				"later",// display
				"search, go_to_line, fullscreen, |, undo, redo, |, select_font,|, change_smooth_selection, highlight, reset_highlight, word_wrap, |, help", // toolbar 
				"",		// beginToolbar
				"", 	// endToolbar
				10,		// fontSize
				"monospace", // fontFamily
				"begin", // cursorPosition
				false, // geckoSpellcheck
				20, // maxUndo
				false,	// fullScreen
				true,	// isEditable
				false,	// wordWrap
				4,	// replaceTabBySpaces
				false,	// debug
				false,	// showLineColors
				null // Additional Agrs
		); 
	}
	
	public SourceCodeEditor(String language,
			String syntax,
			String syntaxSelectionAllow,
			boolean startHighlight,
			boolean isMultiFiles,
			int minWidth,
			int minHeight,
			String allowResize,
			boolean allowToggle,
			String plugins,
			String browsers,
			String display,
			String toolbar,
			String beginToolbar,
			String endToolbar,
			int fontSize,
			String fontFamily,
			String cursorPosition,
			boolean geckoSpellcheck,
			int maxUndo,
			boolean fullScreen,
			boolean isEditable,
			boolean wordWrap,
			Integer replaceTabBySpaces,
			boolean debug,
			boolean showLineColors,
			Map<String, Object> additionalArgs){
		this.language = language;
		this.syntax = syntax;
		this.syntaxSelectionAllow = syntaxSelectionAllow;
		this.startHighlight = startHighlight;
		this.isMultiFiles = isMultiFiles;
		this.minWidth = minWidth;
		this.minHeight = minHeight;
		this.allowResize = allowResize;
		this.allowToggle = allowToggle;
		this.plugins = plugins;
		this.browsers = browsers;
		this.display = display;
		this.toolbar = toolbar;
		this.beginToolbar = beginToolbar;
		this.endToolbar = endToolbar;
		this.fontSize = fontSize;
		this.fontFamily = fontFamily;
		this.cursorPosition = cursorPosition;
		this.geckoSpellcheck = geckoSpellcheck;
		this.maxUndo = maxUndo;
		this.fullScreen = fullScreen;
		this.isEditable = isEditable;
		this.wordWrap = wordWrap;
		if(replaceTabBySpaces != null){
			this.replaceTabBySpaces = replaceTabBySpaces;
		}else{
			this.replaceTabBySpaces = 8;
		}
		this.debug = debug;
		this.showLineColors = showLineColors;
		if(additionalArgs != null){
			this.additionalArgs = additionalArgs;
		}else{
			this.additionalArgs = new HashMap<String, Object>();
		}
		this.id = DOM.createUniqueId();
		this.editAreaContent = new TextArea();

		editAreaContent.getElement().setId(id);
		
		main.add(editAreaContent);
		initWidget(main);

		main.setCellWidth  (editAreaContent, "100%");
		main.setCellHeight (editAreaContent, "100%");
		
		//bottom margin
		FlowPanel marginPanel = new FlowPanel();
		marginPanel.setHeight("20px");
		main.add(marginPanel);
		
		editAreaContent.setHeight ("100%");
		editAreaContent.setWidth  ("100%");
	}


	/**
	 * This method is called immediately after a widget becomes attached to the
	 * browser's document.
	 */

	@Override
	protected void onLoad(){
		super.onLoad();
		_convertToEditArea(this,
				id, 
				language,
				syntax,
				syntaxSelectionAllow,
				startHighlight,
				isMultiFiles,
				minWidth,
				minHeight,
				allowResize,
				allowToggle,
				plugins, 
				browsers,
				display,
				toolbar,
				beginToolbar,
				endToolbar,
				fontSize,
				fontFamily,
				cursorPosition,
				geckoSpellcheck,
				maxUndo,
				fullScreen,
				isEditable,
				wordWrap,
				replaceTabBySpaces,
				debug,
				showLineColors);
		initialized = true;
		setValue(text);
	}

	@Override
	protected void onUnload(){
		initialized = false; 
		super.onUnload();
	}

	/**
	 * The id of the converted textarea
	 * @return The id
	 */
	public String getId(){
		if(!initialized){ return null; }
		
		return this.id; 
	}
	
	/** Gets the content shown in the editor     
	 * @return the content of the editor 
	 **/
	public String getValue(){
		if(!initialized){ return text; }
		
		return _getValue(id); 
	}

	/** Sets the content shown in the editor
	 * @param value the text to be shown in the editor 
	 **/
	public void setValue(String value){
		if(initialized){
			_setValue(id, value);	
		}else{ 
			text = value;
		}
	}

	/** Sets the editor width.    
	 * @param width the object's new width, in CSS units (e.g. "10px", "1em") 
	 **/
	@Override 
	public void setWidth(String width){
		super.setWidth(width); 
		main.setWidth(width);
	}

	/** Sets the editor height.   
	 * @param height the object's new height, in CSS units (e.g. "10px", "1em") 
	 **/
	@Override 
	public void setHeight(String height){
		super.setHeight(height); 
		main.setHeight(height);
	}
	
	/**
	 * This method allow to insert tags at the current position. If no text was selected, the cursor is then displayed between the open and the close tags. Otherwise, the cursor is positionned after the close tag. Works on normal textarea if the EditArea is toggled off.
	 * @param openTag	The open tag 
	 * @param closeTag 	The close tag
	 */
	public void insertTags(String openTag, String closeTag){
		if(!initialized){ return; }
		
		_insertTags(id, openTag, closeTag); 
	}

	/**
	 * This method return the text contained in the the selection range. Works on normal textarea if the EditArea is toggled off.
	 * @return The text contained in the the selection range. 
	 */
	public String getSelectedText(){
		if(!initialized){ return null; }
		
		return _getSelectedText(id);
	}
	
	/**
	 * This method allow to replace the text contained in the selection range with a given string. The selection range will then contain the new string. Works on normal textarea if the EditArea is toggled off.
	 * @param text	The string that will replace the current selected text.
	 */
	public void setSelectedText(String text){
		if(!initialized){ return; }
			
		_setSelectedText(id, text);
	};
	
	/**
	 * This method return the position start and position end of the selection range in the editor. Works on normal textarea if the EditArea is toggled off.
	 * @return An array containing the index of the selection start and end. Array("start", "end")
	 */
	public Map<String, Integer> getSelectionRange(){
		Map<String, Integer> result = new HashMap<String, Integer>();
		if(!initialized){ return result; }
			
		int selectionRangesStart = _getSelectionRangeStart(id);
		int selectionRangesEnd = _getSelectionRangeEnd(id);
		result.put("start", selectionRangesStart);
		result.put("end", selectionRangesEnd);
		return result;
	};
	
	/**
	 * This method allow to replace the text contained in the selection range with a given string. The selection range will then contain the new string. Works on normal textarea if the EditArea is toggled off.
	 * @param newStart 	The character position determining the start of the selection range.
	 * @param newEnd 	The character position determining the end of the selection range.
	 */
	public void setSelectionRange(int newStart, int newEnd){
		if(!initialized){ return; }
			
		_setSelectionRange(id, newStart, newEnd);
	};
	
	/**
	 * Allow to access to EditArea functions and datas (for advanced users only).
	 * @param command		The function or the parameter of the EditArea object that will be returned.
	 * @param commandParam 	If command is a function, the you can pass one parameter to the function with command_param
	 * @return the value of the executed command or data.
	 */
	public JavaScriptObject execCommand(String command, Object commandParam){
		if(!initialized){ return null; }
			
		return _execCommand(id, command, commandParam);
	};
	
	/**
	 * Delete an instance of EditArea and restore simple textarea.
	 */
	public void deleteInstance(){
		if(!initialized){ return; }
		
		_deleteInstance(id);
	};
	
	/**
	 * Hide a textarea and it's related EditArea.
	 */
	public void hide(){
		if(!initialized){ return; }
		
		_hide(id);
	};
	
	/**
	 * Restore a textarea and it's related EditArea hidden with the hide() function.
	 * @param id	The id of the converted textarea.
	 */
	public void show(){
		if(!initialized){ return; }
		
		_show(id);
	};
	
	/**
	 * Restore a textarea and it's related EditArea hidden with the hide() function.
	 * @param fileInfos	
	 * An object containing datas of the file that will be opened. Here are the main fields (for the other possible fields see the returned Object of the getFile function):
     * - id : (required) A string that will identify the file. it's the only required field.
     * Type: String
     * - title : (optional) The title that will be displayed in the tab area.
     * Type: String
     * Default: set with the id field value
     * - text : (optional) The text content of the file.
     * Type: String
     * Default: ""
     * - syntax : (optional) The syntax to use for this file.
     * Type: String
     * Default: ""
     * - do_highlight : (optional) Set if the file should start highlighted or not
     * Type: String
     * Default: ""
	 */
	public void openFile(FileInfo fileInfo){
		if(!initialized){ return; }
			
		_openFile(id, fileInfo);
	};
	
	/**
	 * This method return the position start and position end of the selection range in the editor. Works on normal textarea if the EditArea is toggled off.
	 * @param id	The id of the converted textarea.
	 * @return An object containing datas related to the file.
	 */
	public JavaScriptObject getCurrentFile(){
		if(!initialized){ return null; }
		
		return _getCurrentFile(id);
	};
	
	/**
	 * Return datas of the file identified by file_id (for multi file editing mode).
	 * @param fileId	The id of the file.
	 * @return An object containing datas related to the file.
	 */
	public JavaScriptObject getFile(String fileId){
		if(!initialized){ return null; }
		
		return _getFile(id, fileId);
	};
	
	/**
	 * Return datas of all the currently openned files (for multi file editing mode).
	 * @return An object containing datas of each files
	 */
	public JavaScriptObject getAllFiles(){
		if(!initialized){ return null; }
		
		return _getAllFiles(id);
	};
	
	/**
	 * Close the file identified by file_id (for multi file editing mode).
	 * @param fileId	The id of the file to close.
	 */
	public void closeFile(String fileId){
		if(!initialized){ return; }
		
		_closeFile(id, fileId);
	};
	
	/**
	 * Define is the file should appears as edited or not.
	 * @param fileId	The id of the file to close.
	 * @param editedMode A boolean that indicate if the file should be set edited or not edited.
	 */
	public void setFileEditedMode(String fileId, boolean editedMode){
		if(!initialized){ return; }
			
		_setFileEditedMode(id, fileId, editedMode);
	};
	
	/** 
	 * Switch the editable mode whenever you want 
	 * (code example for a toggle edit mode: editAreaLoader.execCommand('editor_id', 'set_editable', !editAreaLoader.execCommand('editor_id', 'is_editable'));). 
	 */
	public void toggleEditable(){
		if(!initialized){ return; }
			
		_toggleEditable(id);
	};
	

	private void setAdditionalAgrs(){
		if(!additionalArgs.isEmpty()){
			for(Iterator<String> it = additionalArgs.keySet().iterator(); it.hasNext();){
				String argName = (String)it.next();
				Object argValue = additionalArgs.get(argName);
				_setAdditionalArg(id, argName, argValue);				
			}
		}
	}
	
	/* Encapsulated native code */
	/**
	 * Converts the TextArea into an EditArea widget with every options
	 * 
	 * @param id should contain the id of the textarea that should be converted into an editor 
	 * @param language should contain a code of the language pack to be used for translation. If EditArea doesn't have a language pack for your language you could always write your own and contribute this back to this project by uploading it as a Patch at SourceForge. 
	 * @param syntax should contain a code of the syntax definition file that must be used for the highlight mode. 
	 * @param startHighlight set if the editor should start with highlighted syntax displayed. 
	 * @param isMultiFiles determine if the editor load the content of the textarea (false) or if it wait for an openFile() call for allowing file editing. 
	 * @param minWidth define the minimum width of the editor 
	 * @param minHeight define the minimum height of the editor 
	 * @param allowResize define one with axis the editor can be resized by the user. ("no" (no resize allowed), "both" (x and y axis), "x", "y") 
	 * @param allowToggle define if a toggle button must be added under the editor in order to allow to toggle between the editor and the orginal textarea. 
	 * @param plugins a comma separated list of plugins to load. 
	 * @param browsers define if the editor must be loaded only when the user navigotr is known to be a working one, or if it will be loaded for all navigators. ("all" or "known")  
	 * @param display specify when the textarea will be converted into an editor. If set to "later", the toogle button will be displayed to allow later conversion. ("onload" or "later") 
	 * @param toolbar define the toolbar that will be displayed, each element being separated by a ",". 
	 * (combinaison of: "|", "*", "search", "go_to_line", "undo", "redo", "change_smooth_selection", "reset_highlight", "highlight", "word_wrap", "help", "save", "load", "new_document", "syntax_selection")
	 * "|" or "separator" make appears a separator in the toolbar.
	 * "*" or "return" make appears a line-break in the toolbar 
	 * @param beginToolbar toolbar button list to add before the toolbar defined by the "toolbar" option. (cf. "toolbar" option) 
	 * @param endToolbar toolbar button list to add after the toolbar defined by the "toolbar" option. (cf. "toolbar" option) 
	 * @param fontSize define the font-size used to display the text in the editor. 
	 * @param fontFamily define the font-familly used to display the text in the editor. (eg: "monospace" or "verdana,monospace"). Opera will always use "monospace". 
	 * @param cursorPosition define if the cursor should be placed where it was in the textarea before replacement (auto) or at the beginning of the file (begin). ("begin" or "auto") 
	 * @param geckoSpellcheck allow to disable/enable the Firefox 2 spellchecker 
	 * @param maxUndo number of undo action allowed 
	 * @param fullScreen determine if EditArea start in fullscreen mode or not 
	 * @param isEditable determine if EditArea display only the highlighted syntax (no edition possiblities, no toolbars). It's possible to switch the editable mode whenever you want (code example for a toggle edit mode: editAreaLoader.execCommand('editor_id', 'set_editable', !editAreaLoader.execCommand('editor_id', 'is_editable'));). 
	 * @param wordWrap determine if the text will be automatically wrapped to the next line when it reach the end of a line. This is linked ot the word_wrap icon available in the toolbar. 
	 * @param replaceTabBySpaces define the number of spaces that will replace tabulations (\t) in text. If tabulation should stay tabulation, set this option to 8. 
	 * @param debug used to display some debug information into a newly created textarea. Can be usefull to display trace info in it if you want to modify the code. 
	 */
	private native static void _convertToEditArea(SourceCodeEditor handler, 
			String id, 
			String language,
			String syntax,
			String syntaxSelectionAllow, 
			boolean startHighlight,
			boolean isMultiFiles,
			int minWidth,
			int minHeight,
			String allowResize,
			boolean allowToggle,
			String plugins,
			String browsers,
			String display,
			String toolbar,
			String beginToolbar,
			String endToolbar,
			int fontSize,
			String fontFamily,
			String cursorPosition,
			boolean geckoSpellcheck,
			int maxUndo,
			boolean fullScreen,
			boolean isEditable,
			boolean wordWrap,
			int replaceTabBySpaces,
			boolean debug,
			boolean showLineColors)/*-{
			var idName = id.replace(/-/g,"_");
			var load_callback_function_name = "load_callback"+idName;
			var save_callback_function_name = "save_callback"+idName;
			var change_callback_function_name = "change_callback"+idName;
			var submit_callback_function_name = "submit_callback"+idName;
			var EA_init_callback_function_name = "EA_init_callback"+idName;
			var EA_delete_callback_function_name = "EA_delete_callback"+idName;
			var EA_toggle_on_callback_function_name = "EA_toggle_on_callback"+idName;
			var EA_toggle_off_callback_function_name = "EA_toggle_off_callback"+idName;
			var EA_load_callback_function_name = "EA_load_callback"+idName;
			var EA_unload_callback_function_name = "EA_unload_callback"+idName;
			var EA_file_switch_on_callback_function_name = "EA_file_switch_on_callback"+idName;
			var EA_file_switch_off_callback_function_name = "EA_file_switch_off_callback"+idName;
			var EA_file_close_callback_function_name = "EA_file_close_callback"+idName;		
		
		$wnd.editAreaLoader.init({
			// init configuration
			id              : id,    // id of the textarea to transform
			language		: language, 
			syntax          : syntax,
			syntax_selection_allow : syntaxSelectionAllow,		
			start_highlight : startHighlight,  // if start with highlight
			is_multi_files  : isMultiFiles,
			min_width		: minWidth,
			min_height		: minHeight,
			allow_resize	: allowResize,
			allow_toggle    : allowToggle,
			plugins			: plugins,
			browsers		: browsers,
			display			: display,
			toolbar			: toolbar,
			begin_toolbar	: beginToolbar,
			end_toolbar		: endToolbar,
			font_size		: fontSize,
			font_family 	: fontFamily,
			cursor_position	: cursorPosition,
			gecko_spellcheck: geckoSpellcheck,
			max_undo		: maxUndo,
			fullscreen		: fullScreen,
			is_editable		: isEditable,
			word_wrap       : wordWrap,
			replace_tab_by_spaces: replaceTabBySpaces,
			debug			: debug,
			show_line_colors: showLineColors,
			// init callbacks
			load_callback 	: load_callback_function_name,
			save_callback	: save_callback_function_name,
			change_callback	: change_callback_function_name,
			submit_callback	: submit_callback_function_name,
			EA_init_callback: EA_init_callback_function_name,
			EA_delete_callback: EA_delete_callback_function_name,
			EA_toggle_on_callback: EA_toggle_on_callback_function_name,
			EA_toggle_off_callback: EA_toggle_off_callback_function_name,
			EA_load_callback: EA_load_callback_function_name,
			EA_unload_callback: EA_unload_callback_function_name,
			EA_file_switch_on_callback: EA_file_switch_on_callback_function_name,
			EA_file_switch_off_callback: EA_file_switch_off_callback_function_name,
			EA_file_close_callback: EA_file_close_callback_function_name
		});		
		
		//Define callback functions on the window object.
   		$wnd[load_callback_function_name] = function(id) {
 			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::loadCallback(Ljava/lang/String;)(id);
   		}

   		$wnd[save_callback_function_name] = function(id, content) {
 			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::saveCallback(Ljava/lang/String;Ljava/lang/String;)(id, content);
   		}
   		
   		$wnd[change_callback_function_name] = function(id) {
 			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::changeCallback(Ljava/lang/String;)(id);
   		}
		
		$wnd[submit_callback_function_name] = function(id) {
 			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::submitCallback(Ljava/lang/String;)(id);
   		}
   		
   		$wnd[EA_init_callback_function_name] = function(id) {
     		handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EAInitCallback(Ljava/lang/String;)(id);
   		}
   		
   		$wnd[EA_delete_callback_function_name] = function(id) {
     			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EADeleteCallback(Ljava/lang/String;)(id);
   		}
   		
   		$wnd[EA_toggle_on_callback_function_name] = function(id) {
     			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EAToggleOnCallback(Ljava/lang/String;)(id);
   		}
   		
   		$wnd[EA_toggle_off_callback_function_name] = function(id) {
     			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EAToggleOffCallback(Ljava/lang/String;)(id);
   		}
   		
   		$wnd[EA_load_callback_function_name] = function(id) {
     			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EALoadCallback(Ljava/lang/String;)(id);
   		}
   		
   		$wnd[EA_unload_callback_function_name] = function(id) {
     			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EAUnloadCallback(Ljava/lang/String;)(id);
   		}
   		
   		$wnd[EA_file_switch_on_callback_function_name] = function(fileInfo) {
     			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EAFileSwitchOnCallback(Lcom/gz/gwt/ui/sourcecodeeditor/client/type/FileInfo;)(fileInfo);
   		}
   		
   		$wnd[EA_file_switch_off_callback_function_name] = function(fileInfo) {
     			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EAFileSwitchOffCallback(Lcom/gz/gwt/ui/sourcecodeeditor/client/type/FileInfo;)(fileInfo);
   		}
   		
   		$wnd[EA_file_close_callback_function_name] = function(fileInfo) {
     			handler.@com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor::EAFileCloseCallback(Lcom/gz/gwt/ui/sourcecodeeditor/client/type/FileInfo;)(fileInfo);
   		}
   		
	}-*/;
	
	/**
	 * This method allow to update the content text of an editor. Works on normal textarea if the EditArea is toggled off.
	 * @param id    The id of the converted textarea
	 * @param value The new text that will replace the Editor content.
	 */
	private static native void _setValue(String id, String value)/*-{
		$wnd.editAreaLoader.setValue(id, value);
	}-*/;

	/**
	 * This method return the content text of the editor. Works on normal textarea if the EditArea is toggled off.
	 * @param id    The id of the converted textarea
	 * @return the content text of the editor. 
	 */
	private static native String _getValue(String id)/*-{
		return $wnd.editAreaLoader.getValue(id);
	}-*/;
	
	/**
	 * This method allow to insert tags at the current position. If no text was selected, the cursor is then displayed between the open and the close tags. Otherwise, the cursor is positionned after the close tag. Works on normal textarea if the EditArea is toggled off.
	 * @param id 	The id of the converted textarea
	 * @param openTag	The open tag 
	 * @param closeTag 	The close tag
	 */
	private static native void _insertTags(String id, String openTag, String closeTag)/*-{
		$wnd.editAreaLoader.insertTags(id, openTag, closeTag);
	}-*/;
	
	/**
	 * This method return the text contained in the the selection range. Works on normal textarea if the EditArea is toggled off.
	 * @param id	The id of the converted textarea
	 * @return The text contained in the the selection range. 
	 */
	private static native String _getSelectedText(String id)/*-{
		return $wnd.editAreaLoader.getSelectedText(id);
	}-*/;
	
	/**
	 * This method allow to replace the text contained in the selection range with a given string. The selection range will then contain the new string. Works on normal textarea if the EditArea is toggled off.
	 * @param id	The id of the converted textarea
	 * @param text	The string that will replace the current selected text.
	 */
	private static native void _setSelectedText(String id, String text)/*-{
		$wnd.editAreaLoader.setSelectedText(id, text);
	}-*/;
	
	/**
	 * This method return the position start and position end of the selection range in the editor. Works on normal textarea if the EditArea is toggled off.
	 * @param id	The id of the converted textarea
	 * @return An array containing the index of the selection start and end. Array("start", "end")
	 */
	private static native JsArray<JavaScriptObject> _getSelectionRange(String id)/*-{
		return $wnd.editAreaLoader.getSelectionRange(id);
	}-*/;
	
	/**
	 * This method return the start position of the selection range in the editor. Works on normal textarea if the EditArea is toggled off.
	 * @param id	The id of the converted textarea
	 * @return selection range start position
	 */
	private static native int _getSelectionRangeStart(String id)/*-{
		return $wnd.editAreaLoader.getSelectionRange(id).start;
	}-*/;
	
	/**
	 * This method return the end position of the selection range in the editor. Works on normal textarea if the EditArea is toggled off.
	 * @param id	The id of the converted textarea
	 * @return selection range end position
	 */
	private static native int _getSelectionRangeEnd(String id)/*-{
		return $wnd.editAreaLoader.getSelectionRange(id).end;
	}-*/;
	
	/**
	 * This method allow to replace the text contained in the selection range with a given string. The selection range will then contain the new string. Works on normal textarea if the EditArea is toggled off.
	 * @param id	The id of the converted textarea
	 * @param newStart 	The character position determining the start of the selection range.
	 * @param newEnd 	The character position determining the end of the selection range.
	 */
	private static native void _setSelectionRange(String id, int newStart, int newEnd)/*-{
		$wnd.editAreaLoader.setSelectionRange(id, newStart, newEnd);
	}-*/;
	
	/**
	 * Allow to access to EditArea functions and datas (for advanced users only).
	 * @param id	The id of the converted textarea on which the command should be executed.
	 * @param command		The function or the parameter of the EditArea object that will be returned.
	 * @param commandParam 	If command is a function, the you can pass one parameter to the function with command_param
	 * @return the value of the executed command or data.
	 */
	private static native JavaScriptObject _execCommand(String id, String command, Object commandParam)/*-{
		return $wnd.editAreaLoader.execCommand(id, command, commandParam);
	}-*/;
	
	/**
	 * Delete an instance of EditArea and restore simple textarea.
	 * @param id	The id of the converted textarea.
	 */
	private static native void _deleteInstance(String id)/*-{
		$wnd.editAreaLoader.delete_instance(id);
	}-*/;
	
	/**
	 * Hide a textarea and it's related EditArea.
	 * @param id	The id of the converted textarea.
	 */
	private static native void _hide(String id)/*-{
		$wnd.editAreaLoader.hide(id);
	}-*/;
	
	/**
	 * Restore a textarea and it's related EditArea hidden with the hide() function.
	 * @param id	The id of the converted textarea.
	 */
	private static native void _show(String id)/*-{
		$wnd.editAreaLoader.show(id);
	}-*/;
	
	/**
	 * Restore a textarea and it's related EditArea hidden with the hide() function.
	 * @param id	The id of the converted textarea.
	 * @param fileInfos	
	 * An object containing datas of the file that will be opened. Here are the main fields (for the other possible fields see the returned Object of the getFile function):
     * - id : (required) A string that will identify the file. it's the only required field.
     * Type: String
     * - title : (optional) The title that will be displayed in the tab area.
     * Type: String
     * Default: set with the id field value
     * - text : (optional) The text content of the file.
     * Type: String
     * Default: ""
     * - syntax : (optional) The syntax to use for this file.
     * Type: String
     * Default: ""
     * - do_highlight : (optional) Set if the file should start highlighted or not
     * Type: String
     * Default: ""
	 */
	private static native void _openFile(String id, FileInfo fileInfo)/*-{
		$wnd.editAreaLoader.openFile(id, fileInfo);
	}-*/;
	
	/**
	 * This method return the position start and position end of the selection range in the editor. Works on normal textarea if the EditArea is toggled off.
	 * @param id	The id of the converted textarea.
	 * @return An object containing datas related to the file.
	 */
	private static native JavaScriptObject _getCurrentFile(String id)/*-{
		return $wnd.editAreaLoader.getCurrentFile(id);
	}-*/;
	
	/**
	 * Return datas of the file identified by file_id (for multi file editing mode).
	 * @param id		The id of the converted textarea.
	 * @param fileId	The id of the file.
	 * @return An object containing datas related to the file.
	 */
	private static native JavaScriptObject _getFile(String id, String fileId)/*-{
		return $wnd.editAreaLoader.getFile(id, fileId);
	}-*/;
	
	/**
	 * Return datas of all the currently openned files (for multi file editing mode).
	 * @param id		The id of the converted textarea.
	 * @return An object containing datas of each files
	 */
	private static native JavaScriptObject _getAllFiles(String id)/*-{
		return $wnd.editAreaLoader.getAllFiles(id);
	}-*/;
	
	/**
	 * Close the file identified by file_id (for multi file editing mode).
	 * @param id		The id of the converted textarea.
	 * @param fileId	The id of the file to close.
	 */
	private static native void _closeFile(String id, String fileId)/*-{
		$wnd.editAreaLoader.closeFile(id, fileId);
	}-*/;
	
	/**
	 * Define is the file should appears as edited or not.
	 * @param id		The id of the converted textarea.
	 * @param fileId	The id of the file to close.
	 * @param editedMode A boolean that indicate if the file should be set edited or not edited.
	 */
	private static native void _setFileEditedMode(String id, String fileId, boolean editedMode)/*-{
		$wnd.editAreaLoader.setFileEditedMode(id, fileId, editedMode);
	}-*/;
	
	/**
	 * Switch the editable mode whenever you want 
	 * (code example for a toggle edit mode: editAreaLoader.execCommand('editor_id', 'set_editable', !editAreaLoader.execCommand('editor_id', 'is_editable'));). 
	 * @param id		The id of the converted textarea.
	 */
	private static native void _toggleEditable(String id)/*-{
		$wnd.editAreaLoader.execCommand(id, 'set_editable', !$wnd.editAreaLoader.execCommand(id, 'is_editable'));
	}-*/;
	
	private static native void _setFileEditedMode(String id, String argName, Object argValue)/*-{
		$wnd.editAreaLoader.setFileEditedMode(id, fileId, editedMode);
	}-*/;
	
	private static native void _setAdditionalArg(String id, String argName, Object argValue)/*-{
		$wnd.editAreas[id].settings[argName] = argValue;
	}-*/;
	
	/* Listeners */
	public void addLoadCallbackHandler(LoadCallbackHandler handler) {
		addHandler(handler, LoadCallbackEvent.getType());
	}
	
	public void addSaveCallbackHandler(SaveCallbackHandler handler) {
		addHandler(handler, SaveCallbackEvent.getType());
	}
	
	public void addChangeCallbackHandler(ChangeCallbackHandler handler) {
		addHandler(handler, ChangeCallbackEvent.getType());
	}
	
	public void addSubmitCallbackHandler(SubmitCallbackHandler handler) {
		addHandler(handler, SubmitCallbackEvent.getType());
	}
	
	public void addEAInitCallbackHandler(EAInitCallbackHandler handler) {
		addHandler(handler, EAInitCallbackEvent.getType());
	}
	
	public void addEADeleteCallbackHandler(EADeleteCallbackHandler handler) {
		addHandler(handler, EADeleteCallbackEvent.getType());
	}
	
	public void addEAToggleOnCallbackHandler(EAToggleOnCallbackHandler handler) {
		addHandler(handler, EAToggleOnCallbackEvent.getType());
	}
	
	public void addEAToggleOffCallbackHandler(EAToggleOffCallbackHandler handler) {
		addHandler(handler, EAToggleOffCallbackEvent.getType());
	}
	
	public void addEALoadCallbackHandler(EALoadCallbackHandler handler) {
		addHandler(handler, EALoadCallbackEvent.getType());
	}
	
	public void addEAUnloadCallbackHandler(EAUnloadCallbackHandler handler) {
		addHandler(handler, EAUnloadCallbackEvent.getType());
	}
	
	public void addEAFileSwitchOnCallbackHandler(EAFileSwitchOnCallbackHandler handler) {
		addHandler(handler, EAFileSwitchOnCallbackEvent.getType());
	}
	
	public void addEAFileSwitchOffCallbackHandler(EAFileSwitchOffCallbackHandler handler) {
		addHandler(handler, EAFileSwitchOffCallbackEvent.getType());
	}
	
	public void addEAFileCloseCallbackHandler(EAFileCloseCallbackHandler handler) {
		addHandler(handler, EAFileCloseCallbackEvent.getType());
	}
	
	/*Callback functions*/
	/**
	 * Function that will be called when the user will press the "load" button in the toolbar. This function will reveice one parameter that will be the id of the textarea. You can update the content of the textarea by using "editAreaLoader.setValue(the_id, new_value);".
	 * @param id
	 */
	public void loadCallback(String id){
		fireEvent(new LoadCallbackEvent(id));
	}
	
	/**
	 * Function that will be called when the user will press the "save" button in the toolbar. This function will reveice two parameters, the first being the id of the textarea and the second containing the content of the textarea. 
	 * @param id
	 * @param content
	 */
	public void saveCallback(String id, String content){
		fireEvent(new SaveCallbackEvent(id, content));
	}
	
	/**
	 * Function that will be called when the onchange event of the textarea of EditArea will be triggered. This function will reveice one parameter that will be the id of the textarea. Will be triggered only is EditArea is displayed. 
	 * @param id
	 */
	public void changeCallback(String id){
		fireEvent(new ChangeCallbackEvent(id));
	}
	
	/**
	 * Function that will be called when the form containing the EditArea will be submitted. This function will reveice one parameter that will be the id of the textarea. Will be triggered regardless the state of EditArea (displayed or not). 
	 * @param id
	 */
	public void submitCallback(String id){
		fireEvent(new SubmitCallbackEvent(id));
	}
	
	/**
	 * Function that will be called just after the editAreaLoader.init() function, once EditAreaLoader will be initalized but still not displayed. This function will receive one parameter that will be the id of the textarea. 
	 * @param id
	 */
	public void EAInitCallback(String id){
		// We set Additional Args
		setAdditionalAgrs();
		fireEvent(new EAInitCallbackEvent(id));
	}
	
	/**
	 * Function that will be called when EditArea will be destroyed regardless the fact that it has been displayed or not. This function will reveice one parameter that will be the id of the textarea. 
	 * @param id
	 */
	public void EADeleteCallback(String id){
		fireEvent(new EADeleteCallbackEvent(id));
	}
	
	/**
	 * Function that will be called when EditArea will be toogled on for. This function will reveice one parameter that will be the id of the textarea. 
	 * @param id
	 */
	public void EAToggleOnCallback(String id){
		fireEvent(new EAToggleOnCallbackEvent(id));
	}
	
	/**
	 * Function that will be called when EditArea will be toggled off. This function will reveice one parameter that will be the id of the textarea. 
	 * @param id
	 */
	public void EAToggleOffCallback(String id){
		fireEvent(new EAToggleOffCallbackEvent(id));
	}
	
	/**
	 * Function that will be called when EditArea will be displayed for the first time. This function will reveice one parameter that will be the id of the textarea. 
	 * @param id
	 */
	public void EALoadCallback(String id){
		fireEvent(new EALoadCallbackEvent(id));
	}
	
	/**
	 * Function that will be called when EditArea will be destroyed (if it have been displayed at least one time). This function will reveice one parameter that will be the id of the textarea. 
	 * @param id
	 */
	public void EAUnloadCallback(String id){
		fireEvent(new EAUnloadCallbackEvent(id));
	}
	
	/**
	 * Function that will be called when the tabulation of the file will be selected. This function will reveice one parameter that will be an associative array containing all file's infos. 
	 * @param fileInfo
	 */
	public void EAFileSwitchOnCallback(FileInfo fileInfo){
		fireEvent(new EAFileSwitchOnCallbackEvent(fileInfo));
	}
	
	/**
	 * Function that will be called when the tabulation of the file will be blur (the file was selected, and another file receive focus). This function will reveice one parameter that will be an associative array containing all file infos. 
	 * @param fileInfo
	 */
	public void EAFileSwitchOffCallback(FileInfo fileInfo){
		fireEvent(new EAFileSwitchOffCallbackEvent(fileInfo));	
	}
	
	/**
	 * Function that will be called when the tabulation of a file will be closed. This function will reveice one parameter that will be an associative array containing all file infos. If the callback function return false, the file won't be closed. 
	 * @param fileInfo
	 */
	public void EAFileCloseCallback(FileInfo fileInfo){
		fireEvent(new EAFileCloseCallbackEvent(fileInfo));
	}
	
}
