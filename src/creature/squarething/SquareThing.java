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
		float r = p.random(15, 45);
		float r2 = p.random(15, 45);
		body = new SquareThingBody(pos, r, r);
	}

	@Override
	protected void addBehaviours() {
		addBehaviour(new CollisionBehaviour2(this));
	}

}
