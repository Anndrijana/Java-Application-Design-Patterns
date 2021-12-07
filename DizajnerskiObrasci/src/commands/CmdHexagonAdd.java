package commands;

import adapterNew.HexagonAdapter;

import mvc.DrawingModel;

public class CmdHexagonAdd implements Command {
	
	private DrawingModel model;
	HexagonAdapter hexagon;

	public CmdHexagonAdd(DrawingModel model, HexagonAdapter hexagon) {
		this.model = model;
		this.hexagon = hexagon;
	}

	@Override
	public void execute() {
		model.addShape(hexagon);
	}

	@Override
	public void unexecute() {
		model.removeShape(hexagon);
	}
	
	@Override
	public String toString() {
		return "Added->"+hexagon.toString();
	}
}
