//package command;
//
//
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class CreateShape extends Command {
//	
//	public CreateShape(Shape shape) {
//		super(shape);
//	}
//
//	@Override
//	public void execute(Model model) {
//		System.out.println(shape + " is created" );
//		model.getShapes().add(shape);
//		
//	}
//
//	@Override
//	public void undo(Model model) {
//		System.out.println("Undo: " + shape + " is uncreated" );
//		model.getShapes().remove(shape);
//		
//	}
//	
//	@Override
//	public void redo(Model model) {
//		System.out.println("Redo: " + shape + " is created" );
//		model.getShapes().add(shape);
//		
//	}
//	
//	@Override
//	public String stringForLogo(CommandText type)
//	{
//		if(type == CommandText.CONSOLE) {
//			return shape.toString() + " is created";
//		}
//		else if(type == CommandText.LOGO_FOR_FILE) {
//			return "C" + LogoLine.DILIM + shape.logo() + LogoLine.DILIM + shape.getLogoId();
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
