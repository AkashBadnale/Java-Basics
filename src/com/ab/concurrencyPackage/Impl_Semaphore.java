package com.ab.concurrencyPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Impl_Semaphore {

	public static void main(String[] args) {
		
		Semaphore    semaphore  =  new Semaphore(2);
		List<String>  list  = new ArrayList<>();
		
		Worker worker1  =  new Worker(semaphore, "WORKER-1",list);
		Worker worker2  =  new Worker(semaphore, "WORKER-2",list);
		Worker worker3  =  new Worker(semaphore, "WORKER-3",list);
		Worker worker4  =  new Worker(semaphore, "WORKER-4",list);
		Worker worker5  =  new Worker(semaphore, "WORKER-5",list);
		Worker worker6  =  new Worker(semaphore, "WORKER-6",list);
		
		worker1.start();
		worker2.start();
		worker3.start();
		worker4.start();
		worker5.start();
		worker6.start();
		
	}//main
}//Impl_Semaphore

class  Worker  extends Thread{
	
	Semaphore sem = null;
	String threadName = null;
	List<String> l = null;
	
	public Worker(Semaphore sem, String threadName, List <String> l) {
		super(threadName);
		this.sem = sem;
		this.l = l;
	}

	public void run() {
	      	
	      try {
	    	  System.out.println("  current thread is ---"+Thread.currentThread().getName());
	    	  sem.acquire();
	    	  System.out.println(" -----   lock aquired   by -----"+Thread.currentThread().getName());
	    	 
	    	  for(int i = 0 ; i<=5;i++) {
	    		    l.add("String -"+i);
	    	  }//for
	    	  System.out.println(l);
	    	  
	    	  Thread.sleep(5000);
	    	  sem.release();
	    	  System.out.println(" -----   lock relesed   by -----"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}//run
	
/*	@Override
	public String toString() {
		return "Work [sem=" + sem + ", threadName=" + threadName + "]";
	}*/
	
	
}//Work