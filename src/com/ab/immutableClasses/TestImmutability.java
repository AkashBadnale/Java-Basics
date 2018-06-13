package com.ab.immutableClasses;

public class TestImmutability {

	public static void main(String[] args) {
		
		Specification spec = new Specification ( 153 , 50 , 107);
		Bike myBike = Bike.newBike( "FZ" , 96000 , spec );
		System.out.println(myBike);
		
	}//main
	
	
}//TestImmutability
