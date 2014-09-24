package thePackage;

import processing.core.PApplet;

/**
 * A paddle that draws itself and moves left and right
 * @author 60129
 *
 */
public abstract class Paddle extends Sprite
{
	
	/**
	 * Creates a paddle
	 * @param parent the PApplet parent
	 */
	public Paddle ( PApplet parent )
	{
		super(parent, 0.0f, 0.0f);
	}
	
	

}
