package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import commandx.*;
import model.*;
import view.MainWindow;


public class LogoControlor implements ActionListener{
	
	
	private int logoIndex = 0;
	private LinkedList<Command> commands = new LinkedList<>();
	private Model model;
	private MainWindow frame;
	private int p = 0;
	
	private JTextArea console;

	
	public LogoControlor(MainWindow frame) {
		
		this.frame = frame;
		model = frame.getModel();
		this.logoIndex = 0;
		console = frame.getConsole();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("SAVE AS LOGO")) {
			 saveLogo();
		}
		else if(e.getActionCommand().equals("LOAD LOGO")) {
			try {	
				loadLogo();
				model.setNormalMode(false);
				model.getShapes().clear();
				frame.getMainPanel().repaint();
				frame.getConsole().setText("");
				model.setExecuteCommandFromLogoFile(commands);
			}
			catch(InterruptedException excep) {
				
			}
			catch(Exception excep) {
				
				JOptionPane.showMessageDialog(null, "Logo file is not valid", "Error", JOptionPane.ERROR_MESSAGE);
				model.clear();
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
		
		Command command = commands.get(logoIndex);
		if(command instanceof Undo) {
			
			Command comm = model.undo();
			System.out.println(model.size() + " - " + model.getExecuteIndex());
			
			model.decrementExecuteIndex();
			console.append("UNDO COMMAND"  + this.forConsoleLogoMode(comm) + "\n");
			
		}
		else if(command instanceof Redo) {
		
			model.incrementExecuteIndex();
			Command comm = model.redo();
			System.out.println(model.size() + " - " + model.getExecuteIndex());
			
			console.append("REDO COMMAND: " + this.forConsoleLogoMode(comm) + "\n");
			
		}
		else {
			model.incrementExecuteIndex();
			model.execute(command);
			System.out.println(model.size() + " - " + model.getExecuteIndex());
			console.append("EXECUTE COMMAND: " + this.forConsoleLogoMode(command) + "\n");
			
		}
		
		
		
	
		if(logoIndex == commands.size()-1) {
			frame.next.setEnabled(false);
		}
		
		logoIndex++;
		frame.previous.setEnabled(true);
		frame.getMainPanel().repaint();
		
	}
	
	private void previous() {
		p++;
		
		logoIndex--;
		
			
		Command command = commands.get(logoIndex);
		String forConsole = "";
		Command comm = null;
	
		if(command instanceof Undo) {
			model.incrementExecuteIndex();
			comm = model.redo();
			System.out.println(model.getExecuteIndex());
			console.append("CANCEL UNDO: " + this.forConsoleLogoMode(comm) + "\n");
			
		
		}
		else if(command instanceof Redo) {
			
			
			System.out.println(model.size() + " - " + model.getExecuteIndex());
			comm = model.undo();
			model.decrementExecuteIndex();
			console.append("CANCEL REDO: " + this.forConsoleLogoMode(comm) + "\n");
			
			
		}
		else {
			
			
			comm = model.undo();
			System.out.println(model.size() + " - " + model.getExecuteIndex());
			model.decrementExecuteIndex();
			console.append("CANCEL EXECUTE: " + this.forConsoleLogoMode(comm) + "\n");
				
		}
			
			
		
		

		
		
		if(logoIndex != 0) {
			frame.next.setEnabled(true);
		}
		else {
			model.getShapes().clear();
			frame.previous.setEnabled(false);
		}
		frame.getMainPanel().repaint();
		
	
			
	
			
	}
	
	private void cancel() {
		commands.clear();
		model.getShapes().clear();
		frame.next.setVisible(false);
		frame.previous.setVisible(false);
		frame.cancel.setVisible(false);
		frame.accept.setVisible(false);
		frame.getMainPanel().repaint();
		console.setText("");
		model.setNormalMode(true);
		
		
	}
	
	private void accept() {
		
		commands.clear();
		frame.next.setVisible(false);
		frame.previous.setVisible(false);
		frame.cancel.setVisible(false);
		frame.accept.setVisible(false);
		console.setText("");
		if(model.isShapeSelected()) {
			frame.getTglbtnSelect().setSelected(true);
		}
		frame.getMainPanel().repaint();
		model.setNormalMode(true);
		
	}
	


	
	private void logoLines2Commands(ArrayList<String> stringCommands) {
		
		for(String logoLine : stringCommands) {
	
			LogoLine line = new LogoLine(logoLine, model);
			Command command = line.converToCommand();
			if(command instanceof CreateShape) {
				model.execute(command);
			}
			commands.add(command);
			
		}
		
	}
	
	

	void loadLogo() throws Exception {
		
		ArrayList<String> logos = getLogoLines();
		logoLines2Commands(logos);
		frame.next.setEnabled(true);
		frame.next.setVisible(true);
		frame.previous.setVisible(true);
		frame.cancel.setVisible(true);
		frame.accept.setVisible(true);
	
			
			
	}
	
	
	public  ArrayList<String> getLogoLines() throws Exception {
		
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showOpenDialog(null);
		
		
		
		ArrayList<String> logos = new ArrayList<>();
		
		if(response == JFileChooser.APPROVE_OPTION) {
			
			FileReader  reader = new FileReader (
					fileChooser.getSelectedFile().getAbsolutePath());
			
			Scanner sc = new Scanner(reader);
		
			
			
			while(sc.hasNext()) {
				String line = sc.nextLine();
				
				if(!line.equals("\n")) 	{
					logos.add(line);
				}
				
				
			}
			sc.close();
			
						
		}
		else {
			throw new InterruptedException();
		}
		
		return logos;
		
	}
	
		
	

	void saveLogo() {
		frame.getModel().saveLogo();
			
	}
	
	private String forConsoleLogoMode(Command command) {
		
		
		String[] arr =  command.stringForLogo(CommandTextType.CONSOLE).split("]") ;
		return arr[arr.length - 1];
		
	}



}
