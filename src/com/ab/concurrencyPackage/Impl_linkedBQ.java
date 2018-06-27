package com.ab.concurrencyPackage;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Impl_linkedBQ {

	public static void main(String[] args) {
		
	//  LinkedBlockingQueue  -  bounded + unbounded
		BlockingQueue<Integer>  bqueue  =  new LinkedBlockingQueue<>(7);  
		
		Producer_LBQ   p1 = new Producer_LBQ(bqueue, "Thread - P1");
		Consumer_LBQ  c1 = new  Consumer_LBQ(bqueue, "Thread - C1");
		
		p1.start();
		c1.start();
		
	}//main
}//Impl_linkedBQ

class Producer_LBQ extends Thread {
	  
	private BlockingQueue<Integer>  bk = null;

	public Producer_LBQ(BlockingQueue<Integer> bk , String name) {
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

class Consumer_LBQ  extends Thread {
	
	private BlockingQueue<Integer>  bk = null;

	public Consumer_LBQ(BlockingQueue<Integer> bk , String name) {
		super(name);
		this.bk = bk;
	}
	
	public  void run() {
		while(true) {
			System.out.println("current thread  ="+Thread.currentThread().getName()+"  queued items"+bk);
			
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

