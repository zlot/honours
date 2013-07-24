package creature.virus;

import processing.core.*;
import creature.Body;
import creature.MoveBehaviour;

public class VirusBody extends Body {
	
	public VirusBody(PVector _pos, int _width) {
		super(_pos, _width, _width);
	}

	@Override
	public void draw() {
	  // ellipse, with pos at center
	  p.fill(0, 80, 80);
	  p.ellipse(pos.x, pos.y, width, width);
	}

}
