package creature;

import processing.core.PVector;

public abstract class Body extends Part {

	protected float width, height;
	
	AABB aabb2; // the aabb2 is always in world space.
	AABB aabb; // aabb for body. needs: farthest top, right, bottom, left values. how to get these?
	// the bounding box actually has to be in WORLD SPACE.
	// does this mean it must get updated every frame?
	
	protected Body(PVector _pos) {
		super(_pos);
	}
	
	public abstract void draw();
	
	
	///// note::: have to understand how im going to do the AABB thing.
	//// does it belong here, or in its own behaviour attached to Creature.
	//// probably as its own behaviour attached to creature.```
	public void update() {
		//super.update();
		// the aabb2 is always in world space.
		
		PVector worldaabb = PVector.add(aabb.lowerBound, pos);
		
		aabb2.lowerBound.x = worldaabb.x;
		aabb2.lowerBound.y = worldaabb.y;
		
		worldaabb = PVector.add(aabb.upperBound, pos);
		
		aabb2.upperBound.x = worldaabb.x;
		aabb2.upperBound.y = worldaabb.y;
		
	}
	
	public void setWidth(float _width) {
		width = _width;
		setBoundingBox();
	}
	public void setHeight(float _height) {
		height = _height;
		setBoundingBox();
	}
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
	
	private void setBoundingBox() {
		if(width !=0 && height != 0) // only if width/height have been set
			aabb = new AABB(new PVector(-width/2,height/2), new PVector(width/2,-height/2));
			aabb2 = new AABB(new PVector(-width/2,height/2), new PVector(width/2,-height/2));
	}
	
	// temporary only
	public void drawBoundingBox() {
		p.pushStyle();
		p.stroke(0, 100, 100);
		p.noFill();
		p.rect(aabb2.lowerBound.x, aabb2.upperBound.y, width, height);
		p.popStyle();
	}
	public void drawBoundingBoxCollide() {
		p.pushStyle();
		p.fill(0, 100, 100);
		p.rect(aabb2.lowerBound.x, aabb2.upperBound.y, width, height);
		p.popStyle();
	}
}
