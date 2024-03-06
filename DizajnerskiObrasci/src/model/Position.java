package model;

import java.io.Serializable;

public class Position implements Serializable {
	
	int x;
	int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}
	
	public double distance(Position p) {
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	public void changePosition(int dx, int dy) {
		x += dx ;
		y += dy;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
