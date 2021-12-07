package commands;

import mvc.DrawingModel;

import shapes.Donut;

public class CmdDonutAdd implements Command {
	DrawingModel model;
	Donut donut;

	public CmdDonutAdd(DrawingModel model, Donut donut) {
		this.model = model;
		this.donut = donut;
	}
	
	@Override
	public void execute() {
		model.addShape(donut);
	}

	@Override
	public void unexecute() {
		model.removeShape(donut);
	}
	
	@Override
	public String toString() {
		return "Added->" + donut.toString();
	}
}
