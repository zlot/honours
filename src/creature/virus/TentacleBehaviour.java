package creature.virus;

import processing.core.PVector;
import creature.*;

public class TentacleBehaviour extends Behaviour {

	float tOffset; // special offset to make this tentacle unique.
	float w, h;
	
	public TentacleBehaviour() {
		tOffset = p.random(0, 2); // tentacle offset
		
	}
	
	// annoying global just for noise.
	float noiseInc = 0;
	
	@Override
	public void update() {
		// sloppy
		if(limb != null) {
			w = limb.getWidth();
			h = limb.getHeight();			
		}
		
		
		
		float n = p.noise(noiseInc + tOffset);
		//////// COULD BE SELECTED FOR PARAMETER CONTROL.
		float tentacleTwist = p.map(n,0,1,3.6f,6.29f); // 3.6-6.29 chosen as nice range for tentacles to move.
		noiseInc += 0.006;
		p.rotate(limb.getAngle() + tentacleTwist); 
	
		// re-map the twist for recursive tentacles to twist more at ends
		tentacleTwist = p.map(tentacleTwist, 3.6f, 6.29f, -2.1f, 2.1f);
		recursiveTentacles(limb.getHeight(), tentacleTwist);
	}

	private void recursiveTentacles(float l, float tentacleTwist) {
		if(l > 0) {      
	//////// COULD BE SELECTED FOR PARAMETER CONTROL.
			p.rotate(p.radians(tentacleTwist));
	  	//////// 2.5 COULD BE SELECTED FOR PARAMETER CONTROL.
			
			limb.drawSpecific(0,   (w-(w*(l/h))) * 2.5f,   w*(l/h),   w*(l/h));
			
			//p.ellipse(0, (20-(r*(l/length))) * 2.5f, r*(l/length), r*(l/length));
			l--;
			recursiveTentacles(l, tentacleTwist);
		}
	}
	
	
	@Override
	protected void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveTo(PVector loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void startMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void freeze() {
		// TODO Auto-generated method stub

	}

}
