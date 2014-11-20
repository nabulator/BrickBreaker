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
<<<<<<< HEAD
		System.out.println(frameRate);
=======
		//System.out.println(frameRate);
>>>>>>> branch 'briansbr' of https://github.com/nabulator/BrickBreaker.git
	}
	
	public void exit()
	{
		
	}
}
