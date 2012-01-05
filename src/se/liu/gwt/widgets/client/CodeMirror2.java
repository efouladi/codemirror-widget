package se.liu.gwt.widgets.client;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.dom.client.Document;
import com.google.gwt.resources.client.CommonResources;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CodeMirror2 extends Widget implements HasValue<String>,HasValueChangeHandlers<String>, HasChangeHandlers{
    private JavaScriptObject editor;
    private Element host;
    private static int nextId =0;
    private String id;
    private CodeMirrorConf config;
    private boolean valueChangeHandlerInitialized = false;
    
    public CodeMirror2(CodeMirrorConf config){
//	super();

	id = "codemirror-editor-"+(++nextId);
	
	host = Document.get().createDivElement();
	host.setClassName(CommonResources.getInlineBlockStyle());
	host.setId(id);
	setElement(host);
	//setStyleName("gwt-CodeMirror");
	this.config = config;


    }
    public void onLoad(){
//	super.onLoad();
	editor = this.initEditor(config);	
	this.focus();	
	this.refresh();
    }
    private native JavaScriptObject initEditor(CodeMirrorConf conf)/*-{
			 
	var id = this.@se.liu.gwt.widgets.client.CodeMirror2::id;
	var mode = this.@se.liu.gwt.widgets.client.CodeMirror2::getParserConfig(Lse/liu/gwt/widgets/client/ModeDTO;)(conf.@se.liu.gwt.widgets.client.CodeMirrorConf::getMode()());
	var value = conf.@se.liu.gwt.widgets.client.CodeMirrorConf::getValue()();
	var lineNumber = conf.@se.liu.gwt.widgets.client.CodeMirrorConf::isLineNumbers()();

	


	codemirror = new $wnd.CodeMirror($doc.getElementById(id), {
	  value: value,
	  mode: mode,
	  lineNumbers: lineNumber
	});
	return codemirror;
	}-*/;
	private native JavaScriptObject getParserConfig(ModeDTO mode)/*-{
	    var keywords = mode.@se.liu.gwt.widgets.client.ModeDTO::getKeywordsJSON()();
	    var stringCh = mode.@se.liu.gwt.widgets.client.ModeDTO::getStringCh()();
	    var isOperatorChar = mode.@se.liu.gwt.widgets.client.ModeDTO::getIsOperatorChar()();
	    var commentSingle = mode.@se.liu.gwt.widgets.client.ModeDTO::getCommentSingle()();
	    var commentMStart = mode.@se.liu.gwt.widgets.client.ModeDTO::getCommentMStart()();
	    var commentMEnd = mode.@se.liu.gwt.widgets.client.ModeDTO::getCommentMEnd()();
	    var escapeCh = mode.@se.liu.gwt.widgets.client.ModeDTO::getEscapeCh()();
	    
	 parserConfig = {
				name : "basemode",
				keywords : {"class": "true", "System":"true"},
				stringCh : ["\"","\'"],
				isOperatorChar : /[isOperatorChar]/,
				commentSingle : commentSingle,
				commentMStart : commentMStart,
			    commentMEnd : commentMEnd,
			    escapeCh : escapeCh
				
			};
			//$wnd.alert(parserConfig.keywords);
		return parserConfig;										   
	}-*/;

    private native String getContent()/*-{
	    var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
	    return editor.getValue();
	    }-*/;
    private native void setContent(String content)/*-{
	    editor.setValue(content);
	    }-*/;
    private native void focus()/*-{
	    var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
	    return editor.focus();
	    }-*/;
    private native void refresh()/*-{
	    var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
	    return editor.refresh();
	    }-*/;
    private native void mode(ModeDTO mode)/*-{
		
	    var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
	    var keywords = mode.@se.liu.gwt.widgets.client.ModeDTO::getKeywords()();
	    var stringCh = mode.@se.liu.gwt.widgets.client.ModeDTO::getStringCh()();
	    var isOperatorChar = mode.@se.liu.gwt.widgets.client.ModeDTO::getIsOperatorChar()();
	    var commentSingle = mode.@se.liu.gwt.widgets.client.ModeDTO::getCommentSingle()();
	    var commentMStart = mode.@se.liu.gwt.widgets.client.ModeDTO::getCommentMStart()();
	    var commentMEnd = mode.@se.liu.gwt.widgets.client.ModeDTO::getCommentMEnd()();
	    var escapeCh = mode.@se.liu.gwt.widgets.client.ModeDTO::getEscapeCh()();
	    var keywordsJSON = "{";
	    for (var i ;i<keywords.length ;i++ ){
	    	if(i==keywords.length)
			keywordsJSON = keywordsJSON + keywords[i] +": true";
		else
			
			keywordsJSON = keywordsJSON + keywords[i] +": true,";

	    
	    }
	    	keywordsJSON = keywordsJSON +"}"; 
	 parserConfig = {
				name : "basemode",
				keywords : keywordsJSON,
				stringCh : stringCh,
				isOperatorChar : /[isOperatorChar]/,
				commentSingle : commentSingle,
				commentMStart : commentMStart,
			    commentMEnd : commentMEnd,
			    escapeCh : escapeCh
				
			};
			//for (var p in parserConfig)
				$wnd.alert("test");	
			editor.setOption("mode",parserConfig);
	
	}-*/;
    public String getValue(){
	return getContent();
    }
    public void setValue(String value){
	setContent(value);
    }
    public void setValue(String value, boolean fireEvents) {
	String oldValue = getContent();
	setContent(value);
	if (fireEvents) {
	    ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
	}
    }
    public void setMode(ModeDTO mode){
	this.mode(mode);	    
    }
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
	// Initialization code
	if (!valueChangeHandlerInitialized) {
	    valueChangeHandlerInitialized = true;
	    addChangeHandler(new ChangeHandler() {
		    public void onChange(ChangeEvent event) {
			ValueChangeEvent.fire(CodeMirror2.this, getValue());
		    }
		});
	}
	return addHandler(handler, ValueChangeEvent.getType());
    }
    public HandlerRegistration addChangeHandler(ChangeHandler handler) {
                return addDomHandler(handler, ChangeEvent.getType());
    }
    
}

