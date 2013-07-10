package creature;

public abstract class Limb extends Part {

	protected Behaviour limbBehaviour;
	// note: maybe this is promoted to Limb field? can have a helper function that can
	// ALWAYS calculate this based on body PVector?
	protected float ang; // angle on body. ALREADY IN RADIANS.
	
	protected float width;
	protected float height;
	
	@Override
	public abstract void draw();
	
	public abstract void drawSpecific(float x, float y, float scaleX, float scaleY);

	public void setBehaviour(Behaviour b) {
		limbBehaviour = b;
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
