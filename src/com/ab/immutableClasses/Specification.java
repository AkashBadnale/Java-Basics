package com.ab.immutableClasses;

public  class Specification {
 
	private int engine;
	private int milage;
	private int maxSpeed;
	
	// only getters 
	public int getEngine() {
		return engine;
	}
	
	public int getMilage() {
		return milage;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}


	
	//  parameterized constructor 
	public Specification(int engine, int milage, int maxSpeed) {
		super();
		this.engine = engine;
		this.milage = milage;
		this.maxSpeed = maxSpeed;
	}

	// toString () method
	@Override
	public String toString() {
		return "Specification [engine=" + engine + ", milage=" + milage + ", maxSpeed=" + maxSpeed + "]";
	}
	
	
	
	
	
}//specification
