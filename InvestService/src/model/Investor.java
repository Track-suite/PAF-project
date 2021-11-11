package model;

import java.sql.*;
public class Investor {

	// DB Connection
		public Connection connect() {
			Connection con = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/invest", "root", "");

				// For testing
				System.out.print("DB Successfully connected");
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.print("DB not connected");
			}

			return con;
		}
		
		//insert
		public String insertinvestor(String investorName, String Mail, String phoneNumber,String ProjectCode,String ProjectName,String InvestAmount) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = " insert into investor values(`investorID`,`investorName`,`Mail`,`phoneNumber`,`ProjectCode`,`ProjectName`,`InvestAmount`)"
						+ " values (?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, investorName);
				preparedStmt.setString(3, Mail);
				preparedStmt.setInt(4, Integer.parseInt(phoneNumber));
				preparedStmt.setInt(5, Integer.parseInt(ProjectCode));
				preparedStmt.setString(6, ProjectName);
				preparedStmt.setDouble(7, Double.parseDouble(InvestAmount));
				
			

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Insertion successful";

			} catch (Exception e) {
				output = "Insertion Unsuccess";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		//read
		public String readInvestor() {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}

				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>investorName</th>"
						+"<th>Mail</th><th>phoneNumber</th>"
						+"<th>ProjectCode</th>" 
						+"<th>ProjectName</th>"  
						+"<th>investAmount</th></tr>";

				String query = "select * from investor";

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query);

				// iterate through the rows in the result set
				while (rs.next()) {

					String investorID  = Integer.toString(rs.getInt("investorID"));
					String investorName = rs.getString("investorName");
					String Mail = rs.getString("Mail");
					String phoneNumber = Integer.toString(rs.getInt("phoneNumber"));
					String ProjectCode = Integer.toString(rs.getInt("ProjectCode"));
					String ProjectName = rs.getString("ProjectName");
					String InvestAmount = Double.toString(rs.getDouble("InvestAmount"));
					
				
					

					// Add into the html table
					
					
					output += "<td>" + investorName + "</td>";
					output += "<td>" + Mail  + "</td>";
					output += "<td>" + phoneNumber  + "</td>";
					output += "<td>" + ProjectCode + "</td>";
					output += "<td>" + ProjectName + "</td>";
					output += "<td>" + InvestAmount + "</td>";
					
					 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
							 + "<td><form method='post' action='items.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
							 + "<input name='itemID' type='hidden' value='" +investorID 
							 + "'>" + "</form></td></tr>";

				}

				con.close();

				// Complete the html table
				output += "</table>";

			} catch (Exception e) {
				output = "Error while reading.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		// Update
		public String updateInvestor(String investorID, String investorName, String Mail, String phoneNumber,String ProjectCode,String ProjectName,String InvestAmount) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}

				// create a prepared statement
				String query = "UPDATE investor SET investorName=?,Mail=?,phoneNumber=?,ProjectCode=?,ProjectName=?,InvestAmount=? WHERE investorID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				
				preparedStmt.setString(2, investorName);
				preparedStmt.setString(3, Mail);
				preparedStmt.setInt(4, Integer.parseInt(phoneNumber));
				preparedStmt.setInt(5, Integer.parseInt(ProjectCode));
				preparedStmt.setString(6, ProjectName);
				preparedStmt.setDouble(7, Double.parseDouble(InvestAmount));
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				output = " Updated Successfully";

			} catch (Exception e) {
				output = "Error while updating the project .";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		
		// Delete
		public String deleteinvestor(String investorID) {
			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}

				// create a prepared statement
				String query = "delete from investor where investorID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, Integer.parseInt(investorID));

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Deleted successfully";

			} catch (Exception e) {
				output = "Error while deleting the investor Details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
}
