package creature;

import processing.core.PVector;
import loader.PClass;

public abstract class Creature extends PClass {

	protected Body body = null;
	protected LimbManager limbManager = null;
	protected BehaviourManager behaviourManager = new BehaviourManager(this);
	
	public abstract void draw();
	
	protected abstract void createParts();
	
	
	/**
	 * Shortcut to setting behaviour with behaviourManager.
	 * This will add and set behaviour if it doesn't already exist for behaviourManager of creature.
	 * If the behaviour exists, then it will set the behaviour.
	 */
	public void setBehaviour(Behaviour b) {
		// if behaviour doesn't exist in behaviourManager, add to it and set.
		if(!behaviourManager.getBodyBehaviours().contains(b)) {
			behaviourManager.add(b);
			behaviourManager.setBehaviour(b);
		} else {
			behaviourManager.setBehaviour(b);
		}
	}
	
	
	public BehaviourManager getBehaviourManager() {
		return behaviourManager;
	}
	public void setBehaviourManager(BehaviourManager _bm) {
		behaviourManager = _bm;
	}

	
	
	public Body getBody() {
		return body;
	}
}
