package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends SurfaceShape implements Comparable{

	private int width;
	private int height;
	
	

	public Rectangle(Position upperLeft, int width, int height, Color outerColor, Color innerColor) {
		super(upperLeft, outerColor, innerColor);
	
		this.width = width;
		this.height = height;
	}
	
	@Override
	public Rectangle getCopy() {
		return new Rectangle(getPosition(), getWidth(), getHeight(), getEdgeColor(), getInnerColor());
	}
	
	@Override
	public void changeAtribute(Shape shape) {
		Rectangle rect = (Rectangle)shape;
		setPosition(rect.getPosition());
		setWidth(rect.getWidth());
		setHeight(rect.getHeight());
		setInnerColor(rect.getInnerColor());
		setEdgeColor(rect.getEdgeColor());
	}


	public Position getUpperLeft() {
		return getPosition();
	}

	public void setUpperLeft(Position upperLeft) {
		setPosition(upperLeft);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width > 0) {
			this.width = width;
		} else {
			throw new NumberFormatException("Width has to be a value greater than 0!");
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height > 0) {
			this.height = height;
		} else {
			throw new NumberFormatException("Height has to be a value greater than 0!");
		}
	}

	public int area() {
		return width * height;
	}
	
	@Override
	public boolean contains(Position p) {
		if (getUpperLeft().getX() <= p.getX() && 
				getUpperLeft().getY() <= p.getY() && 
				p.getX() <= getUpperLeft().getX() + this.width && 
				p.getY() <= getUpperLeft().getY() + this.height) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	

	public String toString() {
		
		return "Rectangle " + getUpperLeft() + 
				", width = " + width + ", height = " + height + ", Edge Color = " + getEdgeColor().toString().substring(14)
				+ ", Inner Color=" + getInnerColor().toString().substring(14);
		
	}
	
	@Override
	public String logo() {
	
		return "Rectangle" + DILIM + 
				getUpperLeft().getX() + DILIM +
				getUpperLeft().getY() + DILIM +
				width + DILIM + 
				height + DILIM + 
				getEdgeColor().toString().substring(14) + DILIM +
				getInnerColor().toString().substring(14);
		
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (getUpperLeft().equals(pomocna.getUpperLeft()) && this.width == pomocna.getWidth()
					&& this.height == pomocna.getHeight()) {
				return true;
			} else
				return false;

		} else
			return false;

	}

	

	@Override
	public void draw(Graphics g) {
		
		fill(g);
		Graphics2D g2 = (Graphics2D)g ;
		g2.setColor(getEdgeColor());
		g2.setStroke(new BasicStroke(2));
		g2.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.height);
		
		
	}
	
	@Override
	public void drawSelectMark(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(getUpperLeft().getX() - 3, getUpperLeft().getY() - 3, 6, 6);
		g.drawRect(getUpperLeft().getX() - 3, getUpperLeft().getY() + this.height - 3, 6, 6);// 
		g.drawRect(getUpperLeft().getX() + this.width - 3, getUpperLeft().getY() + this.height - 3, 6, 6);// donji desni
		g.drawRect(getUpperLeft().getX() + this.width - 3, getUpperLeft().getY() - 3, 6, 6);//
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.height);

	}

	@Override
	public void moveBy(int dx, int dy) {
		getUpperLeft().changePosition(dx, dy);;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return this.area()-((Rectangle) o).area();
		}
		return 0;
	}
	
	public static Shape formObjectFromLogo(String[] data) {
		
		int x = Integer.parseInt(data[2]);
		int y = Integer.parseInt(data[3]);
		int W = Integer.parseInt(data[4]);
		int H = Integer.parseInt(data[5]);
		Color edge  = LogoLine.convertColorNotation(data[6]);
		Color inner = LogoLine.convertColorNotation(data[7]);
		
		
		
		return new Rectangle(new Position(x,y), W, H,  edge, inner);
		
	}
}
