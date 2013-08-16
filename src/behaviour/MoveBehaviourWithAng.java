package behaviour;

import creature.Behaviour;
import creature.Creature;
import processing.core.*;
import loader.PClass;

@SuppressWarnings("static-access")
public class MoveBehaviourWithAng extends Behaviour {

	float nOffset; // special offset to make virus movement unique.
	
	PVector acc, vel;
	float ang; // angle that creature is moving.
	
	public MoveBehaviourWithAng(Creature  _creature) {
		super(_creature);
		nOffset = p.random(-100, 100);
		acc = new PVector();
		vel = new PVector();
	}
	
	// annoying field just for noise
	float noiseInc = 0;
	float mmStep = 0.015f; // movement step
	
	public float ang2;
	
	// noise-walk the pos
	public void move() {
	    PVector pos = c.getBody().getPos();
		
	    float n = p.noise(noiseInc + nOffset);
	    float nMapped = p.map(n, 0, 1, -mmStep, mmStep); // for x
	    acc.x = nMapped;
	    
	    n = p.noise(noiseInc + 3); // 3 is arbitrary to have it different to y
	    nMapped = p.map(n, 0, 1, -mmStep, mmStep); // for y
	    acc.y = nMapped;
	    
	    noiseInc += 0.006;

	    
	    // get angle of pos to vel
	    p.pushMatrix();
	    	p.translate(pos.x, pos.y);
	    	ang = p.atan2(vel.y, vel.x); // in radians
	    	// get angle of pos to acc
	    	ang2 = p.atan2(acc.y, acc.x); // in radians
	    p.popMatrix();
	    
	    
	    // set creature angle
	    c.setAngle(ang);
	    
	    vel.add(acc);
	    pos.add(vel);
	    pos.x = p.constrain(pos.x, 0, getScreenWidth());
	    pos.y = p.constrain(pos.y, 0, getScreenHeight());
    }

	public float getAngle() {
		return ang;
	}
	
	
	@Override
	public void update() {
		move();
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
