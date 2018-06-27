package com.ab.concurrencyPackage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Impl_ArrayBQ {
	
	public static void main(String[] args) {
		
		BlockingQueue<Integer>  bqueue  =  new ArrayBlockingQueue<>(10);
		
		Producer_ABQ   p1 = new Producer_ABQ(bqueue, "Thread - P1");
		Consumer_ABQ  c1 = new  Consumer_ABQ(bqueue, "Thread - C1");
		
		p1.start();
		c1.start();
		
	}//main

}//Impl_ArrayBQ ( ArrayBlockingQueue ) = ABQ

class Producer_ABQ extends Thread {
	  
	private BlockingQueue<Integer>  bk = null;

	public Producer_ABQ(BlockingQueue<Integer> bk , String name) {
		super(name);
		this.bk = bk;
	}
	
	public void run() {
		    while(true) {
		    	System.out.println(" current thread --"+Thread.currentThread().getName());		    	
		    	
		    	  int random  =  ThreadLocalRandom.current().nextInt(5,15);
		    	 System.out.println(" produced item = "+random);
		    	  try {
				      bk.put(random);
				      TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	  
		    	  
		    }//while(true)
	}//run()  Producer 
}//Producer

class Consumer_ABQ  extends Thread {
	
	private BlockingQueue<Integer>  bk = null;

	public Consumer_ABQ(BlockingQueue<Integer> bk , String name) {
		super(name);
		this.bk = bk;
	}
	
	public  void run() {
		while(true) {
			System.out.println("current thread = "+Thread.currentThread().getName()+"  queued items"+bk);
			
			try {
				int number = bk.take();
				System.out.println(" consuming item = "+number);
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}//while(true)
	}//run() consumer 
	
}//Consumer
