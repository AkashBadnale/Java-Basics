package com.ab.cloningConcept;

public class TestingCloning {

	public static void main(String[] args) throws  CloneNotSupportedException {
	
		Address oldStudentsAddress = new Address (42,"bakers street","new Jersey");
		Student oldStudent = new Student (1,"AB",oldStudentsAddress);
		
		System.out.println(oldStudent);
		
		Student newStudent =  oldStudent.clone();
		System.out.println(newStudent);
		
		newStudent.getAddress().setHouseNo(43);
		
		System.out.println("--- After changing address of newStudent only ---");
		System.out.println(newStudent);
		System.out.println(oldStudent);
		
	}//main
}//TestingCloning
