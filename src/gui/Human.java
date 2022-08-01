package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import physics.Body;
import physics.Universe;
import util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Human implements ActionListener {
		
	private GUI gui;
	private Timer timer;
	private final double timeDelta = 50;
	
	private int FRAME_WIDTH = 750;
	private int FRAME_HEIGHT = 750;
	
	private final double scaleFactor = 1.0 / 1;
	
	public Human() {
		
	}
	
	public void launch() {
		gui = new GUI();
		timer = new Timer((int) (1000.0 / timeDelta), this);
        	timer.start();
	}
	
		
	class GUI extends JFrame {
		GUIPanel panel;
		public GUI () {	
			panel = new GUIPanel();
			this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
			this.add(panel);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);	
		}
		
	    @Override
	    public void paint(Graphics g) 
	    {
			panel.repaint();
	    }
	
	}
	
	class GUIPanel extends JPanel {
				
		public void clear(Graphics g) {
		 	g.setColor(Color.WHITE);
	    	g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

	    }
		
	    @Override
	    public void paintComponent(Graphics g) {
	    	clear(g);
	    	g.setColor(Color.BLACK);
	    	for (Body b : Universe.bodies) {
	    		Vector pos = b.getPos();
	    		g.fillOval((int) (pos.get(0) * scaleFactor), (int) (pos.get(1) * scaleFactor), 30, 30);
	    	}

	    }
	    
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
    	Universe.update(1 / timeDelta);
		gui.repaint();
	}
	
	
}
