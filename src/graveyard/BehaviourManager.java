package graveyard;

import java.util.ArrayList;

import creature.Behaviour;
import creature.Creature;
import loader.PClass;

public class BehaviourManager extends PClass {

	protected Creature creature; // reference to creature that BehaviourManager belongs to.
	
	protected ArrayList<Behaviour> behaviours = new ArrayList<Behaviour>();
	
	protected Behaviour behaviour = null; // currently active behaviour
	
	public BehaviourManager(Creature _c) {
		creature = _c;
	}
	
	public void add(Behaviour b) {
		behaviours.add(b);
	}
	public void setBehaviour(Behaviour _b) {
		behaviour = _b;
	}
	
	public ArrayList<Behaviour> getBehaviours() {
		return behaviours;
	}
}
