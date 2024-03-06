package commandx;

import commandx.CommandTextType;
import model.LogoLine;
import model.Shape;

public class ModifyShape extends Command {
	
	
	private Shape before;
	private Shape after;
	private int logoId;
	public Shape getBefore() {
		return before;
	}

	public Shape getAfter() {
		return after;
	}

	
	public ModifyShape(Shape before, Shape after) {
		
		this.before = before.getCopy();
		this.after = after;
		this.logoId = before.getLogoId();
	}
	
	
	

	@Override
	public String stringForLogo(CommandTextType type) {
		
		if(type == CommandTextType.CONSOLE) {
			return before.toString() + " is modified";
		}
		else if(type == CommandTextType.LOGO_FOR_FILE) {
			int index= after.logo().indexOf(LogoLine.DILIM) + 1;
			return "MD" + LogoLine.DILIM + logoId + LogoLine.DILIM + after.logo().substring(index);
		}
		else {
			return null;
		}
		
	}

}
