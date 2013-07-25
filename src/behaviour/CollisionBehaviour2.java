package behaviour;

import processing.core.PVector;
import creature.*;

import pbox2d.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.joints.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.contacts.*;

public class CollisionBehaviour2 extends Behaviour {

	// width and height can be referenced by c
	
	// A reference to our box2d world
	static public PBox2D box2d;
	private org.jbox2d.dynamics.Body body;
	private int box2dFrameCount; // used to make sure box2d is stepped through only once per frame.
	
	public CollisionBehaviour2(Creature _creature) {
		super(_creature);
		// create box2D world if not created already (lazy instantiation)
		if(box2d == null) {
			box2d = new PBox2D(p);
			box2d.createWorld();
			// Turn on collision listening!
			box2d.listenForCollisions();
		}
		addToBox2DWorld();
		box2dFrameCount = p.frameCount;
	}
	
	private void addToBox2DWorld() {
		BodyDef bd = new BodyDef();
		bd.position.set(box2d.coordPixelsToWorld(c.getPos()));
		body = box2d.createBody(bd);
	    // Define the shape -- a polygon (this is what we use for a rectangle)
	    PolygonDef sd = new PolygonDef();
	    float box2dW = box2d.scalarPixelsToWorld(c.getBody().getWidth()/2);
	    float box2dH = box2d.scalarPixelsToWorld(c.getBody().getHeight()/2);
	    sd.setAsBox(box2dW, box2dH);
	    // Parameters that affect physics
	    // TODO::
	    sd.density = 1.0f;
	    sd.friction = 0.3f;
	    sd.restitution = 0.5f;

	    // Attach that shape to our body!
	    body.createShape(sd);
	    body.setMassFromShapes();

	    // Give it some initial random velocity
	    body.setLinearVelocity(new Vec2(p.random(-5,5),p.random(2,5)));
	    body.setAngularVelocity(p.random(-5,5));
		
	}

	@Override
	public void update() {
		// We must always step through time!
		// TODO:: make sure this is happening only once per frame. Is this logic correct.
		if(box2dFrameCount == p.frameCount) {
			box2d.step();
			box2dFrameCount++;
		} else return;
	}

	// Collision event functions!
	public void addContact(ContactPoint cp) {
	  // Get both shapes
	  Shape s1 = cp.shape1;
	  Shape s2 = cp.shape2;
	  // Get both bodies
	  org.jbox2d.dynamics.Body b1 = s1.getBody();
	  org.jbox2d.dynamics.Body b2 = s2.getBody();
	  
	  b1.
	  
	  // Get our objects that reference these bodies
	  Object o1 = b1.getUserData();
	  Object o2 = b2.getUserData();

	  // What class are they?  Box or Particle?
	  String c1 = o1.getClass().getName();
	  String c2 = o2.getClass().getName();

	  
	  if (c1.contains("Box")) {
	    Particle p = (Particle) o2;
	    p.change();
	  } 
	}	
	
	
	@Override
	protected void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveTo(PVector loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void freeze() {
		// TODO Auto-generated method stub

	}

}
