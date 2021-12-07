package mvc;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;

import specialCase.InappropriateValue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.awt.Font;

import java.io.IOException;

public class DrawingFrame extends JFrame {

	private DrawingController controller;
	private DrawingView view = new DrawingView();
	
	private int mainState = 0;
	
	private ButtonGroup shapesGroup = new ButtonGroup();
	
	private JToggleButton tglBtnSelect;
	private JToggleButton tglBtnModify;
	private JToggleButton tglBtnDelete;
	
	private JButton btnUndo;
	private JButton btnRedo;
	
	private DefaultListModel <String> dlmList;
	
	private JList<String> activityLog;
	
	public DefaultListModel<String> getDlmList() {
		return dlmList;
	}

	public void setDlmList(DefaultListModel<String> dlmList) {
		this.dlmList = dlmList;
	}
	
	public JList<String> getActivityLog() {
		return activityLog;
	}

	public void setActivityLog(JList<String> activityLog) {
		this.activityLog = activityLog;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public void setBtnRedo(JButton btnRedo) {
		this.btnRedo = btnRedo;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}

	public JToggleButton getTglBtnDelete() {
		return tglBtnDelete;
	}

	public void setTglBtnDelete(JToggleButton tglBtnDelete) {
		this.tglBtnDelete = tglBtnDelete;
	}

	public JToggleButton getTglBtnSelect() {
		return tglBtnSelect;
	}

	public void setTglBtnSelect(JToggleButton tglBtnSelect) {
		this.tglBtnSelect = tglBtnSelect;
	}
	
	public int getState() {
		return mainState;
	}
	
	public JToggleButton getTglBtnModify() {
		return tglBtnModify;
	}

	public void setTglBtnModify(JToggleButton tglBtnModify) {
		this.tglBtnModify = tglBtnModify;
	}
	
	public void setState(int state) {
		this.mainState = state;
	}
	
	public DrawingView getView() {
		return view;
	}
	
	public void setView(DrawingView view) {
		this.view = view;
	}

	public DrawingController getController() {
		return controller;
	}
	
	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public DrawingFrame() {
		final Color VERY_DARK_RED = new Color(153,0,0);
		this.setBackground(Color.WHITE);
		dlmList = new DefaultListModel<String>();
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlNorth.setBackground(VERY_DARK_RED);
		getContentPane().add(pnlNorth, BorderLayout.NORTH);
		
		GridBagLayout gbl_pnlNorth = new GridBagLayout();
		gbl_pnlNorth.columnWidths = new int[]{109, 109, 0, 72, 50, 57, 50, 0, 0, 0, 0, 69, 0};
		gbl_pnlNorth.rowHeights = new int[]{23, 0, 0};
		gbl_pnlNorth.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlNorth.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		pnlNorth.setLayout(gbl_pnlNorth);
		
		JRadioButton rbtnPoint = new JRadioButton("Point");
		rbtnPoint.setBackground(VERY_DARK_RED);
		rbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(1);
			}
		});
		rbtnPoint.setForeground(Color.WHITE);
		shapesGroup.add(rbtnPoint);
		
		GridBagConstraints gbc_rbtnPoint = new GridBagConstraints();
		gbc_rbtnPoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbtnPoint.anchor = GridBagConstraints.NORTH;
		gbc_rbtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnPoint.gridx = 0;
		gbc_rbtnPoint.gridy = 0;
		pnlNorth.add(rbtnPoint, gbc_rbtnPoint);
		
		JRadioButton rbtnRectangle = new JRadioButton("Rectangle");
		rbtnRectangle.setForeground(Color.WHITE);
		rbtnRectangle.setBackground(VERY_DARK_RED);
		rbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(4);
			}
		});
		shapesGroup.add(rbtnRectangle);
		GridBagConstraints gbc_rbtnRectangle = new GridBagConstraints();
		gbc_rbtnRectangle.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnRectangle.gridx = 1;
		gbc_rbtnRectangle.gridy = 0;
		pnlNorth.add(rbtnRectangle, gbc_rbtnRectangle);
		
		JRadioButton rbtnDonut = new JRadioButton("Donut");
		rbtnDonut.setForeground(Color.WHITE);
		rbtnDonut.setBackground(VERY_DARK_RED);
		rbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(5);
			}
		});
		shapesGroup.add(rbtnDonut);
		GridBagConstraints gbc_rbtnDonut = new GridBagConstraints();
		gbc_rbtnDonut.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbtnDonut.insets = new Insets(0, 0, 5, 5);
		gbc_rbtnDonut.gridx = 2;
		gbc_rbtnDonut.gridy = 0;
		pnlNorth.add(rbtnDonut, gbc_rbtnDonut);
		
		JRadioButton rbtnLine = new JRadioButton("Line");
		rbtnLine.setForeground(Color.WHITE);
		rbtnLine.setBackground(VERY_DARK_RED);
		rbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(2);
			}
		});
		
		JButton btnUndo_1 = new JButton("Undo");
		final Color VERY_LIGHT_GREEN = new Color(102,255,102);
		btnUndo_1.setBackground(VERY_LIGHT_GREEN);
		btnUndo_1.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnUndo_1 = new GridBagConstraints();
		gbc_btnUndo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUndo_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo_1.gridx = 3;
		gbc_btnUndo_1.gridy = 0;
		pnlNorth.add(btnUndo_1, gbc_btnUndo_1);
		this.btnUndo = btnUndo_1;
		this.btnUndo.setVisible(false);
		btnUndo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.undo();
			}
		});
		
		JButton btnToFront = new JButton("To Front");
		btnToFront.setBackground(Color.BLUE);
		btnToFront.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnToFront = new GridBagConstraints();
		gbc_btnToFront.anchor = GridBagConstraints.WEST;
		gbc_btnToFront.insets = new Insets(0, 0, 5, 5);
		gbc_btnToFront.gridx = 4;
		gbc_btnToFront.gridy = 0;
		pnlNorth.add(btnToFront, gbc_btnToFront);
		btnToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toFront();
			}
		});
		
		JButton btnBringToFront = new JButton("Bring To Front");
		btnBringToFront.setBackground(Color.BLUE);
		btnBringToFront.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
		gbc_btnBringToFront.anchor = GridBagConstraints.WEST;
		gbc_btnBringToFront.insets = new Insets(0, 0, 5, 5);
		gbc_btnBringToFront.gridx = 5;
		gbc_btnBringToFront.gridy = 0;
		pnlNorth.add(btnBringToFront, gbc_btnBringToFront);
		btnBringToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bringToFront();
			}
		});
		JButton btnOpenPainting = new JButton("Open");
		btnOpenPainting.setBackground(Color.WHITE);
		btnOpenPainting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.unserialize();
			}
		});
		GridBagConstraints gbc_btnOpenPainting = new GridBagConstraints();
		gbc_btnOpenPainting.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOpenPainting.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpenPainting.gridx = 11;
		gbc_btnOpenPainting.gridy = 0;
		pnlNorth.add(btnOpenPainting, gbc_btnOpenPainting);
		shapesGroup.add(rbtnLine);
		GridBagConstraints gbc_rbtnLine = new GridBagConstraints();
		gbc_rbtnLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbtnLine.insets = new Insets(0, 0, 0, 5);
		gbc_rbtnLine.anchor = GridBagConstraints.NORTH;
		gbc_rbtnLine.gridx = 0;
		gbc_rbtnLine.gridy = 1;
		pnlNorth.add(rbtnLine, gbc_rbtnLine);
		
		JRadioButton rbtnCircle = new JRadioButton("Circle");
		rbtnCircle.setForeground(Color.WHITE);
		rbtnCircle.setBackground(VERY_DARK_RED);
		rbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(3);
			}
		});
		shapesGroup.add(rbtnCircle);
		GridBagConstraints gbc_rbtnCircle = new GridBagConstraints();
		gbc_rbtnCircle.fill = GridBagConstraints.BOTH;
		gbc_rbtnCircle.insets = new Insets(0, 0, 0, 5);
		gbc_rbtnCircle.gridx = 1;
		gbc_rbtnCircle.gridy = 1;
		pnlNorth.add(rbtnCircle, gbc_rbtnCircle);
		
		JRadioButton rbtnHexagon = new JRadioButton("Hexagon");
		rbtnHexagon.setForeground(Color.WHITE);
		rbtnHexagon.setBackground(VERY_DARK_RED);
		rbtnHexagon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(6);
			}
		});
		shapesGroup.add(rbtnHexagon);
		GridBagConstraints gbc_rbtnHexagon = new GridBagConstraints();
		gbc_rbtnHexagon.insets = new Insets(0, 0, 0, 5);
		gbc_rbtnHexagon.fill = GridBagConstraints.HORIZONTAL;
		gbc_rbtnHexagon.gridx = 2;
		gbc_rbtnHexagon.gridy = 1;
		pnlNorth.add(rbtnHexagon, gbc_rbtnHexagon);
		
		JButton btnRedo_1 = new JButton("Redo");
		final Color VERY_DARK_GREEN = new Color(0, 102, 0);
		btnRedo_1.setBackground(VERY_DARK_GREEN);
		btnRedo_1.setForeground(Color.WHITE);
		this.btnRedo = btnRedo_1;
		this.btnRedo.setVisible(false);
		btnRedo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
			}
		});
		GridBagConstraints gbc_btnRedo_1 = new GridBagConstraints();
		gbc_btnRedo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRedo_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnRedo_1.gridx = 3;
		gbc_btnRedo_1.gridy = 1;
		pnlNorth.add(btnRedo_1, gbc_btnRedo_1);
		
		JButton btnToBack = new JButton("To Back");
		btnToBack.setBackground(Color.BLUE);
		btnToBack.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnToBack = new GridBagConstraints();
		gbc_btnToBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnToBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnToBack.gridx = 4;
		gbc_btnToBack.gridy = 1;
		pnlNorth.add(btnToBack, gbc_btnToBack);
		btnToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toBack();
			}
		});
		
		JButton btnBringToBack = new JButton("Bring To Back");
		btnBringToBack.setBackground(Color.BLUE);
		btnBringToBack.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnBringToBack = new GridBagConstraints();
		gbc_btnBringToBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBringToBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBringToBack.gridx = 5;
		gbc_btnBringToBack.gridy = 1;
		pnlNorth.add(btnBringToBack, gbc_btnBringToBack);
		
		JButton btnSerialize = new JButton("Save");
		btnSerialize.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnSerialize = new GridBagConstraints();
		gbc_btnSerialize.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSerialize.gridx = 11;
		gbc_btnSerialize.gridy = 1;
		pnlNorth.add(btnSerialize, gbc_btnSerialize);
		btnSerialize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.serialize();
			}
		});
		btnBringToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bringToBack();
			}
		});
		
		JPanel pnlWest = new JPanel();
		pnlWest.setBackground(VERY_DARK_RED);
		pnlWest.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlWest.setForeground(Color.WHITE);
		getContentPane().add(pnlWest, BorderLayout.WEST);
		GridBagLayout gbl_pnlWest = new GridBagLayout();
		gbl_pnlWest.columnWidths = new int[]{89, 0};
		gbl_pnlWest.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlWest.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlWest.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlWest.setLayout(gbl_pnlWest);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setBackground(Color.WHITE);
		tglbtnSelect.setForeground(Color.BLACK);
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(7);
				view.repaint();
			}
		});
		
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		pnlWest.add(tglbtnSelect, gbc_tglbtnSelect);
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		final Color VERY_LIGHT_BLUE = new Color(51,204,255);
		tglbtnModify.setBackground(VERY_LIGHT_BLUE);
		this.tglBtnModify = tglbtnModify;
		tglbtnModify.setVisible(false);
		tglbtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.modifyShape();
				} catch (InappropriateValue e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnModify.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnModify.gridx = 0;
		gbc_tglbtnModify.gridy = 2;
		pnlWest.add(tglbtnModify, gbc_tglbtnModify);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.setBackground(Color.YELLOW);
		this.tglBtnDelete = tglbtnDelete;
		tglbtnDelete.setVisible(false);
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete();
				view.repaint();
			}
		});
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDelete.gridx = 0;
		gbc_tglbtnDelete.gridy = 3;
		pnlWest.add(tglbtnDelete, gbc_tglbtnDelete);
		
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					controller.mouseClicked(e);
				} catch (InappropriateValue e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		shapesGroup.add(tglbtnDelete);
		shapesGroup.add(tglbtnModify);
		shapesGroup.add(tglbtnSelect);
		
		JButton btnFillColor = new JButton("Fill color");
		btnFillColor.setBackground(Color.WHITE);
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color fillColor = JColorChooser.showDialog(btnFillColor, "Izaberite boju", Color.WHITE);
				if(fillColor!=null) {
					controller.setInColor(fillColor);
					btnFillColor.setBackground(fillColor);
				}
			}
		});
		
		JButton btnOutlineColor = new JButton("Outline color");
		btnOutlineColor.setBackground(Color.WHITE);
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color outlineColor = JColorChooser.showDialog(btnOutlineColor, "Izaberite boju", Color.BLACK);
				if(outlineColor!=null) {
					controller.setOutColor(outlineColor);
					btnOutlineColor.setBackground(outlineColor);
				}	
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(VERY_DARK_RED);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		pnlWest.add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(VERY_DARK_RED);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 5;
		pnlWest.add(panel_1, gbc_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(VERY_DARK_RED);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 6;
		pnlWest.add(panel_2, gbc_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(VERY_DARK_RED);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 7;
		pnlWest.add(panel_3, gbc_panel_3);
		
		GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
		gbc_btnOutlineColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOutlineColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnOutlineColor.gridx = 0;
		gbc_btnOutlineColor.gridy = 10;
		pnlWest.add(btnOutlineColor, gbc_btnOutlineColor);
		GridBagConstraints gbc_btnFillColor = new GridBagConstraints();
		gbc_btnFillColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFillColor.gridx = 0;
		gbc_btnFillColor.gridy = 11;
		pnlWest.add(btnFillColor, gbc_btnFillColor);
		getContentPane().add(view, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{402, 7, 0};
		gbl_pnlSouth.rowHeights = new int[]{53, 25};
		gbl_pnlSouth.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlSouth.add(scrollPane, gbc_scrollPane);
		
		activityLog = new JList<String>();
		activityLog.setValueIsAdjusting(true);
		activityLog.setBackground(Color.LIGHT_GRAY);
		activityLog.setModel(dlmList);
		activityLog.setFont(new Font("Lucida Console", Font.BOLD, 12));
		scrollPane.setViewportView(activityLog);
		view.setBackground(Color.WHITE);
		scrollPane.setBounds(586, 452, 784, 461);
	}
}