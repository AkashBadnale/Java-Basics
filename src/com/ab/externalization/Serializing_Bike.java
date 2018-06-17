package com.ab.externalization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializing_Bike {
 
	public static void main(String[] args) throws IOException {
	
		Bike myBike = new Bike("FZ16",2008,"Sports");
		
		File  file  =  new File("bike.txt");
		FileOutputStream  fos  =  new FileOutputStream(file);
		ObjectOutputStream  oos  = new ObjectOutputStream(fos);
		
		oos.writeObject(myBike.getName());
		oos.writeInt(myBike.getManufacturingYear());
		
		oos.close();
		
			}//main
}//Serializing_Bike
