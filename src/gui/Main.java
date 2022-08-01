package gui;

import physics.Universe;

public class Main {

	public static void main(String[] args) {
		
		Universe.init();
		Human human = new Human();
		human.launch();
		
	}
	
}
