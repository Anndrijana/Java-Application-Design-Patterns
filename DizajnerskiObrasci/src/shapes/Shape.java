package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Comparable, Serializable, Moveable, Cloneable {
	
	boolean selected;
	private Color outlineColor;
	
	public Shape() {
		
	}
	 
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public Color getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}

	public abstract boolean contains(int x, int y);
	
	public abstract void draw(Graphics g);
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}	
}