
package model;

import java.sql.*;

public class Finance {

	// DB Connection
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/finance1", "root", "");

			// For testing
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.print("DB not connected");
		}

		return con;
	}

	// Insert
	public String insertFinance(String finance_Type, String cost, String account_Type) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into finance1(`finance_ID`,`finance_Type`,`cost`,`account_Type)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2,finance_Type );
			preparedStmt.setInt(3, Integer.parseInt(cost));
			preparedStmt.setString(4, account_Type);
		

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

	
	// Read
	public String readFinance() {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>finance_Type</th>" + "<th>cost</th>"
					+ "<th>account_Type</th>";

			String query = "select * from finance1";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				String finance_ID = Integer.toString(rs.getInt("finance_ID"));
				String finance_Type = rs.getString("finance_Type");
				String cost = Integer.toString(rs.getInt("cost"));
				String account_Type = rs.getString("account_Type");
			
				

				// Add into the html table
				output += "<tr><td>" + finance_Type + "</td>";
				output += "<td>" + cost + "</td>";
				output += "<td>" + account_Type + "</td>";

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
	public String updateFinance(String finance_ID ,String finance_Type, String cost, String account_Type) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE finance1 SET finance_Type=?,cost=?,account_Type=? WHERE finance_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, finance_Type);
			preparedStmt.setInt(2, Integer.parseInt(cost));
			preparedStmt.setString(3, account_Type);
			preparedStmt.setInt(4, Integer.parseInt(finance_ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Successfully Updated";

		} catch (Exception e) {
			output = "Updating unsuccesful .";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	// Delete
	public String deleteFinance(String finance_ID) {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from finance1 where finance_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(finance_ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the Product Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}