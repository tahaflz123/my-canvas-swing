package com.mycanvas;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Window extends JFrame{

	private Dimension dimension;
	
	
	public Window(Dimension dimension) {
		this.dimension = dimension;
	}
	
	

	
	public void init() {
		setSize(this.dimension);
		setResizable(true);
		setFocusable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
}
