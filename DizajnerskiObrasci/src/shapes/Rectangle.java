package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends SurfaceShape {
	
	private static final long serialVersionUID = 1L;
	private Point upperLeftPoint;
	private int width;
	private int height;
	private boolean confirmation;

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color outlineColor, Color fillColor) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
		setOutlineColor(outlineColor);
		setFillColor(fillColor);
	}

	public Rectangle(Point upperLeftPoint,int width, int height, boolean selected) {
		this(upperLeftPoint,width,height);
		this.selected = selected;
	}
	
	public Rectangle(int x, int y, int width, int height)
	{
		upperLeftPoint.setX(x);
		upperLeftPoint.setY(y);
		this.width = width;
		this.height = height;
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public Rectangle clone() {
    	return new Rectangle(upperLeftPoint.clone(), width, height, getOutlineColor(), getFillColor());
    }
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Rectangle)
			return this.area() - ((Rectangle)o).area();
		return 0;
	}

	public boolean contains(int x, int y) {
		return (x >= upperLeftPoint.getX() &&
				x <= upperLeftPoint.getX() + width &&
				y >= upperLeftPoint.getY() &&
				y <= upperLeftPoint.getY() + height);
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle rectangle = (Rectangle) obj;
			return upperLeftPoint.equals(rectangle.upperLeftPoint) && width == rectangle.getWidth() && height == rectangle.getHeight();
		}
		return false;
	}
	
	public void draw(Graphics g) {
			g.setColor(getFillColor());
			g.fillRect(upperLeftPoint.getX()+1, upperLeftPoint.getY()+1, width-1, height-1);
			g.setColor(getOutlineColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeftPoint.getX() - 3, upperLeftPoint.getY() - 3, 6, 6);
			g.drawRect(upperLeftPoint.getX() + width - 3, upperLeftPoint.getY() - 3, 6, 6);
			g.drawRect(upperLeftPoint.getX() - 3, upperLeftPoint.getY() + height - 3, 6, 6);
			g.drawRect(upperLeftPoint.getX() + width  - 3, upperLeftPoint.getY() + height - 3, 6, 6);
		}
	}
	
	public int area() {
		return width*height;
	}
	
	@Override
	public String toString() {
		return "Rectangle: x=" + upperLeftPoint.getX() + "; y=" + upperLeftPoint.getY() + "; height=" + height + "; width=" + width + "; edge color=" + getOutlineColor().toString().substring(14).replace('=', '-') + "; area color=" + getFillColor().toString().substring(14).replace('=', '-');
	}
}