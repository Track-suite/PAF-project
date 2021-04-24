package model;

import java.sql.*;

public class user {
	
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useSSL=false", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	
	//read user method
	public String readUsers(String type)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 
	 if (type.equals("buyer") || type.equals("buyer")) {
	 
	 output = "<table border='1'><tr><th>Buyer ID</th><th>Buyer Code</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th>" +"<th>update</th>" + "<th>Delete</th></tr>";

	 String query = "select * from buyer";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String buyerID = Integer.toString(rs.getInt("userID"));
	 String buyerCode = rs.getString("userCode");
	 String userName = rs.getString("userName");
	 String password = rs.getString("password");
	 String email = rs.getString("email");
	 String address = rs.getString("address");
	 String dob = rs.getString("dob");
	 String phone = rs.getString("phone");
	 
	 // Add into the html table
	 output += "<tr><td>" + buyerID + "</td>";
	 output += "<td>" + buyerCode + "</td>";
	 output += "<td>" + userName + "</td>";
	 output += "<td>" + password + "</td>";
	 output += "<td>" + email + "</td>";
	 output += "<td>" + address + "</td>";
	 output += "<td>" + dob + "</td>";
	 output += "<td>" + phone + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
	 + "<input name='itemID' type='hidden' value='" + buyerID
	 + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 
	 if (type.equals("developer") || type.equals("Developer")) {
		 
		 output = "<table border='1'><tr><th>Developer ID</th><th>developer Code</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th>" +"<th>Description</th>"+"<th>update</th>" + "<th>Delete</th></tr>";

		 String query = "select * from developer";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String developerID = Integer.toString(rs.getInt("developerID"));
		 String developerCode = rs.getString("developerCode");
		 String userName = rs.getString("userName");
		 String password = rs.getString("password");
		 String email = rs.getString("email");
		 String address = rs.getString("address");
		 String dob = rs.getString("dob");
		 String phone = rs.getString("phone");
		 String desc = rs.getString("desc");
		 
		 // Add into the html table
		 output += "<tr><td>" + developerID + "</td>";
		 output += "<td>" + developerCode + "</td>";
		 output += "<td>" + userName + "</td>";
		 output += "<td>" + password + "</td>";
		 output += "<td>" + email + "</td>";
		 output += "<td>" + address + "</td>";
		 output += "<td>" + dob + "</td>";
		 output += "<td>" + phone + "</td>";
		 output += "<td>" + desc + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
		 + "<td><form method='post' action='items.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
		 + "<input name='itemID' type='hidden' value='" + developerID
		 + "'>" + "</form></td></tr>";
		 }
		 con.close();
		 // Complete the html table
		 output += "</table>";
		 }
	  
	 
 if (type.equals("investor") || type.equals("Investor")) {
		 
		 output = "<table border='1'><tr><th>investor ID</th><th>investor Code</th><th>User Name</th>" +"<th>Password</th>" +"<th> Gmail</th>" +"<th>Address</th>"+"<th>DOB</th>" + "<th>phone</th>" +"<th>update</th>" + "<th>Delete</th></tr>";

		 String query = "select * from investor";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String investorID = Integer.toString(rs.getInt("investorID"));
		 String investorCode = rs.getString("investorCode");
		 String userName = rs.getString("userName");
		 String password = rs.getString("password");
		 String email = rs.getString("email");
		 String address = rs.getString("address");
		 String dob = rs.getString("dob");
		 String phone = rs.getString("phone");
		
		 
		 // Add into the html table
		 output += "<tr><td>" + investorID + "</td>";
		 output += "<td>" + investorCode + "</td>";
		 output += "<td>" + userName + "</td>";
		 output += "<td>" + password + "</td>";
		 output += "<td>" + email + "</td>";
		 output += "<td>" + address + "</td>";
		 output += "<td>" + dob + "</td>";
		 output += "<td>" + phone + "</td>";
	
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
		 + "<td><form method='post' action='items.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
		 + "<input name='itemID' type='hidden' value='" + investorID
		 + "'>" + "</form></td></tr>";
		 }
		 con.close();
		 // Complete the html table
		 output += "</table>";
		 }
	  
	 
	 
	 
	 
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the users.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	/*method to inert the user*/
	public String insertUser(String usercode ,String username, String password, String email, String address,String dob ,String phone, String type,String desc )
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 
	 // create a prepared statement
	 if (type.equals("buyer") || type.equals("Buyer")) {
		 	 
		 
	 String query = " insert into user.buyer (`userID`,`userCode`,`userName`,`password`,`email`,`address`,`dob`,`phone`)"
	 + " values (?, ?, ?, ?, ?, ?, ?, ?)";
	 
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, usercode);
	 preparedStmt.setString(3, username);
	 preparedStmt.setString(4, password);
	 preparedStmt.setString(5, email);
	 preparedStmt.setString(6, address);
	 preparedStmt.setString(7, dob);
	 preparedStmt.setString(8, phone);
	// preparedStmt.setString(9, desc);
	// execute the statement
	
	 preparedStmt.execute();
	 con.close();
	 output = " User Inserted successfully";
	
	 }
	 
	 if (type.equals("developer") || type.equals("Developer")) {
		 
		 
		
		 //query for inserting
		 String query = " insert into user.developer(`developerID`,`developerCode`,`userName`,`password`,`email`,`address`,`dob`,`phone`,`desc`)"
				 + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				 
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setInt(1, 0);
				 preparedStmt.setString(2, usercode);
				 preparedStmt.setString(3, username);
				 preparedStmt.setString(4, password);
				 preparedStmt.setString(5, email);
				 preparedStmt.setString(6, address);
				 preparedStmt.setString(7, dob);
				 preparedStmt.setString(8, phone);
				 preparedStmt.setString(9, desc);
				// execute the statement
				
				 preparedStmt.execute();
				 con.close();
				 output = "User Inserted successfully";
	 }
	 
