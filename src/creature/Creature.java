package creature;

import processing.core.PVector;
import loader.PClass;

public abstract class Creature extends PClass {

	protected PVector pos = null; // usually the same as body pos.
	protected Body body = null;
	protected LimbManager limbManager = null;
	
	public abstract void draw();
	
	protected abstract void createParts();
	
	public Body getBody() {
		return body;
	}
	public LimbManager getLimbManager() {
		return limbManager;
	}
}
