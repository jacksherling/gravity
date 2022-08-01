package util;

public class Vector {
	
	private double[] entries;
	private int dim;
	
	public Vector(int dim) {
		this.dim = dim;
		entries = new double[dim];
	}
	
	public Vector setEntries(double... values) {
		int length = values.length;
		if (length != dim) {
			return null;
		}
		for (int i = 0; i < length; i++) {
			entries[i] = values[i];
		}
		return this;
	}
	
	public double get(int index) {
		return this.entries[index];
	}
	
	public double magnitudeSqaured() {
		double magnitudeSquared = 0;
		for (double i : entries) {
			magnitudeSquared += i * i;
		}
		return magnitudeSquared;
	}
	
	public double magnitude() {
		return Math.sqrt(this.magnitudeSqaured());
	}
	
	public Vector scale(double factor) {
		for (int i = 0; i < entries.length; i++) {
			entries[i] *= factor;
		}
		return this;
	}
	
	public Vector add(double... values) {
		return this.add(new Vector(values.length).setEntries(values));
	}
	
	public Vector add(Vector other) {
		if (other.entries.length != entries.length) return null;
		for (int i = 0; i < this.entries.length; i++) {
			this.entries[i] += other.entries[i];
		}
		return this;
	}
	
	public Vector normalize() {
		return this.scale(1 / this.magnitude());
	}
	

	public double[] getEntries() {
		return this.entries;
	}
	
	@Override
	public Vector clone() {
		Vector result = new Vector(entries.length);
		result.setEntries(this.entries);
		return result;
	}
	
	public String toString() {
		String result = "";
		for (double i : entries) {
			result += i + " ";
		}
		return result;
	}
	


}
