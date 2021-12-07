package adapter;

import java.awt.Color;

import java.awt.Graphics;

import shapes.Hexagon;
import shapes.SurfaceShape;

import specialCase.InappropriateValue;

public class HexagonAdapter extends SurfaceShape {
	
	private static final long serialVersionUID = 1L;
	private Hexagon hexagon;
	
	public HexagonAdapter() {
		
	}
	
	public HexagonAdapter(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			Hexagon hex = ((HexagonAdapter) obj).hexagon;
			return hexagon.getX() == hex.getX() && hexagon.getY() == hex.getY() && hexagon.getR() == hex.getR();
		}
		return false;
	}
	
	public HexagonAdapter clone() {
		Hexagon h;
		try {
			h = new Hexagon(hexagon.getX(), hexagon.getY(), hexagon.getR());
			h.setBorderColor(hexagon.getBorderColor());
			h.setAreaColor(hexagon.getAreaColor());
			return new HexagonAdapter(h);
		} catch (InappropriateValue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
	}

	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Hexagon: radius=" + hexagon.getR() + "; x=" + hexagon.getX() + "; y=" + hexagon.getY() + "; edge color=" + getColor().toString().substring(14).replace('=', '-') + "; area color=" + getInteriorColor().toString().substring(14).replace('=', '-');
	}
	
	public Color getColor() {
		return hexagon.getBorderColor();
	}
	
	public void setColor(Color color) {
		hexagon.setBorderColor(color);
		super.setOutlineColor(color);
	}
	
	public Color getInteriorColor() {
		return hexagon.getAreaColor();
	}
	
	public void setInteriorColor(Color color) {
		hexagon.setAreaColor(color);
		super.setFillColor(color);
	}
	
	public void setSelected(boolean selected) {
		this.hexagon.setSelected(selected);
	}
	
	public int getR() {
		return hexagon.getR();
	}
	
	public void setR(int r) throws InappropriateValue {
		hexagon.setR(r);
	}
	
	public int getX() {
		return hexagon.getX();
	}
	
	public int getY() {
		return hexagon.getY();
	}
	
	public void setX(int x) {
		hexagon.setX(x);
	}
	
	public void setY(int y) {
		hexagon.setY(y);
	}
}