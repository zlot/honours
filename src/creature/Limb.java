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
	
	public void setAngle(float _ang) {
		ang = _ang;
	}
	
	
	// TEMP ONLY
	public float ang2;
	public float ang3;
	
	public void setAngle2(float _ang2) {
		ang2 = _ang2;
	}
	public void setAngle3(float _ang3) {
		ang3 = _ang3;
	}
	
	
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
