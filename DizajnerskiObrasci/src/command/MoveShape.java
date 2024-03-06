//package command;
//
//import java.util.ArrayList;
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class MoveShape extends Command {
//	
//
//	private int dx;
//	private int dy;
//	
//	public  MoveShape(ArrayList<Shape> shapes, int dx, int dy) {
//		super(shapes);
//		this.dx = dx;
//		this.dy = dy;
//		
//	}
//	
//	public MoveShape(Shape shape, int dx, int dy) {
//		super(shape);
//		this.dx = dx;
//		this.dy = dy;
//	}
//
//	@Override
//	public void execute(Model model) {
//		System.out.println(shape + " move " + dx + " " + dy);
//		
//		for(Shape shape : shapes) {
//			model.moveShape(shape, dx, dy);
//		}
//	}
//	
//	@Override
//	public void undo(Model model) {
//		System.out.println("Undo: " + shape + " move " + dx + " " + dy);
//		for(Shape shape : shapes) {
//			model.moveShape(shape, -dx, -dy);
//		
//		}
//		
//	}
//	
//	@Override
//	public void redo(Model model) {
//		System.out.println("Redo: " + shape + " move " + dx + " " + dy);
//		for(Shape shape : shapes) {
//			model.moveShape(shape, dx, dy);
//		}
//		
//	}
//	
//	@Override
//	public String stringForLogo(CommandText type) {
//	
//	
//		String str = "";
//		if(type == CommandText.CONSOLE){
//			for(Shape shape : shapes) {
//				str += shape.toString() + " is moved " + dx + " " + dy + "\n" ;
//					
//			}
//			return  str.substring(0, str.length()-1) ;
//			
//		}
//		else if(type == CommandText.LOGO_FOR_FILE){
//			
//			for(Shape shape : shapes) {
//				str += "M" + LogoLine.DILIM + 
//						shape.getLogoId() +  LogoLine.DILIM + 
//						dx + LogoLine.DILIM + 
//						dy + "\n";
//			}
//		
//			return  str.substring(0, str.length()-1) ;
//			
//		}
//		else {
//			return getLogoText();
//		}
//		
//	}
//	
//
//	
//}
