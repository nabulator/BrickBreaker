package demoscene;

import processing.core.PApplet;

public class Main extends PApplet{

	private Metaballs fx;
	
	public void setup()
	{
		size(480, 480);
		colorMode(HSB);
		fx = new Metaballs(this);
	}
	
	public void draw()
	{
		this.fill(255);
		this.background(0);
		
		fx.draw();
		System.out.println(frameRate);
	}
	
	public void exit()
	{
		
	}
}
