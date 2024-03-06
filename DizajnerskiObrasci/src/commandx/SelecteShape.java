package commandx;

import commandx.CommandTextType;
import model.LogoLine;
import model.Shape;

public class SelecteShape extends Command{
	
	private Shape selectedShape;
	
	public SelecteShape(Shape shape) {
		this.selectedShape = shape;
	}
	
	public Shape getSelectedShape() {
		return selectedShape;
	}

	@Override
	public String stringForLogo(CommandTextType type) {
		
		if(type == CommandTextType.CONSOLE) {
			return selectedShape.toString() + " is selected" ;
		}
		
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			return "S" + LogoLine.DILIM + selectedShape.getLogoId() ;
		}
		else {
			return null;
		}
	}

}
