package physics;

import java.util.ArrayList;

import util.Vector;

public class Universe {
	
	public static final double G = 5; // not real universal value
	public static final double minDistance = 10; // forces too great when bodies are too close
	
	public static ArrayList<Body> bodies = new ArrayList<Body>();
	
	// enter bodies here
	public static void init() {
		// binary star system (which ultimately collapses)
		bodies.add(new Body(20000, new Vector(2).setEntries(150, 300), new Vector(2).setEntries(0, 200)));
		bodies.add(new Body(20000, new Vector(2).setEntries(550, 300), new Vector(2).setEntries(0, -200)));
	}
	
	public static void update(double timeDelta) {
		for (int i = 0; i < bodies.size(); i++) {
			for (int j = 0; j < bodies.size(); j++) {
				if (i == j) continue;
				bodies.get(i).actOn(bodies.get(j), timeDelta);
			}
		}
	}
	
	

}
