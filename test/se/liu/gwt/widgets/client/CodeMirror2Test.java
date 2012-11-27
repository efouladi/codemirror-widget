package se.liu.gwt.widgets.client;


import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class CodeMirror2Test extends GWTTestCase {

	/**
	 * Must refer to a valid module that sources this class.
	 */

	private CodeMirror2 c;
	public String getModuleName() {
		return "se.liu.gwt.widgets.CodeMirror2JUnit";
	}

	
	public void gwtSetUp(){
		
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
		mode.put("isOperatorChar",new JSONString("\\+"));
		CodeMirrorConf config = new CodeMirrorConf();
		
		config.setMode(mode);
		config.setLineNumbers(true);
		
		c = new CodeMirror2(config);
		
	}	
	public void test_getCursor(){
		c.onLoad();
		
		
		c.setValue("test\ntest2");
		c.setCursor(0, 2);
		assertEquals(0, c.getCursor().getLine().intValue());
		assertEquals(2, c.getCursor().getCh().intValue());

	}

}
