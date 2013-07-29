package behaviour;

import java.util.ArrayList;
import java.util.List;

import processing.core.PVector;
import creature.*;
import pbox2d.*;
import main.World;

import org.jbox2d.common.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.contacts.*;

public class CollisionBehaviour2 extends Behaviour {
	// width and height can be referenced by c
	
	// A reference to our box2d world
	static public PBox2D box2d;
	static private int box2dFrameCount; // used to make sure box2d is stepped through only once per frame.

	private org.jbox2d.dynamics.Body body;
	private List<Updateable> updateList = new ArrayList<Updateable>();
	
	public CollisionBehaviour2(Creature _creature) {
		super(_creature);
		// create box2D world if not created already (lazy instantiation)
		if(box2d == null) {
			box2d = new PBox2D(p);
			box2d.createWorld();
			// Turn on collision listening!
			box2d.listenForCollisions();
			box2d.setGravity(0, 0);
			addAConstraint();
		}
		addToBox2dWorld();
		box2dFrameCount = 1;
	}
	
	private void addToUpdate(Updateable o) {
		// observer pattern. Used to register update() and draw() methods within the passed object.
		updateList.add(o);
	}
	
	
	private void addToBox2dWorld() {
		BodyDef bd = new BodyDef();
		bd.position.set(box2d.coordPixelsToWorld(c.getPos()));
		body = box2d.createBody(bd);
		
		// Define the shape -- a polygon (this is what we use for a rectangle)
		defineSquareShape();
	    PolygonDef sd = new PolygonDef();
	    
	    float box2dW = box2d.scalarPixelsToWorld(c.getBody().getWidth()/2);
	    float box2dH = box2d.scalarPixelsToWorld(c.getBody().getHeight()/2);
	    sd.setAsBox(box2dW, box2dH);
	    // Parameters that affect physics
	    sd.density = 1f;
	    sd.friction = .03f;
	    sd.restitution = 0.85f; // bounce off other objects

	    // Attach that shape to our body!
	    body.createShape(sd);
	    
	    body.setMassFromShapes();
	    // add application-specific body data. Box2d body now knows the creature it is attached to.
	    // can be retrieved by casting body.getUserData() to Creature.
	    body.setUserData(c);

	    // Give it some initial random velocity
	    body.setLinearVelocity(new Vec2(p.random(-10,10),p.random(4,6)));
	    body.setAngularVelocity(p.random(-5,5));
	}
	
	private void defineSquareShape() {
		
	}
	
	private void defineEllipseShape() {
		
	}

	@Override
	public void update() {
		// We must always step through time!
		if(p.frameCount == box2dFrameCount) {
			box2dFrameCount++;
			box2d.step();
		}
		move();
		
		for(Updateable o : updateList) {
			o.update();
			o.draw();
		}
		
		// returns head of the world body list (as a body).
		// use Body.getNext() to get the next body in the world list.
		org.jbox2d.dynamics.Body b = box2d.world.getBodyList();
		while(b != null) {
			Vec2 pos = b.getPosition();
			// draw box at position
			p.pushStyle();
			p.fill(0);
			// transform from box2d world to pixel space
			PVector pixelSpace = box2d.coordWorldToPixelsPVector(pos);
			p.rectMode(p.CENTER);
			p.rect(pixelSpace.x, pixelSpace.y, 10, 10);
			p.popStyle();
			b = b.getNext();
		}

	}

	// Collision event functions!
	static public void addContact(ContactPoint cp) {
	  // Get both shapes
	  Shape s1 = cp.shape1;
	  Shape s2 = cp.shape2;
	  // Get both bodies
	  org.jbox2d.dynamics.Body b1 = s1.getBody();
	  org.jbox2d.dynamics.Body b2 = s2.getBody();
	  
	  // Get our objects that reference these bodies
	  Creature c1 = (Creature) b1.getUserData();
	  Creature c2 = (Creature) b2.getUserData();
	  
	  // if c1 and c2 are creatures, then run collisionAction
	  if(c1 instanceof Creature && c2 instanceof Creature) {
		  collisionAction(c1);
		  collisionAction(c2);
	  } else {
		  // else, it could be a collision between creature and boundary; do nothing for now.
	  }

	}	
	
