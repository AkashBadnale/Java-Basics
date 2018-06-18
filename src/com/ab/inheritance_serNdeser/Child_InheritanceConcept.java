package com.ab.inheritance_serNdeser;

import java.io.Serializable;

public class Child_InheritanceConcept extends Parent_InheritanceConcept implements Serializable{
	
	int j;

	public Child_InheritanceConcept() {
		super();
	 System.out.println(" child class constructor");
	}



	public Child_InheritanceConcept(int i,int j) {
		super(i);	
		this.j = j;
	}



	@Override
	public String toString() {
		return "Child_InheritanceConcept [j=" + j +" i= "  +i +"]";
	}

}//Child_InheritanceConcept
