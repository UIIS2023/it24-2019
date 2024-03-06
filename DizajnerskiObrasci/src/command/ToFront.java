//package command;
//
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class ToFront extends Command {
//	
//
//
//
//	public ToFront(Shape shape) {
//		super(shape);
//	}
//
//	@Override
//	public void execute(Model model) {
//		int index = model.getShapes().indexOf(shape);
//		if(index == model.getShapes().size() - 1) return ;
//		model.swap(index, index+1);
//		
//	}
//
//	@Override
//	public void undo(Model model) {
//		int index = model.getShapes().indexOf(shape);
//		model.swap(index, index-1);
//		
//	}
//
//	@Override
//	public void redo(Model model) {
//		int index = model.getShapes().indexOf(shape);
//		model.swap(index, index+1);
//		
//	}
//
//	@Override
//	public String stringForLogo(CommandText type) {
//		
//		if(type == CommandText.CONSOLE) {
//			return shape.toString() + " is pushed to front" ;
//		}
//		
//		else if(type == CommandText.LOGO_FOR_FILE) {
//			return "F" + LogoLine.DILIM + shape.getLogoId() ;
//		}
//		else {
//			return getLogoText();
//		}
//		
//	}
//
//}
