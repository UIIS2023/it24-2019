package commandx;

import model.LogoLine;
import model.Shape;

public class UnselecteShape extends Command{
	
	private Shape shape;
	
	public UnselecteShape(Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}
	
	@Override
	public String stringForLogo(CommandTextType type) {
		
		if(type == CommandTextType.CONSOLE) {
			return shape.toString() + " is unselected" ;
		}
		
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			return "U" + LogoLine.DILIM + shape.getLogoId() ;
		}
		else {
			return null;
		}

	}


	

}
