package com.ab.immutableClasses;

public final  class Bike {

	private final String  name;
	private final int price;
	private final Specification specifications;
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Specification getSpecifications() {
		return specifications;
	}

	//  parameterized constructor 
	

	private  Bike(String name, int price, Specification specifications) {
		super();
		this.name = name;
		this.price = price;
		this.specifications = specifications;
	}

	// toString ()  method 
	@Override
	public String toString() {
		return "Bike [name=" + name + ", price=" + price + ", specifications=" + specifications + "]";
	}
	
	// method to access the constructor to create a new instance 
	public static Bike newBike (String name, int price , Specification specification ) {
		    return new Bike (name , price , specification);
	}//newBike

	
	
	
}//Bike 
