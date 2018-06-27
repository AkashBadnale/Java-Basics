package com.ab.concurrencyPackage;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class Impl_TransferQ {

	public static void main(String[] args) {
		
		TransferQueue<Car>  tk = new LinkedTransferQueue<>();
		
		Producer_TK  p1  = new Producer_TK(tk, "Thread - Producer");
		Consumer_TK  c1  = new Consumer_TK(tk, "Thread - Consumer");
		
		p1.start();
		c1.start();
		
	}//main
}//Impl_TransferQ

class Car{
	public int price;
	public String name;
	
	public Car(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [price=" + price + ", name=" + name + "]";
	}
}//Car

class Producer_TK extends Thread {
	
	TransferQueue<Car>  tk ;

	public Producer_TK(TransferQueue<Car> tk  , String threadName) {
		super(threadName);
		this.tk = tk;
	}
	
	public void run() {
		
		Car  c1 = new Car(5, "Swift");
		Car c2  = new Car(8, "EcoSports");
		Car c3  = new Car(14,"Innova");
		Car c4  =  new Car(35 , "Mustang");		
		try {
			System.out.println(" transferring -- "+c1);
			//tk.transfer(c1);       
			   System.out.println(tk.tryTransfer(c1));
			TimeUnit.SECONDS.sleep(1);
			
			System.out.println(" transferring -- "+c2);
			//tk.transfer(c2);
			System.out.println(tk.tryTransfer(c2));
			TimeUnit.SECONDS.sleep(1);
			
			System.out.println(" transferring -- "+c3);
			//tk.transfer(c3);
			System.out.println(tk.tryTransfer(c3));
			TimeUnit.SECONDS.sleep(1);
			
			System.out.println(" transferring -- "+c4);
			//tk.transfer(c4);
			System.out.println(tk.tryTransfer(c4));
			TimeUnit.SECONDS.sleep(1);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}//run()  Producer_TK
}//Producer_TK

class Consumer_TK  extends Thread {
	
	TransferQueue<Car>  tk;

	public Consumer_TK(TransferQueue<Car> tk , String  threadName) {
		super(threadName);
		this.tk = tk;
	}
	
	public  void run() {
		
		while(true) {
			try {
				Car  car =  tk.take();
				System.out.println(" Consuming ---   price = "+car.price+" name =  "+car.name);
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while(true)
	}//run() Consumer_TK
	
	
}