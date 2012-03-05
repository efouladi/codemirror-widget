package se.liu.gwt.widgets.client;

import com.google.gwt.json.client.JSONObject;

import com.google.gwt.user.client.DOM;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.dom.client.Document;
import com.google.gwt.resources.client.CommonResources;
import com.google.gwt.user.client.ui.RequiresResize;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CodeMirror2 extends FocusWidget implements HasValue<String>,HasValueChangeHandlers<String>, HasChangeHandlers, RequiresResize, IsWidget{
    private JavaScriptObject editor;
    private Element host;
    private static int nextId =0;
    private String id;
    private CodeMirrorConf config;
    private boolean valueChangeHandlerInitialized = false;
    //private boolean isResized = false;
    public CodeMirror2(CodeMirrorConf config){
		super();
	
		id = "codemirror-editor-"+(++nextId);
		
		host = DOM.createDiv();
	//	host.setClassName(CommonResources.getInlineBlockStyle());
		host.setId(id);
		setElement(host);
		//setStyleName("gwt-CodeMirror");
		this.config = config;
		

    }
    public void onLoad(){
		//super.onLoad();
		
		editor = this.initEditor(config);	
		
		  Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
	             @Override
	             public void execute() {
	            	 onResize();
	            	 setFocus(true);
	             }
	         });
		
		this.refreshNative();
		

    }
    
   private native JavaScriptObject initEditor(CodeMirrorConf conf)/*-{
			 
	var id = this.@se.liu.gwt.widgets.client.CodeMirror2::id;
	var mode =conf.@se.liu.gwt.widgets.client.CodeMirrorConf::getModeObject()();
	var value = conf.@se.liu.gwt.widgets.client.CodeMirrorConf::getValue()();
	var lineNumber = conf.@se.liu.gwt.widgets.client.CodeMirrorConf::isLineNumbers()();



	codemirror = new $wnd.CodeMirror($doc.getElementById(id), {
	  value: value ,
	  width: "100px",
      height: "100px",
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
	    var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
	    editor.setValue(content);
	    }-*/;
    private native void focusNative()/*-{
	    var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
	    editor.focus();
	    }-*/;
    private native void refreshNative()/*-{
	    var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
	    editor.refresh();
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
    private native void setOption(String option,JavaScriptObject value)/*-{
   		 
	    var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
	    editor.setOption(option,value);
    
    
    	}-*/;
    private native void setMarkerNative(int line)/*-{
    		var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
    		editor.setMarker(line,"\u25cf");
    	}-*/;
    private native void clearMarkerNative(int line)/*-{
		var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
		editor.clearMarker(line);
		}-*/;
    private native void setCursorNative(int line, int ch)/*-{
   		var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
   		editor.setCursor(line, ch);
   		}-*/;
    private native void setSizeNative(String width, String height)/*-{
		var editor= this.@se.liu.gwt.widgets.client.CodeMirror2::editor;
		editor.getScrollerElement().width = width;
		editor.getScrollerElement().height = height;
		editor.refresh();
		}-*/;

    @Override
    public void setFocus(boolean focused){
    	super.setFocus(focused);
    	if(focused)	
    		focusNative();
    	
    }
    public void setCursor(Integer line,Integer ch){
    	
    	this.setCursorNative(line,ch);
    	
    }
    
    public void setMarker(Integer line){
    	this.setMarkerNative(line);
    	
    }
    public void clearMarker(Integer line){
    	this.clearMarkerNative(line);
    	
    }
    public String getValue(){
	return getContent();
    }
    public void refresh() {
    
    	refreshNative();
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
    public void setMode(JSONObject mode){
	this.setOption("mode",mode.getJavaScriptObject());	    
	this.refresh();

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
    public void onResize() {

    	 int height = getParent().getOffsetHeight();
         int width = getParent().getOffsetWidth();
         setSize(width+"px",height+"px");
        
       
         
     }
    
   
    
    @Override
    public void setSize(String width, String height) {
    	// TODO Auto-generated method stub
    	
    	
    	if(editor!=null){
    		setSizeNative(width, height);
    	}
    }
    public Widget asWidget(){
    	return this;
    
    }

}

