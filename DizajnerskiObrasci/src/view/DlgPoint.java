package view;


import javax.swing.JOptionPane;

import commandx.ModifyShape;

import model.Point;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgPoint extends MyDialog {



	public DlgPoint() {
		setTitle("Set Point");
	
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		
	
		positionPanel = new XYPanel("CENTER OF CIRCLE", "COORDINATE X:", "COORDINATE Y:") ;
		contentPanel.add(positionPanel, gbc);
		
	
		gbc.gridx = 0;
		gbc.gridy = 1;
		contentPanel.add(colorButtonPanel,gbc);
		
		okButton.addActionListener(new EventHandler()) ;
		
	
	}
	

	private class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if (positionPanel.getTextX().trim().isEmpty() || 
					positionPanel.getTextY().trim().isEmpty() )
			{
				setConfirm(false);
				JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} 
			
			
			else {
				try {
					int x = positionPanel.getValueX();
					int y = positionPanel.getValueY();
				
					if ( x < 0 || y < 0) 
					{
						JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} 
					else 
					{
						if(shape == null) {
							shape = new Point(x,y, getEdgeColor());
						}
						else {
							Point point = (Point)shape;
							if(x != point.getX() ||
									y != point.getY()||
									!getEdgeColor().equals(point.getEdgeColor())) {
									
								model.execute(new ModifyShape(point,  new Point(x,y, getEdgeColor())));
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
	

	

}
