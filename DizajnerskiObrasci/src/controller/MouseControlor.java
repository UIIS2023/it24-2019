package controller;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import commandx.* ;
import model.*;
import view.MainWindow;


public class MouseControlor extends MouseAdapter{
	
	
	private Model model;
	private MainWindow frame;

	
	public MouseControlor(MainWindow frame) {
		this.frame = frame;
		model = frame.getModel();
	}
	
	
	public void mouseClicked(MouseEvent me) {
		thisMouseClicked(me);
	
		
	}
	
	protected void thisMouseClicked(MouseEvent me) {
		
		frame.getMainPanel().requestFocus();
		Position click = new Position(me.getX(), me.getY());

		if (frame.getTglbtnSelect().isSelected()) {
			
			selectButtonActivate(me, click);
		
		} 
		else {
			StartUpCreateDialog.startDialog(model, frame, click);
		}

	}
	
	
	
	private void selectButtonActivate(MouseEvent me, Position click) {
		
		
		Shape clickedShape = model.getClickedShape(click);
		boolean changeHappend = false;
		if(clickedShape != null) {
			if(clickedShape.isSelected() && me.isControlDown()) {
				
				Command command = new UnselecteShape(clickedShape);
				model.execute(command);
				frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
				changeHappend = true;
			}
			else if(clickedShape.isSelected() && !me.isControlDown()) {
				
				
			}
			else if(model.isShapeSelected() && !me.isControlDown()) {
				
				Command command1 = new UnselecteShape(model.getSelectedShapes().get(0));
				Command command2 = new SelecteShape(clickedShape);
				model.execute(command1);
				model.execute(command2);
				
				frame.getConsole().append(command1.stringForLogo(CommandTextType.CONSOLE)+"\n");
				frame.getConsole().append(command2.stringForLogo(CommandTextType.CONSOLE)+"\n");
				changeHappend = true;
			}
			else if(model.isShapeSelected() && !me.isControlDown()) {
				
				Command command = new SelecteShape(clickedShape);
				model.execute(command);
				frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
				
				changeHappend = true;
			}
			else {
				Command command = new SelecteShape(clickedShape);
				model.execute(command);
				frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
				changeHappend = true;
			}
		}
		else if(model.isShapeSelected() && !me.isControlDown()) {
			Command command = new UnselectAll(model.getSelectedShapes());
			model.execute(command);
			frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
			changeHappend = true;
		}
		if(changeHappend) {
			
			frame.getMainPanel().repaint();
			model.FireChange();
		}
		
	}



	

	

}
