package commandx;

import java.util.ArrayList;

import commandx.CommandTextType;
import model.LogoLine;
import model.Shape;

public class UnselectAll extends Command {
	
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}


	public UnselectAll(ArrayList<Shape> shapes) {
		for(Shape shape : shapes) {
			this.shapes.add(shape);
		}
	}
	
	@Override
	public String stringForLogo(CommandTextType type) {
		
		if(type == CommandTextType.CONSOLE) {
			return "Unselect all" ;
		}
		
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			
			String str = "";
			
			str += "U" + LogoLine.DILIM ;
			for(Shape shape : shapes) {
				str += shape.getLogoId() + LogoLine.DILIM;
			}
			return  str.substring(0, str.length()-1) ;
			
		}
		else {
			return null;
		}
		
	}

	

}
