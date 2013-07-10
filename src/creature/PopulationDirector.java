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
		for(Creature c : creatures) {
			c.getBody().update();
			c.getLimbManager().update();
		}
		/* Draw all creatures */
		for(Creature c : creatures) {
			c.draw();
			c.getBody().drawBoundingBox();
			
		}
		for(int i=0; i<creatures.size(); i++) {
			Creature c = creatures.get(i);
			for(int j = i; j<creatures.size(); j++) {
				Creature c2 = creatures.get(j);
				// test: check if bounding boxes collide
				if(AABB.testOverlap(c.getBody().aabb2, c2.getBody().aabb2)) {
					System.out.println("COLLIDED!!");
					c.getBody().drawBoundingBoxCollide();
					c2.getBody().drawBoundingBoxCollide();
				}
				
				if(c.getBody().aabb2.contains(c2.getBody().aabb2)) {
					System.out.println("COLLIDED!!");
					c.getBody().drawBoundingBoxCollide();
					c2.getBody().drawBoundingBoxCollide();
				}
				
				
			}
		}
	}
}
