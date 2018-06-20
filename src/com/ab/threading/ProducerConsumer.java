
package com.ab.threading;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
   
	 public static void main(String[] args) throws InterruptedException {
	       
		 ArrayList<Integer>  nums  = new ArrayList<>();
		 
		 
		 /*int size = 1;
		  *       if you uncomment these and comment below 
		  *       you can see the scenario of consuming , producing alternatively
		  * */
		 
		   int size = 10;
		  Producer p1 = new Producer( nums, size,"P1" );
		  Producer p2 = new Producer(nums, size, "P2");
		  Consumer  c1  =  new Consumer(nums,size,"C1");
		  
		  p1.start();	  
		 p2.start();
		 c1.start();
		
		    
	}//main
}//ProducerConsumer


/*creating  class Producer  which will   create product to consume for the consumer 
 *     if (list size full)
 *          wait 
 *     else 
 *          add
 *          notify waiting objects 
 **/
 
class  Producer  extends  Thread {
	 ArrayList<Integer> numbers  = null;
	 int maxSize = 0;

	 public Producer(ArrayList<Integer> num, int max_Size , String threadName) {
		super(threadName);
		this.numbers = num;
		this.maxSize = max_Size;
	}
	 
	 public void run() {
		     while(true) {
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
		    	    	      }//ifElse
		    	    	      
		    	    }//synchronized
		    	 
		     }//while(true)
	 }//run() Producer
	 
	 
}//Producer


/*  Consumer class is consuming the product created by the producer
 *   if (list  is empty)
 *      wait
 *   else 
 *     consume - remove
 *     notify
 * */
 

class  Consumer  extends  Thread {
	 ArrayList<Integer> numbers  = null;
	 int maxSize = 0;

	 public Consumer(ArrayList<Integer> num, int max_Size , String threadName) {
		super(threadName);
		this.numbers = num;
		this.maxSize = max_Size;
	}
	 
	 public void run() {
		     while(true) {
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
