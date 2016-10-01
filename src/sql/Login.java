package sql;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login {
	
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://rasp.abraham.tokyo/hms";
	
	public static boolean correct(String eid,String pwd){
		MessageDigest md5=null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md5.update(StandardCharsets.UTF_8.encode(pwd));
		String pwdhash= String.format("%032x", new BigInteger(1, md5.digest()));
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection(DB_URL,"java","javerpwd");
			Statement stmt = c.createStatement();
			String sql;
			sql = "SELECT * FROM employees";
			ResultSet rs = stmt.executeQuery(sql);
			boolean found =false;
			while(!found && rs.next()){
				String EID = rs.getString("EID");
				if(EID.equals(eid)){
					found=true;
					String pwd2= rs.getString("pwdhash");
					//System.out.println(EID+" "+ pwd2);
					if(pwd2.equals(pwdhash)){
						return true;
					}else{
						return false;
					}
					
				}
				
				
				
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return false;
		
	}
	
	
	
}
