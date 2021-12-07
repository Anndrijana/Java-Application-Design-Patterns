package commands;

import mvc.DrawingModel;
import shapes.Shape;

public class CmdBringToFront implements Command {
	
	private DrawingModel model;
	private int beforeIndex;
	private Shape shape;
	
	public CmdBringToFront(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		beforeIndex=model.getIndexOfShape(shape);
		model.getShapes().remove(shape);
		model.getShapes().add(shape);
	}

	@Override
	public void unexecute() {
		model.getShapes().remove(shape);
		model.getShapes().add(beforeIndex, shape);
	}
	
	@Override
	public String toString() {
		return "Brought to front->" + shape.toString();
	}
}
