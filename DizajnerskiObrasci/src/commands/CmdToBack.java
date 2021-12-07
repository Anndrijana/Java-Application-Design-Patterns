package commands;

import java.util.Collections;

import mvc.DrawingModel;

import shapes.Shape;

public class CmdToBack implements Command {
	
	private DrawingModel model;
	private int index;
	private Shape shape;
	
	public CmdToBack(DrawingModel model, int index, Shape shape) {
		this.model = model;
		this.index = index;
		this.shape = shape;
	}

	@Override
	public void execute() {
		if(index!=0) { 
			Collections.swap(model.getShapes(), index-1, index);
		}	
	}

	@Override
	public void unexecute() {
		if(index!=0) {
			Collections.swap(model.getShapes(), index, index-1);
		}
	}
	
	@Override
	public String toString() {
		return "Moved to back->" + shape.toString();
	}
}
