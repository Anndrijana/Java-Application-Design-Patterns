package commands;

import mvc.DrawingModel;

import shapes.Line;

public class CmdLineAdd implements Command {
	
	private DrawingModel model;
	private Line line;

	public CmdLineAdd(DrawingModel model, Line line) {
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		model.addShape(line);
	}

	@Override
	public void unexecute() {
		model.removeShape(line);
	}
	
	@Override
	public String toString() {
		return "Added->" + line.toString();
	}
}
