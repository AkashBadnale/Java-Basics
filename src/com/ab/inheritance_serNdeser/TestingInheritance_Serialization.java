package com.ab.inheritance_serNdeser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestingInheritance_Serialization {

	   public static void main(String[] args) throws IOException, Exception {
		   
		     Child_InheritanceConcept   cic  =  new  Child_InheritanceConcept(10,20);
		
		     File file = new File ("inheritance.txt");
		     FileOutputStream   fos   =  new FileOutputStream(file);
		     ObjectOutputStream    oos  = new   ObjectOutputStream(fos);
		    oos.writeObject(cic);
	
	}//main
}//TestingInheritance
