package commandx;

import java.util.ArrayList;

import commandx.CommandTextType;
import model.LogoLine;
import model.Shape;

public class DeleteShape extends Command {
	
	
	ArrayList<Shape> deleteShapes = new ArrayList<Shape>();
	ArrayList<Integer> indexs = new ArrayList<>();
	


	
	public DeleteShape(ArrayList<Shape> shapes, ArrayList<Integer> indexs_)
	{
		for(Shape shape : shapes) {
			deleteShapes.add(shape);
		}
		for(Integer x : indexs_) {
			this.indexs.add(x);
		}
	}



	public ArrayList<Shape> getDeleteShapes() {
		return deleteShapes;
	}


	


	public ArrayList<Integer> getIndexs() {
		return indexs;
	}


	
	@Override
	public String stringForLogo(CommandTextType type) {
		
		String str = "";
		if(type == CommandTextType.CONSOLE){
			for(Shape shape : deleteShapes) {
				str += shape.toString() + "\n" ;
					
			}
			return  str.substring(0, str.length() - 1) + " is deleted" ;
			
		}
		else if(type == CommandTextType.LOGO_FOR_FILE){
			
			str += "D" + LogoLine.DILIM ;
			
			for(Shape shape : deleteShapes) {
				str += shape.getLogoId() + LogoLine.DILIM ;
			}
			
			
		
			return  str.substring(0, str.length()-1) ;
		
			
		}
		else {
			return null;
		}
		
	
		
	}
	
	
	
	



}
