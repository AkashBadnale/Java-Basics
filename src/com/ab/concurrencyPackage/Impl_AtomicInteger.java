package com.ab.concurrencyPackage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class Impl_AtomicInteger {

	public static void main(String[] args) {      Mytest m = new Mytest();
          
	         AtomicInteger  atomicInteger  =  new AtomicInteger(0); // 0 is initial value  , we can specify any thing we want 
	         
	         System.out.println(atomicInteger.get()); // retuns 0
	         System.out.println(atomicInteger.incrementAndGet()); // increment by 1 
	          
	         System.out.println(atomicInteger.compareAndSet(1, 20));
	     //  compare 1 with previous value if true update the value to 20 else return false
	         
	         System.out.println(atomicInteger.get()); // retunrs 20
	         System.out.println(atomicInteger.floatValue()); // returns the float value of 20
	         
	         System.out.println(atomicInteger.compareAndSet(15, 45));
	     //  compare 15 with previous value if true update the value to 45 else return false
	        System.out.println(atomicInteger.getAndUpdate(m));
	}// main
	
}// AtomicInteger

class  Mytest implements IntUnaryOperator{

	@Override
	public int applyAsInt(int operand) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}