package creature.virus;

import creature.Limb;
import processing.core.*;

public class Tentacle extends Limb {

	  PVector pos; // pos on body
	  float length; // length of tentacle
	  float r; // radius of tentacle /// COULD BE SELECTED FOR PARAMETER CONTROL
	  float ang; // angle on body?
	  float tOffset; // special offset to make this tentacle unique.
	    
	  public Tentacle(PVector _pos, float _ang) {
	    pos = _pos;
	    ang = _ang;
	    length = 16; // COULD BE SELECTED FOR PARAMETER CONTROL.
	    r = 20; // r being radius of biggest part of tentacle.
	    tOffset = p.random(0, 2); // tentacle offset
	  }
	    
	  
	  // annoying global just for noise.
	  float noiseInc = 0;
	  
	  public void draw() {
		  p.fill(60, 70, 70);
		  p.pushMatrix();
		  p.translate(pos.x, pos.y);
	    
		  float n = p.noise(noiseInc + tOffset);
	//////// COULD BE SELECTED FOR PARAMETER CONTROL.
		  float tentacleTwist = p.map(n,0,1,3.6f,6.29f); // 3.6-6.29 chosen as nice range for tentacles to move.
		  noiseInc += 0.006;
		  p.rotate(ang + tentacleTwist); 
	    
		  // re-map the twist for recursive tentacles to twist more at ends
		  tentacleTwist = p.map(tentacleTwist, 3.6f, 6.29f, -2.1f, 2.1f);
		  recursiveTentacles(length, tentacleTwist);
	    
		  p.popMatrix();
	  }
	  
	  // this is really part of behaviour!	  
	  private void recursiveTentacles(float l, float tentacleTwist) {
	    if(l > 0) {      
	//////// COULD BE SELECTED FOR PARAMETER CONTROL.
	    	p.rotate(p.radians(tentacleTwist));
	    	//////// 2.5 COULD BE SELECTED FOR PARAMETER CONTROL.
	    	p.ellipse(0, (20-(r*(l/length))) * 2.5f, r*(l/length), r*(l/length));
	    	l--;
	    	recursiveTentacles(l, tentacleTwist);
	      
	    }
	  }
	  
	  // this would be part of behaviour!
	  public void update() {
	    
	  }

}
