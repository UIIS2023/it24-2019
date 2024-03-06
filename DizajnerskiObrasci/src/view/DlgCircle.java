package view;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import commandx.ModifyShape;
import model.Circle;
import model.Position;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgCircle extends MyDialog {
	


	private ParameterPanel dlgParameterPanel ;

	public DlgCircle() {
		
		setTitle("Set Circle");
		
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
	
		positionPanel = new XYPanel("CENTER OF CIRCLE", "COORDINATE X:", "COORDINATE Y:") ;
		contentPanel.add(positionPanel, gbc);
		
		
		//---------------------------------------
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		dlgParameterPanel = new ParameterPanel("RADIUS:") ;
		contentPanel.add(dlgParameterPanel, gbc);
		dlgParameterPanel.setFocus();
		
		
		//---------------------------------------
	
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPanel.add(this.colorButtonPanel,gbc);
	
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPanel.add(new JLabel(),gbc);
		
		okButton.addActionListener(new EventHandler()) ;
		
	
	}
	

	private class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if (positionPanel.getTextX().trim().isEmpty() || 
				positionPanel.getTextY().trim().isEmpty() || 
				dlgParameterPanel.getParameterTxt().trim().isEmpty())
			{
				setConfirm(false);
				JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} 
			
			
			else {
				try {
					int x = positionPanel.getValueX();
					int y = positionPanel.getValueY();
					int R = dlgParameterPanel.getValue();
					Color inner = getInnerColor() ;
					Color edge = getEdgeColor();
					if ( x < 0 || y < 0 ) 
					{
						JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} 
					else 
					{
						if(shape == null) { //ako shape ne pokazuje ni nasta onda se desava Kreacija
							shape = new Circle(new Position(x,y) , R, edge, inner);
						}
						else { //u suprotnom shape pokazuje na nesto tj desava se Modifikacija
							Circle circle = (Circle)shape;
	
							if(x != circle.getCenter().getX() ||
									y != circle.getCenter().getY()||
									R != circle.getRadius() ||
									!inner.equals(circle.getInnerColor()) ||
									!edge.equals(circle.getEdgeColor())) {
								
								
								model.execute(new ModifyShape(circle,  new Circle(new Position(x,y) , R, edge, inner)));
								mainPanel.repaint();
							}
						}
						
						setConfirm(true);
						setVisible(false);
			
					}
				} 
				
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
			
		}
		
	}
	

	

	
	public String getTextR() {
		return dlgParameterPanel.getParameterTxt();
	}
	
	public void setTextR(String value) {
		
		dlgParameterPanel.setParameterTxt(value);
	}
	
	
	


}
