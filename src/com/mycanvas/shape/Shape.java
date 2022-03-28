package com.mycanvas.shape;

import java.awt.Color;
import java.awt.Point;

public class Shape {
	
	private Point location;

	private Color color;
	
	private int width = 5;
	
	private int height = 5;
	
	private ShapeType shapeType;
	

	public Shape(Point location, Color color, int width, int height, ShapeType shapeType) {
		this.location = location;
		this.color = color;
		this.width = width;
		this.height = height;
		this.shapeType = shapeType;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}
	
	public ShapeType getShapeType() {
		return shapeType;
	}
	
}
