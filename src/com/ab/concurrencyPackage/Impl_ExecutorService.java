package com.ab.concurrencyPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Impl_ExecutorService {

	public static void main(String[] args) {
		 
	    //ExecutorService  executorService  =  Executors.newCachedThreadPool(); 
		// ExecutorService  executorService  =  Executors.newFixedThreadPool(2);
		//ExecutorService  executorService  =  Executors.newSingleThreadExecutor();
		//ExecutorService  executorService  =  Executors.newScheduledThreadPool(3);
		ExecutorService  executorService  =  Executors.newSingleThreadScheduledExecutor();
		
		MyThread   t1 = new MyThread("Thread - T1");
		MyThread   t2 = new MyThread("Thread - T2");
		MyThread   t3 = new MyThread("Thread - T3");
		MyThread   t4 = new MyThread("Thread - T4");
		MyThread   t5 = new MyThread("Thread - T5");
		
	    executorService.execute(t1);
		executorService.execute(t2);
		executorService.execute(t3);
		executorService.execute(t4);
		executorService.execute(t5);
	    
		executorService.shutdown();
	}//main
}//Impl_ExecutorService


class  MyThread  extends  Thread {
	
	String threadName = null;

	public MyThread(String threadName) {
		super(threadName);
		
	}
	
	public void run() {
		System.out.println(" current  Thread  --- "+Thread.currentThread().getName());
		
		for (int i = 0 ; i <= 5 ;  i++) {
			  System.out.println(" i = "+i);
			  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
	}//run()
}//Thread 