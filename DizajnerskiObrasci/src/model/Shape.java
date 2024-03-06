package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Serializable{

	private static final long serialVersionUID = 1L;

	private Color color;
	private boolean isSelected;
	private int logoId;
	public static String DILIM = ";";
	
	public abstract void draw(Graphics g);
	public abstract void drawSelectMark(Graphics g);
	public abstract String logo();
	public abstract void moveBy(int dx, int dy);
	public abstract boolean contains(Position p);
	public abstract Shape getCopy(); //stvare se novi objekat sa istim osobinama
	public abstract void changeAtribute(Shape shape);
	//metoda copy mjenja objekat koji je pozvao copy
	private Position position;

	public Shape(Position position, Color color) {
		this.color = color;
		isSelected = false;
		logoId = this.hashCode();
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void setSelected(boolean value) {
		isSelected = value;
	}

    public boolean isSelected() {
    	return isSelected;
    }
	
	public Color getEdgeColor() {
		return color;
	}

	public void setEdgeColor(Color color) {
		this.color = color;
	}
	
	public int getLogoId() {
		return logoId;
	}
	public void setLogoId(int logoId) {
		this.logoId = logoId;
	}
	
	

}
