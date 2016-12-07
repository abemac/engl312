package util;

public class Customer {

	public String name,email;
	public int roomNumber;
	public boolean checkedIn;
	
	public long reservationStart; //format yyyymmdd
	public long reservationEnd;
	public double balance;
	public boolean VIP;
	
	
	public Customer(String name){
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
}
