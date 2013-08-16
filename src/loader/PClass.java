package loader;
import processing.core.PApplet;


/**
 * Used as a helper superclass such that the PApplet does not
 * have to be passed as an argument into every constructed class.
 * 
 * @author zlot
 */
public abstract class PClass {

	protected static PApplet p;
	private static int width;
	private static int height;
	
	public static boolean insertPApplet(PApplet _p) {
		if(p == null)
			p = _p;
		return true;
	}
	public static void setWidthAndHeight(int w, int h) {
		width = w;
		height = h;
	}
	
	public static float getScreenWidth() {
		return width;
	}
	public static float getScreenHeight() {
		return height;
	}
}
