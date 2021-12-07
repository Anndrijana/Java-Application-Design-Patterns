package commands;

import mvc.DrawingModel;

import shapes.Rectangle;

public class CmdRectangleAdd implements Command {
	
	private DrawingModel model;
	private Rectangle rectangle;

	public CmdRectangleAdd(DrawingModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}
	
	@Override
	public void execute() {
		model.addShape(rectangle);
	}

	@Override
	public void unexecute() {
		model.removeShape(rectangle);
	}
	
	@Override
	public String toString() {
		return "Added->" + rectangle.toString();
	}
}
