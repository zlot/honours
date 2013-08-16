package creature.millipede;

import behaviour.MoveBehaviourWithAng;
import processing.core.PVector;
import toxi.math.waves.*;
import creature.Creature;
import creature.Limb;
import creature.LimbManager;

public class FeelerManager extends LimbManager {

	AbstractWave sineWave;

	public FeelerManager(Creature _c) {
		super(_c);
		createLimbs();
		
		sineWave = new SineWave(0, p.radians(4), 1, 0);
	}

	@Override
	public void draw() {
		MoveBehaviourWithAng m = (MoveBehaviourWithAng) creature.getBehaviourManager().getBehaviours().get(MoveBehaviourWithAng.class);

		float sineAngle = sineWave.update();
		
		// TODO: have to find a way to make this a FORCED thing.
		for(Limb feeler : limbs) {
//			feeler.setAngle(creature.getAngle());
			
			
			feeler.setAngle(creature.getAngle());
			feeler.setAngle2(m.ang2);
			feeler.setAngle3(sineAngle);
			
			feeler.draw();
		}
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
			Limb feeler = new Feeler(new PVector(0, i), feelerWidth, p.radians(-180)); // when width is 0
			
			// TODO: have to find a way to make this a FORCED thing.
			limbs.add(feeler);
			
			// angle is normal
			feeler = new Feeler(new PVector(width, i), feelerWidth, 0); // when width is full width.
			limbs.add(feeler);
			
		}
	}

}
