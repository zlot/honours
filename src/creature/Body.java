package creature;

import processing.core.PVector;

public abstract class Body extends Part {

	protected PVector pos;
	public int w;
	
//	AABB aabb; // aabb for body. needs: farthest top, right, bottom, left values. how to get these?
	
	public abstract void draw();
	
	public PVector getPos() {
		return pos;
	}

}
