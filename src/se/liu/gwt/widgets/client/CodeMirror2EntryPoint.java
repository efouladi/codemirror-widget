package se.liu.gwt.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import se.liu.gwt.widgets.client.CodeMirrorConf;
import se.liu.gwt.widgets.client.CodeMirror2;
import se.liu.gwt.widgets.client.event.CursorActivityEvent;
import se.liu.gwt.widgets.client.event.CursorActivityHandler;

import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * This is the Test class for development of CodeMirror2 gwt widget
 * @author Amir Hossein Fouladi
 *
 */

public class CodeMirror2EntryPoint implements EntryPoint {

		private CodeMirror2 editor;
		private CodeMirrorConf config = new CodeMirrorConf();

		private ScrollPanel panel = new ScrollPanel();
	public void onModuleLoad() {

	JSONObject mode = new JSONObject();
			JSONArray keywords = new JSONArray();
			JSONArray stringCh = new JSONArray();
			keywords.set(0,new JSONString("class"));
			keywords.set(1,new JSONString("System"));
			stringCh.set(0,new JSONString("\'"));
			stringCh.set(1,new JSONString("\""));
			mode.put("name",new JSONString("basemode"));
			mode.put("keywords",keywords);
			mode.put("stringCh",stringCh);
			mode.put("commentSingle",new JSONString("//"));
			mode.put("commentMStart",new JSONString("/*"));
			mode.put("commentMEnd",new JSONString("*/"));
			mode.put("escapeCh",new JSONString("\\"));
			mode.put("isOperatorChar",new JSONString("\\+-"));

			
			config.setMode(mode);
			config.setLineNumbers(true);
			
			editor = new CodeMirror2(config);
			//editor.setWidth("100%");
			//editor.setHeight("100%");
			
		
			panel.add(editor);
		
		//	panel.setHeight("100%");
		//	panel.setWidth("250px");
			Button lineInfo = new Button("show line info");
			lineInfo.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					editor.markLine(0);
					
				}
			});
			VerticalPanel p = new VerticalPanel();
			p.add(panel);
			p.add(lineInfo);
		RootLayoutPanel.get().add(p);
		
		editor.setMode(mode);
		editor.setFocus(true);
		editor.addCursorActivityHandler(new CursorActivityHandler() {
			
			@Override
			public void onCursorActivity(CursorActivityEvent event) {
				System.out.println("cursor");
				editor.setLineClass(0, "bgMarkedLine");
				
			}
		});
		editor.setValue("test");
		//RootLayoutPanel.get().forceLayout();
		//editor.setSize("500px", "500px");
		//editor.setMarker(0);
		//editor.setCursor(0, 3);
//		editor.setValue("\n");
//		editor.refresh();

	}
}
