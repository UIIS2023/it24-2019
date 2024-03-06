package view;


import javax.swing.JOptionPane;

import commandx.ModifyShape;

import model.Line;

import model.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends MyDialog {



	private XYPanel dlgXYPanel1 ;
	private XYPanel dlgXYPanel2 ;


	public DlgLine() {
		
		setTitle("SET LINE");
		
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
	
		dlgXYPanel1 = new XYPanel("START POINT", "COORDINATE X:", "COORDINATE Y:") ;
		contentPanel.add(dlgXYPanel1, gbc);
		
		
		//---------------------------------------
		
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
	
		dlgXYPanel2 = new XYPanel("END POINT", "COORDINATE X:", "COORDINATE Y:") ;
		contentPanel.add(dlgXYPanel2, gbc);
		
		
		//---------------------------------------
		

		
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPanel.add(this.colorButtonPanel,gbc);
	
		
	

		okButton.addActionListener(new EventHandler()) ;
		
		
		
		
	}
	

	private class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if (dlgXYPanel1.getTextX().trim().isEmpty() || 
				dlgXYPanel1.getTextY().trim().isEmpty() ||
				dlgXYPanel2.getTextX().trim().isEmpty() || 
				dlgXYPanel2.getTextY().trim().isEmpty())
			{
				setConfirm(false);
				JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} 
			
			
			else {
				try {
					int x1 = dlgXYPanel1.getValueX();
					int y1 = dlgXYPanel1.getValueY();
					
					int x2 = dlgXYPanel2.getValueX();
					int y2 = dlgXYPanel2.getValueY();
	
					if ( x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) 
					{
						JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} 
					else 
					{
						
						
						if(shape == null) {
							shape = new Line(new Position(x1,y1), new Position(x2,y2), getEdgeColor());
						}
						else {
							Line line = (Line)shape;
							
							if(x1 != line.getStartPoint().getX() ||
								y1 != line.getStartPoint().getY()||
								x2 != line.getEndPoint().getX() ||
								y2 != line.getEndPoint().getY()||
								!getEdgeColor().equals(line.getEdgeColor())) {
								
								
								model.execute(new ModifyShape(line,  new Line(new Position(x1,y1) , new Position(x2,y2), getEdgeColor())));
								mainPanel.repaint();
							}
						}
						setConfirm(true);
						setVisible(false);
					
					}
				} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Enter numbers only", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
			
		}
		
	}
	


	public String getTextX1() {
		return dlgXYPanel1.getTextX();
	}
	
	public String getTextY1() {
		return dlgXYPanel1.getTextY();
	}
	
	
	public String getTextX2() {
		return dlgXYPanel2.getTextX();
	}
	
	public String getTextY2() {
		return dlgXYPanel2.getTextY();
	}
	
	public void setTextX1(String value) {
		dlgXYPanel1.setTxtX(value);
	}
	
	public void setTextY1(String value) {
		dlgXYPanel1.setTxtY(value);
	}
	
	public void setTextX2(String value) {
		dlgXYPanel2.setTxtX(value);
	}
	
	public void setTextY2(String value) {
		dlgXYPanel2.setTxtY(value);
	}
	
	
	
	
	
	
	


	
	

}
