package commands;


import java.awt.Color;

import adapterNew.HexagonAdapter;
import hexagon.Hexagon;
import specialCase.InappropriateValue;

public class CmdHexagonUpdate implements Command {
	
	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter originalState = new HexagonAdapter(new Hexagon(0, 0, 0));
	
	public CmdHexagonUpdate(HexagonAdapter oldState, HexagonAdapter newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		originalState = oldState.clone();
		oldState.getHexagon().setX(newState.getHexagon().getX());
		oldState.getHexagon().setY(newState.getHexagon().getY());
		oldState.getHexagon().setR(newState.getHexagon().getR());
		
		if(newState.getHexagon().getBorderColor() == Color.BLACK && originalState.getHexagon().getBorderColor() != Color.BLACK) {
			oldState.getHexagon().setBorderColor(originalState.getHexagon().getBorderColor());
		} else {
			oldState.getHexagon().setBorderColor(newState.getHexagon().getBorderColor());
		}
		
		if(newState.getHexagon().getAreaColor()== Color.WHITE && originalState.getHexagon().getAreaColor()!= Color.WHITE) {
			oldState.getHexagon().setAreaColor(originalState.getHexagon().getAreaColor());
		} else {
			oldState.getHexagon().setAreaColor(newState.getHexagon().getAreaColor());
		}
	}

	@Override
	public void unexecute() {
		oldState.getHexagon().setX(originalState.getHexagon().getX());
		oldState.getHexagon().setY(originalState.getHexagon().getY());
		oldState.getHexagon().setR(originalState.getHexagon().getR());
		oldState.getHexagon().setBorderColor(originalState.getHexagon().getBorderColor());
		oldState.getHexagon().setAreaColor(originalState.getHexagon().getAreaColor());
	}

	@Override
	public String toString() {
		return "Updated->"+oldState.toString()+"->"+newState.toString();
	}	
}