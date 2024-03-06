package commandx;

import java.util.ArrayList;

import commandx.CommandTextType;
import model.LogoLine;
import model.Shape;

public class MoveShape extends Command{
	
	private ArrayList<Shape> movingShapes = new ArrayList<>();
	private int dx;
	private int dy;
	
	
	public MoveShape(ArrayList<Shape> shapes, int dx, int dy)
	{
		for(Shape shape : shapes) {
			movingShapes.add(shape);
		}
		this.dx = dx;
		this.dy = dy;
	}


	public ArrayList<Shape> getMovingShapes() {
		return movingShapes;
	}


	public int getDx() {
		return dx;
	}



	public int getDy() {
		return dy;
	}
	
	@Override
	public String stringForLogo(CommandTextType type) {
		String str = "";
		if(type == CommandTextType.CONSOLE){
			for(Shape shape : movingShapes) {
				str += shape.toString() + "\n" ;
					
			}
			return  str.substring(0, str.length()-1) + " is moved " + dx + " " + dy ;
			
		}
		else if(type == CommandTextType.LOGO_FOR_FILE){
			
			str += "M" + LogoLine.DILIM + dx + LogoLine.DILIM + dy + LogoLine.DILIM ;
			for(Shape shape : movingShapes) {
				
				str += shape.getLogoId() +  LogoLine.DILIM ;
						
			}
			return  str.substring(0, str.length()-1) ;
			
		}
		else {
			return null;
		}
		
		
	
	}







}
