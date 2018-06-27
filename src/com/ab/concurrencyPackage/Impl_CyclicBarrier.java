package com.ab.concurrencyPackage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Impl_CyclicBarrier {
	
	public static void main(String[] args) throws InterruptedException {
		
		CyclicBarrier  cyclicBarrier  = new CyclicBarrier(4);
		
		Employee  s1 = new Employee(1, "A", cyclicBarrier);
		Employee  s2 = new Employee(2, "B", cyclicBarrier);
		Employee  s3 = new Employee(3, "C", cyclicBarrier);
		Employee  s4 = new Employee(4, "D", cyclicBarrier);
		
		Thread.sleep(2000);
		s1.start();
		Thread.sleep(2000);
		s2.start();
		Thread.sleep(2000);
		s3.start();
		Thread.sleep(2000);
		s4.start();
		
		System.out.println(Thread.currentThread().getName()+" has finished");
	}//main

}//Impl_CyclicBarrier

class  Employee extends Thread {
	public  int id;
	public String name;
	private CyclicBarrier cyclicBarrier;
	
	public Employee(int id, String name , CyclicBarrier cyclicBarrier) {
		super();
		this.id = id;
		this.name = name;
		this.cyclicBarrier = cyclicBarrier;
	}
	
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()+" is calling await");
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName()+" is started running again");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}//run()

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cyclicBarrier=" + cyclicBarrier + "]";
	}
	
	
}//Student
