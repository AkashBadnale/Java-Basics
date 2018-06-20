package com.ab.threading;

public class YieldExample {
     public static void main(String[] args) {
		
    	 ThreadOne p = new ThreadOne();
    	 ThreadTwo c = new ThreadTwo();
    	 
    	 p.start();
    	 c.start();
	}//main
}//YieldExample

class  ThreadOne  extends  Thread {
	
	public void run() {
		 for (int i = 0 ; i<=5 ; i++) {
			 System.out.println(" producing --"+i);
			 Thread.yield();
		 }
	}//run
}//Thread

class ThreadTwo  extends Thread {
	
	public void run() {
		for(int i = 0; i <= 5; i++) {
			System.out.println(" consuming --"+i);
			Thread.yield();
		}
	}
}//Consumer