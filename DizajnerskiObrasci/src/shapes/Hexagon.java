package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.Serializable;

import specialCase.InappropriateValue;


public class Hexagon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private boolean selected;
	private int x;
	private int y;
	private int r;
	private Color borderColor;
	private Color areaColor; 
	
	public Hexagon() {
		
	}
	
	public Hexagon(int x, int y, int r) throws InappropriateValue {
		if(r>0) {
			this.x = x;
			this.y = y;
			setR(r);
		}
	}
	
	public Hexagon(int x, int y, int r, Color outlineColor, Color fillColor) throws InappropriateValue {
		if(r>0) {
			this.x = x;
			this.y = y;
			setR(r);
			borderColor = outlineColor;
			areaColor = fillColor;
		}
	}
	
	public void paint(Graphics g) {
		int[] xovi = new int[6];
		int[] yoni = new int[6];
		Polygon plg = new Polygon();
		int i;
		for (i = 0; i < 6; i++) {
			xovi[i] = (int)(this.x + this.r * Math.cos((i * 2) * Math.PI / 6.0D));
			yoni[i] = (int)(this.y + this.r * Math.sin((i * 2) * Math.PI / 6.0D));
			plg.addPoint(xovi[i], yoni[i]);
		} 
		if(this.areaColor!=null) {
			g.setColor(this.areaColor);
			g.fillPolygon(plg);
		}
		if(this.borderColor != null) {
			g.setColor(borderColor);
		} else {
			g.setColor(Color.BLACK);
		}
		g.drawPolygon(plg);
		if (this.selected) {
			g.setColor(Color.BLUE);
			for (i = 0; i < 6; i++)
				g.drawRect(xovi[i] - 2, yoni[i] - 2, 5, 5); 
		} 
	}

	public boolean doesContain(int x, int y) {
		Polygon plg = new Polygon();
		int i = 0;
		while (i < 6) {
			plg.addPoint((int)(this.x + this.r * Math.cos((i * 2) * Math.PI / 6.0D)), (int)(this.y + this.r * Math.sin((i * 2) * Math.PI / 6.0D)));
			i++;
		} 
		return plg.contains(x, y);
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return this.r;
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
	
	public Color getBorderColor() {
		return this.borderColor;
	}

	public Color getAreaColor() {
		return this.areaColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public void setAreaColor(Color areaColor) {
		this.areaColor = areaColor;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}