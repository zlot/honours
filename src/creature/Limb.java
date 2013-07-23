package creature;

import processing.core.PVector;

public abstract class Limb extends Part {

	// note: maybe this is promoted to Limb field? can have a helper function that can
	// ALWAYS calculate this based on body PVector?
	protected float ang; // angle on body. ALREADY IN RADIANS.
	
	protected float width;
	protected float height;
	
	protected Limb(PVector _pos) {
		super(_pos);
	}
	
	@Override
	public abstract void draw();
	
//	public void setBehaviour(Behaviour b) {
//		behaviour = b;
//	}
	
	public abstract void update();
	
    public float getAngle() {
    	return ang;
    }
    
    public float getWidth() {
    	return width;
    }
    
    public float getHeight() {
    	return height;
    }
	

}
