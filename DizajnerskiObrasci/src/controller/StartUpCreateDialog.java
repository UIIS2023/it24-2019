package controller;



import commandx.*;
import model.*;
import view.*;


public class StartUpCreateDialog {
	
	
	static public void startDialog(Model model, MainWindow frame , Position click) {
		
		MyDialog dialog = null;
		Shape newShape = null;
		
		if (frame.getRdbtnPoint().isSelected()) {

			newShape = new Point(click.getX(), click.getY(), frame.btnSelectEdgeColor.getBackground());
			Command command = new CreateShape(newShape);
			model.execute(command);
			frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
			frame.getMainPanel().repaint();

		} else if (frame.getRdbtnLine().isSelected()) {

			if (frame.getMainPanel().getFirstClick() == null)
				frame.getMainPanel().setFirstClick(click);
			else {
				newShape = new Line(frame.getMainPanel().getFirstClick(), click, frame.btnSelectEdgeColor.getBackground());
				frame.getMainPanel().setFirstClick(null);
				
				
				Command command = new CreateShape(newShape);
				model.execute(command);
				frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
				frame.getMainPanel().repaint();
			}

		} else if (frame.getRdbtnCircle().isSelected()) {

			dialog = new DlgCircle();
		
			
		} else if (frame.getRdbtnDonut().isSelected()) {

			dialog = new DlgDonut();
		
		} else if (frame.getRdbtnRectangle().isSelected()) {

			dialog = new DlgRectangle();
			
		}
		else if (frame.getRdbtnHexagon().isSelected()) {

			dialog = new DlgHexagon();
			
		}
		
		if(dialog != null) {
		
			dialog.setTextX("" + Integer.toString(click.getX()));
			dialog.setTextY("" + Integer.toString(click.getY()));
			
			dialog.setVisibleForColorDialog(false);
			dialog.setVisible(true);
			dialog.disableXY();
			
			dialog.setModal(true);
			
			
			if (dialog.isConfirm()) {
				newShape = dialog.getShapee();
			}
			
				
			
			if (newShape != null) {
				newShape.setEdgeColor(frame.btnSelectEdgeColor.getBackground());
				if(newShape instanceof SurfaceShape) {
					((SurfaceShape)newShape).setInnerColor(frame.btnSelectInnerColor.getBackground());
				}
			
				Command command = new CreateShape(newShape);
				model.execute(command);
				frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
			}
			
			
	
			frame.getMainPanel().repaint();
		
		}
		
	}

}
