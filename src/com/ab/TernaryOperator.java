package com.gslab.ab;

public class TernaryOperator {
   public static void main(String[] args) {
	   String test1 = "test";
	   String test2 = null;
	   String propertiesFile = "url";
	   
	   String output1 = test2!=null ? test2 : propertiesFile ;
	   System.out.println(output1); // url
	   
	   String output2 = test1!=null ? test1 : propertiesFile ;
	   System.out.println(output2); // test
   }
}
