package creature.millipede;

import behaviour.MoveBehaviourWithAng;
import processing.core.PVector;
import toxi.math.waves.*;
import creature.Creature;
import creature.Limb;
import creature.LimbManager;

public class FeelerManager extends LimbManager {

	AbstractWave sineWave;
	float sineAngle;
	
	public FeelerManager(Creature _c) {
		super(_c);
		createLimbs();
		
		sineWave = new SineWave(0, p.radians(4), 1, 0);
	}

	@Override
	public void draw() {
		for(Limb l : limbs) {
			l.draw();
		}
	}
	@Override
	public void update() {
		sineAngle = sineWave.update();
	}

	@Override
	public void createLimbs() {
		// Create limbs around body
		// have to find perimeter of body. How to do this?
		// 2d for loop: from 0 to height; from 0 to width; create a limb.
		int step = 8;
		
		float height = creature.getBody().getHeight();
		float width = creature.getBody().getWidth();
		float feelerWidth = width * 0.65f;
		
		for(int i=0; i<height; i += step) {
			// when width is 0
			Limb feeler = new Feeler(creature, new PVector(0, i), feelerWidth, p.radians(-180));
			
			// TODO: have to find a way to make this a FORCED thing.
			limbs.add(feeler);
			
			// when width is full width, angle is normal
			feeler = new Feeler(creature, new PVector(width, i), feelerWidth, 0);
			limbs.add(feeler);
			
		}
	}

}
