package dialogs;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class DlgDonutUpdate extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtInnerRadius;
	private boolean confirm;
	private JTextField txtOuterRadius;
	private Color borderColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	private JTextField txtX;
	private JTextField txtY;

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

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}

	public JTextField getTxtOuterRadius() {
		return txtOuterRadius;
	}

	public void setTxtOuterRadius(JTextField txtOuterRadius) {
		this.txtOuterRadius = txtOuterRadius;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut Dialog = new DlgDonut();
			Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			Dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonutUpdate() {
		setResizable(false);
		setModal(true);
		setTitle("Update Donut");
		setBounds(100, 100, 390, 277);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{95, 120, 116, 0};
		gbl_contentPanel.rowHeights = new int[]{22, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JButton btnBorderColor = new JButton("Border Color");
			btnBorderColor.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borderColor =  JColorChooser.showDialog(btnBorderColor, "Izaberite boju", Color.BLACK);
				}
			});
			{
				JLabel lblX = new JLabel("X:");
				lblX.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
				GridBagConstraints gbc_lblX = new GridBagConstraints();
				gbc_lblX.insets = new Insets(0, 0, 5, 5);
				gbc_lblX.gridx = 0;
				gbc_lblX.gridy = 0;
				contentPanel.add(lblX, gbc_lblX);
			}
			{
				txtX = new JTextField();
				GridBagConstraints gbc_txtX = new GridBagConstraints();
				gbc_txtX.anchor = GridBagConstraints.NORTH;
				gbc_txtX.insets = new Insets(0, 0, 5, 5);
				gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtX.gridx = 1;
				gbc_txtX.gridy = 0;
				contentPanel.add(txtX, gbc_txtX);
				txtX.setColumns(10);
			}
			{
				JLabel lblY = new JLabel("Y:");
				lblY.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
				GridBagConstraints gbc_lblY = new GridBagConstraints();
				gbc_lblY.insets = new Insets(0, 0, 5, 5);
				gbc_lblY.gridx = 0;
				gbc_lblY.gridy = 1;
				contentPanel.add(lblY, gbc_lblY);
			}
			{
				txtY = new JTextField();
				GridBagConstraints gbc_txtY = new GridBagConstraints();
				gbc_txtY.anchor = GridBagConstraints.NORTH;
				gbc_txtY.insets = new Insets(0, 0, 5, 5);
				gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtY.gridx = 1;
				gbc_txtY.gridy = 1;
				contentPanel.add(txtY, gbc_txtY);
				txtY.setColumns(10);
			}
			{
				JLabel lblInnerRadius = new JLabel("Inner Radius:");
				lblInnerRadius.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
				GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
				gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblInnerRadius.gridx = 0;
				gbc_lblInnerRadius.gridy = 2;
				contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
			}
			{
				txtInnerRadius = new JTextField();
				GridBagConstraints gbc_txtInnerRadius = new GridBagConstraints();
				gbc_txtInnerRadius.insets = new Insets(0, 0, 5, 5);
				gbc_txtInnerRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtInnerRadius.anchor = GridBagConstraints.NORTH;
				gbc_txtInnerRadius.gridx = 1;
				gbc_txtInnerRadius.gridy = 2;
				contentPanel.add(txtInnerRadius, gbc_txtInnerRadius);
				txtInnerRadius.setColumns(10);
			}
			{
				JLabel lblOuterRadius = new JLabel("OuterRadius :");
				lblOuterRadius.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
				GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
				gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblOuterRadius.gridx = 0;
				gbc_lblOuterRadius.gridy = 3;
				contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
			}
			{
				txtOuterRadius = new JTextField();
				GridBagConstraints gbc_txtOuterRadius = new GridBagConstraints();
				gbc_txtOuterRadius.insets = new Insets(0, 0, 5, 5);
				gbc_txtOuterRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtOuterRadius.gridx = 1;
				gbc_txtOuterRadius.gridy = 3;
				contentPanel.add(txtOuterRadius, gbc_txtOuterRadius);
				txtOuterRadius.setColumns(10);
			}
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnBorderColor.anchor = GridBagConstraints.SOUTH;
			gbc_btnBorderColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnBorderColor.gridx = 0;
			gbc_btnBorderColor.gridy = 4;
			contentPanel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JButton btnFillColor = new JButton("Fill Color");
			btnFillColor.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnFillColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillColor = JColorChooser.showDialog(btnFillColor, "Izaberite boju", Color.BLACK);
				}
			});
			GridBagConstraints gbc_btnFillColor = new GridBagConstraints();
			gbc_btnFillColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnFillColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnFillColor.gridx = 0;
			gbc_btnFillColor.gridy = 5;
			contentPanel.add(btnFillColor, gbc_btnFillColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setConfirm(true);
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
}