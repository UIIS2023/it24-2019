package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.Model;
import view.MainWindow;

public class LogoButtonControlor {

	/*private Model model;
	private JTextArea console;
	private LogoControlor logoCommandControlor ;
	private MainWindow frame;

	
	public LogoButtonControlor(MainWindow frame) {
		
		this.frame = frame;
		model = frame.getModel();
		console = frame.getConsole();
		logoCommandControlor = new LogoControlor(frame);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("SAVE AS LOGO")) {
			logoCommandControlor.saveLogo();
		}
		else if(e.getActionCommand().equals("LOAD LOGO")) {
			try {	
				logoCommandControlor.loadLogo();
				model.getShapes().clear();
			}
			catch(Exception excep) {
				
				JOptionPane.showMessageDialog(null, "Logo file is not valid", "Error", JOptionPane.ERROR_MESSAGE);
			}
			  
		}
		else if(e.getActionCommand().equals("  NEXT  ")) {
				next();
		}
		else if(e.getActionCommand().equals("PREVIOUS")) {
				previous();
		}
		else if(e.getActionCommand().equals("CANCEL LOGO")) {
				cancel();
		}
		else if(e.getActionCommand().equals("ACCEPT LOGO")) {
				accept();
		}
		
	}
	

	
	
	private void next() {
		
		String stringForLogo = logoCommandControlor.executeCommand();
		console.append(stringForLogo + "\n");
		
		if(!logoCommandControlor.hasNext()) {
			frame.next.setEnabled(false);
		}
		frame.previous.setEnabled(true);
		frame.getMainPanel().repaint();
		
	}
	
	private void previous() {
		
		String stringForLogo = logoCommandControlor.undoCommand();
		console.append(stringForLogo + "\n");
		

		if(logoCommandControlor.hasPrevious()) {
			frame.next.setEnabled(true);
		}
		else {
			model.getShapes().clear();
			frame.previous.setEnabled(false);
		}
		frame.getMainPanel().repaint();
		
	
			
	
			
	}
	
	private void cancel() {
		logoCommandControlor.clearCommands();
		model.getShapes().clear();
		frame.next.setVisible(false);
		frame.previous.setVisible(false);
		frame.cancel.setVisible(false);
		frame.accept.setVisible(false);
		frame.getMainPanel().repaint();
		console.setText("");
		
		
		
	}
	
	private void accept() {
		
		logoCommandControlor.clearCommands();
		frame.next.setVisible(false);
		frame.previous.setVisible(false);
		frame.cancel.setVisible(false);
		frame.accept.setVisible(false);
		console.setText("");
		/*for(Shape shape : model.getShapes()) {
			shape.setSelected(false);
		}
		model.unSelectAll();
		frame.getMainPanel().repaint();
		
	}*/

}
