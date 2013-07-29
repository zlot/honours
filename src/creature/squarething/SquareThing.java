package creature.squarething;

import processing.core.PVector;
import behaviour.CollisionBehaviour2;
import main.World;
import creature.Creature;

public class SquareThing extends Creature {

	public SquareThing() {
		pos = new PVector(p.random(World.getScreenWidth()), p.random(World.getScreenHeight()));
		createParts();
		addBehaviours();
	}

	@Override
	public void draw() {
	 // TODO:: incorporate this up a step into Creature.
	  p.pushMatrix();
		p.translate(getPos().x, getPos().y);
	  	p.rotate(-angle); // has to be -angle. Why? I don't know.
		body.draw();
	  p.popMatrix();
	}

	@Override
	protected void createParts() {
		float r = p.random(20, 80);
		r = 10;
		float r2 = 220;
		body = new SquareThingBody(pos, r, r2);
	}

	@Override
	protected void addBehaviours() {
		addBehaviour(new CollisionBehaviour2(this));
	}

}
