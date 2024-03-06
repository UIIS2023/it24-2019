package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgSort extends JDialog {

	private final JPanel panelCenter = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	public boolean isOk;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgSort dialog = new DlgSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgSort() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panelCenter.setBackground(Color.lightGray);
		panelCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		setTitle("Add/Sort rectangles");
		setResizable(false);
		setModal(true);
		
		JLabel lblX = new JLabel("X KOORDINATA:");
		
		txtX = new JTextField();
		txtX.setColumns(10);
		
		JLabel lblY = new JLabel("Y KOORDINATA:");
		
		txtY = new JTextField();
		txtY.setColumns(10);
		
		JLabel lblWidth = new JLabel("WIDTH:");
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		
		JLabel lblHeight = new JLabel("HEIGHT:");
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCenter.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblY, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblX, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
						.addGroup(gl_panelCenter.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblHeight, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblWidth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
					.addGap(3)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCenter.createSequentialGroup()
							.addGap(1)
							.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panelCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panelCenter.setLayout(gl_panelCenter);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
								|| txtWidth.getText().trim().isEmpty() || txtHeight.getText().trim().isEmpty())
						{
					        isOk=false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "You have to fill all fields!");
					
						}
						else if(Integer.parseInt(getTxtWidth().getText()) < 0 || Integer.parseInt(getTxtHeight().getText()) < 0)
						{
							isOk=false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "The values for width and height must be positive, please!");
							
						}
						else {
							isOk=true;
							dispose();
						}
						
					}
				});
				okButton.setBackground(Color.GREEN);
				okButton.setForeground(Color.BLACK);
				okButton.setFont(new Font("SansSerif", okButton.getFont().getStyle(), okButton.getFont().getSize() + 2));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCEL");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setBackground(Color.RED);
				cancelButton.setFont(new Font("SansSerif", cancelButton.getFont().getStyle(), cancelButton.getFont().getSize() + 2));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextX() {
		return txtX;
	}

	public void setTextX(JTextField textX) {
		this.txtX = textX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}
	 
	
}
