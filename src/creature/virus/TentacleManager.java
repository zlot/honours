package creature.virus;

import processing.core.PVector;
import creature.*;

public class TentacleManager extends LimbManager {

	public TentacleManager(Creature _c) {
		super(_c);
		
		createLimbs();
	}

	@Override
	public void draw() {
		for(Limb t : limbs) {
			t.draw();
		}
	}
	
	public void createLimbs() {
	    PVector tPos; // tentacle pos
	    float r = creature.getBody().getWidth()/2; // radius is half of body
	    
	///// COULD BE SELECTED FOR PARAMETER CONTROL
	    int numTentacles = (p.random(1) < 0.5) ? 6 : 7;
	    float rndOffset = p.random(360); // for further uniqueness per virus.
	    for(int i=0; i<numTentacles; i++) {
	    	float ang = p.radians(i*(360/numTentacles) + rndOffset);
	    	tPos = new PVector(r * p.cos(ang), r * p.sin(ang));
	    	Tentacle t = new Tentacle(tPos, ang);
	      
	    	// add to tentacles
	    	limbs.add(t);
	    }
	}

	float tOffset; // special offset to make this tentacle unique.

}
