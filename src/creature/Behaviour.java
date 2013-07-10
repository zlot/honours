package creature;

import loader.PClass;
import processing.core.PVector;


/**
 * Mediator pattern?
 *
 */
public abstract class Behaviour extends PClass {
	
	// note: maybe have an nOffset, that gets incremented here?
	// and initiated with random value, allowing all behaviours
	// to always have an accessible noise value to use thats unique.
	
	protected Limb limb = null; // reference to limb, if used as a limb behaviour.
	PVector pos; // not needed?? This should be a reference to the body instead.
	
	// behaviour should register existence to BehaviourDirector.
	// observer pattern. BehaviourDirector controlls this.
	// but maybe we need a mediator or proxy here? A BehaviourManager?
	// so the Creature itself gets control over switching its behaviour?

	public abstract void update();
	
	protected abstract void move();

	public abstract void moveTo(PVector loc);

	public abstract void startMove();
	
	public abstract void stopMove();
	
	public abstract void freeze();	

	// MUST be set if used as limbBehaviour! This is sloppy.
	public void setLimb(Limb _limb) {
		limb = _limb;
	}
}
