package creature.virus;

import creature.*;

import processing.core.*;

public class Tentacle extends Limb {

	//  float length; // length of tentacle
	 // float r; // radius of tentacle /// COULD BE SELECTED FOR PARAMETER CONTROL
	  
	  // AABB maybe? so instead of r for radius and length, we can use the width/height
	  // of the AABB?

	  public Tentacle(PVector _pos, float _ang) {
	    pos = _pos;
	    ang = _ang;
	    height = 16; // COULD BE SELECTED FOR PARAMETER CONTROL.
	    width = 20; // width being radius of biggest part of tentacle.
	    
	    setBehaviour(new TentacleBehaviour(this));
	  }
	    
	  
	  public void draw() {
		  p.fill(60, 70, 70);
		  p.pushMatrix();
		  p.translate(pos.x, pos.y);
		  behaviour.update();
	    
		  p.popMatrix();
	  }
	  
	  @Override
	  public void update() {

	  }
	  
	  
	  public void drawSpecific(float x, float y, float scaleX, float scaleY) {
		  p.ellipse(x, y, scaleX, scaleY);
//		  scaleX *= 3.5;
//		  scaleY *= 3.5;
//		  p.triangle(x-scaleX, y+scaleY, x, y-scaleY, x+scaleX, y+scaleY);
	  }
	  
	  


	  

}
