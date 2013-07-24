package creature.virus;

import creature.*;
import processing.core.*;

@SuppressWarnings("static-access")
public class Virus extends Creature {
	  
	  public Virus() {
		  super(); // creates behaviourManager
		  pos = new PVector(p.random(width), p.random(height));
		  createParts();
		  addBehaviours();
	  }
	  
	  public void draw() {
		  body.draw();
		  limbManager.draw();
	  }
	  
	  protected void createParts() {
		  int w = (int) p.random(70, 130);
		  body = new VirusBody(pos, w);
		  
		  limbManager = new TentacleManager(this); // w/2 is radius
	  }
	  
	  protected void addBehaviours() {
		  addBehaviour(new MoveBehaviour(this));
	  }
	  
	}