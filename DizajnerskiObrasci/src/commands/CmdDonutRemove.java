package commands;

import mvc.DrawingModel;
import shapes.Donut;

public class CmdDonutRemove implements Command {
	
	private DrawingModel model;
	private Donut donut;
	
	public CmdDonutRemove(DrawingModel model, Donut donut) {
		this.model = model;
		this.donut = donut;
	}

	@Override
	public void execute() {
		model.removeShape(donut);	
	}

	@Override
	public void unexecute() {
		model.addShape(donut);	
	}
}
