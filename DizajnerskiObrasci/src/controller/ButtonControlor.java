package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import commandx.*;
import model.*;
import view.*;




public class ButtonControlor implements ActionListener {
	

	private Model model;
	private MainWindow frame;

	
	public ButtonControlor(MainWindow frame) {
		this.frame = frame;
		model = frame.getModel();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OPEN")) {
			open();
		}
		else if(e.getActionCommand().equals("SAVE")) {
			save();
		}
		
		else if(e.getActionCommand().equals("DELETE")) {
			delete();
		}
		else if(e.getActionCommand().equals("UNDO")) {
			undo();
		}
		else if(e.getActionCommand().equals("REDO")) {
			redo();
		}
	
		else if(e.getActionCommand().equals("TO BACK")) {
			toBack();
		}
		else if(e.getActionCommand().equals("TO FRONT")) {
			toFront();
		}
		else if(e.getActionCommand().equals("BRING TO BACK")) {
			bringToBack();
		}
		else if(e.getActionCommand().equals("BRING TO FRONT")) {
			bringToFront();
		}
		
		else if(e.getActionCommand().equals("MODIFY")) {
			
			
				modify();
			
		}
		
		
	}
	
	private void toBack() {
		
		Shape shape = model.getSelectedShapes().get(0);
		
		Command command = new ToBack(shape);
	
		model.execute(command);
		frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
		
	}
	private void toFront() {
		
		Command command = new ToFront(model.getSelectedShapes().get(0));
		model.execute(command);
		frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
	}
	private void bringToBack() {
		
		Command command = new BringToBack(model.getSelectedShapes().get(0));
	
		model.execute(command);
		frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
	}
	private void bringToFront() {
		
		Command command = new BringToFront(model.getSelectedShapes().get(0));
		model.execute(command);
		frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
	
	}
	

	private void modify() {
		
		Shape selectedShape = model.getSelectedShapes().get(0);
		StartUpModifyDialog.startDialog(selectedShape, model, frame.getMainPanel());
		
	}
	


	private void undo() {
		
		
		Command command = model.undo();
		if(command != null) {
			frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+ " - COMMAND IS UNDO\n");
			frame.getMainPanel().repaint();
		}
		
		
	}
	
	private void redo() {
		Command command = model.redo();
		if(command != null) {
			frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+ " - COMMAND IS REDO\n");
			frame.getMainPanel().repaint();
		}
	}
	
	private void save() {
		model.save();	
	}
	private void open() {
		
		try {
			model.load();
			frame.getMainPanel().repaint();	
		} 

		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	private void delete() {
		

		if (model.isShapeSelected()) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning message",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				Command command = new DeleteShape(model.getSelectedShapes(), model.indexsOfSelectedShapes());
				model.execute(command);
				model.FireChange();
				frame.getConsole().append(command.stringForLogo(CommandTextType.CONSOLE)+"\n");
			}
		} 
		else {
			JOptionPane.showMessageDialog(null, "You haven't selected any shape!", "Error",
					JOptionPane.WARNING_MESSAGE);
		}

		frame.getMainPanel().repaint();
		
	}

	

}
