//package command;
//
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class UnselecteShape extends Command {
//	
//
//	
//	
//	public UnselecteShape(Shape shape) {
//		super(shape);
//		
//	}
//
//	@Override
//	public void execute(Model model) {
//		System.out.println(shape + " is unselected" );
//		shape.setSelected(false);
//		model.FireChange();	
//		
//	}
//
//	@Override
//	public void undo(Model model) {
//		System.out.println("Undo: " + shape + " is selected" );
//	
//		shape.setSelected(true);
//		model.FireChange();	
//		
//		
//	}
//	
//	@Override
//	public void redo(Model model) {
//		System.out.println("Redo: " + shape + " is unselected" );
//		shape.setSelected(false);
//		model.FireChange();	
//		
//	}
//	
//	@Override
//	public String stringForLogo(CommandText type)
//	{
//		
//		if(type == CommandText.CONSOLE) {
//			return shape.toString() + " is unselected" ;
//		}
//		
//		else if(type == CommandText.LOGO_FOR_FILE) {
//			return "U" + LogoLine.DILIM + shape.getLogoId() ;
//		}
//		else {
//			return getLogoText();
//		}
//		
//	}
//
//}
