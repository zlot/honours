package graveyard;

import java.util.ArrayList;

import creature.Behaviour;

import loader.PClass;

public class BehaviourDirector extends PClass {

	private static BehaviourDirector singleton = new BehaviourDirector(); // thread-safe.
	
	// arraylist of agent behaviours to run
	ArrayList<Behaviour> behaviours;
	
	private BehaviourDirector() {
		behaviours = new ArrayList<Behaviour>();
	}
	
	public static BehaviourDirector getInstance() {
		return singleton;
	}
	
	public void update() {
		for(Behaviour b : behaviours) {
			b.update();
		}
	}

	public void add(Behaviour b) {
		behaviours.add(b);
	}
}
