//package command;
//
//
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class ToBack extends Command{
//	
//	
//	public ToBack(Shape shape) {
//		super(shape);
//
//	}
//
//	@Override
//	public void execute(Model model) {
//		int index = model.getShapes().indexOf(shape);
//		if( index == 0) return ;
//		model.swap(index, index-1);
//		
//	}
//
//	@Override
//	public void undo(Model model) {
//		int index = model.getShapes().indexOf(shape);
//		model.swap(index, index+1);
//		
//		
//	}
//
//	@Override
//	public void redo(Model model) {
//		int index = model.getShapes().indexOf(shape);
//		model.swap(index, index-1);
//		
//	}
//
//	@Override
//	public String stringForLogo(CommandText type) {
//		
//		if(type == CommandText.CONSOLE) {
//			return shape.toString() + " is pushed to back" ;
//		}
//		
//		else if(type == CommandText.LOGO_FOR_FILE) {
//			return "B" + LogoLine.DILIM + shape.getLogoId() ;
//		}
//		else {
//			return getLogoText();
//		}
//		
//	}
//
//}
