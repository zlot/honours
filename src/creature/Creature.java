package creature;

import processing.core.PVector;
import loader.PClass;

public abstract class Creature extends PClass {

	protected PVector pos = null; // pointing to same instance as body pos.
	protected Body body = null;
	protected LimbManager limbManager = null;
	
	protected BehaviourManager behaviourManager = null;
	
	// I think the CREATURE should hold all the behaviours (except limb behaviour)
	// so the creature has eg move behaviour, 'push-if-collide', 'hunt' behaviour
	// makes sense from a end user programmer also
	
	public Creature() {
		behaviourManager = new BehaviourManager(this);
	}
	
	public abstract void draw();
	
	protected abstract void createParts();
	
	protected abstract void addBehaviours();
	
	protected void addBehaviour(Behaviour b) {
		behaviourManager.add(b);
	}
	
	public Body getBody() {
		return body;
	}
	public LimbManager getLimbManager() {
		return limbManager;
	}
	public BehaviourManager getBehaviourManager() {
		return behaviourManager;
	}
	public PVector getPos() {
		return pos;
	}
	
}
