package commandx;

import commandx.CommandTextType;
import model.LogoLine;
import model.Shape;

public class BringToFront  extends Command{
	
	private Shape selectedShape;
	private int index;
	
	
	public BringToFront(Shape shape) {
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
			return selectedShape.toString() + " is brought to front" ;
		}
		
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			return "BTF" + LogoLine.DILIM + selectedShape.getLogoId() ;
		}
		else {
			return null;
		}
	}

}
