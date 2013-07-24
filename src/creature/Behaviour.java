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

	protected Creature c; // reference to creature instance
	
	// behaviour should register existence to BehaviourDirector.
	// observer pattern. BehaviourDirector controlls this.
	// but maybe we need a mediator or proxy here? A BehaviourManager?
	// so the Creature itself gets control over switching its behaviour?

	Behaviour(Creature _creature) {
		c = _creature;
	}
	
	public abstract void update();
	
	protected abstract void move();

	public abstract void moveTo(PVector loc);

	public abstract void startMove();
	
	public abstract void stopMove();
	
	public abstract void freeze();	

	
}
