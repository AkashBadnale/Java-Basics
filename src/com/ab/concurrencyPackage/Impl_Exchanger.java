package com.ab.concurrencyPackage;

import java.util.concurrent.Exchanger;

public class Impl_Exchanger {

	public static void main(String[] args) {

		Exchanger<String> exchanger = new Exchanger<>();

		Message message1 = new Message(exchanger, "Thread 1's message ", "Thread - Message 1");
		Message message2 = new Message(exchanger, "Thread 2's message ", "Thread - Message 2");

		message1.start();
		message2.start();

	}// main
}// Impl_Exchanger

class Message extends Thread {

	Exchanger exchanger = null;
	String msg = null;
	String threadName = null;

	public Message(Exchanger exchanger, String msg, String threadName) {
		super(threadName);
		this.exchanger = exchanger;
		this.msg = msg;
		this.threadName = threadName;
	}

	public void run() {
		System.out.println(" current thread ---" + Thread.currentThread().getName() + " message ---" + msg);
		try {
			msg = (String) exchanger.exchange(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" currrent thread ---" + Thread.currentThread().getName() + " message ---" + msg);
	}// run()

	@Override
	public String toString() {
		return "Message [exchanger=" + exchanger + ", msg=" + msg + ", threadName=" + threadName + "]";
	}

}// Message