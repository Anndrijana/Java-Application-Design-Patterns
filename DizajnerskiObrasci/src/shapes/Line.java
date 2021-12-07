package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Line() {

	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, Color mainColor) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		setOutlineColor(mainColor);
	}

	public String toString() {
		 return "Line: start point x=" + startPoint.getX() + "; start point y=" + startPoint.getY() + "; end point x=" + endPoint.getX() + "; end point y=" + endPoint.getY() + "; color=" + getOutlineColor().toString().substring(14).replace('=', '-');
	}

	public double length() {
		double length = startPoint.distance(endPoint.getX(), endPoint.getY());
		return length;
	}
	
	 public Line clone() {
		return new Line(startPoint.clone(), endPoint.clone(), getOutlineColor());
	}
	
	public int compareTo(Object o) {
		if(o instanceof Line)
			return (int) (this.length() - ((Line)o).length());
		return 0;
	}

	public boolean contains(int x, int y) {
		double temp = startPoint.distance(x, y) + endPoint.distance(x, y);
		return temp - this.length() <=3;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line line = (Line) obj;
			return startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint);
		}
		return false;
	}
	
	public void draw(Graphics g) {
		g.setColor(getOutlineColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(isSelected()) {
			g.setColor(Color.RED);
			g.drawRect(startPoint.getX()-3, startPoint.getY()-3, 6, 6);
			g.drawRect(endPoint.getX()-3, endPoint.getY()-3, 6, 6);
		}
	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
	}
}