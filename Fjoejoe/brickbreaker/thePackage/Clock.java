package thePackage;

import java.util.Date;

import processing.core.PApplet;

/**
 * This class serves as the basic count down timer
 * @author FJoe
 */
public class Clock
{
	private PApplet parent;
	private GameManager gm;
	private Date end;
	private boolean stopped;
	private float x, y;
	
	/**
	 * Constructs an instance of clock
	 * @param parent the PApplet 
	 * @param gm the GameManager
	 */
	public Clock(PApplet parent, GameManager gm)
	{
		this.parent = parent;
		this.gm = gm;
		this.x = 450;
		this.y = 50;

		end = new Date(new Date().getTime() + 100000); //100 seconds

		stopped = false;
	}
	
	/**
	 * Gets the amount of time left 
	 * @return time left in SECONDS
	 */
	public int getTimeLeft()
	{
		int left = (int) (end.getTime() - new Date().getTime()) / 1000;
		if( left <= 0 )
		{
			if( ! stopped )
			{
				gm.endGame();
				stopped = true;
			}
			return 0;
		}
		
		return left;
	}
	
	public void draw()
	{
		parent.fill(0);
		//parent.quad(x-50, y-50, x-20, y+10, x+90, y+10, x+120, y-50);
		parent.ellipse(x+32, y-50, 140, 130);
		parent.fill( 34, 255, 0 );
		parent.textAlign(parent.CENTER);
		parent.textSize(50);
		parent.text(getTimeLeft(), x+33, y);
		parent.fill( 255 );
		
	}
}
