package commands;

import mvc.DrawingModel;

import shapes.Point;

public class CmdPointAdd implements Command {
	
	private DrawingModel model;
	private Point point;
	
	public CmdPointAdd(DrawingModel model, Point point) {
		this.model = model;
		this.point = point;
	}
	
	@Override
	public void execute() {
		model.addShape(point);
	}

	@Override
	public void unexecute() {
		model.removeShape(point);
	}
	
	@Override
	public String toString() {
		return "Added->" + point.toString();
	}
}
