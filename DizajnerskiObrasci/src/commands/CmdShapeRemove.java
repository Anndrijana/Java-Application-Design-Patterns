package commands;

import mvc.DrawingModel;
import shapes.Shape;

public class CmdShapeRemove implements Command {
	
	private DrawingModel model;
	private Shape shape;
	
	public CmdShapeRemove(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		model.removeShape(shape);
		model.getSelectedShapes().remove(shape);
	}

	@Override
	public void unexecute() {
		model.getShapes().add(shape);
	}
	
	@Override
	public String toString() {
		return "Deleted->" + shape.toString();
	}
}
