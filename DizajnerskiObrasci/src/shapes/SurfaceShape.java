package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class SurfaceShape extends Shape {
	
	private static final long serialVersionUID = 1L;
	private Color fillColor;
	
	public Color getFillColor() {
		return fillColor;
	}
 
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub	
	}
}