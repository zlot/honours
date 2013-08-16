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
	
//	private ArrayList<Creature> creatures = new ArrayList<Creature>();
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
		
		// because this loop is awkward; it would be better to do this somehow like below, where we can just add
		// to populationdirector in one swoop.
//		for(int i=0; i<7; i++) {
//			Creature v = new Virus();
//			v.setBehaviour(new MoveBehaviour(v.getBody().getPos()));
//			populationDirector.addCreature(v);
//		}
		
		populationDirector.addCreatures(Virus.class, 9);
		
//	 	populationDirector.addCreatures(SquareThing.class, 25);
		
//	 	populationDirector.addCreatures(Millipede.class, 4);

//	 	populationDirector.addCreatures(Worm.class, 16);
	 	
		// for all creatures, add their behaviours to behaviourDirector
		// this could probably be included as part of instantiation of behaviourDirector singleton.
		// NOTE: remember if I do this, have to make singleton pattern thread-safe! See book.
		// OR, not really, because this is probably usually done inside the creature itself.
		// the creature controls its initial behaviours.
		// in the world, we can change this later.
//		for(Creature c : creatures)
//			behaviourDirector.add(c.getBehaviourManager());
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
