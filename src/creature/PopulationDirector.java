package creature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import loader.PClass;

public class PopulationDirector extends PClass {

	private static PopulationDirector singleton = new PopulationDirector(); // thread-safe.
	
	// List of all creatures in population
	public ArrayList<Creature> creatures;

	private PopulationDirector() {
		creatures = new ArrayList<Creature>();
	}
	
	public static PopulationDirector getInstance() {
		return singleton;
	}
	
	public void addCreature(Creature c) {
		creatures.add(c);
	}
	public void addCreatures(Class<? extends Creature> creatureClass, int numOfCreatures) {
		Creature c = null;
		for(int i=0; i<numOfCreatures; i++) {
			try {
				c = creatureClass.newInstance();
			} catch (Exception e) {e.printStackTrace();}
			creatures.add(c);
		}
	}
	
	public void update() {
		/* Update all behaviours */
		for(Creature c : creatures) {

			// iterate through Map of behaviours.
			for (Entry<Class<? extends Behaviour>, Behaviour> entry : c.getBehaviourManager().getBehaviours().entrySet()) {
				entry.getValue().update();
			}
//			for(Behaviour b : c.getBehaviourManager().getBehaviours())
//				b.update();
			if(c.getLimbManager() != null) c.getLimbManager().update(); // update limbs. This may or may not do anything
										 // depending on the implemenation of the limb.
		}
		/* Draw all creatures */
		for(Creature c : creatures) {
			c.draw();
		}
	}
}
