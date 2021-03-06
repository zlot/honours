package creature.virus;

import java.util.ArrayList;

import creature.*;
import processing.core.*;


// Strategy Pattern?
@SuppressWarnings("static-access")
public class Virus extends Creature {
	  
	  public Virus() {
		  pos = new PVector(p.random(width), p.random(height));
		  
		  setBehaviour(new MoveBehaviour(pos));
		  createParts();
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
	  
	}