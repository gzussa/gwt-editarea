package com.gz.gwt.ui.sourcecodeeditor.test.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gz.gwt.ui.sourcecodeeditor.client.SourceCodeEditor;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EALoadCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.EALoadCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.LoadCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.LoadCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.event.SaveCallbackEvent;
import com.gz.gwt.ui.sourcecodeeditor.client.event.SaveCallbackHandler;
import com.gz.gwt.ui.sourcecodeeditor.client.type.FileInfo;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SourceCodeEditorComponent implements EntryPoint {

	public void onModuleLoad(){
		// Creation of the main panel
		VerticalPanel main = new VerticalPanel();
		main.setWidth("100%");
		// Creation of the header
		HTML header = new HTML();
		header.setHTML("<h1>GWT-EditArea Library Demo</h1>" +
				"<p>Demo for <a href='https://github.com/gzussa/gwt-editarea/'>GWT-EditArea</a> widget.</p>" +
				"<p>GWT-EditArea is a GWT widget for editing texts with source code highlights, based on the javascript library EditArea from Christophe Dolivet. (<a href='http://www.cdolivet.com/editarea/'>http://www.cdolivet.com/editarea/</a>).<p>" +
				"<p>This Demo is based on the <a href='http://www.cdolivet.com/editarea/editarea/exemples/exemple_full.html'>original demo</a> for the Javascript library</p>");
		main.add(header);
		
		// Creation of the four examples groupBox
		CaptionPanel example1 = new CaptionPanel();
		example1.setCaptionText("Example 1");
		initExample1(example1);
		main.add(example1);
		
		CaptionPanel example2 = new CaptionPanel();
		example2.setCaptionText("Example 2");
		initExample2(example2);
		main.add(example2);
		
		CaptionPanel example3 = new CaptionPanel();
		example3.setCaptionText("Example 3");
		initExample3(example3);
		main.add(example3);
		
		CaptionPanel example4 = new CaptionPanel();
		example4.setCaptionText("Example 4");
		initExample4(example4);
		main.add(example4);

		//Attachment of the layout on the webpage
		RootPanel.get().add(main);
	}
	
	private void initExample1(CaptionPanel example1){
		VerticalPanel vpExemple1 = new VerticalPanel();
		vpExemple1.setWidth("100%");
		vpExemple1.add(new HTML("<p>Test in English with php syntax, highlighted, toggle enabled, word-wrap enabled, resize enabled and default toolbar. Also offer the possibility to switch on/off the readonly mode.</p>"));
		
		
		// Initialize SourceCodeEditor 
		final SourceCodeEditor editor1 = new SourceCodeEditor("en", // language
				"php",	// syntax
				"",		// syntaxSelectionAllow
				true, 	// startHighlight
				false, 	// isMultiFiles
				400,	// minWidth
				100,	// minHeight
				"both", // allowResize
				true,	// allowToggle
				"",		// plugins
				"known",// browsers
				"onload",// display
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
				true,	// wordWrap
				null,	// replaceTabBySpaces
				false,	// debug
				false,	// showLineColors
				null	// additional Args
		);
		editor1.setValue("<?php	\n" +
				"	$authors	= array();\n" +
				"	$news		= array();\n" +
				"	/* this is a long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long comment for showing word-wrap feature */\n" +
				"	$query	= \"SELECT author, COUNT(id) as 'nb_news' FROM news_messages GROUP BY author\";\n" +
				"	$result	= mysql_query($query, $DBnews);\n" +
				"	while( $line = mysql_fetch_assoc($result) ){\n" +
				"		$authors[$line[\"author\"]]	= $line[\"author\"];\n" +
				"		$news[$line[\"author\"]] = $line['nb_news'];\n" +
				"	}" +
				"	$list= sprintf(\"('%s')\", implode(\"', '\", $authors));\n" +
				"	$query=\"SELECT p.people_id, p.name, p.fname, p.status, team_name, t.leader_id=p.people_id as 'team_leader', w.name as 'wp_name', w.type\n" +
				"					FROM people p, teams t, wppartis wp, wps w\n" +
				"					WHERE p.people_id IN $list AND p.org_id=t.team_id AND wp.team_id=t.team_id AND wp.wp_id=w.wp_id\n" +
				"					GROUP BY p.people_id\";\n" +
				"	if(isset($_GET[\"order\"]) && $_GET[\"order\"]!=\"nb_news\")\n" +
				"		$query.=\" ORDER BY \".$_GET[\"order\"];\n" +
				"	$result=mysql_query($query, $DBkal);\n" +
				"	while($line = mysql_fetch_assoc($result)){\n" +
				"		printf(\"<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>\", $line[\"name\"], $line[\"fname\"],\n" +
				"			$news[$line[\"people_id\"]], $line[\"status\"], $line[\"team_name\"], ($line[\"team_leader\"]==\"1\")?\"yes\":\"no\", $line[\"type\"], $line[\"wp_name\"]);\n" +
				"	}\n" +
				"	printf(\"</table>\");\n" +
				"?>\n");
		editor1.setWidth("100%");
		editor1.setHeight("350px");
		vpExemple1.add(editor1);
		example1.setContentWidget(vpExemple1);
		FlowPanel fpExample1 = new FlowPanel();
		vpExemple1.add(new HTML("<p>Custom controls:<br />"));
		vpExemple1.add(fpExample1);
		// Creation of a button that will show the content of the editor
		Button b_editor1_getValue = new Button("getValue", new ClickHandler(){
			public void onClick(ClickEvent event) {
				Window.alert(editor1.getValue());
			}
		});
		fpExample1.add(b_editor1_getValue);
		
		Button b_editor1_setValue = new Button("setValue", new ClickHandler(){
			public void onClick(ClickEvent event) {
				editor1.setValue("new_value");
			}
		});
		fpExample1.add(b_editor1_setValue);
		
		Button b_editor1_getSelectedRange = new Button("getSelectionRange", new ClickHandler(){
			public void onClick(ClickEvent event) {
				Map<String, Integer> sel = editor1.getSelectionRange();
				Window.alert(("start: "+sel.get("start")+"\nend: "+sel.get("end")));
			}
		});
		fpExample1.add(b_editor1_getSelectedRange);
		
		Button b_editor1_setSelectedRange = new Button("setSelectionRange", new ClickHandler(){
			public void onClick(ClickEvent event) {
				editor1.setSelectionRange(100, 150);
			}
		});
		fpExample1.add(b_editor1_setSelectedRange);
		
		Button b_editor1_getSelectedText = new Button("getSelectedText", new ClickHandler(){
			public void onClick(ClickEvent event) {
				Window.alert(editor1.getSelectedText());
			}
		});
		fpExample1.add(b_editor1_getSelectedText);
		
		Button b_editor1_setSelectedText = new Button("setSelectedText", new ClickHandler(){
			public void onClick(ClickEvent event) {
				editor1.setSelectedText("[REPLACED SELECTION]");
			}
		});
		fpExample1.add(b_editor1_setSelectedText);
		
		Button b_editor1_insertTags = new Button("insertTags", new ClickHandler(){
			public void onClick(ClickEvent event) {
				editor1.insertTags("[OPEN]", "[CLOSE]");
			}
		});
		fpExample1.add(b_editor1_insertTags);
		
		Button b_editor1_readonlymode = new Button("Toggle readonly mode", new ClickHandler(){
			public void onClick(ClickEvent event) {
				editor1.toggleEditable();
			}
		});
		fpExample1.add(b_editor1_readonlymode);
	}
	
	private void initExample2(CaptionPanel example2){
		VerticalPanel vpExemple2 = new VerticalPanel();
		vpExemple2.setWidth("100%");
		vpExemple2.add(new HTML("<p>Multi file mode example with syntax selection option. The highlight colors of the selected line is also shown.</p>"));
		
		// Initialize SourceCodeEditor 
		final SourceCodeEditor editor2 = new SourceCodeEditor("en", // language
				"html",	//syntax
				"css,html,js,php,python,vb,xml,c,cpp,sql,basic,pas,brainfuck", //syntaxSelectionAllow
				true, 	// startHighlight
				true, 	// isMultiFiles
				400,	// minWidth
				100,	// minHeight
				"both", // allowResize
				false,	// allowToggle
				"",		// plugins
				"known",// browsers
				"onload",// display
				"search, go_to_line, |, undo, redo, |, select_font, |, syntax_selection, |, change_smooth_selection, highlight, reset_highlight, |, help", // toolbar 
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
				null,	// replaceTabBySpaces
				false,	// debug
				true,	// showLineColors
				null	// additional Args
				);
		
		editor2.addEALoadCallbackHandler(new EALoadCallbackHandler(){
			@Override
			public void onCallbackEvent(EALoadCallbackEvent eaLoadCallbackEvent) {
				openFile1(editor2);
				openFile2(editor2);
			}
		});
		
		editor2.setWidth("100%");
		editor2.setHeight("250px");
		vpExemple2.add(editor2);
		example2.setContentWidget(vpExemple2);
		
		FlowPanel fpExample2 = new FlowPanel();
		vpExemple2.add(new HTML("<p>Custom controls:<br />"));
		vpExemple2.add(fpExample2);
		
		// Creation of a button that will show the content of the editor
		Button b_editor2_openFile1 = new Button("open file 1", new ClickHandler(){
			public void onClick(ClickEvent event) {
				openFile1(editor2);
			}
		});
		fpExample2.add(b_editor2_openFile1);
		
		Button b_editor2_openFile2 = new Button("open file 2", new ClickHandler(){
			public void onClick(ClickEvent event) {
				openFile2(editor2);
			}
		});
		fpExample2.add(b_editor2_openFile2);
		
		Button b_editor2_closeFile1 = new Button("close file 1", new ClickHandler(){
			public void onClick(ClickEvent event) {
				editor2.closeFile("Filename1");
			}
		});
		fpExample2.add(b_editor2_closeFile1);
	}
	
	private void openFile1(SourceCodeEditor sce){
		FileInfo fileInfo = FileInfo.create("Filename1", 
				"beautiful title", 
				"$authors= array();\n$news= array();", 
				"php", 
				"true");
		sce.openFile(fileInfo);
	}
	
	private void openFile2(SourceCodeEditor sce){
		FileInfo fileInfo = FileInfo.create("Filename2", 
				"Filename", 
				"<a href=\"toto\">\n\tbouh\n</a>\n<!-- it's a comment -->", 
				"html", 
				"true");
		sce.openFile(fileInfo);
	}

	private void initExample3(CaptionPanel example3){
		VerticalPanel vpExemple3 = new VerticalPanel();
		vpExemple3.setWidth("100%");
		vpExemple3.add(new HTML("<p>Test in French with css syntax, verdana font, smaller default font size, toggle disabled, vertical only resize, custom toolbar, visual keyboard plugin, save and load callback examples.</p>"));
		
		Map<String, Object> additionalArgs = new HashMap<String, Object>();
		additionalArgs.put("charmap_default", "armenian");
		// Initialize SourceCodeEditor 
		final SourceCodeEditor editor3 = new SourceCodeEditor("fr", // language
				"css",	// syntax
				"",
				true, 	// startHighlight
				false, 	// isMultiFiles
				400,	// minWidth
				100,	// minHeight
				"y", // allowResize
				false,	// allowToggle
				"charmap",		// plugins
				"known",// browsers
				"onload",// display
				"new_document, save, load, |, charmap, |, search, go_to_line, |, undo, redo, |, select_font, |, change_smooth_selection, highlight, reset_highlight, |, help", // toolbar 
				"",		// beginToolbar
				"", 	// endToolbar
				8,		// fontSize
				"verdana, monospace", // fontFamily
				"begin", // cursorPosition
				false, // geckoSpellcheck
				20, // maxUndo
				false,	// fullScreen
				true,	// isEditable
				false,	// wordWrap
				null,	// replaceTabBySpaces
				false,	// debug
				false,	// showLineColors
				additionalArgs // additional Args
				);
		editor3.setValue("/* toolbar buttons (inspired from tinyMCE ones)*/\n" +
				".editAreaButtonNormal, .editAreaButtonOver, .editAreaButtonDown, .editAreaSeparator, .editAreaSeparatorLine, .editAreaButtonDisabled, .editAreaButtonSelected {\n" +
				"	border: 0px; margin: 0px; padding: 0px; background: transparent;\n" +
				"	margin-top: 0px;\n" +
				"	margin-left: 1px;\n" +
				"	padding: 0px;\n" +
				"}\n\n" +
				".editAreaButtonNormal {\n" +
				"	border: 1px solid #ECE9D8 !important;\n" +
				"	cursor: pointer;\n" +
				"}\n\n" +
				".editAreaButtonOver {\n" +
				"	border: 1px solid #0A246A !important;\n" +
				"	cursor: pointer;\n" +
				"	background-color: #B6BDD2;\n" +
				"}\n\n" +
				".editAreaButtonDown {\n" +
				"	cursor: pointer;	\n" +
				"	border: 1px solid #0A246A !important;\n" +
				"	background-color: #8592B5;\n" +
				"}\n\n" +
				".editAreaButtonSelected {\n" +
				"	border: 1px solid #C0C0BB !important;\n" +
				"	cursor: pointer;\n" +
				"	background-color: #F4F2E8;\n" +
				"}\n\n" +
				".editAreaButtonDisabled {\n" +
				"	filter:progid:DXImageTransform.Microsoft.Alpha(opacity=30);\n" +
				"	-moz-opacity:0.3;\n" +
				"	opacity: 0.3;\n" +
				"	border: 1px solid #F0F0EE !important;\n" +
				"	cursor: pointer;\n" +
				"}\n\n" +
				".editAreaSeparatorLine {\n" +
				"	margin: 1px 2px;\n" +
				"	background-color: #C0C0BB;\n" +
				"	width: 2px;\n" +
				"	height: 18px;\n" +
				"}\n\n");
		editor3.setWidth("100%");
		editor3.setHeight("350px");
		editor3.addLoadCallbackHandler(new LoadCallbackHandler() {			
			@Override
			public void onCallbackEvent(LoadCallbackEvent event) {
				editor3.setValue("The content is loaded from the load_callback function into EditArea");
			}
		});
		editor3.addSaveCallbackHandler(new SaveCallbackHandler() {			
			@Override
			public void onCallbackEvent(SaveCallbackEvent event) {
				Window.alert("Here is the content of the EditArea '"+ event.getId() +"' as received by the save callback function:\n"+event.getContent());				
			}
		});
		vpExemple3.add(editor3);
		example3.setContentWidget(vpExemple3);
	}
	
	private void initExample4(CaptionPanel example4){
		VerticalPanel vpExemple4 = new VerticalPanel();
		vpExemple4.setWidth("100%");
		vpExemple4.add(new HTML("<p>Test in German with Python syntax, toggle enabled for a later display, with highlight not enabled by default, without resizing possibility (but with larger minimum height when editor is toggled), and with tabs replaced by 4 spaces.</p>"));

		// Initialize SourceCodeEditor 
		final SourceCodeEditor editor4 = new SourceCodeEditor("de", // language
				"python", // syntax
				"",
				true, 	// startHighlight
				false, 	// isMultiFiles
				400,	// minWidth
				350,	// minHeight
				"no", // allowResize
				true,	// allowToggle
				"",		// plugins
				"known",// browsers
				"onload",// display
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
				new Integer(4),	// replaceTabBySpaces
				false,	// debug
				false,	// showLineColors
				null // additionalArgs
				);
		editor4.setValue("import Blender\n" +
				"class Python:\n\n" +
				"	# Instancie un objet\n" +
				"	# cls = la classe Python et non pas l'object instancie\n" +
				"	def __new__(cls):\n" +
				"		pass\n\n" +
				"	# Constructeur de l'objet\n" +
				"	def __init__(self):\n" +
				"		self.items = [1, 2, 3]\n\n" +
				"	# Destructeur\n" +
				"	def __del__(self):\n" +
				"		print \"Pourquoi tant de haine ?\"\n\n" +
				"	# Utilise pour : \"len(p)\"\n" +
				"	def __len__(self):\n" +
				"		return len(self.items)\n\n" +
				"	# Utilise pour : \"p[x]\"\n" +
				"	def __getitem__(self, key):\n" +
				"		return self.items[key]\n\n" +
				"	# Utilise pour : \"x in p\"\n" +
				"	def __contains__(self, value):\n" +
				"		return (value in self.items)\n\n" +
				"	# Utilise pour : \"for x in p\"\n" +
				"	def __iter__(self):\n" +
				"		for x in self.items:\n" +
				"			yield x\n");
		editor4.setWidth("100%");
		editor4.setHeight("50px");
		
		editor4.addLoadCallbackHandler(new LoadCallbackHandler() {			
			@Override
			public void onCallbackEvent(LoadCallbackEvent event) {
				editor4.setValue("The content is loaded from the load_callback function into EditArea");
			}
		});
		editor4.addSaveCallbackHandler(new SaveCallbackHandler() {			
			@Override
			public void onCallbackEvent(SaveCallbackEvent event) {
				Window.alert("Here is the content of the EditArea '"+ event.getId() +"' as received by the save callback function:\n"+event.getContent());				
			}
		});
		
		vpExemple4.add(editor4);
		example4.setContentWidget(vpExemple4);
	}

}
