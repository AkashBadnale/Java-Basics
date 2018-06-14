package com.ab.factoryPattern_DesignPatterns;

import java.util.Scanner;

public class TestingFactoryPattern {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		double bill, domesticRate, institutesRate , industrialRate;
		
		System.out.println(" How many unit's of electricity have you used ");
		int  noOfUnits = input.nextInt();
		
		System.out.println(" Enter what type of plan you want to choose ");
		System.out.println("1.Domestic");
		System.out.println("2.Institutional");
		System.out.println("3.Industrial");
		
		int choosenOption = input.nextInt();
		
		switch(choosenOption) {
		
		case 1 : ElectricityPlan planObject1 = ElectricityPlanFactory.getPlanType("domestic");
		         domesticRate = planObject1.getRate();
		         bill =  planObject1.calculateBill(noOfUnits , domesticRate);
		         System.out.println("your total bill is "+bill+" Rs");
		         break;
		         
		case 2 : ElectricityPlan planObject2 = ElectricityPlanFactory.getPlanType("institute");
		         institutesRate = planObject2.getRate();
                 bill =  planObject2.calculateBill(noOfUnits , institutesRate);
                 System.out.println("your total bill is "+bill+" Rs");
                 break;
        
		case 3 : ElectricityPlan planObject3 = ElectricityPlanFactory.getPlanType("industrial");
		         industrialRate = planObject3.getRate();
                 bill =  planObject3.calculateBill(noOfUnits , industrialRate);
                 System.out.println("your total bill is "+bill+" Rs");
                 break;
                 
        default : System.out.println(" choose one of the option only ");
		
		}//switch
		
	}//main
}//TestingFactoryPattern
