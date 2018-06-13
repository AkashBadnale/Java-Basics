package com.ab.cloningConcept;

public class Address implements Cloneable{
	
	private int houseNo;
	private String streetName;
	private String cityName;
	
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Address(int houseNo, String streetName, String cityName) {
		super();
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streetName=" + streetName + ", cityName=" + cityName + "]";
	}
	
	public Address clone() throws CloneNotSupportedException {
		return (Address)  super.clone();
	}

}
