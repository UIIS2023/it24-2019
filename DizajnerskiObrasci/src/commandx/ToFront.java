package commandx;

import model.LogoLine;
import model.Shape;

public class ToFront extends Command {
	
	private Shape selectedShape;
	
	
	public ToFront(Shape shape) {
		this.selectedShape = shape;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}
	
	@Override
	public String stringForLogo(CommandTextType type) {
		if(type == CommandTextType.CONSOLE) {
			return selectedShape.toString() + " is pushed to front" ;
		}
		
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			return "F" + LogoLine.DILIM + selectedShape.getLogoId() ;
		}
		else {
			return null;
		}
	}

}
