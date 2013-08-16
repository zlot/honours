package creature.millipede;

import processing.core.PVector;
import creature.Body;
import creature.Creature;

public class MillipedeBody extends Body {

	public MillipedeBody(Creature _creature, PVector _pos, float _width, float _height) {
		super(_creature, _pos, _width, _height);
		setColor(0xea00aa22);
	}

	@Override
	public void draw() {
		p.pushStyle();
			p.noStroke();
			p.fill(color);
			p.rect(0,0,width,height);
		p.popStyle();
	}

	@Override
	public void setColor(int color) {
		this.color = color;
	}

}