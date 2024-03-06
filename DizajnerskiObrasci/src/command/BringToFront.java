//package command;
//
//
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class BringToFront extends Command {
//	
//
//	private int index;
//
//	public BringToFront(Shape shape) {
//		super(shape);
//
//	}
//	public BringToFront(Shape shape, int index) {
//		super(shape);
//		this.index = index;
//
//	}
//
//	@Override
//	public void execute(Model model) {
//		index = model.getShapes().indexOf(shape);
//		int end = model.getShapes().size() - 1 ;
//		if(index == end) return;
//		model.getShapes().remove(index);
//		model.getShapes().add(shape);
//		
//	}
//
//	@Override
//	public void undo(Model model) {
//		int end = model.getShapes().size() - 1 ;
//		model.getShapes().remove(end);
//		model.getShapes().add(index,shape);
//		
//	}
//
//	@Override
//	public void redo(Model model) {
//		model.getShapes().remove(index);
//		model.getShapes().add(shape);
//		
//	}
//
//	@Override
//	public String stringForLogo(CommandText type) {
//		
//		
//		if(type == CommandText.CONSOLE) {
//			return shape.toString() + " is brought to front" ;
//		}
//		
//		else if(type == CommandText.LOGO_FOR_FILE) {
//			return "BTF" + LogoLine.DILIM + shape.getLogoId() ;
//		}
//		else {
//			return getLogoText();
//		}
//		
//
//	}
//
//}
