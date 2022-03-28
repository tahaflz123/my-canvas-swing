package com.mycanvas;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import com.mycanvas.shape.Shape;
import com.mycanvas.shape.ShapeType;

public class FileUtil {
	
	public static boolean saveAsFile(List<Shape> shapes) {
		JFileChooser chooser = new JFileChooser();
		chooser.showSaveDialog(null);
		chooser.setDialogTitle("save");
		
		File file = chooser.getSelectedFile();
		
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			for(Shape shape: shapes) {
				String keyword = shape.getLocation().x + "," + shape.getLocation().y + "," + shape.getColor().getRed()
					+ "," + shape.getColor().getGreen() + "," + shape.getColor().getBlue()+ "," + shape.getWidth() + "," + shape.getHeight() + "," + shape.getShapeType().toString() +  "\n";
				fos.write(keyword.getBytes());
			}
			fos.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Shape> importFile(){
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		
		List<Shape> shapes = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(file);
			boolean reading = true;
			while(reading) {
				String s = scanner.next();
				String[] location =  s.split(",");
				Shape shape = new Shape(new Point(Integer.valueOf(location[0]), Integer.valueOf(location[1])),
						new Color(Integer.valueOf(location[2]),Integer.valueOf(location[3]), Integer.valueOf(location[4])),Integer.valueOf(location[5]),Integer.valueOf(location[6])
						,ShapeType.valueOf(location[7]));
				shapes.add(shape);
				reading = scanner.hasNext();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return shapes;
	}
	

}
