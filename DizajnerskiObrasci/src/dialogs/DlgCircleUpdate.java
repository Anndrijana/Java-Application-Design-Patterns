package dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircleUpdate extends JDialog {
	
	private JTextField txtRadius;
	private boolean confirmation;
	private int radius;
	private Color outlineColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	
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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

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

	public DlgCircleUpdate() {
		setResizable(true);
		setModal(true);
		setTitle("Update Circle");
		setBounds(100, 100, 350, 200);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 100, 62, 21, 68, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 22, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outlineColor = JColorChooser.showDialog(btnOutlineColor, "Izaberite boju", Color.BLACK);
			}
		});
		
		JLabel lblCenterX = new JLabel("Center X :");
		lblCenterX.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
		gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
		gbc_lblCenterX.gridx = 2;
		gbc_lblCenterX.gridy = 1;
		panel.add(lblCenterX, gbc_lblCenterX);
		
		txtCenterX = new JTextField();
		GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
		gbc_txtCenterX.insets = new Insets(0, 0, 5, 5);
		gbc_txtCenterX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCenterX.gridx = 3;
		gbc_txtCenterX.gridy = 1;
		panel.add(txtCenterX, gbc_txtCenterX);
		txtCenterX.setColumns(10);
		
		JLabel lblCenterY = new JLabel("Center Y :");
		lblCenterY.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
		gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
		gbc_lblCenterY.gridx = 2;
		gbc_lblCenterY.gridy = 2;
		panel.add(lblCenterY, gbc_lblCenterY);
		
		txtCenterY = new JTextField();
		GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
		gbc_txtCenterY.insets = new Insets(0, 0, 5, 5);
		gbc_txtCenterY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCenterY.gridx = 3;
		gbc_txtCenterY.gridy = 2;
		panel.add(txtCenterY, gbc_txtCenterY);
		txtCenterY.setColumns(10);
		
		JLabel lblR = new JLabel("Radius :");
		lblR.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.insets = new Insets(0, 0, 5, 5);
		gbc_lblR.gridx = 2;
		gbc_lblR.gridy = 3;
		panel.add(lblR, gbc_lblR);
		
		txtRadius = new JTextField();
		GridBagConstraints gbc_txtCenterX1 = new GridBagConstraints();
		gbc_txtCenterX1.insets = new Insets(0, 0, 5, 5);
		gbc_txtCenterX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCenterX1.gridx = 3;
		gbc_txtCenterX1.gridy = 3;
		panel.add(txtRadius, gbc_txtCenterX1);
		txtRadius.setColumns(10);
		btnOutlineColor.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
		gbc_btnOutlineColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOutlineColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnOutlineColor.gridx = 2;
		gbc_btnOutlineColor.gridy = 4;
		panel.add(btnOutlineColor, gbc_btnOutlineColor);
		
		JButton btnFillColor = new JButton("Fill Color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillColor = JColorChooser.showDialog(btnFillColor, "Izaberite boju", Color.WHITE);
			}
		});
		btnFillColor.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_btnFillColor = new GridBagConstraints();
		gbc_btnFillColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFillColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnFillColor.gridx = 3;
		gbc_btnFillColor.gridy = 4;
		panel.add(btnFillColor, gbc_btnFillColor);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setConfirmation(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 6;
		panel.add(btnCancel, gbc_btnCancel);
	}
}