package creature;

import processing.core.PVector;

public abstract class Body extends Part {

	protected float width, height;
	
	AABB aabb; // aabb for body. needs: farthest top, right, bottom, left values. how to get these?
	
	protected Body(PVector _pos, float _width, float _height) {
		super(_pos);
		width = _width;
		height = _height;
		setAABB(_width, _height);
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
	public void setAABB(float width, float height) {
		PVector lowerVertex = new PVector(-width/2, height/2);
		PVector upperVertex = new PVector(width/2, -height/2);
		aabb = new AABB(lowerVertex, upperVertex);
	}
	
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
	
}
