package creature;

import java.util.ArrayList;
import loader.PClass;

public class BehaviourManager extends PClass {

	protected Creature creature; // reference to creature that BehaviourManager belongs to.
	
	protected ArrayList<Behaviour> bodyBehaviours = new ArrayList<Behaviour>();
	
	protected ArrayList<Behaviour> limbBehaviours = new ArrayList<Behaviour>();
	
	protected Behaviour behaviour = null; // currently active behaviour
	
	
	public BehaviourManager(Creature _c) {
		creature = _c;
	}
	
	public void add(Behaviour b) {
		bodyBehaviours.add(b);
	}
	public void setBehaviour(Behaviour _b) {
		behaviour = _b;
	}
	
	public void setLimbBehaviour(Behaviour b) {
		
		Behaviour limbBehaviour;
		
		// for all limbs, 
		for(Limb l : creature.limbManager.getLimbs()) {
			// create new behaviour with limb assigned, and store in limbBehaviours
			try {
				limbBehaviour = b.getClass().newInstance();
				limbBehaviour.setLimb(l);
				limbBehaviours.add(limbBehaviour);
			} catch (Exception e) { e.printStackTrace(); }
			
		}
			
	}
	
	public ArrayList<Behaviour> getBodyBehaviours() {
		return bodyBehaviours;
	}
	public ArrayList<Behaviour> getLimbBehaviours() {
		return limbBehaviours;
	}
	
	public void update() {
		for(Behaviour b : getBodyBehaviours())
			b.update();
		for(Behaviour b : getLimbBehaviours())
			b.update();
	}
	
	
}
