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
import javax.swing.SwingUtilities;

import com.mycanvas.shape.Shape;
import com.mycanvas.shape.ShapeType;

public class Canvas extends JPanel implements MouseMotionListener, KeyListener {

	
	
	
	public List<Shape> shapes = new ArrayList<>();
	private Dimension dimension;
	private Color color = new Color(255,255,255);
	private int shapeWidth = 15;
	private int shapeHeight = 15;
	private ShapeType shapeType = ShapeType.CIRCLE;
	
	
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
			if(shape.getShapeType() == ShapeType.CIRCLE) {
				g.fillOval(shape.getLocation().x, shape.getLocation().y, shape.getWidth(), shape.getHeight());
			}else if(shape.getShapeType() == ShapeType.RECT) {
				g.fillRect(shape.getLocation().x, shape.getLocation().y, shape.getWidth(), shape.getHeight());
			}
			System.err.println(shape.toString());
		}
	}

	
	@Override
	public void repaint() {
		super.repaint();
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
		if(e.getKeyCode() == KeyEvent.VK_R) {
			if(shapeType.equals(ShapeType.CIRCLE)) {
				shapeType = ShapeType.RECT;
			}else{
				shapeType = ShapeType.CIRCLE;
			}
			System.err.println(shapeType);
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
		
		if(SwingUtilities.isLeftMouseButton(e)) {
			shapes.add(new Shape(e.getPoint(), color, shapeWidth, shapeHeight, shapeType));
			mouseMoved(e);
			repaint();
			System.err.println(e.getPoint());
		}if(SwingUtilities.isRightMouseButton(e)) {
			shapes.add(new Shape(e.getPoint(), new Color(0,0,0), shapeWidth, shapeHeight, shapeType));
			repaint();
		}
		System.err.println(e.getButton());
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
