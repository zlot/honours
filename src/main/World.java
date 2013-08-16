package main;
import creature.*;
import creature.virus.*;
import creature.worm.Worm;
import creature.millipede.Millipede;
import creature.squarething.*;
import loader.PClass;


public class World extends PClass {

	static int width;
	static int height;
	static int bgColor;
	
	public static PopulationDirector populationDirector;
	
	
	public World() {
		width = 1050;
		height = 900;
		p.size(width, height, p.P2D);
		p.colorMode(p.HSB, 360, 100, 100);
		bgColor = p.color(240, 40, 40);
		p.noFill();

	}
	
	public void setup() {
		
		populationDirector = PopulationDirector.getInstance();
		
		// need a creature factory maybe?
		// because we need to create each creature AND MAKE SURE a behaviour is attached to its behaviourManager.
		populationDirector.addCreatures(Virus.class, 9);
		
//	 	populationDirector.addCreatures(SquareThing.class, 25);
		
	 	populationDirector.addCreatures(Millipede.class, 6);

//	 	populationDirector.addCreatures(Worm.class, 16);
	 	
	}

	public void setBgColor(int c) {
		bgColor = c;
	}
	
	
	public void run() {
		// refresh background
		p.fill(bgColor);
		p.rect(0,0,width,height);
		populationDirector.update();
		
	}

}
