package commands;

import java.awt.Color;

import shapes.Point;
import shapes.Rectangle;

public class CmdRectangleUpdate implements Command {
	
	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle originalState = new Rectangle(new Point(), 1, 1);
	
	public CmdRectangleUpdate(Rectangle oldState, Rectangle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState = oldState.clone();
		oldState.getUpperLeftPoint().setX(newState.getUpperLeftPoint().getX());
		oldState.getUpperLeftPoint().setY(newState.getUpperLeftPoint().getY());
		if(newState.getOutlineColor() == Color.BLACK && originalState.getOutlineColor() != Color.BLACK) {
			oldState.setOutlineColor(originalState.getOutlineColor());
		} else {
			oldState.setOutlineColor(newState.getOutlineColor());
		}
		
		if(newState.getFillColor() == Color.WHITE && originalState.getFillColor() != Color.WHITE) {
			oldState.setFillColor(originalState.getFillColor());
		} else {
			oldState.setFillColor(newState.getFillColor());
		}
	}

	@Override
	public void unexecute() {
		oldState.getUpperLeftPoint().setX(originalState.getUpperLeftPoint().getX());
		oldState.getUpperLeftPoint().setY(originalState.getUpperLeftPoint().getY());
		oldState.setHeight(originalState.getHeight());
		oldState.setWidth(originalState.getWidth());
		oldState.setOutlineColor(originalState.getOutlineColor());
		oldState.setFillColor(originalState.getFillColor());
	}
	
	@Override
	public String toString() {
		return "Updated->" + oldState.toString() + "->" + newState.toString();
	}
}