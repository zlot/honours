package creature;

import processing.core.PVector;

public abstract class Body extends Part {

	protected float width, height;
	
	AABB aabb2; // the aabb2 is always in world space.
	AABB aabb; // aabb for body. needs: farthest top, right, bottom, left values. how to get these?
	// the bounding box actually has to be in WORLD SPACE.
	// does this mean it must get updated every frame?
	
	protected Body(PVector _pos, float _width, float _height) {
		super(_pos);
		width = _width;
		height = _height;
	}
	
	public abstract void draw();
	
	public void update() {
	}
	
	public void setWidth(float _width) {
		width = _width;
	}
	public void setHeight(float _height) {
		height = _height;
	}
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
	
}
