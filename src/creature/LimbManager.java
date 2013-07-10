package creature;

import java.util.ArrayList;
import loader.PClass;

public abstract class LimbManager extends PClass {

	protected Creature creature; // reference to creature that LimbManager belongs to.
	
	protected ArrayList<Limb> limbs = new ArrayList<Limb>();
	
//	protected Behaviour limbBehaviour;
	
	public LimbManager(Creature _c) {
		creature = _c;
	}
	
	public abstract void draw();
	
	public abstract void createLimbs();
	
//	public void assignBehaviour(Behaviour b) {
//		// assign all limbs to this behaviour.
//		for(Limb l : limbs) {
//			limbBehaviour = b;
//			l.setBehaviour(b);
//		}
//		// this limits all limbs to all use the same behaviour.
//		// but it makes it easier to swap the behaviour in and out.
//	}
	
	
	public void add(Limb l) {
		limbs.add(l);
	}
	
	public ArrayList<Limb> getLimbs() {
		return limbs;
	}
}
