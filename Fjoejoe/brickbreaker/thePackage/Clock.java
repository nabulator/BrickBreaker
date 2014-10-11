package thePackage;

import java.util.Date;

import processing.core.PApplet;

public class Clock
{
	private PApplet parent;
	private Date end;
	
	public Clock(PApplet parent)
	{
		this.parent = parent;
		end = new Date(new Date().getTime() + 99000);
	}
	
	public int getTimeLeft()
	{
		return ((int) (end.getTime() - new Date().getTime())) / 1000;
	}
	
	public void draw()
	{
		parent.fill( 34, 255, 0 );
		parent.textSize(50);
		parent.text(getTimeLeft(), 440, 50);
		parent.fill( 255 );
	}
}
