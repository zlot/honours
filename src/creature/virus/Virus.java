package creature.virus;

import behaviour.CollisionBehaviour;
import behaviour.PBox2DBehaviour;
import behaviour.MoveBehaviour;
import creature.*;
import processing.core.*;

@SuppressWarnings("static-access")
public class Virus extends Creature {
	  
	  public Virus() {
		  super(); // creates behaviourManager
		  pos = new PVector(p.random(getScreenWidth()), p.random(getScreenHeight()));
		  createParts();
		  addBehaviours();
	  }
	  
	  public void draw() {
		  // TODO:: incorporate this up a step into Creature.
		  p.pushMatrix();
			p.translate(getPos().x, getPos().y);
		  	p.rotate(-angle); // has to be -angle. Why? I don't know.
			body.draw();
			limbManager.draw();
		  p.popMatrix();
	  }
	  
	  protected void createParts() {
		  int w = (int) p.random(70, 130);
		  body = new VirusBody(this, pos, w);
		  
		  limbManager = new TentacleManager(this); // w/2 is radius
	  }
	  
	  protected void addBehaviours() {
		  
//		  addBehaviour(new MoveBehaviour(this));
		  addBehaviour(new PBox2DBehaviour(this, PBox2DBehaviour.CreatureShape.CIRCLE));
	  }
	  
	}