package util;

import java.util.ArrayList;
import java.util.LinkedList;

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
	
	public static void setUser(String eid){
		if(user==null){
			user=eid;
		}else{
			System.err.println("Repeat assignent of session user.");
		}
	}
	
	
	
	
	
}
