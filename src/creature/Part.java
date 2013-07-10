package creature;
import loader.PClass;
import processing.core.*;


public abstract class Part extends PClass {

	protected PVector pos;
	protected Behaviour behaviour; // MUST this exist for each part?
	
	Part(PVector _pos) {
		pos = _pos;
	}
	
	
	public abstract void draw();
	
	/**
	 * Override if necessary for more complex behaviours that
	 * are intertwined with drawing.
	 */
	public void update() {
		getBehaviour().update();
	}
	
	// hmm how to make this FORCIBLY set by anything that extends Part?
	public void setBehaviour(Behaviour _b) {
		behaviour = _b;
	}
	
	public Behaviour getBehaviour() {
		return behaviour;
	}
	
	public PVector getPos() {
		return pos;
	}
}
