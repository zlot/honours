package main;
import java.util.ArrayList;
import java.util.List;
import creature.*;
import creature.virus.*;
import creature.squarething.*;
import loader.PClass;


public class World extends PClass {

	static int width;
	static int height;
	static int bgColor;
	
//	private ArrayList<Creature> creatures = new ArrayList<Creature>();
	private PopulationDirector populationDirector;
	
	
	public World() {
		width = 550;
		height = 550;
		p.size(width, height);
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
		
		populationDirector.addCreatures(new Virus(), 3);
		
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
		
		p.translate(width/2, height/2);
		p.scale(1.5f);
		populationDirector.update();
		
	}

}
