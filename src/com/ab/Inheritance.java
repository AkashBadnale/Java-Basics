package com.gslab.ab;

public class Inheritance {
	
	public static void main(String[] args) {
		
		//GrandChild gc = new GrandChild();  // result is -- Parent /n child /n GrandChild
		//Child c = new Child();  // result is -- parent  /n  child
		//Parent p = new Parent();  // result is -- parent
	}
}

class Parent{
	static {
		System.out.println("parent");
	}
}
class Child extends Parent{
	static {
		System.out.println("child");
	}
}

class GrandChild extends Child{
	static {
		System.out.println("GrandChild");
	}
}
