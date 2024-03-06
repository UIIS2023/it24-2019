package view;


import java.awt.Color;

import javax.swing.JOptionPane;

import commandx.ModifyShape;
import model.Donut;

import model.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends MyDialog {
	


	private ParameterPanel dlgInnerR ;
	private ParameterPanel dlgOuterR ;
	


	public DlgDonut() {
		setTitle("SET DONUT");
		setResizable(false);
		setModal(true);
		setBackground(Color.WHITE);
		
	
		setBounds(0, 0, 400, 300);
		
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
	
		positionPanel = new XYPanel("CENTER OF DONUT", "COORDINATE X:", "COORDINATE Y:") ;
		contentPanel.add(positionPanel, gbc);
		
		
		//---------------------------------------
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = gbc.WEST;
		dlgOuterR = new ParameterPanel("OUTER RADIUS:") ;
		contentPanel.add(dlgOuterR, gbc);
		
		
		//---------------------------------------
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = gbc.WEST;
		dlgInnerR = new ParameterPanel("INNER RADIUS:") ;
		contentPanel.add(dlgInnerR, gbc);
		
		
		
	
		//-------------------------------------------
	
		
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPanel.add(this.colorButtonPanel,gbc);
	
		
		okButton.addActionListener(new EventHandler()) ;
	
		
		
		
	}
	

	private class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if (getTextX().trim().isEmpty() || 
				getTextY().trim().isEmpty() || 
				getTextInnerR().trim().isEmpty() ||
				getTextOuterR().trim().isEmpty())
			{
				setConfirm(false);
				JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} 
			
			else {
				try {
					int x = Integer.parseInt(getTextX());
					int y = Integer.parseInt(getTextY());
					int innerR = Integer.parseInt(getTextInnerR()) ;
					int outerR = Integer.parseInt(getTextOuterR()) ;
					Color inner = getInnerColor() ;
					Color edge = getEdgeColor();
					if ( x < 0 || y < 0 || outerR <= 0 || innerR <= 0) 
					{
						JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} 
					else 
					{
						
						
						
						if(shape == null) {
							shape = new Donut(new Position(x,y) , outerR, innerR, edge, inner);
						}
						else {
							Donut donut = (Donut)shape;
							System.out.println(shape);
							if(x != donut.getCenter().getX() ||
								y != donut.getCenter().getY()||
									outerR != donut.getRadius() ||
									innerR != donut.getInnerRadius() ||
									!inner.equals(donut.getInnerColor()) ||
									!edge.equals(donut.getEdgeColor())) {
								
								
								model.execute(new ModifyShape(donut,  new Donut(new Position(x,y) , outerR, innerR, edge, inner)));
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
	
	


	
	
	public String getTextInnerR() {
		return dlgInnerR.getParameterTxt();
	}
	
	public void setTextInnerR(String value) {
		dlgInnerR.setParameterTxt(value);
	}
	
	
	public String getTextOuterR() {
		return dlgOuterR.getParameterTxt();
	}
	
	public void setTextOuterR(String value) {
		dlgOuterR.setParameterTxt(value);
	}
	
	
	
	


}
