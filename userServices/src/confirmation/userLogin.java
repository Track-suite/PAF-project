package confirmation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userLogin {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useSSL=false", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String userLogin(String username, String password,String type) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
		
			if (type.equals("buyer") || type.equals("Buyer")) {
				
				String query ="select userID,userCode,userName,password,email,address,dob,phone from consumer where userName= '"+username+"'AND password= '"+password+"' ";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				ResultSet rs = ((java.sql.Statement) preparedStmt).executeQuery(query);
				
				
				  while (rs.next()) {
					    String userID = Integer.toString(rs.getInt("userID"));
					    String UserCode = rs.getString("userCode");
				        String UserName = rs.getString("userName");
				        String Password = rs.getString("password");
				        String Email = rs.getString("email");
				        String Address = rs.getString("address");
				        String Dob =rs.getString("dob");
				        String phone =rs.getString("phone");
				  
				        if((username.equals(UserName)) && (password.equals(Password))) {
				        	
				        	output ="     Login Successful  !!           You're logged as "   +username;
				        	output += "<br><br><table border='1'><tr><th>User ID</th><th>User Code</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th></tr>";
				        	output += "<tr><td>" + userID + "</td>";
				        	output += "<td>" + UserCode + "</td>";
						   	output += "<td>" + UserName + "</td>";
						   	output += "<td>" + password + "</td>";
						   	output += "<td>" + Email + "</td>";
						   	output += "<td>" + Address + "</td>";
							output += "<td>" + Dob + "</td>";
						   	output += "<td>" + phone + "</td>";	
				        
				        }
			              else {
			                output ="      Login Failed...!!";
			              	} 
				  	}
				
				con.close();
				
			}
			if (type.equals("developer") || type.equals("Developer")) {
				
				String query ="select developerID,developerCode,userName,password,email,address,dob,phone,developer.desc from developer where userName= '"+username+"'AND password= '"+password+"' ";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				ResultSet rs = ((java.sql.Statement) preparedStmt).executeQuery(query);
				
				
				  while (rs.next()) {
					    String userID = Integer.toString(rs.getInt("developerID"));
					    String UserCode = rs.getString("developerCode");
				        String UserName = rs.getString("userName");
				        String Password = rs.getString("password");
				        String Email = rs.getString("email");
				        String Address = rs.getString("address");
				        String Dob =rs.getString("dob");
				        String phone =rs.getString("phone");
				        String desc = rs.getString("desc");
				        
				  
				        if((username.equals(UserName)) && (password.equals(Password))) {
				        	
				        	output ="     Login Successful  !!           You're logged as "   +username;
				        	output += "<br><br><table border='1'><tr><th>Developer ID</th><th>Developer Code</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th>" + "<th>description</th></tr>";
				        	output += "<tr><td>" + userID + "</td>";
				        	output += "<td>" + UserCode + "</td>";
						   	output += "<td>" + UserName + "</td>";
						   	output += "<td>" + password + "</td>";
						   	output += "<td>" + Email + "</td>";
						   	output += "<td>" + Address + "</td>";
							output += "<td>" + Dob + "</td>";
						   	output += "<td>" + phone + "</td>";	
							output += "<td>" + desc + "</td>";	
				        	}
			              else {
			                output ="      Login Failed...!!";
			            	 //output ="     Login Successful  !!           You're logged as"   +username;
			              	} 
				  	}
				
				con.close();
			}
			if (type.equals("investor") || type.equals("investor")) {
				
				String query ="select investorID,investorCode,userName,password,email,address,dob,phone,profileInfo from investor where userName= '"+username+"'AND password= '"+password+"' ";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				ResultSet rs = ((java.sql.Statement) preparedStmt).executeQuery(query);
				
				
				  while (rs.next()) {
					    String userID = Integer.toString(rs.getInt("investorID"));
					    String UserCode = rs.getString("investorCode");
				        String UserName = rs.getString("userName");
				        String Password = rs.getString("password");
				        String Email = rs.getString("email");
				        String Address = rs.getString("address");
				        String Dob =rs.getString("dob");
				        String phone =rs.getString("phone");
				        String profileInfo = rs.getString("profileInfo");
				        
				  
				        if((username.equals(UserName)) && (password.equals(Password))) {
				        	
				        	output ="     Login Successful  !!           You're logged as "   +username;
				        	output += "<br><br><table border='1'><tr><th>Investor ID</th><th>Investor Code</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th>" + "<th>profile Information</th></tr>";
				        	output += "<tr><td>" + userID + "</td>";
				          	output += "<td>" + UserCode + "</td>";
						   	output += "<td>" + UserName + "</td>";
						   	output += "<td>" + password + "</td>";
						   	output += "<td>" + Email + "</td>";
						   	output += "<td>" + Address + "</td>";
							output += "<td>" + Dob + "</td>";
						   	output += "<td>" + phone + "</td>";	
							output += "<td>" + profileInfo + "</td>";	
				        	}
			              else {
			                output ="      Login Failed...!!";
			            	 
			              	} 
				  	}
				
				con.close();
			}
			
		}catch (Exception e) {
			output = "Error while Logging.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
}