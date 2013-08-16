package main;
import java.util.List;

import loader.PClass;




import processing.core.*;

public class Main extends PApplet {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
//		PApplet.main(new String[] { "--present", "Main" }); // DEPRECATED. Should update this in Processing website tutorial github!
		PApplet.main(new String[] { "--location=30,30", "main.Main" });
	}

	public PApplet p = this;
	
	
	World world;
	
//	public List<SuperCreature> masterObjectList;
	
	
	@Override
	public void setup() {
		// Abstract PClass setup. Necessary!
		PClass.insertPApplet(this); // send instance of this PApplet to abstract ProcessingClass
		
		world = new World();
		PClass.setWidthAndHeight(width, height, 150); // last arg is screen edge buffer value in pixels

		world.setup();
		
	}
	@Override
	public void draw() {
	  world.run();
  }
	
	public void mouseClicked() {
//		world.insertIntoWorld(new Medusa());
	}
	public void mouseDragged() {
	}
	
	public void keyPressed() {
		switch (key) {
		case 's':
			break;
		case 'd':
			break;
		}
	}
}