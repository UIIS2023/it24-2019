//package command;
//
//import java.util.ArrayList;
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class UnselectAll extends Command{
//	
//	
//	public UnselectAll(ArrayList<Shape> shapes) {
//		super(shapes);
//	}
//
//	@Override
//	public void execute(Model model) {
//		System.out.println("unselect all" );
//		for(Shape shape : shapes) {
//			shape.setSelected(false);
//		}
//		model.FireChange();
//		
//	}
//
//	@Override
//	public void undo(Model model) {
//		for(Shape shape : shapes) {
//			shape.setSelected(true);
//		}
//		model.FireChange();
//		
//	}
//
//	@Override
//	public void redo(Model model) {
//		for(Shape shape : shapes) {
//			shape.setSelected(false);
//		}
//		model.FireChange();
//		
//	}
//
//	@Override
//	public String stringForLogo(CommandText type) {
//		if(type == CommandText.CONSOLE) {
//			return "Unselect all" ;
//		}
//		
//		else if(type == CommandText.LOGO_FOR_FILE) {
//			
//			String str = "U" + LogoLine.DILIM;
//			for(Shape shape : shapes) {
//				str += shape.getLogoId() + LogoLine.DILIM + "\n";
//			}
//			return  str.substring(0, str.length()-1) ;
//			
//		}
//		else {
//			return getLogoText();
//		}
//	}
//
//}
