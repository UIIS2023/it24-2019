package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import commandx.Command;
import commandx.CommandTextType;

public class FileTools {
	
	

	static public void save(ArrayList<Shape> shapes) {
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showSaveDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			
			
			try {
				FileOutputStream fs = new FileOutputStream(
						fileChooser.getSelectedFile().getAbsolutePath());
				ObjectOutputStream out = new ObjectOutputStream(fs);
				for(Shape shape : shapes) {
					out.writeObject(shape);
				}
				out.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	static public void load(ArrayList<Shape> shapes) throws Exception{
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showOpenDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			
			
			FileInputStream fs = new FileInputStream(
					fileChooser.getSelectedFile().getAbsolutePath());
			ObjectInputStream in = new ObjectInputStream(fs); //wrap
			shapes.clear();
			Shape shape;
			try {
				while(true) {
					shape = (Shape)in.readObject();
					if(shape == null) break;
					shapes.add(shape);
					
				}
			}
			catch(EOFException e) {
				in.close();
			}
				
			
		}
	}
	
	public static void saveLogo(LinkedList<String> commands) {
		
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showSaveDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			
			
			try {
				FileWriter writer = new FileWriter(
						fileChooser.getSelectedFile().getAbsolutePath());
				
			
				boolean first = true;
				for(String string : commands) {
					
					if(first) {
						writer.write(string);
						first = false;
					}
					else {
						writer.write("\n" + string);
					}
					
				}
				
				
				writer.close();
				
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		
	}
	
	

}
