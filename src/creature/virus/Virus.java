package creature.virus;

import java.util.ArrayList;

import creature.*;
import processing.core.*;


// Strategy Pattern?
@SuppressWarnings("static-access")
public class Virus extends Creature {
	  
	  public Virus() {
		  createParts();
		  setBehaviours();
	  }
	  
	  public void draw() {
		  body.draw();
		  limbManager.draw();
	  }
	  
	  protected void createParts() {
		  int w = (int) p.random(70, 130);
		  PVector randomPos = new PVector(p.random(width), p.random(height));
		  body = new VirusBody(randomPos, w);
		  
		  limbManager = new TentacleManager(this); // w/2 is radius
	  }
	  
	  protected void setBehaviours() {
		  setBehaviour(new MoveBehaviour(body.getPos()));
		  getBehaviourManager().setLimbBehaviour(new TentacleBehaviour());
	  }
	  
	}