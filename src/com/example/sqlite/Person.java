package com.example.sqlite;

import java.io.Serializable;


public class Person  implements Serializable {

	String username;
	String usephone;
	String station;
	String company;
	String address;
	
public Person(String username,String usephone,String station,String company,String address) {
	super();
	//位所有的的数据赋值
	this.username = username;
	this.usephone = usephone;
	this.station = station;
	this.company = company;
	this.address = address;

}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUsephone() {
	return usephone;
}
public void setUsephone(String usephone) {
	this.usephone = usephone;
}
public String getStation() {
	return station;
}
public void setStation(String station) {
	this.station = station;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
}
