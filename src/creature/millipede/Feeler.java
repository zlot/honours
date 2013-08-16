package creature.millipede;

import processing.core.PVector;
import creature.Limb;
import toxi.math.waves.*;

public class Feeler extends Limb {

	AbstractWave sineWave; 
	
	public Feeler(PVector _pos, float _width, float _ang) {
		super(_pos);
		width = _width;
		setColor(0);
		// TODO:: clean up this code!
		ang = _ang;
		sineWave = new SineWave();
	}

	@Override
	public void draw() {
		p.pushMatrix();
		p.translate(pos.x, pos.y);
		
		p.rotate(-(ang+p.radians(90))); // rotate back to world axis
		p.rotate(ang2+ang3+p.radians(90)); // need angle of acc
//		p.rotate(p.radians(p.random(180)));
		
		p.pushStyle();
			p.color(color);
			p.stroke(40);
			//p.line(pos.x, pos.y, pos.x+width, pos.y);
			p.line(0, 0, 0, width);
			
		p.popStyle();
		p.popMatrix();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(int _color) {
		color = _color;
	}

}
