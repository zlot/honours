package creature.virus;

import behaviour.MoveBehaviour;
import processing.core.*;
import creature.Body;

public class VirusBody extends Body {
	
	public VirusBody(PVector _pos, int _width) {
		super(_pos, _width, _width);
		color = 0xFF007744;
	}

	@Override
	public void draw() {
		// ellipse, with pos at center
		//p.fill(0, 80, 80);
		p.pushStyle();
		p.fill(color);
		p.ellipse(0, 0, width, width);
		p.popStyle();
	}

	@Override
	public void setColor(int _color) {
		color = _color;
	}

}
