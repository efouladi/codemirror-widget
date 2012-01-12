package se.liu.gwt.widgets.client;


import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import se.liu.gwt.widgets.client.CodeMirrorConf;
import se.liu.gwt.widgets.client.CodeMirror2;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Composite;

/**
 * This is the Test class for development of CodeMirror2 gwt widget
 * @author Amir Hossein Fouladi
 *
 */

public class CodeMirror2EntryPoint implements EntryPoint {


	public void onModuleLoad() {
		TestWidget test = new TestWidget();


		RootLayoutPanel.get().add(test);

	}
	public class TestWidget extends Composite {
		private CodeMirror2 editor;
		private CodeMirrorConf config = new CodeMirrorConf();
		public TestWidget(){

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

			config.setValue("class");
			config.setMode(mode);
			config.setLineNumbers(true);
			editor = new CodeMirror2(config);
			editor.setWidth("100%");
			editor.setHeight("100%");

			initWidget(editor);
		}                
	}
}
