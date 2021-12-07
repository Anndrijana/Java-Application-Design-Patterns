package commands;

import mvc.DrawingModel;
import shapes.Circle;

public class CmdCircleAdd implements Command {
	
	DrawingModel model;
	Circle circle;

	public CmdCircleAdd(DrawingModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.addShape(circle);
	}

	@Override
	public void unexecute() {
		model.removeShape(circle);
	}
	
	@Override
	public String toString() {
		return "Added->"+circle.toString();
	}
}
