package creature;

import processing.core.*;
import loader.PClass;

@SuppressWarnings("static-access")
public class MoveBehaviour extends Behaviour {

	  float nOffset; // special offset to make virus movement unique.
	  
	  public MoveBehaviour(PVector _pos) {
	    pos = _pos;
	    nOffset = p.random(-100, 100);
	  }
	  
	  // annoying field just for noise
	  float noiseInc = 0;
	  float mmStep = 0.5f; // movement step
	  
	  // noise-walk the pos
	public void move() {
	    PVector vel = new PVector();
	    float n = p.noise(noiseInc + nOffset);
	    float nMapped = p.map(n, 0, 1, -mmStep, mmStep); // for x
	    vel.x = nMapped;
	    
	    n = p.noise(noiseInc + 3); // 3 is arbitrary to have it different to y
	    nMapped = p.map(n, 0, 1, -mmStep, mmStep); // for y
	    vel.y = nMapped;
	    
	    noiseInc += 0.006;
	    
	    pos.add(vel);
	    pos.x = p.constrain(pos.x, 0, width);
	    pos.y = p.constrain(pos.y, 0, height);
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
