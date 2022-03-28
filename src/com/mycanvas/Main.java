package com.mycanvas;

import java.awt.Dimension;

public class Main {
	public static void main(String[] args) {
		new Main().create();
	}

	
	private Window window;
	private Canvas canvas;
	private Dimension dimension;
	
	public void create() {
		dimension = new Dimension(800,800);
		window = new Window(dimension);
		canvas = new Canvas(dimension);
		this.run();
	}
	
	
	public void run() {
		window.add(canvas);
		window.init();
		canvas.init();
		window.setVisible(true);
		window.addKeyListener(canvas);
	}
	
	public void update() {
		while(true) {
			canvas.paint(canvas.getGraphics());
		}
	}
	
	
	
}
