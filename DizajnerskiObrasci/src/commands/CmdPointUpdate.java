package commands;

import java.awt.Color;

import shapes.Point;

public class CmdPointUpdate implements Command {
	
	private Point oldState;
	private Point newState;
	private Point originalState = new Point();
	
	public CmdPointUpdate( Point oldState, Point newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	public void execute() {
		originalState = oldState.clone();
		oldState.setX(newState.getX());
		oldState.setY(newState.getY());
		if(newState.getOutlineColor() == Color.BLACK && originalState.getOutlineColor() != Color.BLACK) {
			oldState.setOutlineColor(originalState.getOutlineColor());
		} else {
			oldState.setOutlineColor(newState.getOutlineColor());
		}
	}
 
	@Override
	public void unexecute() {
		oldState.setX(originalState.getX());
		oldState.setY(originalState.getY());   	
		oldState.setOutlineColor(originalState.getOutlineColor());
	}
	
	@Override
	public String toString() {
		return "Updated->"+oldState.toString() + "->" + newState.toString();
	}
}