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
		body.draw();
	}

	@Override
	protected void createParts() {
		float r = p.random(40, 60);
		r = 40;
		body = new SquareThingBody(pos, r, r);
	}

	@Override
	protected void addBehaviours() {
		addBehaviour(new CollisionBehaviour2(this));
	}

}
