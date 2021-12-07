package commands;

import mvc.DrawingModel;
import shapes.Shape;

public class CmdUnselect implements Command {
	
	private DrawingModel model;
	private Shape selectedShape;
	
	public CmdUnselect(DrawingModel model, Shape selectedShape) {
		this.model = model;
		this.selectedShape = selectedShape;
	}

	@Override
	public void execute() {
		model.getShapes().get(model.getShapes().indexOf(selectedShape)).setSelected(false);
		model.getSelectedShapes().remove(selectedShape);
	}

	@Override
	public void unexecute() {
		model.getShapes().get(model.getShapes().indexOf(selectedShape)).setSelected(true);
		model.getSelectedShapes().add(selectedShape);
	}
}