if (type.equals("Investor") || type.equals("investor")) {
	
	
	;
		 //query for inserting
		 String query = " insert into user.investor(`investorID`,`investorCode` ,`userName`,`password`,`email`,`address`,`dob`,`phone`)"
				 + " values (?, ?, ?, ?, ?, ?, ?, ?)";
				 
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setInt(1, 0);
				 preparedStmt.setString(2, usercode);
				 preparedStmt.setString(3, username);
				 preparedStmt.setString(4, password);
				 preparedStmt.setString(5, email);
				 preparedStmt.setString(6, address);
				 preparedStmt.setString(7, dob);
				 preparedStmt.setString(8, phone);
				
				// execute the statement
				
				 preparedStmt.execute();
				 con.close();
				 output = "User Inserted successfully";
	 }
	 
	
	 }
	
	 catch (Exception e)
	 {
	 output = "Error while inserting the user.";
	 System.err.println(e.getMessage());
	 }
	
	 return output;
	 
	 }
	

    /*method to update the user*/
	public String updateUser(String type , String userID, String userName, String password, String email, String address,String dob,String phone,String desc)
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for updating."; } 
	
	 // create a prepared statement
	 
	 if (type.equals("buyer") || type.equals("Buyer")) {
	 String query = "UPDATE user.buyer SET userName=?,password=?,email=?,address=?,dob=?,phone=?where userID=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	
	 preparedStmt.setString(1, userName); 
	 preparedStmt.setString(2, password); 
	 preparedStmt.setString(3, email); 
	 preparedStmt.setString(4, address); 
	 preparedStmt.setString(5, dob); 
	 preparedStmt.setString(6, phone); 
	 preparedStmt.setInt(7, Integer.parseInt(userID));
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Updated successfully"; 
	 } 
	 
	 if (type.equals("developer") || type.equals("Developer")) {
		 
		 String query = "UPDATE user.developer SET userName=?,password=?,email=?,address=?,dob=?,phone=?,developer.desc=? WHERE developerID=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		
		 preparedStmt.setString(1, userName); 
		 preparedStmt.setString(2, password); 
		 preparedStmt.setString(3, email); 
		 preparedStmt.setString(4, address); 
		 preparedStmt.setString(5, dob); 
		 preparedStmt.setString(6, phone); 
		 preparedStmt.setString(7, desc);
		 preparedStmt.setInt(8, Integer.parseInt(userID));
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated successfully"; 
		 
	}
	if (type.equals("investor") || type.equals("Investor")) {
		 
		 String query = "UPDATE user.investor SET userName=?,password=?,email=?,address=?,dob=?,phone=?where investorID=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		
		 preparedStmt.setString(1, userName); 
		 preparedStmt.setString(2, password); 
		 preparedStmt.setString(3, email); 
		 preparedStmt.setString(4, address); 
		 preparedStmt.setString(5, dob); 
		 preparedStmt.setString(6, phone); 
		
		 preparedStmt.setInt(8, Integer.parseInt(userID));
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated successfully"; 
		 
	 }
	 
	 
	 
	 
	 }
	 catch (Exception e) 
	 { 
	 output = "Error while updating the user."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 }
	
	
	/*method to delete the user*/
	public String deleteUser(String type,String userID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 
	 if (type.equals("buyer") || type.equals("buyer")) {
		 
		 // create a prepared statement
		 String query = "delete from buyer where userID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(userID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "buyer deleted successfully";
	 }
	 if (type.equals("developer") || type.equals("Developer")) {
		 
		 // create a prepared statement
		 String query = "delete from developer where developerID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(userID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "developer deleted successfully";
	 }
	 if (type.equals("investor") || type.equals("Investor")) {
		 
		 // create a prepared statement
		 String query = "delete from investor where investorID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(userID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "investor deleted successfully";
	 }
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the user.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	 

}
