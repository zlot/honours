package creature;

import processing.core.PVector;

public abstract class Body extends Part {

	protected float width, height;
	
	AABB aabb2;
	AABB aabb; // aabb for body. needs: farthest top, right, bottom, left values. how to get these?
	// the bounding box actually has to be in WORLD SPACE.
	// does this mean it must get updated every frame?
	// what it is + the pos translation?
	
	protected Body(PVector _pos) {
		super(_pos);
	}
	
	public abstract void draw();
	
	public void update() {
		super.update();
		// the aabb2 is always in world space.
		
		PVector worldaabb = PVector.add(aabb.lowerBound, pos);
		
		aabb2.lowerBound.x = worldaabb.x;
		aabb2.lowerBound.y = worldaabb.y;
		
		worldaabb = PVector.add(aabb.upperBound, pos);
		
		aabb2.upperBound.x = worldaabb.x;
		aabb2.upperBound.y = worldaabb.y;
		
//		aabb2.lowerBound = PVector.add(aabb.lowerBound, pos);
//		aabb2.upperBound = PVector.add(aabb.upperBound, pos);
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
	
	public void setBoundingBox() {
		if(width !=0 && height != 0) // only if width/height have been set
			aabb = new AABB(new PVector(-width/2,height/2), new PVector(width/2,-height/2));
			aabb2 = new AABB(new PVector(-width/2,height/2), new PVector(width/2,-height/2));
	}
	
	public void drawBoundingBox() {
//		p.pushMatrix();
//		p.translate(pos.x, pos.y);
		p.pushStyle();
		p.stroke(0, 100, 100);
		p.noFill();
		p.rect(aabb2.lowerBound.x, aabb2.upperBound.y, width, height);
		p.popStyle();
//		p.popMatrix();
	}
	public void drawBoundingBoxCollide() {
//		p.pushMatrix();
//		p.translate(pos.x, pos.y);
		p.pushStyle();
		p.fill(0, 100, 100);
		p.rect(aabb2.lowerBound.x, aabb2.upperBound.y, width, height);
		p.popStyle();
//		p.popMatrix();
	}
}
