package se.liu.gwt.widgets.client;

import com.google.gwt.core.client.JavaScriptObject;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class CodeMirrorConf {

    /**
     * Describe lineNumbers here.
     */
    private boolean lineNumbers;
    String value;
    JSONObject mode;
   
    /**
     * Get the <code>LineNumbers</code> value.
     *
     * @return a <code>boolean</code> value
     */
    public final boolean isLineNumbers() {
	return lineNumbers;
    }

    /**
     * Set the <code>LineNumbers</code> value.
     *
     * @param newLineNumbers The new LineNumbers value.
     */
    public final void setLineNumbers(final boolean newLineNumbers) {
	this.lineNumbers = newLineNumbers;
    }
    public String getValue(){
	return value;
    }
    public void setValue(String value){
	this.value = value;
    }
    public JavaScriptObject getModeObject(){
	return mode.getJavaScriptObject();
    }
    public JSONObject getMode(){
	return mode;
    }
    public void setMode(String mode){
	   JSONObject json = new JSONObject();
	    json.put("name",new JSONString(mode));
	    this.mode =json;
    }
    public void setMode(JSONObject mode){ 
	    this.mode = mode;
    }

}
