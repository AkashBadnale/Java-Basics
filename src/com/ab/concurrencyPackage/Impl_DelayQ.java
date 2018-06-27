package com.ab.concurrencyPackage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Impl_DelayQ {
	
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Bike>   dbq   = new DelayQueue<>();
		
		Bike b1 = new Bike(80000, "Pulsar 150", 5000);
		Bike b2 = new Bike (94000, "FZ-16",6000);
		//  produced bikes & added it to the queue 
	    dbq.put(b1);
	    System.out.println(" Produced -- "+b1);
	    dbq.put(b2);
	    System.out.println(" Produced -- "+b2);
	    TimeUnit.SECONDS.sleep(3);
	    
	    //consuming
	    while(true) {
	    	Bike  bike  = dbq.take();
	    	System.out.println("Consuming  Bike -- name ="+bike.name+"   price ="+bike.price);
	    }//while(True)
	    
	}//main

}//Impl_Delay_Q

class  Bike implements Delayed {

	public int price;
	public String name;
	public long startTime;
	
	public Bike(int price, String name, long delay) {
		super();
		this.price = price;
		this.name = name;
		this.startTime = System.currentTimeMillis() + delay;
	}

	@Override
	public int compareTo(Delayed o) {
	    if(this.startTime  < ( ((Bike)o).startTime) ){
	    	return -1;
	    }
	    if(this.startTime  > ( ((Bike)o).startTime) ){
	    	return 1;
	    }
	    return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		 long  difference    =  startTime  -  System.currentTimeMillis();
		return     unit.convert(difference, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return "Bike [price=" + price + ", name=" + name + ", startTime=" + startTime + "]";
	}
	
	
	
}
