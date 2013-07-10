package graveyard;

import java.util.ArrayList;

import creature.*;
import creature.virus.Tentacle;
import processing.core.*;


// Strategy Pattern?
@SuppressWarnings("static-access")
public class CopyOfVirus extends Creature {
	  
	  private PVector pos;
	  private int w; // width of virus. also height because its a perfect circle.
	  private ArrayList<Tentacle> tentacles = new ArrayList<Tentacle>(); // list of tentacle positions

	  public CopyOfVirus() {
		  pos = new PVector(p.random(width), p.random(height));
		  w = (int) p.random(70, 130);

		  createTentacles();
	  }
	  
	  public void draw() {
	    drawBody();
	    drawTentacles();
	  }
	  
	  private void createTentacles() {
	    PVector tPos; // tentacle pos
	    int r = w/2; // radius is half of body
	    
	///// COULD BE SELECTED FOR PARAMETER CONTROL
	    int numTentacles = (p.random(1) < 0.5) ? 6 : 7;
	    float rndOffset = p.random(360); // for further uniqueness per virus.
	    for(int i=0; i<numTentacles; i++) {
	    	float ang = p.radians(i*(360/numTentacles) + rndOffset);
	    	tPos = new PVector(r * p.cos(ang), r * p.sin(ang));
	    	Tentacle t = new Tentacle(tPos, ang);
	      
	    	// add to tentancles
	    	tentacles.add(t);
	    }
	  }
	  
	  private void drawBody() {
		  // ellipse, with pos at center
		  p.fill(0, 80, 80);
		  p.ellipse(pos.x, pos.y, w, w);
	  }
	  
	  private void drawTentacles() {
		  // for now, just draw ellipses at each spot.
		  p.pushMatrix();
		  p.translate(pos.x, pos.y);
		  for(Tentacle t : tentacles) {
			  t.draw();
		  }
		  p.popMatrix();
	  }

	@Override
	protected void createParts() {
		// TODO Auto-generated method stub
		
	}
	  
	}