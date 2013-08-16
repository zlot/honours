package creature;
import loader.PClass;
import processing.core.*;


public abstract class Part extends PClass {

	protected Creature creature; // reference to creature instance that this part belongs to.
	protected PVector pos;
	
	protected int color; // hexadecimal colour: 0x[alpha][red][green][blue]
	
	Part(Creature _creature, PVector _pos) {
		creature = _creature;
		pos = _pos;
	}
	
	public abstract void draw();
	
	public PVector getPos() {
		return pos;
	}
	
	public abstract void setColor(int color);

	public Creature getCreature() {
		return creature;
	}

	/**
	 * Set by part creator. Can't be set at runtime by anything.
	 */
	protected void setCreature(Creature _creature) {
		creature = _creature;
	}
}