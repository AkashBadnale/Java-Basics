package com.ab.threading;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
		
    	System.out.println("  main()  started ");
    	
    	 Thread    t1  = new Thread( new  Runnable () {
    		  
    		 public void run() {
    			     System.out.println("  t1  started ");
    			       
    			     try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			     
    			    System.out.println("  t1  completed");
    		   } 
    		 
    	 });
    	 
    	 Thread   t2 =  new Thread (new Runnable () {
    		  public void run() {
    		      System.out.println(" t2  started ");
    		       
    		   /*   try {
					t1.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
    		      
    		      try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		      
    		     System.out.println("  t2  completed ");
    		  }
    		  
    	 });
    	  
     	 t1.start();
     	//t1.join();  //  t1 completes  first then only it will go for second one
     	 t2.start();
     	// t2.join(); // t2 completes then only it goes any remaining task 
    	 System.out.println("  main ()  completed ");
    	 
	}//main
}//JoinExample 
