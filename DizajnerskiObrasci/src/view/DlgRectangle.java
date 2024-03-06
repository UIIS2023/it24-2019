package view;


import java.awt.Color;

import javax.swing.JOptionPane;

import commandx.ModifyShape;

import model.Position;
import model.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends MyDialog {


	private ParameterPanel dlgWidth ;
	private ParameterPanel dlgHeight ;



	public DlgRectangle() {
		setTitle("SET RECTANGLE");
	

		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
	
		positionPanel = new XYPanel("UPPER LEFT POINT", "COORDINATE X:", "COORDINATE Y:") ;
		contentPanel.add(positionPanel, gbc);
		
		
		//---------------------------------------
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = gbc.WEST;
		dlgWidth = new ParameterPanel("WIDTH:") ;
		contentPanel.add(dlgWidth, gbc);
		
		//---------------------------------------
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = gbc.WEST;
		dlgHeight = new ParameterPanel("HIGHT:") ;
		contentPanel.add(dlgHeight, gbc);
		
		//-------------------------------------------
	

		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPanel.add(colorButtonPanel,gbc);
		
	
		okButton.addActionListener(new EventHandler()) ;
	
		
	
		
	}
	

	private class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if (positionPanel.getTextX().trim().isEmpty() || 
				positionPanel.getTextY().trim().isEmpty() || 
				dlgWidth.getParameterTxt().trim().isEmpty() ||
				dlgHeight.getParameterTxt().trim().isEmpty())
			{
				setConfirm(false);
				JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} 
			
			else {
				try {
					int x = getValueX();
					int y = getValueY();
					int W = Integer.parseInt(dlgWidth.getParameterTxt()) ;
					int H = Integer.parseInt(dlgHeight.getParameterTxt()) ;
					Color inner = getInnerColor() ;
					Color edge = getEdgeColor();
					if ( x < 0 || y < 0 || W <= 0 || H <= 0) 
					{
						JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} 
					else 
					{
						
						
						if(shape == null) {
							shape = new Rectangle(new Position(x,y) , W, H, edge, inner);
						}
						else {
							Rectangle rect = (Rectangle)getShapee();
							System.out.println(shape);
							if(x != rect.getUpperLeft().getX() ||
									y != rect.getUpperLeft().getY()||
									W != rect.getWidth() ||
									H != rect.getHeight() ||
									!inner.equals(rect.getInnerColor()) ||
									!edge.equals(rect.getEdgeColor())) {
								
								
								model.execute(new ModifyShape(rect,  new Rectangle(new Position(x,y) , W, H, edge, inner)));
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
	
	


	
	public String getTextW() {
		return dlgWidth.getParameterTxt();
	}
	
	public void setTextW(String value) {
		dlgWidth.setParameterTxt(value);
	}
	
	
	public String getTextH() {
		return dlgHeight.getParameterTxt();
	}
	
	public void setTextH(String value) {
		dlgHeight.setParameterTxt(value);
	}
	
	
	
	
	

	
	

}
