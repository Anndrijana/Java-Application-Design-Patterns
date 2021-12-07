package commands;

import java.awt.Color;

import shapes.Circle;
import shapes.Point;

import specialCase.InappropriateValue;

public class CmdCircleUpdate implements Command {
	
	private Circle oldState;
	private Circle newState;
	
	private Circle originalState = new Circle(new Point(), 1);
	
	public CmdCircleUpdate(Circle oldState, Circle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState = oldState.clone();
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		try {
			oldState.setR(newState.getR());
		} catch (InappropriateValue e) {
			e.printStackTrace();
		}
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
		oldState.getCenter().setX(originalState.getCenter().getX());
		oldState.getCenter().setY(originalState.getCenter().getY());
		try {
			oldState.setR(originalState.getR());
		} catch (InappropriateValue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oldState.setOutlineColor(originalState.getOutlineColor());
		oldState.setFillColor(originalState.getFillColor());
	}

	@Override
	public String toString() {
		return "Updated->"+oldState.toString()+"->"+newState.toString();
	}
}