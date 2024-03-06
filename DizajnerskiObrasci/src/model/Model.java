package model;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import commandx.*;



public class Model {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	private LinkedList<Command> undoStack= new LinkedList<>();
	private LinkedList<Command> redoStack = new LinkedList<>();
	private LinkedList<String> logoStackForFile = new LinkedList<>();
	private int executeIndex = -1;
	private boolean isExecuteCommand = true;
	private boolean normalMode = true;

	
	public Model() {
		
	}
	
	PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public ArrayList<Shape> getSelectedShapes() {
		
		ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
		for(Shape shape : shapes) {
			if(shape.isSelected()) {
				selectedShapes.add(shape);
			}
		}
		
		return selectedShapes;
		
	}
	
	public boolean isShapeSelected() {
		return !getSelectedShapes().isEmpty();
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}
	
	
	public void FireChange() {
		
		
		int n = this.numberOfSelectedShapes();
		if(n == 1) {
			changeSupport.firePropertyChange("oneselect", null, null);
		}
		else if(n == 0){
			changeSupport.firePropertyChange("noselect", null, null);
		}
		else {
			changeSupport.firePropertyChange("moreselect", null, null);
		}
		
		
	}
	
	private int numberOfSelectedShapes() {
		return this.getSelectedShapes().size();
	}
	
	
	
	public Shape getElement(int index) {
		return shapes.get(index);
	}
	
	public void setElement(int index, Shape shape) {
		shapes.set(index, shape);
	}
	
	public void swap(int k, int m) {
		Collections.swap(shapes, k, m);
	}
	public ArrayList<Integer> indexsOfSelectedShapes() {
		
		ArrayList<Integer> indeksi = new ArrayList<>();
		for(Shape shape : getSelectedShapes()) {
			int index = shapes.indexOf(shape);
			indeksi.add(index);
		}
		return indeksi;
		
	}
	

	
	
	public Shape getShapeByLogoId(int logoId) {
		for(Shape shape : shapes) {
			if(shape.getLogoId() == logoId) return shape;
		}
		return null;
	}
	
	public Shape getClickedShape(Position p) {
		
		for (Shape shape : shapes) {
			if (shape.contains(p)){
				return shape;
			}
		}
		return null;
		
	}
	
	public Command redo() {
		
		
		
		
		isExecuteCommand = false;
		Command command = null;
		
		if(isNormalMode()) {
			
			if(redoStack.isEmpty()) return null;
			command = redoStack.removeLast();
			undoStack.add(command);
			logoStackForFile.add("REDO");
		}
		else {
			
			command = undoStack.get(executeIndex);
		}
		execute(command);
		
		isExecuteCommand = true;
		
		testEvent();
		return command;
		
	}
	//---------------------------------------------------
	//UNDO
	
