package creature;

import java.util.HashMap;
import java.util.Map;

import loader.PClass;

public class BehaviourManager extends PClass {

	protected Creature creature; // reference to creature that BehaviourManager belongs to.
	
	//protected ArrayList<Behaviour> behaviours = new ArrayList<Behaviour>();
	
	protected Map<Class<? extends Behaviour>, Behaviour> behaviours = new HashMap<Class<? extends Behaviour>, Behaviour>();
	
//	protected Behaviour behaviour = null; // currently active behaviour
	
	public BehaviourManager(Creature _c) {
		creature = _c;
	}
	
	public void add(Behaviour b) {
		behaviours.put(b.getClass(), b);
	}
	
	
//	public void setBehaviour(Behaviour _b) {
//		behaviour = _b;
//	}
	
//	public ArrayList<Behaviour> getBehaviours() {
//		return behaviours;
//	}
	
	public Map<Class<? extends Behaviour>, Behaviour> getBehaviours() {
		return behaviours;
	}
}
