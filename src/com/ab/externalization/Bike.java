package com.ab.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Bike implements Externalizable{

	private String name;
	private int manufacturingYear;
	private String typeOfBike;
	
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public Bike(String name, int manufacturingYear, String typeOfBike) {
		super();
		this.name = name;
		this.manufacturingYear = manufacturingYear;
		this.typeOfBike = typeOfBike;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getTypeOfBike() {
		return typeOfBike;
	}

	public void setTypeOfBike(String typeOfBike) {
		this.typeOfBike = typeOfBike;
	}

	@Override
	public String toString() {
		return "BIke [name=" + name + ", manufacturingYear=" + manufacturingYear + ", typeOfBike=" + typeOfBike + "]";
	}



	@Override
	public void readExternal(ObjectInput oi) throws IOException, ClassNotFoundException {
		
		      String name =  (String) oi.readObject();
              int manufacturingYear = (int) oi.readInt();
              String typeOfBike = (String) oi.readObject();
		}

	@Override
	public void writeExternal(ObjectOutput oo) throws IOException {
		
                 oo.writeObject(name);
                 oo.writeInt(manufacturingYear);
                 oo.writeObject(typeOfBike);
	}

}//Bike
