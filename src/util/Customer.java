package util;

import javafx.beans.property.SimpleStringProperty;

public class Customer {

	private String name,email,addInfo;
	private int roomNumber;
	private boolean checkedIn;
	
	private String reservationStart="none"; //format yyyymmdd
	private String reservationEnd;
	private int numDays;
	private double balance;
	private boolean VIP;
	
	
	private final SimpleStringProperty name_,email_,addInfo_;
	private final SimpleStringProperty roomNumber_;
	private final SimpleStringProperty checkedIn_;
	
	private final SimpleStringProperty reservationStart_; //format yyyymmdd
	private final SimpleStringProperty reservationEnd_;
	private final SimpleStringProperty res_;
	private final SimpleStringProperty numDays_;
	private final SimpleStringProperty balance_;
	private final SimpleStringProperty VIP_;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		name_.set(name);
	}

	public String getEmail() {
		return email;
	}
	
	public String getRes(){
		return res_.get();
	}
	public void setEmail(String email) {
		this.email = email;
		email_.set(email);
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
		addInfo_.set(addInfo);
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
		roomNumber_.set(roomNumber+"");
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
		if(checkedIn){
		checkedIn_.set("Yes");
		}else{
			checkedIn_.set("No");
		}
	}

	public String getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(String reservationStart) {
		this.reservationStart = reservationStart;
		reservationStart_.set(reservationStart);
		
	}

	public String getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(String reservationEnd) {
		this.reservationEnd = reservationEnd;
		reservationEnd_.set(reservationEnd);
		
		
		res_.set(reservationStart+" - "+reservationEnd);
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
		numDays_.set(""+numDays);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
		
	}

	public boolean isVIP() {
		return VIP;
	}

	public void setVIP(boolean vIP) {
		VIP = vIP;
	}

	public Customer(String name){
		this.name = name;
		 name_=new SimpleStringProperty();
		 email_= new SimpleStringProperty();
		 addInfo_ = new SimpleStringProperty();
		 roomNumber_  =new SimpleStringProperty();
		 checkedIn_ =new SimpleStringProperty();
	
		 reservationStart_ =new SimpleStringProperty(); //format yyyymmdd
		 reservationEnd_ =new SimpleStringProperty();
		 res_=new SimpleStringProperty();
		 numDays_=new SimpleStringProperty();
		 balance_=new SimpleStringProperty();
		 VIP_=new SimpleStringProperty();
	}
	
	public String toString(){
		return name;
	}

	public String getName_() {
		return name_.get();
	}

	public String getEmail_() {
		return email_.get();
	}

	public String getAddInfo_() {
		return addInfo_.get();
	}

	public String getRoomNumber_() {
		return roomNumber_.get();
	}
	
	public String getCheckedIn_() {
		return checkedIn_.get();
	}

	public String getReservationStart_() {
		return reservationStart_.get();
	}

	public String getReservationEnd_() {
		return reservationEnd_.get();
	}

	public String getRes_() {
		return res_.get();
	}

	public String getNumDays_() {
		return numDays_.get();
	}

	public String getBalance_() {
		return balance_.get();
	}

	public String getVIP_() {
		return VIP_.get();
	}
	
	
}