	static public void removeContact(ContactPoint cp) {
		  // Get both shapes
		  Shape s1 = cp.shape1;
		  Shape s2 = cp.shape2;
		  // Get both bodies
		  org.jbox2d.dynamics.Body b1 = s1.getBody();
		  org.jbox2d.dynamics.Body b2 = s2.getBody();
		  
		  // Get our objects that reference these bodies
		  Creature c1 = (Creature) b1.getUserData();
		  Creature c2 = (Creature) b2.getUserData();
		  
		  if(c1 instanceof Creature && c2 instanceof Creature) {
				c1.getBody().setColor(0xFF00FF00); // hexadecimal colour: 0x[alpha][red][green][blue]
				c2.getBody().setColor(0xFF00FF00); // hexadecimal colour: 0x[alpha][red][green][blue]
		  } else {
			  // else, it could be a collision between creature and boundary; do nothing for now.
		  }
	}
	
	static private void collisionAction(Creature c) {
		CollisionBehaviour2 collisionBehaviourForCreature = (CollisionBehaviour2) c.getBehaviourManager().getBehaviours().get(CollisionBehaviour2.class);
		collisionBehaviourForCreature.collisionAction();
	}
	
	private void collisionAction() {
		c.getBody().setColor(0xFFFF0000); // hexadecimal colour: 0x[alpha][red][green][blue]
	}
	
	@Override
	protected void move() {
		// here we place the position from the physics engine, back to the pos of the creature.
		Vec2 physicsPos = box2d.getBodyPixelCoord(this.body);
		float a = body.getAngle(); // already in radians it seems
		c.setAngle(a);
		c.getBody().getPos().x = physicsPos.x;
		c.getBody().getPos().y = physicsPos.y;
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

	
	private void addAConstraint() {
		// left boundary
		new Boundary(World.getScreenWidth()-5, World.getScreenHeight()/2, 10, World.getScreenHeight());
		// right boundary
		new Boundary(5, World.getScreenHeight()/2, 10, World.getScreenHeight());
//		// top boundary
		new Boundary(World.getScreenWidth()/2, 5, World.getScreenWidth(), 10);
//		// bottom boundary
		new Boundary(World.getScreenWidth()/2, World.getScreenHeight()-5, World.getScreenWidth(), 10);
	}
	
	class Boundary implements Updateable {
		
		float x, y, w, h;
		org.jbox2d.dynamics.Body b;
		
		Boundary(float _x, float _y, float _w, float _h) {
			x = _x;
			y = _y;
			w = _w;
			h = _h;
			
			PolygonDef polygon = new PolygonDef();
			
			float box2dW = box2d.scalarPixelsToWorld(w/2);
			float box2dH = box2d.scalarPixelsToWorld(h/2);
			polygon.density = 0;    // No density means it won't move!
			polygon.friction = 0.3f;
			polygon.setAsBox(box2dW, box2dH);
			
			BodyDef bd = new BodyDef();
			
			Vec2 posInBox2dWorld = box2d.coordPixelsToWorld(new PVector(x,y));
			bd.position.set(posInBox2dWorld);
			
			org.jbox2d.dynamics.Body constraint = box2d.createBody(bd);
			constraint.createShape(polygon);
			
			addToUpdate(this);
		}
		
		public void update() {}
		
		public void draw() {
		    p.pushStyle();
		    p.fill(0);
		    p.stroke(0);
		    p.rectMode(p.CENTER);
		    p.rect(x,y,w,h);
		    p.popStyle();
		}
		
	}
	
	
}
