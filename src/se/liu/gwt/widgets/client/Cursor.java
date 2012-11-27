package se.liu.gwt.widgets.client;

public class Cursor {
	private Integer line;
	private Integer ch;
	
	public Cursor(Integer line, Integer ch){
		this.line= line;
		this.ch= ch;
		
	}
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
	}
	public Integer getCh() {
		return ch;
	}
	public void setCh(Integer ch) {
		this.ch = ch;
	}
	
	@Override
	public String toString(){
		
		return "{line:'"+line+"',ch:'"+ch+"'}";
	}
	
}
