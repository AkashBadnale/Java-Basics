package com.ab.threading;

import java.util.concurrent.Callable;

public class Multithreading_Ways {

	public static void main(String[] args) throws Exception {
		
		A   a  = new A();
		      a.start();
		      a.run1();
		     // a.run();  --  you can write these without any problem cause these call run () of Thread class
		    
		B  b = new B();
		     Thread   t  =  new Thread (b);
		     t.start();
		     t.run();
		
		C  c = new C();
		      String returning = c.call();
		      System.out.println(returning);
		
		
	}//main
}//Multithreading_Ways

class   A   extends Thread{
	
	public void run1() {
		System.out.println("run () of A");
	}
}//A

class   B  implements Runnable {

	@Override
	public void run() {
	     System.out.println(" run () of B");	
	} 
}//B

class   C  implements Callable {

	@Override
	public String call() throws Exception {
		   return "Call method of C ";
	}
	
}//C