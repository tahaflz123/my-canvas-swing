package com.mycanvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Canvas extends JPanel implements MouseMotionListener, KeyListener {

	
	
	
	public List<Shape> shapes = new ArrayList<>();
	private Dimension dimension;
	private Color color = Color.WHITE;
	private int shapeWidth = 15;
	private int shapeHeight = 15;
	
	
	public Canvas(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public void init() {
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		setSize(dimension);
		setBackground(Color.BLACK);
		requestFocusInWindow();
		setVisible(true);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape shape : shapes) {
			g.setColor(shape.getColor());
			g.fillOval(shape.getLocation().x, shape.getLocation().y, shape.getWidth(), shape.getHeight());
			System.err.println(shape.toString());
		}
	}

	
	@Override
	public void repaint() {
		super.repaint();
	}
	
	public void deleteShape(Point location) {
		Rectangle rectangle = new Rectangle((int) location.getX(),(int) location.getY(), 20, 20);
		System.err.println(rectangle.toString());
		for(Shape shape : shapes) {
			if(rectangle.contains(new Rectangle((int) shape.getLocation().getX(), (int) shape.getLocation().getY(), 20, 20))) {
				System.err.println("contains");
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
			System.err.println("asfasdfasd");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_F) {
			this.setColor();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			incrementShapeSize();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			decrementShapeSize();
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			shapes.removeAll(shapes);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			FileUtil.saveAsFile(shapes);
		}
		if(e.getKeyCode() == KeyEvent.VK_C) {
			shapes = FileUtil.importFile();
			repaint();
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
			shapes.add(new Shape(e.getPoint(), color, shapeWidth, shapeHeight));
			repaint();
			System.err.println(e.getPoint());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	
	public void setColor() {
		JOptionPane optionPane = new JOptionPane();
		optionPane.setSize(300,300);
		optionPane.setVisible(true);
		String input = optionPane.showInputDialog("RGB");
		String[] rgb = input.split(",");
		color = new Color(Integer.valueOf(rgb[0]),Integer.valueOf(rgb[1]), Integer.valueOf(rgb[2]));
	}
	
	
	public void incrementShapeSize() {
		shapeWidth++;
		shapeHeight++;
	}
	
	public void decrementShapeSize() {
		shapeWidth--;
		shapeHeight--;
	}
	
}
