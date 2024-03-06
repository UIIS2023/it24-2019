package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class XYPanel extends JPanel{
	
	private JTextField txtX = new JTextField();
	private JTextField txtY = new JTextField();
	
	private JLabel lblTitle = new JLabel();
	private JLabel lblX = new JLabel();
	private JLabel lblY = new JLabel();


	
	public XYPanel(String title, String lblXText, String lblYText) {
		
		txtX.setTransferHandler(null);
		txtX.setColumns(10);
		setBackground(new Color(255,255,180));

		txtY.setTransferHandler(null);
		txtY.setColumns(10);
		
		lblTitle.setFont(new Font("SansSerif", lblTitle.getFont().getStyle(), lblTitle.getFont().getSize() + 2));
		lblX.setFont(new Font("SansSerif", lblX.getFont().getStyle(), lblX.getFont().getSize() + 2));
		lblY.setFont(new Font("SansSerif", lblY.getFont().getStyle(), lblY.getFont().getSize() + 2));
		
		lblTitle.setText(title);
		lblX.setText(lblXText);
		lblY.setText(lblYText);
		
		GridLayout grid = new GridLayout(3,2,5,5);
		
		setLayout(grid);
		add(lblTitle);
		add(new JLabel());
		add(lblX);
		add(txtX);
		add(lblY);
		add(txtY);
		
	}
	

	
	
	public String getTextX() {
		return txtX.getText();
	}

	public void setTxtX(String text) {
		txtX.setText(text);
	}

	public String getTextY() {
		
		return txtY.getText();
	}

	public void setTxtY(String text) {
		txtY.setText(text);
	}

	public int getValueX() {
		return Integer.parseInt(getTextX());
	}
	public int getValueY() {
		return Integer.parseInt(getTextY());
	}
	
	public void disableTextFields() {
		txtX.setEnabled(false);
		txtY.setEnabled(false);
	}
	
	
	

}
