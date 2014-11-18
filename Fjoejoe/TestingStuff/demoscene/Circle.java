package demoscene;

import processing.core.PApplet;

public class Circle {
	
	public int x;
	public int y;
	public int radius;
	
	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public Circle(PApplet p)
	{
		this.x = (int)(Math.random() * p.width);
		this.y = (int)(Math.random() * p.height);
		this.radius = (int)(Math.random() * 200);
	}

}
