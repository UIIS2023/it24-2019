//package command;
//
//import java.util.ArrayList;
//
//import model.Model;
//import model.Shape;
//
//public abstract class Command {
//	
//	protected ArrayList<Shape> shapes = new ArrayList<Shape>();
//	
//	protected Shape shape;
//	
//	private String logoText;
//
//	public String getLogoText() {
//		return logoText;
//	}
//
//	public void setLogoText(String logoText) {
//		this.logoText = logoText;
//	}
//
//	public Command(ArrayList<Shape> shapes) {
//		this.shapes = shapes ;
//	}
//	
//	public Command(Shape shape) {
//		this.shape = shape ;
//		shapes.add(shape);
//	}
//		
//	public abstract void execute(Model model);
//	public abstract void undo(Model model);
//	public abstract void redo(Model model);
//	public abstract String stringForLogo(CommandText text);
//	public Shape getShape() { return shape ;}
//
//
//}
