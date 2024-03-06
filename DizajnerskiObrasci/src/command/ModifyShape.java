//package command;
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class ModifyShape extends Command{
//	
//	
//	Shape before;
//	Shape after;
//	
//	public ModifyShape(Shape before, Shape after) {
//		super(before);
//		this.before = before.getCopy();
//		this.after = after;
//	}
//	
//	@Override
//	public void execute(Model model) {
//		System.out.println(shape + " is modified" );
//		shape.changeAtribute(after);
//		
//	}
//	
//	@Override
//	public void undo(Model model) {
//		shape.changeAtribute(before);
//		
//	}
//	
//	@Override
//	public void redo(Model model) {
//		shape.changeAtribute(after);
//		//shape usisava sve osobine objekta after
//	}
//	
//	@Override
//	public String stringForLogo(CommandText type) {
//		
//		if(type == CommandText.CONSOLE) {
//			return shape.toString() + " is modified";
//		}
//		else if(type == CommandText.LOGO_FOR_FILE) {
//			int index= after.logo().indexOf(LogoLine.DILIM) + 1;
//			return "MD" + LogoLine.DILIM + shape.getLogoId() + LogoLine.DILIM + after.logo().substring(index);
//		}
//		else {
//			return getLogoText();
//		}
//	}
//
//}
