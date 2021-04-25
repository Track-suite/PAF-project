package model;

import java.sql.*; 

public class Payment {

	
	

	public  Connection connect() { 
		
		Connection con = null;
		
		try {
		 
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gaddb","root", "");
	 		
		}
	 
	 	catch(Exception e) {
	 		
	 		e.printStackTrace();
	 		}

		return con;

	 
	}
	


	public String insertPayment(String UserID, String Method, String Status, String Amount, String Date, String Description) { 
		
		String output = ""; 
	 
		try { 
			Connection con = connect();
	  
			if (con == null) {
				return "Error while connecting to the database for inserting."; 
			} 
	 
			String query = " insert into payment (`payment_id`, `user_id`,`method`,`status`,`amount`,`date`,`description`)" + " values (?, ?, ?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, UserID); 
			preparedStmt.setString(3, Method); 
			preparedStmt.setString(4, Status); 
			preparedStmt.setString(5, Amount); 
			preparedStmt.setString(6, Date); 
			preparedStmt.setString(7, Description); 
		
	 
	
			preparedStmt.execute(); 
			con.close(); 
	 
			output = "Payment successfully added"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while inserting the Payment."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
	
	
	

	public String readPayment() 
	 { 
		String output = ""; 
		
		try
		{ 
			Connection con = connect(); 
			if (con == null) {
				return "Error while connecting to the database for reading.";
				} 
	
			output = "<table border='1'> <tr><th>Payment ID</th>"
					+ "<th>User ID</th>"
					+ "<th>Method</th>"
					+ "<th>Status</th>"
					+ "<th>Amount</th>"
					+ "<th>Date</th>"
					+ "<th>Description</th></tr>"; 
	 
			String query = "select * from payment"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
	 
	 
	
			while (rs.next()) 
			{ 
		 
				String payment_id = Integer.toString(rs.getInt("payment_id")); 
				String user_id = rs.getString("user_id"); 
				String method = rs.getString("method"); 
				String status = rs.getString("status"); 
				String amount = rs.getString("amount"); 
				String date = rs.getString("date"); 
				String description = rs.getString("description"); 
				
	 
	
				output += "<tr><td>" + payment_id + "</td>";
				output += "<td>" + user_id + "</td>";
				output += "<td>" + method + "</td>"; 
				output += "<td>" + status + "</td>"; 
				output += "<td>" + amount + "</td>"; 
				output += "<td>" + date + "</td>"; 
				output += "<td>" + description + "</td>"; 
				
				 // buttons 		
				   output
						  += "<td><input name='btnUpdate' "
						  + " type='button' value='Update' class='btn btn-secondary' </td>"
				 		  + "<td><form method='post' action='Products.jsp'>"
				 		  + "<input name='btnRemove' " + " type='submit' value='Remove' class='btn btn-danger'>"
				 		  + "<input name='payment_id' type='hidden' " + " value='" + payment_id + "'>" + "</form></td></tr>";
				 		 
			} 
			
	 con.close(); 
	 
	// Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
		 output = "Error while reading the Payment."; 
		 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 

	

	public String updatePayment(String PaymentID, String UserID, String Method, String Status, String Amount, String Date, String Description)
	 {
		
	 String output = "";
	 
	 try
	 {
		 Connection con = connect();
		 
		 if (con == null) {
			 
			 return "Error while connecting to the database for updating.";
			 }
		 
		 
		
			 
		 String query = "UPDATE payment SET user_id=?, method=?, status=?, amount=?, date=?, description=?  WHERE payment_id=?";

		 PreparedStatement preparedStmt = con.prepareStatement(query);

		 preparedStmt.setString(1, UserID); 
		 preparedStmt.setString(2, Method); 
		 preparedStmt.setString(3, Status); 
		 preparedStmt.setString(4, Amount); 
		 preparedStmt.setString(5, Date); 
		 preparedStmt.setString(6, Description); 
		 preparedStmt.setInt(7, Integer.parseInt(PaymentID));
		
				
			 
		 preparedStmt.execute();
		 con.close();
	
		 output = "Payment successfully updated ";
		 }
	
	 catch (Exception e){
		 
		 output = "Error while updating the Payment.";
		 System.err.println(e.getMessage());
	 
	 }
	
	 return output;
	 } 
	
	

	
	public String deletePayment(String PaymentID)
	 {
	 
		String output = "";
		
		try{
			
			Connection con = connect();
			if (con == null){
				return "Error while connecting to the database for deleting.";
				}
	 
			
			String query = "delete from payment where payment_id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			
			preparedStmt.setInt(1, Integer.parseInt(PaymentID));
			
			preparedStmt.execute();
			con.close();
			
			output = "Payment successfully deleted ";
		}
			
	 catch (Exception e) {
		 
		 output = "Error while deleting the Sponsor Details.";
		 System.err.println(e.getMessage());
	 }
		
	 return output;
	 
	 }
	 
}
