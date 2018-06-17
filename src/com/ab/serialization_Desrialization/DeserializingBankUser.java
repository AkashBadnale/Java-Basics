package com.ab.serialization_Desrialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializingBankUser {
  
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileInputStream   fis  =  new   FileInputStream("user_1.txt");
		ObjectInputStream   ois = new   ObjectInputStream(fis);
		
		BankUser user  =  (BankUser) ois.readObject();
		System.out.println(user);
		
	}//main
}//DeserializingBankUser
