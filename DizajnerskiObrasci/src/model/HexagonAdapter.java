package model;
import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;


public class HexagonAdapter extends SurfaceShape{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hexagon hexagon;
	
	public HexagonAdapter(int x, int y, int R, Color outer, Color inner){
		super(new Position(x, y), outer,inner);
		this.hexagon = new Hexagon(x,y,R);
		hexagon.setAreaColor(inner);
		hexagon.setBorderColor(outer);

	}
	
	@Override
	public HexagonAdapter getCopy(){
		
		return new HexagonAdapter(getX(), getY(), getR(), getEdgeColor(), getInnerColor());
	}
	
	@Override
	public void changeAtribute(Shape shape) {
		HexagonAdapter hex = (HexagonAdapter)shape;
		setPosition(hex.getPosition());
		setR(hex.getR());
		setInnerColor(hex.getInnerColor());
		setEdgeColor(hex.getEdgeColor());
	}

	@Override
	public void moveBy(int dx, int dy) {
		hexagon.setX(hexagon.getX() + dx);
		hexagon.setY(hexagon.getY() + dy);
		
	}


	@Override
	public boolean contains(Position p) {
		return hexagon.doesContain(p.getX(), p.getY());
	}

	@Override
	public void fill(Graphics g) {
		hexagon.setAreaColor(getInnerColor());
		hexagon.setBorderColor(getEdgeColor());
		hexagon.paint(g);
	
		
	}

	

	@Override
	public void draw(Graphics g) {
		hexagon.setAreaColor(getInnerColor());
		hexagon.setBorderColor(getEdgeColor());
		hexagon.paint(g);
		
	}
	
	@Override
	public void drawSelectMark(Graphics g) {
		
		g.setColor(Color.blue);
		
		Point[] points = new Point[6];
		for(int i = 0 ;i<6;i++) {
			int x = getX() + (int)(Math.cos(Math.PI* i/ 3)*getR());
			int y = getY() + (int)(Math.sin(Math.PI*i/ 3)*getR());
			points[i] = new Point(x,y);
		}
		
		for(int i = 0 ;i<6;i++) {
			g.drawRect(points[i].getX() - 3, points[i].getY() - 3, 6, 6);
		}
		
	}
	
	public String toString() {
		
		Point point = new Point(getX(), getY());
		return "Hexagon " + point.toString().substring(7) + ",R=" + getR()  + ", Edge Color=" + getEdgeColor().toString().substring(14)
				+ ", Inner Color=" + getInnerColor().toString().substring(14);

	}

	@Override
	public String logo() {
		return "Hexagon" + DILIM + 
				getX() + DILIM + 
				getY() + DILIM + 
				getR()  + DILIM + 
				getEdgeColor().toString().substring(14) + DILIM +
				getInnerColor().toString().substring(14);

	}
	public Point getCenter() {
		return new Point(getX(), getY());
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			HexagonAdapter pomocna = (HexagonAdapter) obj;
			if (getCenter().equals(pomocna.getCenter()) && getR() == pomocna.getR()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}

	public int getX() {
		// TODO Auto-generated method stub
		return hexagon.getX();
		
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return hexagon.getY();
		
	}
	
	public int getR() {
		// TODO Auto-generated method stub
		return hexagon.getR();
		
	}
	
	public void setX(int x) {
		// TODO Auto-generated method stub
		hexagon.setX(x);
		
	}
	
	
	public boolean isSelected(int y) {
	
		return hexagon.isSelected();
		
	}
	
	public void setR(int R) {
		// TODO Auto-generated method stub
		hexagon.setR(R);
		
	}
	
	public static Shape formObjectFromLogo(String[] data) {
		
		int x = Integer.parseInt(data[2]);
		int y = Integer.parseInt(data[3]);
		int R = Integer.parseInt(data[4]);
		Color edge  = LogoLine.convertColorNotation(data[5]);
		Color inner = LogoLine.convertColorNotation(data[6]);
		
		return new HexagonAdapter(x,y,R, edge, inner);
		
		
	}


}
