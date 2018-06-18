package com.ab.inheritance_serNdeser;

public class Parent_InheritanceConcept {
	
	int i;
	

	public Parent_InheritanceConcept() {
		super();
		System.out.println(" parent constructor");
		 
	}

	

	public Parent_InheritanceConcept(int i) {
		super();
		this.i = i;
	}



	@Override
	public String toString() {
		return "Parent_InheritanceConcept [i=" + i + "]";
	}
	
	
}//parent
