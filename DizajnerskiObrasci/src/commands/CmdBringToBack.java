package commands;

import mvc.DrawingModel;
import shapes.Shape;

public class CmdBringToBack implements Command {
	
	private DrawingModel model;
	private int index;
	private Shape shape;

	public CmdBringToBack(DrawingModel model, int index, Shape shape) {
		this.model = model;
		this.index = index;
		this.shape = shape;
	}

	@Override
	public void execute() {
		if(index != 0) {
			model.getShapes().remove(shape);
			model.getShapes().add(0, shape);
		}
	}

	@Override
	public void unexecute() {
		model.getShapes().remove(shape);
		model.getShapes().add(index, shape);
	}
	
	@Override
	public String toString() {
		return "Brought to back->" + shape.toString();
	}
}
