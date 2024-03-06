package view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import commandx.ModifyShape;
import model.HexagonAdapter;

public class DlgHexagon extends MyDialog {


	private ParameterPanel dlgParameterPanel ;
	


	public DlgHexagon() {
		setTitle("SET HEXAGON");
	
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		

		positionPanel = new XYPanel("CENTER OF HEXAGON", "COORDINATE X:", "COORDINATE Y:") ;
		contentPanel.add(positionPanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = gbc.WEST;
		dlgParameterPanel = new ParameterPanel("RADIUS:") ;
		contentPanel.add(dlgParameterPanel, gbc);
		
		
		//---------------------------------------
	
		
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPanel.add(colorButtonPanel,gbc);
		
		
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
					if ( x < 0 || y < 0 || R <= 0) 
					{
						JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} 
					else 
					{
						
						
						if(shape == null) {
						
							shape = new HexagonAdapter(x,y,R, edge, inner);
						}
						else {
							HexagonAdapter hex = (HexagonAdapter)shape;
							System.out.println(shape);
							if(x != hex.getCenter().getX() ||
									y != hex.getCenter().getY()||
									R != hex.getR() ||
									!inner.equals(hex.getInnerColor()) ||
									!edge.equals(hex.getEdgeColor())) {
								
								
								
								
								model.execute(new ModifyShape(hex,  new HexagonAdapter(x, y , R, edge, inner)));
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
