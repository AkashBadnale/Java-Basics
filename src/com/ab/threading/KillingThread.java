package com.ab.threading;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/* 
 *  These  is same class  as  ProducerConsumer  but only differnt thing we are doing here is 
 *  killing a thread execution by passing  false to the infinite loop 
 *  
 *  we are  adding two extra varibles  in both classes --  boolean flag;  int count ;
 * 
 *  */
public class KillingThread {
	
	public static void main(String[] args) {
		
		ArrayList<Integer>  nums  = new ArrayList<>();
		
		 int size = 10;
		  Producer1 p1 = new Producer1( nums, size,"P1" );
		  Producer1 p2 = new Producer1(nums, size, "P2");
		  Consumer1  c1  =  new Consumer1(nums,size,"C1");
		  
		  p1.start();	  
		 p2.start();
		 c1.start();
		
	}//main

}//KillingThread

class  Producer1  extends  Thread {
	 ArrayList<Integer> numbers  = null;
	 int maxSize = 0;
    boolean flag = true;
    int count = 0;
    
	 public Producer1(ArrayList<Integer> num, int max_Size , String threadName) {
		super(threadName);
		this.numbers = num;
		this.maxSize = max_Size;
	}
	 
	 public void run() {
		     while(flag) {
		    	    synchronized(numbers) {
                              		 
		    	    	      System.out.println(" producing  ----"+Thread.currentThread().getName());
		    	    	      
		    	    	      if(maxSize == numbers.size()) {
		    	    	    	      System.out.println(" List is full now ");
		    	    	    	      try {
										numbers.wait();
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
		    	    	    	      
		    	    	      }else {
		    	    	    	  
		    	    	    	    try {
										TimeUnit.SECONDS.sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
		    	    	    	    
                   /*  Below line of code   is used to generate  random numbers between    starting number ,  ending number */		    	    	    	    
		    	    	    	    int randomNumber = ThreadLocalRandom.current().nextInt(89,99);
		    	    	    	    numbers.add(randomNumber);
		    	    	    	    System.out.println("produced element --"+randomNumber);
		    	    	    	     numbers.notify();
		    	    	    	     
		    	    	    	     count++;
		    	    	    	     if (count == 7) {
		    	    	    	    	flag = Kill.killThread();
		    	    	    	     }
		    	    	    	     
		    	    	    	
		    	    	      }//ifElse
		    	    	      
		    	    }//synchronized
		    	 
		     }//while(true)
	 }//run() Producer
	 
	 
}//Producer

class  Consumer1  extends  Thread {
	 ArrayList<Integer> numbers  = null;
	 int maxSize = 0;
    boolean flag = true;
	 public Consumer1(ArrayList<Integer> num, int max_Size , String threadName) {
		super(threadName);
		this.numbers = num;
		this.maxSize = max_Size;
	}
	 
	 public void run() {
		     while(flag) {
		    	    synchronized(numbers) {
                             	System.out.println(" consuming  ---- "+Thread.currentThread().getName()+" elemets in list are --"+numbers);
                             	
                             	if(numbers.isEmpty()) {
                             		System.out.println(" list is empty now");
                             		try {
										numbers.wait();
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
                             	}else {
                             		try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
                             		
                             		int  removedNumber = numbers.remove(0);
                             		System.out.println(" consuming element --"+removedNumber);
                             		numbers.notify();
                             }
                             	
		    	    }//synchronized
		    	 
		     }//while(true)
	 }//run() Consumer
	 	 
}//Consumer

class Kill {
	
	public static boolean killThread () {
		 System.out.println(" we are completing the execution of  -- "+Thread.currentThread().getName());
         return false;	
	}
	
}//kill