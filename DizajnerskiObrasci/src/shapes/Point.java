package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	
	private int x;
	private int y;

	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		setOutlineColor(color);
	}

	@Override
	public String toString() {
		return "Point: x=" + x + "; y=" + y + "; color=" + getOutlineColor().toString().substring(14).replace('=', '-');
	}
	
	@Override 
	public boolean equals(Object obj) {
		Point temp;
		if(obj instanceof Point) {
			temp = (Point) obj;
					return (this.x == temp.x && this.y == temp.y);
		}
		return false;
	}
	
	public double distance(int x, int y) {
		int dx = this.x-x;
		int dy = this.y-y;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Point)
			return (int) (this.distance(0,0)-((Point) o).distance(0,0));
		return 0;
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y)<=3;
	}
	
	public Point clone() {
    	return new Point(x, y, getOutlineColor());
    }
	
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void draw(Graphics g) {
		g.setColor(getOutlineColor());
		g.drawLine(x - 2, y, x + 2, y);
	    g.drawLine(x, y + 2, x, y - 2);
	    	if(isSelected()) {
	    		g.setColor(Color.BLUE);
	        	g.drawRect(x-3, y-3, 6, 6);
	        }
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}