package com.ab.inheritance_serNdeser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestingInheritance_Deserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream fis =  new FileInputStream("inheritance.txt");
	    ObjectInputStream   ois   =   new ObjectInputStream(fis);
	    
	  Child_InheritanceConcept  c =  (Child_InheritanceConcept)  ois.readObject();
	    
	  System.out.println(c);
	
	}//main
}//TestingInheritance_Deserialization
