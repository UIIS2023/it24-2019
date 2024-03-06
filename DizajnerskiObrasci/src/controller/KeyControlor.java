package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import commandx.MoveShape;
import commandx.Command;
import commandx.CommandTextType;
import model.Model;
import model.Shape;
import view.MainWindow;

public class KeyControlor extends KeyAdapter {
	
	
	
		private Model model;
		private MainWindow frame;
		
		public KeyControlor(MainWindow frame) {

			this.frame = frame;
			model = frame.getModel();
		
		}
		
	
		private void moveSelectedShape(int dx, int dy) {
			ArrayList<Shape> shapes = model.getSelectedShapes();
			if(!shapes.isEmpty()) {
				Command command = new MoveShape(model.getSelectedShapes(), dx, dy);
				model.execute(command);
				frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
			
			}
			
		}
	
	  @Override
	  public void keyPressed(KeyEvent e) {
		  
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT :
			
			moveSelectedShape(5,0);
			e.consume();
			break;
		case KeyEvent.VK_LEFT :
			moveSelectedShape(-5,0);
			e.consume();
			break;
		case KeyEvent.VK_UP :
			moveSelectedShape(0,-5);
			e.consume();
			break;
		case KeyEvent.VK_DOWN :
			moveSelectedShape(0, 5);
			e.consume();
			break;
		case 90:
			if(e.isControlDown()) {
				System.out.println("what");
				Command command = model.undo();
				if(command != null) {
					frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+ " - COMMAND IS UNDO\n");
					frame.getMainPanel().repaint();
				}
				e.consume();
			}
			break;
		case 89:
			if(e.isControlDown()) {
				Command command = model.redo();
				if(command != null) {
					frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+ " - COMMAND IS REDO\n");
					frame.getMainPanel().repaint();
				}
				e.consume();
			}
			break;
		}
		
		
		frame.getMainPanel().repaint();
	  }



	      
	   
}
