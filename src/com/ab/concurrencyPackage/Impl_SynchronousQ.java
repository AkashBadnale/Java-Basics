package com.ab.concurrencyPackage;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Impl_SynchronousQ {

	public static void main(String[] args) {
		
	BlockingQueue<Integer>  bqueue  =  new  SynchronousQueue<>();
	
	Producer_SBQ   p1 = new Producer_SBQ(bqueue, "Thread - P1");
	Consumer_SBQ  c1 = new  Consumer_SBQ(bqueue, "Thread - C1");
	
	p1.start();
	c1.start();
	
}//main
}//Impl_SynchronousBQ

class Producer_SBQ extends Thread {
	  
	private BlockingQueue<Integer>  bk = null;

	public Producer_SBQ(BlockingQueue<Integer> bk , String name) {
		super(name);
		this.bk = bk;
	}
	
	public void run() {
		    while(true) {
		    	System.out.println(" current thread --"+Thread.currentThread().getName());		    	
		    	
		    	  int random  =  ThreadLocalRandom.current().nextInt(90,100);
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

class Consumer_SBQ  extends Thread {
	
	private BlockingQueue<Integer>  bk = null;

	public Consumer_SBQ(BlockingQueue<Integer> bk , String name) {
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
