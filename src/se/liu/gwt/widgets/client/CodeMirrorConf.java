package se.liu.gwt.widgets.client;


public class CodeMirrorConf {

    /**
     * Describe lineNumbers here.
     */
    private boolean lineNumbers;
    String value;
    String mode;
   
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
    public String getMode(){
	return mode;
    }
    public void setMode(String mode){
	this.mode = mode;
    }

}