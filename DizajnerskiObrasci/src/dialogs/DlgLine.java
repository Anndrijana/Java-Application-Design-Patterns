package dialogs;

import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {
	
	private JTextField txtStartPointX;
	private JTextField txtStartPointY;
	private JTextField txtEndPointX;
	private JTextField txtEndPointY;
	private Color color = Color.BLACK;
	private boolean confirmation;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public JTextField getTxtStartPointX() {
		return txtStartPointX;
	}

	public void setTxtStartPointX(JTextField txtStartPointX) {
		this.txtStartPointX = txtStartPointX;
	}

	public JTextField getTxtStartPointY() {
		return txtStartPointY;
	}

	public void setTxtStartPointY(JTextField txtStartPointY) {
		this.txtStartPointY = txtStartPointY;
	}

	public JTextField getTxtEndPointX() {
		return txtEndPointX;
	}

	public void setTxtEndPointX(JTextField txtEndPointX) {
		this.txtEndPointX = txtEndPointX;
	}

	public JTextField getTxtEndPointY() {
		return txtEndPointY;
	}

	public void setTxtEndPointY(JTextField txtEndPointY) {
		this.txtEndPointY = txtEndPointY;
	}

	public DlgLine() {
		setBounds(100, 100, 450, 200);
		setModal(true);
		setTitle("Update Line");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 114, 0, 0, 100, 63, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblStartPointX = new JLabel("StartPoint X:");
		lblStartPointX.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
		gbc_lblStartPointX.anchor = GridBagConstraints.SOUTH;
		gbc_lblStartPointX.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartPointX.gridx = 1;
		gbc_lblStartPointX.gridy = 1;
		getContentPane().add(lblStartPointX, gbc_lblStartPointX);

		txtStartPointX = new JTextField();
		GridBagConstraints gbc_txtStartPointX = new GridBagConstraints();
		gbc_txtStartPointX.insets = new Insets(0, 0, 5, 5);
		gbc_txtStartPointX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStartPointX.gridx = 4;
		gbc_txtStartPointX.gridy = 1;
		getContentPane().add(txtStartPointX, gbc_txtStartPointX);
		txtStartPointX.setColumns(10);

		JLabel lblStartPointY = new JLabel("StartPoint Y:");
		lblStartPointY.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStartPointY = new GridBagConstraints();
		gbc_lblStartPointY.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartPointY.gridx = 1;
		gbc_lblStartPointY.gridy = 3;
		getContentPane().add(lblStartPointY, gbc_lblStartPointY);

		txtStartPointY = new JTextField();
		GridBagConstraints gbc_txtStartPointY = new GridBagConstraints();
		gbc_txtStartPointY.insets = new Insets(0, 0, 5, 5);
		gbc_txtStartPointY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStartPointY.gridx = 4;
		gbc_txtStartPointY.gridy = 3;
		getContentPane().add(txtStartPointY, gbc_txtStartPointY);
		txtStartPointY.setColumns(10);

		JLabel lblEndPointX = new JLabel("EndPoint X:");
		lblEndPointX.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
		gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndPointX.gridx = 1;
		gbc_lblEndPointX.gridy = 5;
		getContentPane().add(lblEndPointX, gbc_lblEndPointX);

		txtEndPointX = new JTextField();
		GridBagConstraints gbc_txtEndPointX = new GridBagConstraints();
		gbc_txtEndPointX.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndPointX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndPointX.gridx = 4;
		gbc_txtEndPointX.gridy = 5;
		getContentPane().add(txtEndPointX, gbc_txtEndPointX);
		txtEndPointX.setColumns(10);

		JLabel lblEndPointY = new JLabel("EndPoint Y:");
		lblEndPointY.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
		gbc_lblEndPointY.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndPointY.gridx = 1;
		gbc_lblEndPointY.gridy = 7;
		getContentPane().add(lblEndPointY, gbc_lblEndPointY);

		txtEndPointY = new JTextField();
		GridBagConstraints gbc_txtEndPointY = new GridBagConstraints();
		gbc_txtEndPointY.insets = new Insets(0, 0, 5, 5);
		gbc_txtEndPointY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndPointY.gridx = 4;
		gbc_txtEndPointY.gridy = 7;
		getContentPane().add(txtEndPointY, gbc_txtEndPointY);
		txtEndPointY.setColumns(10);

		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(btnColor, "Enter color", Color.BLACK);
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnColor.gridx = 1;
		gbc_btnColor.gridy = 8;
		getContentPane().add(btnColor, gbc_btnColor);

		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setConfirmation(true);
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOK.insets = new Insets(0, 0, 0, 5);
		gbc_btnOK.gridx = 5;
		gbc_btnOK.gridy = 8;
		getContentPane().add(btnOK, gbc_btnOK);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 6;
		gbc_btnCancel.gridy = 8;
		getContentPane().add(btnCancel, gbc_btnCancel);
	}
}