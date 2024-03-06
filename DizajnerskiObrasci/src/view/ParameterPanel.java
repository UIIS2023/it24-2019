package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ParameterPanel extends JPanel{
	
	
	private JLabel lblP = new JLabel();
	private JTextField txtP = new JTextField();


	
	public ParameterPanel(String lblPText) {
		
		txtP.setTransferHandler(null);
		txtP.setColumns(10);
		setBackground(new Color(255,255,180));
	

		
		lblP.setFont(new Font("SansSerif", lblP.getFont().getStyle(), lblP.getFont().getSize() + 2));
		lblP.setText(lblPText);
	
		GridLayout grid = new GridLayout(1,2);
		setLayout(grid);
		add(lblP);
		add(txtP);
	}
	


	public String getParameterTxt() {
		return txtP.getText();
	}

	public void setParameterTxt(String text) {
		txtP.setText(text);
	}
	
	public int getValue() {
		return Integer.parseInt(getParameterTxt());
	}
	public void setFocus() {
		this.requestFocus();
		txtP.requestFocus();
	}


	

}
