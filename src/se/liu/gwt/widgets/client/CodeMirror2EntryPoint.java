/**
 *      @author Dominik Guzei
 *      Project: StyleKit - Qualifikationsprojekt 1
 *      Fachhochschule Salzburg
 *
 */

package se.liu.gwt.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import se.liu.gwt.widgets.client.CodeMirrorConf;
import se.liu.gwt.widgets.client.CodeMirror2;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;

/**
 * This is the Test class for development of CodeMirror
 * @author dominikguzei
 *
 */

public class CodeMirror2EntryPoint implements EntryPoint {
        
        
        // set up logging to catch exceptions in browser
        public void onModuleLoad() {
	    TestWidget test = new TestWidget();

	
	    RootLayoutPanel.get().add(test);
        
        }
    public class TestWidget extends Composite {
	private CodeMirror2 editor;
        private CodeMirrorConf config = new CodeMirrorConf();
	public TestWidget(){
	    	    
                ModeDTO mode = new ModeDTO();
		String[] k ={"class","System"};
		String[] s = {"\"","\'"};
		mode.setKeywords(k);
		mode.setCommentSingle("//");
		mode.setCommentMStart("/*");
		mode.setCommentMEnd("*/");
		mode.setEscapeCh('\\');
		
		mode.setStringCh(s);
		mode.setIsOperatorChar("+");
        
                config.setValue("class");
		config.setMode(mode);
		config.setLineNumbers(true);
		editor = new CodeMirror2(config);
		editor.setWidth("100%");
		editor.setHeight("100%");
		
		ScrollPanel sp = new ScrollPanel();
		//sp.setHeight("100%");
                //sp.setWidth("100%");
		//sp.add(editor);
              	initWidget(editor);
	}                
    }
}
