package com.ab.factoryPattern_DesignPatterns;

public class ElectricityPlanFactory {

	public static ElectricityPlan getPlanType (String plan) {
		
		if (plan == null) {
			return null;
		}
		
		if (plan.equalsIgnoreCase("Domestic")) {
			return new Domestic();
		}else if (plan.equalsIgnoreCase("institute")) {
			return new Institutes();
		}else if (plan.equalsIgnoreCase("Industrial")) {
			return new Industries();
		}
		
		else {
			return null;
		}
	}//getPlanType
	
}//ElectricityPlanFactory
