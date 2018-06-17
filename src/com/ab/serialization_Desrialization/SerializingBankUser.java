package com.ab.serialization_Desrialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SerializingBankUser {
   
	public static void main(String[] args) throws IOException {
		
		 BankUser   user_1 = new BankUser("Akash",1384665486,456852155,1234);
		
		 File   file = new File ("user_1.txt");
		 FileOutputStream   fos  = new FileOutputStream(file);
		 ObjectOutputStream   oos  =  new ObjectOutputStream(fos);
		 
		 oos.writeObject(user_1);
		 oos.close();
		 
	}//main
	
}//SerializingBankUser
