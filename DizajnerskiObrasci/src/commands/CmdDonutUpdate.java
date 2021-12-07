package commands;

import java.awt.Color;

import shapes.Donut;

public class CmdDonutUpdate implements Command {
	
	private Donut oldState;
	private Donut newState;
	private Donut originalState;

	public CmdDonutUpdate(Donut oldState, Donut newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState = oldState.clone();
		oldState.setInnerRadius(newState.getInnerRadius());
		oldState.setOuterRadius(newState.getOuterRadius());
		oldState.setCenter(newState.getCenter().clone());
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
		oldState.setOuterRadius(originalState.getOuterRadius());
		oldState.setInnerRadius(originalState.getInnerRadius());
		oldState.setCenter(originalState.getCenter());
		oldState.setOutlineColor(originalState.getOutlineColor());
		oldState.setFillColor(originalState.getFillColor());	
	}
	
	@Override
	public String toString() {
		return "Updated->" + oldState.toString() + newState.toString();
	}
}