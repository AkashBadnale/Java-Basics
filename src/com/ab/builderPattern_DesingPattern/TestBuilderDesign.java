package com.ab.builderPattern_DesingPattern;

//import com.ab.builderPattern_DesingPattern.Job.JobInnerClass;

public class TestBuilderDesign {
  
	public static void main(String[] args) {
		Job person = new Job.JobInnerClass("very Good", "Polite").setExtraTallented("No").setWellSettledFamily("No").setRich("No").build();
		System.out.println(" x person is -- "+person);
	}//main
}//TestBuilderDesign
