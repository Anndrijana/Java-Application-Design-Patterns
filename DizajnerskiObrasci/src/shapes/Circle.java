package shapes;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import specialCase.InappropriateValue;

public class Circle extends SurfaceShape {
	
	protected Point center;
	protected int r;
	protected boolean selected;
	private boolean confirmation;

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}
	
	public Circle() {

	}

	public Circle(Point center, int r) {

		this.center = center;
		try {
			setR(r);
		} catch (InappropriateValue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Circle(Point center, int r, Color outlineColor, Color fillColor) throws InappropriateValue {
		this.center = center;
		setR(r);
		setOutlineColor(outlineColor);
		setFillColor(fillColor);
	}

	public Circle(Point center, int r, boolean selected) throws InappropriateValue {
		this(center, r);
		this.selected = selected;
	}

	public String toString() {
		return "Circle: radius=" + r + "; x=" + center.getX() + "; y=" + center.getY() + "; edge color=" + getOutlineColor().toString().substring(14).replace('=', '-') + "; area color=" + getFillColor().toString().substring(14).replace('=', '-');
	}

	public boolean contains(int x, int y) {
		double temp = center.distance(x, y);
		return temp <= r;
	}
	
	public Circle clone() {
    	try {
			return new Circle(center.clone(), r, getOutlineColor(), getFillColor());
		} catch (InappropriateValue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	
	public void draw(Graphics g) {
			g.setColor(getFillColor());
			g.fillOval(center.getX()-r, center.getY()-r, 2*r-1, 2*r-1);
			g.setColor(getOutlineColor());
		g.drawOval(center.getX()-r, center.getY()-r, 2*r, r+r);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - r - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() + r - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() - r - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() + r - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() - 3, 6, 6);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle circle = (Circle) obj;
			return center.equals(circle.getCenter()) && r == circle.getR();
		}
		return false;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Circle)
			return (int) ((this.area())-((Circle)o).area());
		return 0;
	}

	public double area() {
		return r*r*Math.PI;
	}

	public void moveBy(int x, int y) {
		center.moveBy(x, y);
	}
	
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) throws InappropriateValue {
		if(r > 0)
		{
			this.r = r;
		}
		else
		{
			throw new InappropriateValue("Radius has to be a value greater than 0!");
		}
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}