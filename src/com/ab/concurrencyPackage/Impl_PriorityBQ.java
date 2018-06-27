package com.ab.concurrencyPackage;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Impl_PriorityBQ {
 
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Student>  pbqueue   =  new  PriorityBlockingQueue<>(3, new IdComparator());
		Producer_PBQ  p1 = new Producer_PBQ(pbqueue, "Thread - Producer");
		Consumer_PBQ  c1 = new Consumer_PBQ(pbqueue, "Thread - Consumer");
		
		p1.start();
		//p1.join();  or below statement will work properly 
		TimeUnit.SECONDS.sleep(10);
		c1.start();
		
	}//main
}//Impl_PriorityBQ



class Producer_PBQ  extends Thread {
    BlockingQueue<Student> bk;

	public Producer_PBQ(BlockingQueue<Student> bk , String threadName ) {
		super(threadName);
		this.bk = bk;
	}
	
	public void run() {
	
		Student st1 = new Student(1,"A");
		Student st2 = new Student(2,"B");
		Student st3 = new Student(3,"C");
		 System.out.println(" student 1 "+st1+"\n student 2"+st2+"\n student 3"+st3);
		 
		 try {
			bk.put(st3);
			TimeUnit.SECONDS.sleep(1);
			bk.put(st1);
			TimeUnit.SECONDS.sleep(1);
			bk.put(st2);
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
}//run() Producer_PBQ
    
    
}//Producer_PBQ

class Consumer_PBQ  extends Thread {
    BlockingQueue<Student>   bk;

	public Consumer_PBQ(BlockingQueue<Student> bk , String threadName ) {
		super(threadName);
		this.bk = bk;
	}
	
	public void run() {
		while(true) {
		 System.out.println("elements in my queue are - "+bk);
		 
		 try {
			Student  s = bk.take();
			System.out.println(" consuming element - "+s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}//while(true)
	}//run() Consumer_PBQ
    
    
}//Consumer_PBQ


class Student/*  implements   Comparable<Student>*/{                    //you  can use Comparable too  just   use    ---     class  Student  implements   Comparable<Student>
	private int id;
	private String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

 public int getId() {
		return id;
	}

   public void setId(int id) {
		this.id = id;
	}

  public String getName() {
		return name;
	}

  public void setName(String name) {
		this.name = name;
	}

 @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
/*
@Override
public int compareTo(Student o) {
	return  this.getId() - o.getId();
}*/
}//Student

class NameComprator implements  Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return (o1.getName().compareTo(o2.getName()));
	}
	
}//NameComaparator

class  IdComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return  o1.getId() - o2.getId();
	}//compare
	
}//IdComparator
