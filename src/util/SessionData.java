package util;

public class SessionData {

	
	private static String user=null;
	
	public static void setUser(String eid){
		if(user==null){
			user=eid;
		}else{
			System.err.println("Repeat assignent of session user.");
		}
	}
	
	
	
}
