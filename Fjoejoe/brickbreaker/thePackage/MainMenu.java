package thePackage;

import java.awt.Rectangle;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

/**
 * Displays the user interface along with the game title. 
 * Permits player to choose their game type
 * @author 60129
 */
public class MainMenu
{
	private BrickBreaker parent;
	private Minim audioParent;
	private AudioPlayer song;
	private Demo d;
	private Button p1, p2;
	
	/**
	 * Initializes the main menu
	 */
	public MainMenu (BrickBreaker parent, Minim m)
	{
		this.parent = parent;
		this.audioParent = m;
		p1 = new Button(parent, 65, 450, "1 Player");
		p2 = new Button(parent, 65, 500, "2 Player");
		
		song = m.loadFile("StreetFighterSelect.mp3");
		d = new Demo( new Rectangle(350+105, 140, 400, 400));
	}
	
	/**
	 * Draws the main menu
	 */
	public void draw()
	{
		parent.fill(255); //default color
		parent.textSize(36);
		parent.textAlign(parent.CENTER);
		parent.text("BrickBreaker", 170, 110);
		p1.draw();
		p2.draw();
		d.draw(parent);
		
		//graphics
		parent.stroke(100);
		parent.strokeWeight(3);
		parent.line(350, 60, 350, 620);
		
		if( p1.isPressed() )
			parent.switchMode(1);
		
		if( p2.isPressed() )
			parent.switchMode(2);
		
	}
	
	public void startMusic()
	{
		song.loop();
	}
	
	public void exit()
	{
		audioParent.stop();
	}
	
	public void mousePressed()
	{
		p1.mousePressed();
		p2.mousePressed();
	}
	
	public void mouseReleased()
	{
		p1.mouseReleased();
		p2.mouseReleased();
	}
	
}
