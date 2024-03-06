package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

public class DlgStack extends JDialog {

	private final JPanel contentPanel = new JPanel();
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
			DlgStack dialog = new DlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
		setTitle("Add/Delete rectangle");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.lightGray);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("X KOORDINATA:");
		lblNewLabel.setFont(new Font("SansSerif", lblNewLabel.getFont().getStyle(), lblNewLabel.getFont().getSize() + 2));
		
		txtX = new JTextField();
		txtX.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Y KOORDINATA:");
		lblNewLabel_1.setFont(lblNewLabel_1.getFont().deriveFont(lblNewLabel_1.getFont().getSize() + 2f));
		
		txtY = new JTextField();
		txtY.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("WIDTH:");
		lblNewLabel_2.setFont(new Font("SansSerif", lblNewLabel_2.getFont().getStyle(), lblNewLabel_2.getFont().getSize() + 2));
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("HEIGHT:");
		lblNewLabel_3.setFont(new Font("SansSerif", lblNewLabel_3.getFont().getStyle(), lblNewLabel_3.getFont().getSize() + 2));
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		
		
		JLabel lblUpperLeft = new JLabel("UPPER LEFT POINT");
		lblUpperLeft.setFont(new Font("SansSerif", lblUpperLeft.getFont().getStyle(), lblUpperLeft.getFont().getSize() + 3));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUpperLeft, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblUpperLeft)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.setForeground(Color.BLACK);
				btnOk.setBackground(Color.GREEN);
				btnOk.setFont(new Font("SansSerif", btnOk.getFont().getStyle(), btnOk.getFont().getSize() + 2));
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
								|| txtWidth.getText().trim().isEmpty() || txtHeight.getText().trim().isEmpty())
						{
					        isOk=false;//obavestenje da je korisnike klikuno na ok i da je jframu poslao obavestenje 
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
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("SansSerif", btnCancel.getFont().getStyle(), btnCancel.getFont().getSize() + 2));
				btnCancel.setForeground(Color.BLACK);
				btnCancel.setBackground(Color.RED);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
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
