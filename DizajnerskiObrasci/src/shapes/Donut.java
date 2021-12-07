package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import specialCase.InappropriateValue;

public class Donut extends Circle {

	private static final long serialVersionUID = 1L;
	private int innerRadius;
	private int outerRadius;
	private Color outlineColor;
	private Color fillColor;
	private boolean confirmation;
	
	public Color getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor; 
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}
	
	public int getOuterRadius() {
		return outerRadius;
	}

	public void setOuterRadius(int outerRadius) {
		this.outerRadius = outerRadius;
	}

	public Donut() {

	}
	
	public Donut(Point center, int outerRadius, int innerRadius) throws InappropriateValue {
		super(center,outerRadius);
		if(innerRadius < outerRadius)
		{
			this.innerRadius = innerRadius;
			this.outerRadius = outerRadius;
		}
		else
		{
			throw new InappropriateValue("Inner radius can't be smaller than outer radius!");
		}
	}
	
	public Donut(Point center, int outerRadius, int innerRadius, Color outlineColor, Color fillColor) throws InappropriateValue {
		super(center,outerRadius);
		if(innerRadius < outerRadius)
		{
			this.innerRadius = innerRadius;
			this.outerRadius = outerRadius;
			this.outlineColor = outlineColor;
			this.fillColor = fillColor;
		}
		else
		{
			throw new InappropriateValue("Inner radius can't be smaller than outer radius!");
		}
	}

	public Donut(Point center, int outerRadius, int innerRadius, boolean selected) throws InappropriateValue {
		this(center, outerRadius, innerRadius);
		this.selected = selected;
	}
	
	public String toString() {
		return "Donut: radius=" + outerRadius + "; x=" + center.getX() + "; y=" + center.getY() + "; edge color=" + getOutlineColor().toString().substring(14).replace('=', '-') + "; area color=" + getFillColor().toString().substring(14).replace('=', '-') + "; inner radius=" + innerRadius;
	}

	public double area() {
		return super.area() - (innerRadius * innerRadius * Math.PI);
	}
	
	public Donut clone() {
    	try {
			return new Donut(center.clone(), outerRadius, innerRadius, getOutlineColor(), getFillColor());
		} catch (InappropriateValue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) && this.getOuterRadius() == d.getOuterRadius() && this.innerRadius == d.getInnerRadius()) {
				return true;
			} 
			else {
				return false;
			}
		} 
		else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(x, y) > innerRadius;
	}

	public void draw(Graphics g) {
		Color color = new Color (255.0f / 255.0f, 255.0f / 255.0f, 221.0f / 255.0f, 0.0f); 
		g.setColor(color);
		
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		
		if (getFillColor() != null) {
			g.setColor(getFillColor());
			for(int i = getInnerRadius(); i < getOuterRadius(); i++) {
				g.drawOval(this.getCenter().getX() - i,
						  this.getCenter().getY() - i, i * 2,
						  i * 2);		
			}	
		}
		
		if (getOutlineColor() != null)
			g.setColor(getOutlineColor());
		g.drawOval(this.getCenter().getX() - this.getOuterRadius(), this.getCenter().getY() - this.getOuterRadius(),
				this.getOuterRadius() * 2, this.getOuterRadius() * 2);
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		
		g.setColor(new Color(0, 0, 0));
		if (isSelected()) {
			g.setColor(Color.RED);
			g.drawRect(this.getCenter().getX() - innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - innerRadius - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + innerRadius - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - outerRadius - 3 , this.getCenter().getY() , 6, 6);
			g.drawRect(this.getCenter().getX() + outerRadius - 3 , this.getCenter().getY() , 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - outerRadius - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + outerRadius - 3, 6, 6);
		}
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
}