package command;




//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class BringToBack extends Command{
//	
//	private int index;
//
//	public BringToBack(Shape shape, int index) {
//		super(shape);
//		this.index = index;
//	
//	}
//	
//	public BringToBack(Shape shape) {
//		super(shape);
//
//	}
//
//
//	@Override
//	public void execute(Model model) {
//		index = model.getShapes().indexOf(shape);
//		if(index == 0) return ;
//		model.getShapes().remove(index);
//		model.getShapes().add(0, shape);
//		
//	}
//
//	@Override
//	public void undo(Model model) {
//		model.getShapes().remove(0);
//		model.getShapes().add(index, shape);
//		
//	}
//
//	@Override
//	public void redo(Model model) {
//		model.getShapes().remove(index);
//		model.getShapes().add(0, shape);
//		
//	}
//
//	@Override
//	public String stringForLogo(CommandText type) {
//		
//		if(type == CommandText.CONSOLE) {
//			return shape.toString() + " is brought to back" ;
//		}
//		
//		else if(type == CommandText.LOGO_FOR_FILE) {
//			return "BTB" + LogoLine.DILIM + shape.getLogoId() ;
//		}
//		else {
//			return getLogoText();
//		}
//
//	}
//
//}
