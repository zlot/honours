package creature;

import java.util.ArrayList;

import loader.PClass;

public class PopulationDirector extends PClass {

	private static PopulationDirector singleton = new PopulationDirector(); // thread-safe.
	
	// List of all creatures in population
	ArrayList<Creature> creatures;

	private PopulationDirector() {
		creatures = new ArrayList<Creature>();
	}
	
	public static PopulationDirector getInstance() {
		return singleton;
	}
	
	public void addCreature(Creature c) {
		creatures.add(c);
	}
	public void addCreatures(Creature c, int numOfCreatures) {
		for(int i=0; i<numOfCreatures; i++) {
			try {
				c = c.getClass().newInstance();
			} catch (Exception e) {e.printStackTrace();}
			creatures.add(c);
		}
	}
	
	public void update() {
		/* Update all behaviours */
		// for all creatures,
		for(Creature c : creatures)
			c.getBehaviourManager().update();

		
		/* Draw all creatures */
		for(Creature c : creatures)
			c.draw();
		
	}
}
