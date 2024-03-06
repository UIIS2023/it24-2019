package commandx;

import commandx.CommandTextType;
import model.LogoLine;
import model.Shape;

public class BringToBack extends Command{
	
	

	private Shape selectedShape;
	private int index;
	
	public BringToBack(Shape shape) {
		this.selectedShape = shape;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}
	
	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

	@Override
	public String stringForLogo(CommandTextType type) {
		
		if(type == CommandTextType.CONSOLE) {
			return selectedShape.toString() + " is brought to back" ;
		}
		
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			return "BTB" + LogoLine.DILIM + selectedShape.getLogoId() ;
		}
		else {
			return null ;
		}
	}


}
