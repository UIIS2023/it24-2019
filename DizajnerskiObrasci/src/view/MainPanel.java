package view;

import java.awt.BasicStroke;
import java.awt.Color;
import controller.KeyControlor;
import controller.MouseControlor;
import model.Point;
import model.Position;
import model.Shape;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;




public class MainPanel extends JPanel {

	private MainWindow frame;
	private Position startPoint;
	


	public MainPanel(MainWindow frame) {
		
		this.frame = frame;
		setBackground(Color.WHITE); 
		setFocusable(true);
	    requestFocus();
	    addKeyListener(new KeyControlor(frame));
		addMouseListener(new MouseControlor(frame));
	
	}
	


	public void paint(Graphics g) {
		
		super.paint(g);
		//drawCoordinateLines(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setStroke(new BasicStroke(2));
		for(Shape shape : frame.getModel().getShapes()) {
			shape.draw(g2);
			if(shape.isSelected()) {
				shape.drawSelectMark(g2);
			}
	
		}
		
			
	}
	
	private void drawCoordinateLines(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
		g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
	}

	public Position getFirstClick() {
		return startPoint;
	}

	public void setFirstClick(Position startPoint) {
		this.startPoint = startPoint;
	}

	
	
	
	
	

}
