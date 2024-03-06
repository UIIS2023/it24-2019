package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commandx.Command;
import model.Model;
import model.Shape;

@SuppressWarnings("serial")
public class MyDialog extends JDialog {
	
	protected ColorButtonPanel colorButtonPanel= new ColorButtonPanel();
	private boolean confirm;
	protected  Shape shape;
	protected final JPanel contentPanel = new JPanel();
	
	protected GridBagConstraints gbc = new GridBagConstraints();
	private JPanel buttonPane = new JPanel();
	protected JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("CANCEL");
	protected XYPanel positionPanel;
	protected Model model;
	protected MainPanel mainPanel;
	protected Command command;
	
	
	MyDialog(){
		
		setResizable(false);
		setModal(true);
		setBounds(0, 0, 400, 300);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		GridBagLayout grid = new GridBagLayout();
		contentPanel.setLayout(grid);
		contentPanel.setBackground(Color.lightGray);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		colorButtonPanel.setVisibleInnerColorBtn(true);
		colorButtonPanel.setVisibleEdgeColorBtn(true);
		
		add(buttonPane, BorderLayout.SOUTH);
		
		okButton.setBackground(Color.GREEN	);
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		
		cancelButton.setBackground(Color.RED);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		shape = null;
		
	}
	
	
	public int getValueX() {
		return Integer.parseInt(positionPanel.getTextX()) ;
	}
	
	public int getValueY() {
		return Integer.parseInt(positionPanel.getTextY()) ;
	}
	
	public String getTextX() {
		return positionPanel.getTextX();
	}
	
	public String getTextY() {
		return positionPanel.getTextY();
	}
	
	public void setTextX(String value) {
		positionPanel.setTxtX(value);
	}
	
	public void setTextY(String value) {
		positionPanel.setTxtY(value);
	}
	
	public void disableXY() {
		positionPanel.disableTextFields();
	}
	
	
	
	
	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	
	public Shape getShapee() {
		return shape;
	}
	public void conectDialogToShape(Shape shape) {
		this.shape = shape;
	}
	public void setVisibleForColorDialog(boolean value) {
		colorButtonPanel.setVisible(value);
	}
	
	public Color getEdgeColor() {
		return colorButtonPanel.getEdgeColor();
	}
	
	public Color getInnerColor() {
		return colorButtonPanel.getInnerColor();
	}
	
	public ColorButtonPanel getColorButtonPanel() {
		return colorButtonPanel;
	}
	
	public boolean isColorPanelVisible() {
		return this.colorButtonPanel.isVisible();
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void connectDialogToMainPanel(MainPanel panel) {
		this.mainPanel = panel;
	}
	
}
