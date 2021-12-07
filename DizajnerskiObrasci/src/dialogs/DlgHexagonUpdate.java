package dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgHexagonUpdate extends JDialog {
	
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private boolean confirmation;
	private JTextField txtR;
	private Color outlineColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	private final JButton btnFillColor = new JButton("Fill Color");
	
	public Color getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public JTextField getTxtR() {
		return txtR;
	}

	public void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public JTextField getTxtCenterX() {
		return txtCenterX;
	}

	public void setTxtCenterX(JTextField txtCenterX) {
		this.txtCenterX = txtCenterX;
	}

	public JTextField getTxtCenterY() {
		return txtCenterY;
	}

	public void setTxtCenterY(JTextField txtCenterY) {
		this.txtCenterY = txtCenterY;
	}

	public DlgHexagonUpdate() {
		setModal(true);
		setTitle("Update Hexagon");
		setBounds(100, 100, 495, 200);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 18, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCenterX = new JLabel("Center X :");
		lblCenterX.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
		gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
		gbc_lblCenterX.gridx = 1;
		gbc_lblCenterX.gridy = 3;
		panel.add(lblCenterX, gbc_lblCenterX);
		
		txtCenterX = new JTextField();
		GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
		gbc_txtCenterX.insets = new Insets(0, 0, 5, 5);
		gbc_txtCenterX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCenterX.gridx = 3;
		gbc_txtCenterX.gridy = 3;
		panel.add(txtCenterX, gbc_txtCenterX);
		txtCenterX.setColumns(10);
		
		JLabel lblCenterY = new JLabel("Center Y :");
		lblCenterY.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
		gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
		gbc_lblCenterY.gridx = 1;
		gbc_lblCenterY.gridy = 4;
		panel.add(lblCenterY, gbc_lblCenterY);
		
		txtCenterY = new JTextField();
		txtCenterY.setText("");
		GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
		gbc_txtCenterY.anchor = GridBagConstraints.NORTH;
		gbc_txtCenterY.insets = new Insets(0, 0, 5, 5);
		gbc_txtCenterY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCenterY.gridx = 3;
		gbc_txtCenterY.gridy = 4;
		panel.add(txtCenterY, gbc_txtCenterY);
		txtCenterY.setColumns(10);
		
		JButton btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outlineColor = JColorChooser.showDialog(btnOutlineColor, "Izaberite boju", Color.BLACK);
			}
		});
		GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
		gbc_btnOutlineColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOutlineColor.anchor = GridBagConstraints.NORTH;
		gbc_btnOutlineColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnOutlineColor.gridx = 4;
		gbc_btnOutlineColor.gridy = 4;
		panel.add(btnOutlineColor, gbc_btnOutlineColor);
		
		JLabel lblRadius = new JLabel("Radius :");
		lblRadius.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.WEST;
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 5;
		panel.add(lblRadius, gbc_lblRadius);
		
		txtR = new JTextField();
		GridBagConstraints gbc_txtR = new GridBagConstraints();
		gbc_txtR.insets = new Insets(0, 0, 5, 5);
		gbc_txtR.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtR.gridx = 3;
		gbc_txtR.gridy = 5;
		panel.add(txtR, gbc_txtR);
		txtR.setColumns(10);
		GridBagConstraints gbc_btnFillColor = new GridBagConstraints();
		gbc_btnFillColor.fill = GridBagConstraints.BOTH;
		gbc_btnFillColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnFillColor.gridx = 4;
		gbc_btnFillColor.gridy = 5;
		btnFillColor.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillColor = JColorChooser.showDialog(btnOutlineColor, "Izaberite boju", Color.WHITE);
			}
		});
		panel.add(btnFillColor, gbc_btnFillColor);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmation = true;
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.anchor = GridBagConstraints.SOUTH;
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 4;
		gbc_btnOk.gridy = 7;
		panel.add(btnOk, gbc_btnOk);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 7;
		panel.add(btnCancel, gbc_btnCancel);
	}	
}