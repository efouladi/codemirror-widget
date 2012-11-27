package se.liu.gwt.widgets.client;

import java.io.Serializable;

public class CursorCoords implements Serializable{
	private Integer x;
	private Integer y;
	private Integer yBot;
		public CursorCoords(Integer x, Integer y, Integer yBot){
			this.x = x;
			this.y = y;
			this.yBot = yBot;
		}


	/**
	 * Gets the x for this instance.
	 *
	 * @return The x.
	 */
	public Integer getX() {
		return this.x;
	}

	/**
	 * Gets the y for this instance.
	 *
	 * @return The y.
	 */
	public Integer getY() {
		return this.y;
	}

	/**
	 * Gets the yBot for this instance.
	 *
	 * @return The yBot.
	 */
	public Integer getYBot() {
		return this.yBot;
	}

}
