package physics;

import util.Vector;

public class Body {
	
	private double mass;
	private Vector pos;
	private Vector vel;
	
	public Body(double mass, Vector pos) {
		this.mass = mass;
		this.pos = pos;
		this.vel = new Vector(2).setEntries(0, 0);
	}
	
	public Body(double mass, Vector pos, Vector initVel) {
		this.mass = mass;
		this.pos = pos;
		this.vel = initVel;
	}
	
	public Vector getPos() {
		return this.pos;
	}
	
	public void actOn(Body other, double timeDelta) {
		Vector difPosVector = this.pos.clone().add(other.pos.clone().scale(-1));
		double dist = difPosVector.magnitude();
		if (dist < Universe.minDistance) return;

		double force = Universe.G * this.mass * other.mass / difPosVector.magnitude();
		Vector acceleration = difPosVector.normalize().scale(force).scale(1 / other.mass);

		other.vel.add(acceleration.scale(timeDelta));
		other.pos.add(other.vel.get(0) * timeDelta, other.vel.get(1) * timeDelta);
	}

}
