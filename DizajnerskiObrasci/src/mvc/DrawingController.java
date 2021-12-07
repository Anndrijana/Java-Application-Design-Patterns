package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import adapterNew.HexagonAdapter;

import commands.CmdBringToBack;
import commands.CmdBringToFront;
import commands.CmdCircleAdd;
import commands.CmdCircleUpdate;
import commands.CmdDonutAdd;
import commands.CmdDonutUpdate;
import commands.CmdHexagonAdd;
import commands.CmdHexagonUpdate;
import commands.CmdLineAdd;
import commands.CmdLineUpdate;
import commands.CmdPointAdd;
import commands.CmdPointUpdate;
import commands.CmdRectangleAdd;
import commands.CmdRectangleUpdate;
import commands.CmdSelect;
import commands.CmdShapeRemove;
import commands.CmdToBack;
import commands.CmdToFront;
import commands.CmdUnselect;
import commands.Command;

import dialogs.DlgChoice;
import dialogs.DlgCircle;
import dialogs.DlgCircleUpdate;
import dialogs.DlgDonut;
import dialogs.DlgDonutUpdate;
import dialogs.DlgHexagonUpdate;
import dialogs.DlgLine;
import dialogs.DlgPoint;
import dialogs.DlgRectangle;
import dialogs.DlgRectangleUpdate;

import shapes.Circle;
import shapes.Donut;
import hexagon.Hexagon;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import shapes.Shape;

import specialCase.InappropriateValue;

import strategy.FileManager;
import strategy.SerializeDrawing;
import strategy.SerializeFile;
import strategy.SerializeLog;

public class DrawingController implements PropertyChangeListener {

	private DrawingModel model;
	private DrawingFrame frame;
	
	private Color outColor = Color.BLACK;
	private Color inColor = Color.WHITE;
	
