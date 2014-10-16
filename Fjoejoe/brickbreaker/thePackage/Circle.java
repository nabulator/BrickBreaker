package thePackage;

import processing.core.PApplet;

public class Circle {
	
	public int x, y;
	private int radius;
	
	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void draw(PApplet parent)
	{
		parent.fill(0, 255, 45, 128);
		parent.ellipse(x, y, radius, radius);
	}

}
