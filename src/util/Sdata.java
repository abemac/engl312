package util;

import java.util.ArrayList;
import java.util.LinkedList;

import com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManager;

public class Sdata {

	
	private static String user=null;
	public static final int CHECK_IN=0;
	public static final int CHECK_OUT=1;
	public static final int ADD_CUSTOMER=2;
	public static final int OPEN_ROOMS=3;
	public static final int WAKE_UP_CALL=4;
	public static final int ROOM_SERVICE=5;
	public static final int EMAIL=6;
	public static final int TRENDS=7;
	public static final int MONEY=8;
	public static final int BREAKFAST=9;
	public static final int RESERVATION=10;
	
	public static ArrayList<LinkedList<String>> aliases;
	public static boolean[] roomsTaken;
	public static ArrayList<Customer> customers;
	
	public static void setUser(String eid){
		if(user==null){
			user=eid;
		}else{
			System.err.println("Repeat assignent of session user.");
		}
	}
	
	public static void init(){
		loadAliases();
		loadCustomers();
		initRooms();
	}
	
	private static void loadAliases(){
    	Sdata.aliases=new ArrayList<LinkedList<String>>();
    	for(int i=0;i<12;i++){
    		Sdata.aliases.add(new LinkedList<String>());
    		Sdata.aliases.get(i).add("test");
    	}
    }
	
	private static void loadCustomers(){
		customers=new ArrayList<Customer>();
		customers.add(new Customer("Bob Rice"));
		customers.add(new Customer("Brad Smith"));
		customers.add(new Customer("Foulack Ruacien"));
		customers.add(new Customer("MR. OB"));
		
	}
	private static void initRooms(){
		roomsTaken=new boolean[301];
		roomsTaken[277]=true;
		
	}
	
	
}