	private DefaultListModel<String> actLog;
	private FileManager fileManager;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		this.actLog = frame.getDlmList();
	}
	
	public void mouseClicked(MouseEvent e) throws InappropriateValue {
		stateChecker(e);
		if(checkShapes(e) == false) {
			unselectAll();
		}
		frame.getView().repaint();
	}
	
	private PropertyChangeEvent pce;
	@Override 
	public void propertyChange(PropertyChangeEvent evt) {
		this.pce = evt;
		if((int) evt.getNewValue() == 1 && evt.getPropertyName() == "Selected Shapes" || model.getSelectedShapes().size() == 1) {
			frame.getTglBtnModify().setVisible(true);
		} 
		else {
			frame.getTglBtnModify().setVisible(false);
		}
		if((int) evt.getNewValue() == 1 && evt.getPropertyName() == "Selected Shapes" || model.getSelectedShapes().size() > 0) {
			frame.getTglBtnDelete().setVisible(true);
		} else {
			frame.getTglBtnDelete().setVisible(false);
		}
		if((int) evt.getNewValue() == 0 && evt.getPropertyName() == "Deleted Shapes") {
			frame.getTglBtnModify().setVisible(false);
			frame.getTglBtnDelete().setVisible(false);
		}
		if(evt.getPropertyName() == "Undo Stack" && (int) evt.getNewValue() > 0) {
			frame.getBtnUndo().setVisible(true);
		} else if ((int)evt.getNewValue() == 0 && evt.getPropertyName() == "Undo Stack Remove"){
			frame.getBtnUndo().setVisible(false);
		}

		if(evt.getPropertyName() == "Redo Stack" && (int) evt.getNewValue() > 0) {
			frame.getBtnRedo().setVisible(true);
		} else if ((int) evt.getNewValue() == 0 && evt.getPropertyName() == "Redo Stack Remove") {
			frame.getBtnRedo().setVisible(false);
		}
	}
	
	private void drawPoint(MouseEvent e) {
		Point point = new Point(e.getX(), e.getY(), getOutColor());
		CmdPointAdd CmdPointAdd = new CmdPointAdd(model, point);
		CmdPointAdd.execute();
		model.pushToUndoStack(CmdPointAdd);
		actLog.addElement("Added->" + point.toString());
		frame.getBtnRedo().setVisible(false);
		model.getRedoStack().removeAllElements();
	}
	
	private void drawLine(MouseEvent e) {
		if(model.getStartPoint() == null)
			model.setStartPoint(new Point(e.getX(), e.getY())) ;
		else
		{
			Line line = new Line(model.getStartPoint(), new Point(e.getX(), e.getY()), outColor);
			CmdLineAdd CmdLineAdd = new CmdLineAdd(model, line);
			CmdLineAdd.execute();
			model.pushToUndoStack(CmdLineAdd);
			model.setStartPoint(null);
			actLog.addElement("Added->" + line.toString());
			frame.getBtnRedo().setVisible(false);
			model.getRedoStack().removeAllElements();
		}
	}
	
	private void drawCircle(MouseEvent e) {
		DlgCircle dlgCircle = new DlgCircle();
		dlgCircle.setVisible(true);
		
		if(dlgCircle.isConfirm()) {
			try {
				if(checkType(dlgCircle.getTxtRadius().getText())) {
					int radius = Integer.parseInt(dlgCircle.getTxtRadius().getText());
					Circle circle = new Circle(new Point(e.getX(), e.getY()), radius, outColor, inColor);
					CmdCircleAdd CmdCircleAdd = new CmdCircleAdd(model,circle);
					CmdCircleAdd.execute();
					model.pushToUndoStack(CmdCircleAdd);
					actLog.addElement("Added->" + circle.toString());
					frame.getBtnRedo().setVisible(false);
					model.getRedoStack().removeAllElements();
				} else {
					JOptionPane.showMessageDialog(frame,
							"Illegal input type!",
							"Illegal radius error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (InappropriateValue e1) {
				JOptionPane.showMessageDialog(frame,
						"Radius must be greater than 0!",
						"Illegal radius error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void drawRectangle(MouseEvent e) {
		DlgRectangle dlgRectangle = new DlgRectangle();
		dlgRectangle.setVisible(true);

		if(dlgRectangle.isConfirm()) {
			if(checkType(dlgRectangle.getTxtWidth().getText()) && checkType(dlgRectangle.getTxtHeight().getText())) {
				Rectangle rectangle = new Rectangle(new Point(e.getX(), e.getY()),Integer.parseInt(dlgRectangle.getTxtWidth().getText()),Integer.parseInt(dlgRectangle.getTxtHeight().getText()), outColor, inColor);
				CmdRectangleAdd CmdRectangleAdd = new CmdRectangleAdd(model, rectangle);
				CmdRectangleAdd.execute();
				model.pushToUndoStack(CmdRectangleAdd);
				actLog.addElement("Added->" + rectangle.toString());
				frame.getBtnRedo().setVisible(false);
				model.getRedoStack().removeAllElements();
		} else {
			JOptionPane.showMessageDialog(frame,
					"Illegal input type!",
					"Illegal radius error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
	
	private void drawDonut(MouseEvent e) {
		DlgDonut dlgDonut = new DlgDonut();
		dlgDonut.setVisible(true);

		if(dlgDonut.isConfirm()) {
			try {
				if(checkType(dlgDonut.getTxtOuterRadius().getText())) {
					if(dlgDonut.getTxtOuterRadius().getText() != null && dlgDonut.getTxtInnerRadius().getText() != null ) {
						Donut donut = new Donut(new Point(e.getX(), e.getY()), Integer.parseInt(dlgDonut.getTxtOuterRadius().getText()), Integer.parseInt(dlgDonut.getTxtInnerRadius().getText()), outColor, inColor);
						CmdDonutAdd CmdDonutAdd = new CmdDonutAdd(model,donut);
						CmdDonutAdd.execute();
						model.pushToUndoStack(CmdDonutAdd);
						actLog.addElement("Added->" + donut.toString());
						frame.getBtnRedo().setVisible(false);
						model.getRedoStack().removeAllElements();
					}
				} else {
					JOptionPane.showMessageDialog(frame,
							"Illegal input type!",
							"Illegal radius error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (InappropriateValue e1) {
				JOptionPane.showMessageDialog(frame,
						"Inner radius must be smaller than outer radius!",
						"Inappropriate radius error",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
	}
	
	private void drawHexagon(MouseEvent e) { 
		DlgCircle dlgHex = new DlgCircle();
		dlgHex.setTitle("Add Hexagon");
		dlgHex.setVisible(true);

		if(dlgHex.isConfirm()) {
			if(checkType(dlgHex.getTxtRadius().getText())) {
				Hexagon hexagon = new Hexagon(e.getX(),e.getY(),Integer.parseInt(dlgHex.getTxtRadius().getText()));
				hexagon.setBorderColor(outColor);
				hexagon.setAreaColor(inColor);
				HexagonAdapter adapter = new HexagonAdapter(hexagon);
				CmdHexagonAdd CmdHexagonAdd = new CmdHexagonAdd(model,adapter);
				CmdHexagonAdd.execute();
				model.pushToUndoStack(CmdHexagonAdd);
				actLog.addElement("Added->" + adapter.toString());
				frame.getBtnRedo().setVisible(false);
				model.getRedoStack().removeAllElements();
			} else {
				JOptionPane.showMessageDialog(frame,
						"Illegal input type!",
						"Illegal radius error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void undo() {
		if(model.getUndoStack().size()>0) {
			Command command = model.getUndoStack().peek();
			model.pushToRedoStack(command);
			actLog.addElement("Undo->" + model.getUndoStack().peek().toString());
			model.removeFromUndoStack();
			frame.getView().repaint(); 
		}
	}

	public void redo() {
		if(model.getRedoStack().size()>0) {
			model.pushToUndoStack(model.getRedoStack().peek());
			actLog.addElement("Redo->" + model.getRedoStack().peek().toString());
			model.removeFromRedoStack();
			frame.getView().repaint();
		}
	}
	
	private void selectShape(MouseEvent e) {
		for(int i = 0; i<model.getShapes().size(); i++)
		{
			if(model.getShapes().get(i).contains(e.getX(), e.getY()))
			{
				if(model.getShapes().get(i).isSelected())
				{
					return;
				}
				Shape shape = model.getShapes().get(i);
				CmdSelect CmdSelect = new CmdSelect(model, shape);
				CmdSelect.execute();
				actLog.addElement("Selected->" + shape.toString());
				model.getUndoStack().push(CmdSelect);
			}
		}
	}
	
	public void selectShapeFromLog(Shape shape) {
		int index = model.getShapes().indexOf(shape);
		Shape selectedShape = model.getShapes().get(index);
		CmdSelect CmdSelect = new CmdSelect(model, selectedShape);
		CmdSelect.execute();
		model.getUndoStack().push(CmdSelect);
		frame.getView().repaint();
	}

	public void unselectAll() {
		for(int i = 0; i< model.getSelectedShapes().size(); i++) {
			Shape shape = model.getSelectedShapes().get(i);
			CmdUnselect unselect = new CmdUnselect(model, shape);
			unselect.execute();
			actLog.addElement("Unselected->" + shape.toString());
		}
		frame.getTglBtnModify().setVisible(false);
		frame.getTglBtnDelete().setVisible(false);
	}
	
	public void modifyShape() throws InappropriateValue {
		{
			if(model.getSelectedShapes().get(0) instanceof Point) {
				if(model.getSelectedShapes().get(0).isSelected()) {
					DlgPoint dlgPoint = new DlgPoint();
					Point oldState = (Point) model.getSelectedShapes().get(0);
					dlgPoint.getTxtX().setText(Integer.toString(oldState.getX()));
					dlgPoint.getTxtY().setText(Integer.toString(oldState.getY()));
					dlgPoint.setVisible(true);
					if(dlgPoint.isConfirm()) {
						if(checkType(dlgPoint.getTxtX().getText()) && checkType(dlgPoint.getTxtY().getText())) {
							Point newState = new Point(Integer.parseInt(dlgPoint.getTxtX().getText()), Integer.parseInt(dlgPoint.getTxtY().getText()), dlgPoint.getColor());
							actLog.addElement("Updated->" + oldState.toString() + "->" + newState.toString());
							CmdPointUpdate CmdPointUpdate = new CmdPointUpdate(oldState , newState);
							CmdPointUpdate.execute();
							model.pushToUndoStack(CmdPointUpdate);
							frame.repaint();
						} else {
							JOptionPane.showMessageDialog(frame,
									"Illegal input type!",
									"Illegal radius error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} else if (model.getSelectedShapes().get(0) instanceof Line) {

				if(model.getSelectedShapes().get(0).isSelected()) {
					DlgLine dlgLine = new DlgLine();
					Line oldLine = (Line) model.getSelectedShapes().get(0);
					dlgLine.getTxtStartPointX().setText((Integer.toString(oldLine.getStartPoint().getX())));
					dlgLine.getTxtStartPointY().setText((Integer.toString(oldLine.getStartPoint().getY())));
					dlgLine.getTxtEndPointX().setText((Integer.toString(oldLine.getEndPoint().getX())));
					dlgLine.getTxtEndPointY().setText((Integer.toString(oldLine.getEndPoint().getY())));
					dlgLine.setVisible(true);
					if(dlgLine.isConfirmation()) {
						if(checkType(dlgLine.getTxtStartPointX().getText()) && checkType(dlgLine.getTxtStartPointY().getText()) && checkType(dlgLine.getTxtEndPointX().getText()) && checkType(dlgLine.getTxtEndPointY().getText())) {
							Line newLine = new Line(new Point(Integer.parseInt(dlgLine.getTxtStartPointX().getText()), Integer.parseInt(dlgLine.getTxtStartPointY().getText())), new Point(Integer.parseInt(dlgLine.getTxtEndPointX().getText()), Integer.parseInt(dlgLine.getTxtEndPointY().getText())), dlgLine.getColor());
							CmdLineUpdate CmdLineUpdate = new CmdLineUpdate(oldLine,newLine);
							actLog.addElement("Updated->" + oldLine.toString() + "->" + newLine.toString());
							CmdLineUpdate.execute();
							model.pushToUndoStack(CmdLineUpdate);
							frame.repaint();
						} else {
							JOptionPane.showMessageDialog(frame,
									"Illegal input type!",
									"Illegal radius error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} else if (model.getSelectedShapes().get(0) instanceof Rectangle) {
				if(model.getSelectedShapes().get(0).isSelected()) {
					DlgRectangleUpdate dlgRectangleUpdate = new DlgRectangleUpdate();
					Rectangle oldRectangle = (Rectangle) model.getSelectedShapes().get(0);
					dlgRectangleUpdate.getTxtUpperLeftPointX().setText(Integer.toString(oldRectangle.getUpperLeftPoint().getX()));
					dlgRectangleUpdate.getTxtUpperLeftPointY().setText(Integer.toString(oldRectangle.getUpperLeftPoint().getY()));
					dlgRectangleUpdate.getTxtHeight().setText(Integer.toString(oldRectangle.getHeight()));
					dlgRectangleUpdate.getTxtWidth().setText(Integer.toString(oldRectangle.getWidth()));
					dlgRectangleUpdate.setVisible(true);
					if(dlgRectangleUpdate.isConfirmation()) {
						if(checkType(dlgRectangleUpdate.getTxtUpperLeftPointX().getText()) && checkType(dlgRectangleUpdate.getTxtUpperLeftPointY().getText()) && checkType(dlgRectangleUpdate.getTxtWidth().getText()) && checkType(dlgRectangleUpdate.getTxtHeight().getText())) {
							Rectangle newRectangle = new Rectangle(new Point(Integer.parseInt(dlgRectangleUpdate.getTxtUpperLeftPointX().getText()), Integer.parseInt(dlgRectangleUpdate.getTxtUpperLeftPointY().getText())), Integer.parseInt(dlgRectangleUpdate.getTxtWidth().getText()), Integer.parseInt(dlgRectangleUpdate.getTxtHeight().getText()),dlgRectangleUpdate.getOutlineColor(), dlgRectangleUpdate.getFillColor());
							CmdRectangleUpdate CmdRectangleUpdate = new CmdRectangleUpdate(oldRectangle,newRectangle);
							actLog.addElement("Updated->" + oldRectangle.toString() + "->" + newRectangle.toString());
							CmdRectangleUpdate.execute();
							model.pushToUndoStack(CmdRectangleUpdate);
							model.getRedoStack().removeAllElements();
							frame.repaint();
						} else {
							JOptionPane.showMessageDialog(frame,
									"Illegal input type!",
									"Illegal radius error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
			else if (model.getSelectedShapes().get(0) instanceof Donut) {
				if(model.getSelectedShapes().get(0).isSelected()) {
					DlgDonutUpdate dlgDonutUpdate = new DlgDonutUpdate();
					Donut oldDonut = (Donut) model.getSelectedShapes().get(0);
					dlgDonutUpdate.getTxtX().setText(Integer.toString(oldDonut.getCenter().getX()));
					dlgDonutUpdate.getTxtY().setText(Integer.toString(oldDonut.getCenter().getY()));
					dlgDonutUpdate.getTxtInnerRadius().setText(Integer.toString(oldDonut.getInnerRadius()));
					dlgDonutUpdate.getTxtOuterRadius().setText(Integer.toString(oldDonut.getOuterRadius()));
					dlgDonutUpdate.setVisible(true);
					if(dlgDonutUpdate.isConfirm()) {
						if(checkType(dlgDonutUpdate.getTxtX().getText()) && checkType(dlgDonutUpdate.getTxtY().getText()) && checkType(dlgDonutUpdate.getTxtOuterRadius().getText()) && checkType(dlgDonutUpdate.getTxtInnerRadius().getText())) {
							Donut newDonut = new Donut(new Point(Integer.parseInt(dlgDonutUpdate.getTxtX().getText()), Integer.parseInt(dlgDonutUpdate.getTxtY().getText())), Integer.parseInt(dlgDonutUpdate.getTxtOuterRadius().getText()), Integer.parseInt(dlgDonutUpdate.getTxtInnerRadius().getText()), dlgDonutUpdate.getBorderColor(), dlgDonutUpdate.getFillColor());
							CmdDonutUpdate CmdDonutUpdate = new CmdDonutUpdate(oldDonut, newDonut);
							actLog.addElement("Updated->" + oldDonut.toString() + "->" + newDonut.toString());
							CmdDonutUpdate.execute();
							model.pushToUndoStack(CmdDonutUpdate);
							model.getRedoStack().removeAllElements();
							frame.repaint();
						} else {
							JOptionPane.showMessageDialog(frame,
									"Illegal input type!",
									"Illegal radius error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
			else if (model.getSelectedShapes().get(0) instanceof Circle) { 
				if(model.getSelectedShapes().get(0).isSelected()) {
					DlgCircleUpdate dlgCircleUpdate = new DlgCircleUpdate();
					Circle oldCircle = (Circle) model.getSelectedShapes().get(0);
					dlgCircleUpdate.getTxtRadius().setText(Integer.toString(oldCircle.getR()));
					dlgCircleUpdate.getTxtCenterX().setText(Integer.toString(oldCircle.getCenter().getX()));
					dlgCircleUpdate.getTxtCenterY().setText(Integer.toString(oldCircle.getCenter().getY()));
					dlgCircleUpdate.setVisible(true);
					if(dlgCircleUpdate.isConfirmation()) {
						try {
							if(checkType(dlgCircleUpdate.getTxtCenterX().getText()) && checkType(dlgCircleUpdate.getTxtCenterY().getText()) && checkType(dlgCircleUpdate.getTxtRadius().getText())) {
								Circle newCircle = new Circle(new Point(Integer.parseInt(dlgCircleUpdate.getTxtCenterX().getText()), Integer.parseInt(dlgCircleUpdate.getTxtCenterY().getText())), Integer.parseInt(dlgCircleUpdate.getTxtRadius().getText()),dlgCircleUpdate.getOutlineColor(), dlgCircleUpdate.getFillColor());
								CmdCircleUpdate CmdCircleUpdate = new CmdCircleUpdate(oldCircle, newCircle);
								actLog.addElement("Updated->" + oldCircle.toString() + "->" + newCircle.toString());
								CmdCircleUpdate.execute();
								model.pushToUndoStack(CmdCircleUpdate);
								model.getRedoStack().removeAllElements();
								frame.repaint();
							} else {
								JOptionPane.showMessageDialog(frame,
										"Illegal input type!",
										"Illegal radius error",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
				}
			} else if (model.getSelectedShapes().get(0) instanceof HexagonAdapter) {
				if(((HexagonAdapter) model.getSelectedShapes().get(0)).getHexagon().isSelected()) {
					DlgHexagonUpdate dlgHexagonUpdate = new DlgHexagonUpdate();
					HexagonAdapter oldHexagon = (HexagonAdapter) model.getSelectedShapes().get(0);
					dlgHexagonUpdate.getTxtCenterX().setText(Integer.toString(oldHexagon.getHexagon().getX()));
					dlgHexagonUpdate.getTxtCenterY().setText(Integer.toString(oldHexagon.getHexagon().getY()));
					dlgHexagonUpdate.getTxtR().setText(Integer.toString(oldHexagon.getHexagon().getR()));
					dlgHexagonUpdate.setVisible(true);
					if(dlgHexagonUpdate.isConfirmation()) {
						try {
							if(checkType(dlgHexagonUpdate.getTxtCenterX().getText()) && checkType(dlgHexagonUpdate.getTxtCenterY().getText()) && checkType(dlgHexagonUpdate.getTxtR().getText())) {
								Hexagon hex = new Hexagon(Integer.parseInt(dlgHexagonUpdate.getTxtCenterX().getText()), Integer.parseInt(dlgHexagonUpdate.getTxtCenterY().getText()), Integer.parseInt(dlgHexagonUpdate.getTxtR().getText()));
								hex.setAreaColor(dlgHexagonUpdate.getFillColor());
								hex.setBorderColor(dlgHexagonUpdate.getOutlineColor());
								HexagonAdapter adapter = new HexagonAdapter(hex);
								CmdHexagonUpdate CmdHexagonUpdate = new CmdHexagonUpdate(oldHexagon, adapter);
								actLog.addElement("Updated->" + oldHexagon.toString() + "->" + adapter.toString());
								CmdHexagonUpdate.execute();
								model.pushToUndoStack(CmdHexagonUpdate);
								model.getRedoStack().removeAllElements();
								frame.repaint();
							} else {
								JOptionPane.showMessageDialog(frame,
										"Illegal input type!",
										"Illegal radius error",
										JOptionPane.ERROR_MESSAGE);
							}
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public void toFront() {
		if(model.getSelectedShapes().size() == 1) {
			int index = model.getShapes().indexOf(model.getSelectedShapes().get(0));
			Shape shape = model.getShapes().get(index);
			CmdToFront ToFront = new CmdToFront(model, index , shape);
			model.pushToUndoStack(ToFront);
			ToFront.execute();
			actLog.addElement("Moved to front->" + shape.toString());
		} else {
			System.out.println("More than 2 shapes have been selected!");
		}
		frame.repaint();
	}

	public void toBack() {
		if(model.getSelectedShapes().size() == 1) {
			int index = model.getShapes().indexOf(model.getSelectedShapes().get(0));
			Shape shape = model.getShapes().get(index);
			CmdToBack ToBack = new CmdToBack(model, index, shape);
			model.pushToUndoStack(ToBack);
			actLog.addElement("Moved to back->" + shape.toString());
			ToBack.execute();
		}
		frame.repaint();
	}

	public void bringToFront() {
		if(model.getSelectedShapes().size() == 1) {
			int index = model.getShapes().indexOf(model.getSelectedShapes().get(0));
			Shape shape = model.getShapes().get(index);
			CmdBringToFront BringToFront = new CmdBringToFront(model,shape);
			model.pushToUndoStack(BringToFront);
			actLog.addElement("Brought to front->" + shape.toString());
			BringToFront.execute();
		}
		frame.repaint();
	}

	public void bringToBack() {
		if(model.getSelectedShapes().size() == 1) {
			int index = model.getShapes().indexOf(model.getSelectedShapes().get(0));
			Shape shape = model.getShapes().get(index);
			CmdBringToBack BringToBack = new CmdBringToBack(model, index, shape);
			model.pushToUndoStack(BringToBack);
			actLog.addElement("Brought to back->" + shape.toString());
			BringToBack.execute();
		}
		frame.repaint();
	}
	
	public void deleteFromLog() {
		while(model.getSelectedShapes().size()>0) {
			for(int i = 0; i<model.getSelectedShapes().size(); i++) {
				Shape shape = model.getSelectedShapes().get(i);
				CmdShapeRemove CDS = new CmdShapeRemove(model, shape);
				CDS.execute();
				actLog.addElement("Deleted->" + shape.toString());
				model.getUndoStack().push(CDS);
		}
			frame.getView().repaint();
	}	
	}
	
	public void delete()
	{
		DlgChoice dlgChoice = new DlgChoice();
		dlgChoice.setVisible(true);
		if(dlgChoice.confirmation) {
		while(model.getSelectedShapes().size()>0) {
			for(int i = 0; i<model.getSelectedShapes().size(); i++) {
				Shape shape = model.getSelectedShapes().get(i);
				CmdShapeRemove CDS = new CmdShapeRemove(model, shape);
				CDS.execute();
				actLog.addElement("Deleted->" + shape.toString());
				model.getUndoStack().push(CDS);
		}
		}
			}
			frame.repaint();
		}
	
	
	private boolean checkType(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch(NumberFormatException e1) {
			return false;
		}
	}
	
	private boolean checkShapes(MouseEvent e) {
		for(int i = 0; i<model.getShapes().size(); i++) {
			if(model.getShapes().get(i).contains(e.getX(), e.getY())) {
				return true;
			}
		}
		return false;
	}
	
	public void serialize() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
		chooser.enableInputMethods(false);
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileHidingEnabled(false);
		chooser.setEnabled(true);
		chooser.setDialogTitle("Save");
		chooser.setAcceptAllFileFilterUsed(false);

		if (!model.getShapes().isEmpty()) {
			chooser.setFileFilter(new FileNameExtensionFilter("Serialized draw", "ser"));
//			chooser.setFileFilter(new FileNameExtensionFilter("Image", "img"));
		}
		if (!model.getUndoStack().isEmpty() || model.getShapes().isEmpty()) chooser.setFileFilter(new FileNameExtensionFilter("Commands log", "log"));
		if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (chooser.getFileFilter().getDescription().equals("Serialized draw")) fileManager = new FileManager(new SerializeFile(model));
			else if (chooser.getFileFilter().getDescription().equals("Commands log")) fileManager = new FileManager(new SerializeLog(frame, model, this));
			else /*if (chooser.getFileFilter().getDescription().equals("Image"))*/ fileManager = new FileManager(new SerializeDrawing(frame));
			fileManager.saveFile(chooser.getSelectedFile());
		}
		chooser.setVisible(false);
	}


	public void unserialize() {
		JFileChooser chooser = new JFileChooser();
		chooser.enableInputMethods(true);
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileHidingEnabled(false);
		chooser.setEnabled(true);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
		chooser.setFileFilter(new FileNameExtensionFilter("Serialized draw", "ser"));
		chooser.setFileFilter(new FileNameExtensionFilter("Commands log", "log"));

		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			frame.getBtnUndo().setVisible(false);
			frame.getBtnRedo().setVisible(false);
			frame.getDlmList().clear();
			model.getShapes().clear();
			model.getUndoStack().clear();
			model.getRedoStack().clear();
			frame.getView().repaint();
			if (chooser.getFileFilter().getDescription().equals("Serialized draw")) {
				fileManager = new FileManager(new SerializeFile(model));
			}
			else if (chooser.getFileFilter().getDescription().equals("Commands log")) fileManager = new FileManager(new SerializeLog(frame, model, this));
			fileManager.openFile(chooser.getSelectedFile());
		}	
		chooser.setVisible(false);
	}

	public void executeCommand(Command command) {
		command.execute();
		model.pushToUndoStack(command);
		frame.getView().repaint();
	}

	public Color getOutColor() {
		return outColor;
	}

	public void setOutColor(Color outColor) {
		this.outColor = outColor;
	}

	public Color getInColor() {
		return inColor;
	}

	public void setInColor(Color inColor) {
		this.inColor = inColor;
	}

	private void stateChecker(MouseEvent e) throws InappropriateValue {
		if(frame.getState() == 1)
		{
			drawPoint(e);
		}
		else if (frame.getState() == 2)
		{
			drawLine(e);
		}
		else if (frame.getState() == 3)
		{
			drawCircle(e);
		}
		else if (frame.getState() == 4)
		{
			drawRectangle(e);
		}
		else if(frame.getState() == 5)
		{
			drawDonut(e);
		}
		else if(frame.getState() == 6)
		{
			drawHexagon(e);
		}
		else if(frame.getState() == 7)           
		{
			selectShape(e);
		}
		else if(frame.getState() == 8)
		{
			modifyShape();
		}
	}
}