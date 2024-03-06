package model;

import java.awt.Color;
import java.util.ArrayList;

import commandx.*;

public class LogoLine {
	
	private String logoLine;
	private Model model;
	
	public static String DILIM = ";";
	
	public LogoLine(String logoLine, Model model) {
		this.logoLine = logoLine;
		this.model = model;
	}
	
	
	public Command converToCommand() {
		
		String[] logoSplit = logoLine.split(LogoLine.DILIM);
		Shape shape = null;
		Command comm = null;
		
		if(logoSplit[0].equals("UNDO")) {
			return new Undo();
		}
		
		if(logoSplit[0].equals("REDO")) {
			return new Redo();
		}
		if(logoSplit[0].equals("C")){
			
			
			if(logoSplit[1].equals("Line")) {
			
				shape = Line.formObjectFromLogo(logoSplit);
				int id = Integer.parseInt(logoSplit[7]);
				shape.setLogoId(id);
			
				
			}
			else if(logoSplit[1].equals("Circle")) {
				
				
				shape = Circle.formObjectFromLogo(logoSplit);
				int id = Integer.parseInt(logoSplit[7]);
				shape.setLogoId(id);
				
			}
			else if(logoSplit[1].equals("Hexagon")) {
			
				shape = HexagonAdapter.formObjectFromLogo(logoSplit);
				int id = Integer.parseInt(logoSplit[7]);
				shape.setLogoId(id);
				
			}
			else if(logoSplit[1].equals("Donut")) {
	
				shape = Donut.formObjectFromLogo(logoSplit);
				int id = Integer.parseInt(logoSplit[8]);
				shape.setLogoId(id);
				
			}
			else if(logoSplit[1].equals("Rectangle")) {
				
				shape = Rectangle.formObjectFromLogo(logoSplit);
				int id = Integer.parseInt(logoSplit[8]);
				shape.setLogoId(id);
				
			}
			else if(logoSplit[1].equals("Point")) {
			
				
				shape = Point.formObjectFromLogo(logoSplit);
				int id = Integer.parseInt(logoSplit[5]);
				shape.setLogoId(id);
				
			}
			
			comm = new CreateShape(shape);
			
		}
		else if(logoSplit[0].equals("D") || logoSplit[0].equals("M") || logoSplit[0].equals("U")) {
			
			if(logoSplit[0].equals("D")) {
				
				int[] logoIds = new int[logoSplit.length]; 
				ArrayList<Shape> shapes = new ArrayList<>();
				
				for(int i =1 ; i < logoSplit.length ;i++) {
					Shape shh = model.getShapeByLogoId(Integer.parseInt( logoSplit[i]));
					shh.setSelected(true);
					shapes.add(shh);
				}
				comm = new DeleteShape(shapes, model.indexsOfSelectedShapes());			
			}
			else if(logoSplit[0].equals("M")) {
				
				
				
				int[] logoIds = new int[logoSplit.length]; 
				ArrayList<Shape> shapes = new ArrayList<>();
				
				int dx = Integer.parseInt(logoSplit[1]);
				int dy = Integer.parseInt(logoSplit[2]);
				
				for(int i =3 ; i < logoSplit.length ;i++) {
					Shape shh = model.getShapeByLogoId(Integer.parseInt( logoSplit[i]));
					shh.setSelected(true);
					shapes.add(shh);
				}
				comm = new MoveShape(shapes, dx, dy);
				
			}
			else if(logoSplit[0].equals("U")) {
				int[] logoIds = new int[logoSplit.length]; 
				ArrayList<Shape> shapes = new ArrayList<>();
				
				for(int i =1 ; i < logoSplit.length ;i++) {
					Shape shh = model.getShapeByLogoId(Integer.parseInt( logoSplit[i]));
					shh.setSelected(true);
					shapes.add(shh);
				}
				
				comm = new UnselectAll(shapes);
			}
			
		}
		else {
			
			Shape sh = model.getShapeByLogoId( Integer.parseInt( logoSplit[1]));
			
			if(sh == null) {
				throw new NullPointerException("null referenca logo line");
			}
			

			if(logoSplit[0].equals("S")) {
				comm = new SelecteShape(sh);
			}
			
			
			else if(logoSplit[0].equals("B")) {
				comm = new ToBack(sh);
			}
			else if(logoSplit[0].equals("F")) {
				comm = new ToFront(sh);
			}
			else if(logoSplit[0].equals("BTB")) {
				comm = new BringToBack(sh);
			}
			else if(logoSplit[0].equals("BTF")) {
				comm = new BringToFront(sh);
			}
			else if(logoSplit[0].equals("MD")) {
			
				if(sh instanceof Point) {
					comm = new ModifyShape(sh, Point.formObjectFromLogo(logoSplit));
				
				}
				else if(sh instanceof Line) {
					comm = new ModifyShape(sh, Line.formObjectFromLogo(logoSplit));
				}
				else if(sh instanceof Donut) {
					comm = new ModifyShape(sh, Donut.formObjectFromLogo(logoSplit));
				}
				else if(sh instanceof Circle) {
					comm = new ModifyShape(sh, Circle.formObjectFromLogo(logoSplit));
				}
				else if(sh instanceof HexagonAdapter) {
					comm = new ModifyShape(sh, HexagonAdapter.formObjectFromLogo(logoSplit));
				}
				else if(sh instanceof Rectangle) {
					comm = new ModifyShape(sh, Rectangle.formObjectFromLogo(logoSplit));
				}
					
				
			}
			
		}

		return comm;
		
		
	}
	
	public static Color convertColorNotation(String color) { //r=255,b=36,12
		//r=0,g=0,b=255
		color = color.substring(1, color.length()-1);
		int[] numbers = new int[3];
		String[] arr = color.split(",");
		for(int i = 0 ;i <= 2; i++)
			numbers[i] = Integer.parseInt(arr[i].substring(2));
	
		return new Color(numbers[0], numbers[1], numbers[2]);
	}
	
	

}
