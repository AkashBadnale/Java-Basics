package com.ab.factoryPattern_DesignPatterns;

public abstract class ElectricityPlan {

	protected double rate;
	
	abstract double getRate();
	
	public double calculateBill (int units , double rate) {
		return (units*rate);
	}//calculateBill
	
}//ElectricityPlan
