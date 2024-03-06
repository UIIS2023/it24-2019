//package command;
//
//
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//import java.beans.PropertyChangeSupport;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.LinkedList;
//
//import javax.swing.JFileChooser;
//import javax.swing.JTextArea;
//
//import model.Model;
//
//public class CommandModel {
//	
//	private LinkedList<Command> undoStack= new LinkedList<>();
//	private LinkedList<Command> redoStack = new LinkedList<>();
//	private LinkedList<String> logoStackForFile = new LinkedList<>();
//	private int logoIndex = 0;
//
//	PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
//	private JTextArea textArea;
//	private Model model;
//	
//	public CommandModel() {
//		
//	}
//	
//	
//
//	public void setModel(Model model) {
//		this.model = model;
//	}
//	
//
//	
//	public void setConsole(JTextArea textArea) {
//		this.textArea = textArea;
//	}
//	
//	public JTextArea getConsole() {
//		return textArea;
//	}
//	
//	public void execute(Command command) {
//		
//		
//		redoStack.clear();
//		undoStack.add(command);
//		
//		logoStackForFile.add(command.stringForLogo(CommandText.LOGO_FOR_FILE));
//		
//		command.execute(model);
//		logoIndex++;
//		
//		testEvent();
//		
//
//		
//	}
//	public void undo() {
//		if(undoStack.isEmpty()) {
//			return ;
//		}
//		Command command = undoStack.removeLast();
//		textArea.append("UNDO: " + command.stringForLogo(CommandText.CONSOLE)+"\n");
//		redoStack.add(command);
//		command.undo(model);
//		logoIndex--;
//		testEvent();
//		
//		
//		
//	}
//
//	
//	public void redo() {
//		
//		if(redoStack.isEmpty()) {
//			return ;
//		}
//		Command command = redoStack.removeLast();
//		undoStack.add(command);
//		command.redo(model);
//		textArea.append("REDO: " + command.stringForLogo(CommandText.CONSOLE)+"\n");
//		logoIndex++;
//		testEvent();
//	
//	}
//	
//	public void addPropertyChangeListener(PropertyChangeListener listener) {
//		
//		changeSupport.addPropertyChangeListener(listener);
//	
//	}
//	
//	
//	 protected void fire(String stringSos, Object o, Object n ) {
//	
//		    PropertyChangeEvent event = new PropertyChangeEvent( changeSupport, stringSos, o, n );
//		    
//		    for( PropertyChangeListener listener : changeSupport.getPropertyChangeListeners() ) {
//		    	
//		    	listener.propertyChange( event );
//		    }
//	}
//	
//	
//	private void testEvent() {
//		
//		if(undoStack.isEmpty()) fire("undoDisable", null	, null);
//		else fire("undoEnable", null	, null);
//	
//		
//		if(redoStack.isEmpty()) fire("redoDisable", null	, null);
//		else fire("redoEnable", null, null);
//		
//	}
//	public ArrayList<String> logoAsStringArray(){
//		ArrayList<String> LogoString = new ArrayList<>();
//		for(Command command : undoStack) {
//			LogoString.add(command.stringForLogo(CommandText.LOGO_FOR_FILE));
//		}
//		return LogoString;
//	}
//	
//	
//
//	
//	
//	
//	
//
//}
