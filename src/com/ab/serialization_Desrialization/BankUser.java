package com.ab.serialization_Desrialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BankUser implements Serializable{
  
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int accountNo;
	private long debitCardNo;
	private transient  int debitPIN;
	
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankUser(String name, int accountNo, long debitCardNo, int debitPIN) {
		super();
		this.name = name;
		this.accountNo = accountNo;
		this.debitCardNo = debitCardNo;
		this.debitPIN = debitPIN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public long getDebitCardNo() {
		return debitCardNo;
	}

	public void setDebitCardNo(long debitCardNo) {
		this.debitCardNo = debitCardNo;
	}

	public int getDebitPIN() {
		return debitPIN;
	}

	public void setDebitPIN(int debitPIN) {
		this.debitPIN = debitPIN;
	}

	@Override
	public String toString() {
		return "BankUser [name=" + name + ", accountNo=" + accountNo + ", debitCardNo=" + debitCardNo + ", debitPIN="
				+ debitPIN + "]";
	}
	
	
	private  void   writeObject ( ObjectOutputStream os) throws Exception  {
		os.defaultWriteObject();
	    int  newPIN =  debitPIN + 1024;
		os.writeObject(newPIN);
	}//writeObject
	
	private void readObject(ObjectInputStream oi)  throws Exception{
		oi.defaultReadObject();
		int newPIN = (int) oi.readObject();
		int debitPIN = newPIN - 1024;
		System.out.println("decrypted pin is "+debitPIN);
	}//readObject
	
	
}//BankUser
