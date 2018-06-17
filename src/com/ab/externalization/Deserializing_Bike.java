package com.ab.externalization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializing_Bike {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File  file  = new File("bike.txt");
		FileInputStream  fis  = new FileInputStream(file);
		ObjectInputStream  ois = new ObjectInputStream(fis);
		
		String name = (String) ois.readObject();
		int manufacturingYear = (int) ois.readInt();
		
		System.out.println("my bike is "+name +" manufactured in "+manufacturingYear+" obviously i dont have to tell you that its a sport bike");
	}//main
}//Deserializing_Bike
