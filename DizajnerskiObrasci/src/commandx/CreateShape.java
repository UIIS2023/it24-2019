package commandx;

import commandx.CommandTextType;
import model.LogoLine;
import model.Shape;

public class CreateShape extends Command {
	
	private Shape crateShape;
	
	public CreateShape(Shape shape) {
		this.crateShape = shape;
		
	}

	public Shape getCreateShape() {
		crateShape.setSelected(false);
		return crateShape;
	}
	
	@Override
	public String stringForLogo(CommandTextType type) {
		
		if(type == CommandTextType.CONSOLE) {
			return crateShape.toString() + " is created";
		}
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			return "C" + LogoLine.DILIM + crateShape.logo() + LogoLine.DILIM + crateShape.getLogoId();
		}
		else {
			return null;
		}
	}


}
