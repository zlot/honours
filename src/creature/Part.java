package creature;
import loader.PClass;
import processing.core.*;


public abstract class Part extends PClass {

	PVector pos;
	Behaviour behaviour; // MUST this exist for each part?
	
	public abstract void draw();
	
}
