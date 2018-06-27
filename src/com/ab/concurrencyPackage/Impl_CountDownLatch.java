package com.ab.concurrencyPackage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Impl_CountDownLatch {
	
	public static void main(String[] args) throws InterruptedException {
		  
		final  CountDownLatch  latch = new CountDownLatch(2);
		
		FirstTask  ft  = new FirstTask(2, 4, latch);
		SecondTask   st  = new  SecondTask(8, 4, latch);
		
		//Thread.sleep(2000);
		ft.start();
		//Thread.sleep(2000);
		st.start();
		
		latch.await();
		Thread.sleep(5000);
		int  finalResult = ft.addition  * st.substraction;
		System.out.println("  final main task is "+finalResult);
		System.out.println("  All tasks have been completed ");
	}//main

}//Impl_CountDownLatch

class  FirstTask  extends  Thread {
	
	private   int var_one;
	private   int var_two;
	private final CountDownLatch latch;
	public int addition;
	
	public FirstTask(int var_one, int var_two, CountDownLatch latch) {
		super();
		this.var_one = var_one;
		this.var_two = var_two;
		this.latch = latch;
	}
	
   public void run() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		addition  =  var_one + var_two;
		System.out.println(" addition is "+addition);
		System.out.println(" First Task is completed ");
	
		latch.countDown();
	}
}//FirstTask

class  SecondTask  extends  Thread {
	
	private int  var_three;
	private int   var_four;
	private final CountDownLatch latch;
	public int substraction;
	
	public SecondTask(int var_three, int var_four, CountDownLatch latch) {
		super();
		this.var_three = var_three;
		this.var_four = var_four;
		this.latch = latch;
	}
	
	public void run() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        substraction = var_three - var_four;
		System.out.println(" substraction is "+substraction);
		System.out.println(" Second Task is completed ");
		
		latch.countDown();
	}
}//SecondTask
