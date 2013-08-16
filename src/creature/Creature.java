package creature;

import processing.core.PVector;
import loader.PClass;

public abstract class Creature extends PClass {
	public float hithere;

	protected PVector pos = null; // pointing to same instance as body pos.
	protected float angle; // angle in radians.
	protected Body body = null;
	protected LimbManager limbManager = null;
	
	protected BehaviourManager behaviourManager = null;
	
	// I think the CREATURE should hold all the behaviours (except limb behaviour)
	// so the creature has eg move behaviour, 'push-if-collide', 'hunt' behaviour
	// makes sense from a end user programmer also
	
	public Creature() {
		behaviourManager = new BehaviourManager(this);
	}
	
	protected abstract void createParts();
	
	protected abstract void addBehaviours();
	
	public abstract void draw();
	
	
	
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
	public void setPos(PVector _pos) {
		pos = _pos;
	}
	public PVector getPos() {
		return pos;
	}
	public float getAngle() {
		return angle;
	}
	public void setAngle(float _angle) {
		angle = _angle;
	}
	
	
	public boolean hasLimbManager() {
		return limbManager == null ? false : true;
	}
	
}
