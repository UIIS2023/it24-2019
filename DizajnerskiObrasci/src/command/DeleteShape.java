//package command;
//
//
//import java.util.ArrayList;
//
//import model.LogoLine;
//import model.Model;
//import model.Shape;
//
//public class DeleteShape extends Command{
//	
//
//	private ArrayList<Integer> indexs;
//	
//
//	public DeleteShape(ArrayList<Shape> shapes, ArrayList<Integer> indexs) {
//		super(shapes);
//		this.indexs = indexs;
//	}
//	
//	public DeleteShape(Shape shape, int index) {
//		
//	
//		super(shape);
//		indexs = new ArrayList<>();
//		indexs.add(index);
//	}
//
//	@Override
//	public void execute(Model model) {
//		for(Shape shape : shapes) {
//			model.getShapes().remove(shape);
//		}	
//	}
//
//	@Override
//	public void undo(Model model) {
//	
//		int i = 0;
//		for(Shape shape : shapes) {//shapes to je lisa shapeova obrisanih u modelu
//			model.getShapes().add(indexs.get(i), shape);
//			i++;
//		}
//		
//		
//	}
//	
//	@Override
//	public void redo(Model model) {
//		
//		for(Shape shape : shapes) {
//			model.getShapes().remove(shape);
//		}	
//		
//	}
//	
//	@Override
//	public String stringForLogo(CommandText type)
//	{
//		String str = "";
//		if(type == CommandText.CONSOLE){
//			for(Shape shape : shapes) {
//				str += shape.toString() + " is deleted\n" ;
//					
//			}
//			return  str.substring(0, str.length()-1) ;
//			
//		}
//		else if(type == CommandText.LOGO_FOR_FILE){
//			
//			for(Shape shape : shapes) {
//				str += "D"+ LogoLine.DILIM + shape.getLogoId() + "\n";
//			}
//		
//			return  str.substring(0, str.length()-1) ;
//			
//		}
//		else {
//			return getLogoText();
//		}
//		
//		
//		
//	}
//
//
//}