	public Command undo() {
		
		if(undoStack.isEmpty()) return null ;
		Command command = null;
		
		if(isNormalMode()) {
			
			command = undoStack.removeLast();
			logoStackForFile.add("UNDO");
			redoStack.add(command);
			
		}
		else {
			command = undoStack.get(executeIndex);
		}
		
		if(command instanceof DeleteShape) {
			
			DeleteShape delete = (DeleteShape)command;
			this.UndoDeleteSelectedShape(delete);
			
			
		}
		else if(command instanceof MoveShape) {
			
			UndoMoveSelectedShape((MoveShape)command);
			
		}
		else if(command instanceof SelecteShape) {
			SelecteShape selecte = (SelecteShape)command;
			selecte.getSelectedShape().setSelected(false);
			FireChange();
			
		}
		else if(command instanceof UnselecteShape) {
			UnselecteShape unselecte = (UnselecteShape)command;
			unselecte.getShape().setSelected(true);
			FireChange();
		}
	
		else if(command instanceof CreateShape) {
			CreateShape create = (CreateShape)command;
			shapes.remove(create.getCreateShape());
		}
		else if(command instanceof BringToFront) {
			BringToFront bringToFront = (BringToFront)command;
			Shape selectedShape = bringToFront.getSelectedShape();
			int index = bringToFront.getIndex();
			shapes.remove(shapes.size()-1);
			shapes.add(index, selectedShape);
			
		}
		else if(command instanceof BringToBack) {
			BringToBack bringToBack = (BringToBack)command;
			Shape selectedShape = bringToBack.getSelectedShape();
			int index = bringToBack.getIndex();
			shapes.remove(0);
			shapes.add(index, selectedShape);
		
			
		}
		else if(command instanceof ToBack) {
			ToBack toBack = (ToBack)command;
			Shape selectedShape = toBack.getSelectedShape();
			int index = shapes.indexOf(selectedShape);
			swap(index, index+1);
			
		}
		else if(command instanceof ToFront) {
			ToFront toFront = (ToFront)command;
			Shape selectedShape = toFront.getSelectedShape();
			int index = shapes.indexOf(selectedShape);
			swap(index, index-1);
			
		}
		else if(command instanceof ModifyShape) {
			ModifyShape modify = (ModifyShape)command;
			Shape selectedShape = this.getSelectedShapes().get(0);
			selectedShape.changeAtribute(modify.getBefore());
		
		}
		else if(command instanceof UnselectAll) {
			UnselectAll unselectAll = (UnselectAll)command;
			for(Shape shape : unselectAll.getShapes() ) {
				shape.setSelected(true);
			}
			
		}
		testEvent();
		FireChange();
		return command;
		
		
	}
	//---------------------------------------------------------
	//EXECUTE
	public void execute(Command command) {
		
		
		
		if(command instanceof DeleteShape) {
			DeleteShape delete = (DeleteShape)command;
			DeleteSelectedShape(delete);
			
		}
		else if(command instanceof MoveShape) {
			MoveShape move = (MoveShape)command;
			MoveSelectedShape(move);
		}
		else if(command instanceof SelecteShape) {
			SelecteShape selecte = (SelecteShape)command;
			
			if(selecte.getSelectedShape().isSelected()) return ;
			selecte.getSelectedShape().setSelected(true);
			FireChange();
			
		}
		else if(command instanceof UnselecteShape) {
			UnselecteShape unselecte = (UnselecteShape)command;
			unselecte.getShape().setSelected(false);
			FireChange();
			
		}
		
		else if(command instanceof BringToFront) {
			BringToFront bringToFront = (BringToFront)command;
			Shape selectedShape = this.getSelectedShapes().get(0);
			bringToFront.setSelectedShape(selectedShape);
			int index = shapes.indexOf(selectedShape);
			bringToFront.setIndex(index);
			if(index == shapes.size() - 1) return ;
			shapes.remove(index);
			shapes.add(selectedShape);
			
		}
		else if(command instanceof BringToBack) {
			BringToBack bringToBack = (BringToBack)command;
			Shape selectedShape = this.getSelectedShapes().get(0);
			bringToBack.setSelectedShape(selectedShape);
			int index = shapes.indexOf(selectedShape);
			bringToBack.setIndex(index);
			if(index == 0) return ;
			shapes.remove(index);
			shapes.add(0, selectedShape);
			
		}
		else if(command instanceof ToBack) {
			ToBack toBack = (ToBack)command;
			Shape selectedShape = this.getSelectedShapes().get(0);
			int index = shapes.indexOf(selectedShape);
			if( index == 0) return ;
			swap(index, index-1);
			
		}
		else if(command instanceof ToFront) {
			ToFront toFront = (ToFront)command;
			Shape selectedShape = this.getSelectedShapes().get(0);
			int index = shapes.indexOf(selectedShape);
			if( index == shapes.size()-1) return ;
			swap(index, index+1);
			
		}
		
		else if(command instanceof UnselectAll) {
			UnselectAll unselectAll = (UnselectAll)command;
			for(Shape shape : unselectAll.getShapes() ) {
				shape.setSelected(false);
			}
			
		}
		else if(command instanceof CreateShape) {
			CreateShape create = (CreateShape)command;
			shapes.add(create.getCreateShape());
		}
		else if(command instanceof ModifyShape) {
			ModifyShape modify = (ModifyShape)command;
			Shape selectedShape = this.getSelectedShapes().get(0);
			selectedShape.changeAtribute(modify.getAfter());
		
		}
		
		if(isNormalMode() && isExecuteCommand) {
			undoStack.add(command);
			redoStack.clear();
			logoStackForFile.add(command.stringForLogo(CommandTextType.LOGO_FOR_FILE));
			testEvent();
		}
		
	
		
		
		
	}
	
	protected void fire(String stringSos, Object o, Object n ) {
		
	    PropertyChangeEvent event = new PropertyChangeEvent( changeSupport, stringSos, o, n );
	    
	    for( PropertyChangeListener listener : changeSupport.getPropertyChangeListeners() ) {
	    	
	    	listener.propertyChange( event );
	    }
}
	
	
	private void testEvent() {
		
		if(undoStack.isEmpty()) fire("undoDisable", null	, null);
		else fire("undoEnable", null	, null);
	
		
		if(redoStack.isEmpty()) fire("redoDisable", null	, null);
		else fire("redoEnable", null, null);
		
	}
	
	private void MoveSelectedShape(MoveShape move) {
		
		int dx = move.getDx();
		int dy = move.getDy();
		
		for(Shape shape : move.getMovingShapes()) {
			shape.moveBy(dx, dy);
		}
	}
	
	private void UndoMoveSelectedShape(MoveShape move) {
			
		int dx = -move.getDx();
		int dy = -move.getDy();
		
		for(Shape shape : move.getMovingShapes()) {
			shape.moveBy(dx, dy);
		}
	}
	
	private void DeleteSelectedShape(DeleteShape delete) {
		for(Shape shape : delete.getDeleteShapes()) {
			shapes.remove(shape);
		}
	}
	
	private void UndoDeleteSelectedShape(DeleteShape delete) {
		
		int i = 0;
		for(Shape shape : delete.getDeleteShapes()) {
			shapes.add(delete.getIndexs().get(i++), shape);
		}
	}
	
	
	
	
	
	public void save() {
		FileTools.save(shapes);
	}
	
	public void load() throws Exception {
		FileTools.load(shapes);;
	}
	
	public void saveLogo() {
		FileTools.saveLogo(logoStackForFile);
	}
	public void incrementExecuteIndex() {
		executeIndex++;
	}
	public void decrementExecuteIndex() {
		executeIndex--;
	}

	
	public boolean isNormalMode() {
		return normalMode;
	}
	public void setNormalMode(boolean normalMode) {
		this.normalMode = normalMode;
	}
	
	public void setExecuteCommandFromLogoFile(LinkedList<Command> commands) {
		undoStack.clear();
		shapes.clear();
		
		for(Command comm : commands) {
			if(comm instanceof Undo == false && comm instanceof Redo == false) {
				undoStack.add(comm);
			}
		}
	}
	
	public int getExecuteIndex() {
		return executeIndex;
	}
	
	public void clear() {
		shapes.clear();
	}
	public int size() {
		return undoStack.size();
	}
	
	
	
	



}
