package commandx;

import model.LogoLine;
import model.Shape;

public class ToBack  extends Command{
	
	private Shape selectedShape;
	
	
	public ToBack(Shape shape) {
		this.selectedShape = shape;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}
	
	@Override
	public String stringForLogo(CommandTextType type) {
		
		
		if(type == CommandTextType.CONSOLE) {
			return selectedShape.toString() + " is pushed to back" ;
		}
		
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			return "B" + LogoLine.DILIM + selectedShape.getLogoId() ;
		}
		else {
			return null;
		}
	}

}
