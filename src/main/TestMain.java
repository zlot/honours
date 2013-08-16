package main;
import java.util.ArrayList;

import loader.PClass;
import processing.core.*;

public class TestMain extends PApplet {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		PApplet.main(new String[] { "--location=30,30", "main.Main" });
	}

	public PApplet p = this;
	static int width;
	static int height;
	static int bgColor;
	
	
	Wiggler w;
	
	
	@Override
	public void setup() {
		// Abstract PClass setup. Necessary!
		PClass.insertPApplet(this); // send instance of this PApplet to abstract ProcessingClass
		
		PClass.setWidthAndHeight(width, height);

		width = 400;
		height = 400;
		p.size(width, height, P2D);
		p.colorMode(p.HSB, 360, 100, 100);
		bgColor = p.color(240, 40, 40);
		p.noFill();

		w = new Wiggler();
	}
	@Override
	public void draw() {
		// refresh background
		p.fill(bgColor);
		p.rect(0,0,width,height);
		p.fill(0xddaa00aa);
		w.display();
  }
	
	public void mouseClicked() {
	}
	public void mouseDragged() {
	}
	
	public void keyPressed() {
		switch (key) {
		case 's':
			break;
		case 'd':
			break;
		}
	}
	
	
	// An object that wraps the PShape

	class Wiggler {
	  
	  PShape s;
	  PVector pos = new PVector(width/2, height/2);
	  
	  int deg;
	  
	  Wiggler() {
	    
	    // Now make the PShape with those vertices
	    s = createShape();
	    s.beginShape();
	    s.stroke(0xbbb05555);
	    s.strokeWeight(10);
	    for(int i=0; i<140; i+=2) { // put to 1 for even more wormy goodness!
	      s.vertex(0, i);
	    }
	    s.endShape();
	  }
	  
	  public void myWiggle(int deg) {
		  for (int i = 0; i < s.getVertexCount(); i++) {
			  // take the sine update, ++ a float value as it travels down the line
			  PVector v = s.getVertex(i);
			  
			  //v.x += sin(p.radians((deg + i) * 4)) * 0.5;
			  v.x = (float) (sin(p.radians((deg + i) * 6)));
			  
			  
			  //pos.add(new PVector(sineUpdate, 0));
			  s.setVertex(i, v.x, v.y);
		  }
	  }


	  void display() {
	    pushMatrix();
	    translate(pos.x, pos.y);
	    deg++;
	    if(deg % 360 == 0 && deg != 0) deg = 0;
	    myWiggle(deg);
	    shape(s);
	    popMatrix();
	  }
	}

	
}