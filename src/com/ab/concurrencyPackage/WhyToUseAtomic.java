package com.ab.concurrencyPackage;

public class WhyToUseAtomic {

	public static void main(String[] args) {
		
		Sum  s1 = new Sum();
		
		Thread   t1  = new Thread(s1);
		Thread  t2  =  new  Thread(s1);
		
		t1.start();
		t2.start();
		
	}//main
}//WhyToUseAtomic

class Sum implements Runnable {
	
	static int sum = 0;
	
	public void run() {
		
		System.out.println(" inside run");
		
		for (int i = 0 ; sum < 10 ; i++) {
		    sum = sum + i ;
			System.out.println(sum);
		//	System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}//run()
}//Sum