package com.ab.threading;

public class ThreadSynchronization {
   
	public static void main(String[] args) {
             
		 SharedClass   sc  = new SharedClass();
		
		Thread  t1 = new Thread (" Thread - 1") {
			   @Override
			   public void run() {
			            sc.sharedMethod();	   
			   }
		};
		
		Thread   t2  = new Thread(" Thread - 2") {
			@Override
			public void run() {
				sc.sharedMethod();
			}
		};
		
		t1.start();
		t2.start();
		
	}//main
}//ThreadSynchronization

class SharedClass {
	
 public    synchronized  void sharedMethod() {
		
	  Thread   t  =  Thread.currentThread();
	  
	  for (int i = 1 ; i <=10 ; i++) {
		  System.out.println(" current thread --"+t.getName()+" -- i = "+i);
	  }
	}//sharedMethod()
}//SharedClass