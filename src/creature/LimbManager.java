package creature;

import java.util.ArrayList;
import loader.PClass;

public abstract class LimbManager extends PClass {

	protected Creature creature; // reference to creature that LimbManager belongs to.
	
	protected ArrayList<Limb> limbs = new ArrayList<Limb>();
	
	public LimbManager(Creature _c) {
		creature = _c;
	}
	
	public abstract void draw();
	
	public void update() {
		// optional override
	};
	
	public abstract void createLimbs();
	
	
	
	public void add(Limb l) {
		limbs.add(l);
	}
	
	public ArrayList<Limb> getLimbs() {
		return limbs;
	}
}
