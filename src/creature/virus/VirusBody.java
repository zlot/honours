package creature.virus;

import processing.core.*;
import creature.Body;

public class VirusBody extends Body {
	
	 // width of virus. also height because its a perfect circle.

	public VirusBody(PVector _pos, int _w) {
		pos = _pos;
		w = _w;
	}

	@Override
	public void draw() {
	  // ellipse, with pos at center
	  p.fill(0, 80, 80);
	  p.ellipse(pos.x, pos.y, w, w);
	}

}
