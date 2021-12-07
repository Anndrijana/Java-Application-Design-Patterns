package dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

//import net.miginfocom.swing.MigLayout; 

public class DlgPoint extends JDialog {
	
	private JTextField txtX;
	private JTextField txtY;
	private Color color = Color.BLACK;
	private boolean confirm;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public DlgPoint() {
		setModal(true);
		setTitle("Update Point");
		setBounds(100, 100, 450, 300);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{75, 123, 88, 45, 63, 0};
		gbl_panel.rowHeights = new int[]{30, 19, 19, 55, 21, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblX = new JLabel("X coordinate:");
		lblX.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 1;
		gbc_lblX.gridy = 2;
		panel.add(lblX, gbc_lblX);
		
		txtX = new JTextField();
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.anchor = GridBagConstraints.NORTH;
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.gridx = 2;
		gbc_txtX.gridy = 2;
		panel.add(txtX, gbc_txtX);
		txtX.setColumns(10);
		
		JButton btnColor = new JButton("Color");
		btnColor.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(btnColor, "Enter color", Color.BLACK);
			}
		});
		
		JLabel lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 1;
		gbc_lblY.gridy = 3;
		panel.add(lblY, gbc_lblY);
		
		txtY = new JTextField();
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
		gbc_txtY.gridx = 2;
		gbc_txtY.gridy = 3;
		panel.add(txtY, gbc_txtY);
		txtY.setColumns(10);
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnColor.anchor = GridBagConstraints.NORTH;
		gbc_btnColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnColor.gridx = 1;
		gbc_btnColor.gridy = 4;
		panel.add(btnColor, gbc_btnColor);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnOk = new JButton("Ok");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setConfirm(true);
				setVisible(false);
			}
		});

		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.NORTH;
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 6;
		panel.add(btnOk, gbc_btnOk);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTH;
		gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 6;
		panel.add(btnCancel, gbc_btnCancel);
	}
}