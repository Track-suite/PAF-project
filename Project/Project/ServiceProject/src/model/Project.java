package model;
import java.sql.*;

public class Project {
	// DB Connection
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project", "root", "");

			// For testing
			System.out.print("DB Successfully connected");
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.print("DB not connected");
		}

		return con;
	}
	
	// Insert
		public String insertProject(String name, String cost, String duration, String author) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database";
				}

				// create a prepared statement
				String query = " insert into project(`id`,`name`,`cost`,`duration`,`author`)"
						+ " values (?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, name);
				preparedStmt.setInt(3, Integer.parseInt(cost));
				preparedStmt.setInt(4, Integer.parseInt(duration));
				preparedStmt.setString(5, author);
				
			

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
		public String readProject() {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}

				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>Name</th>" + "<th>Cost</th><th>Duration</th>"
						 + "<th>Author</th></tr>";

				String query = "select * from project";

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(query);

				// iterate through the rows in the result set
				while (rs.next()) {

					String id  = Integer.toString(rs.getInt("id"));
					String name = rs.getString("name");
					String cost =  Integer.toString(rs.getInt("cost"));
					String duration = Integer.toString(rs.getInt("duration"));
					String author = rs.getString("author");
				
					

					// Add into the html table
					output += "<tr><td>" + name + "</td>";
					output += "<td>" + cost + "</td>";
					output += "<td>" + duration + "</td>";
					output += "<td>" + author + "</td>";

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
		public String updateProject(String id ,String name, String cost, String duration, String author) {

			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}

				// create a prepared statement
				String query = "UPDATE project SET name=?,cost=?,duration=?,author=? WHERE id=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setString(1, name);
				preparedStmt.setInt(2,  Integer.parseInt(cost));
				preparedStmt.setInt(3, Integer.parseInt(duration));
				preparedStmt.setString(4, author);
				preparedStmt.setInt(5, Integer.parseInt(id));

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
		public String deleteProject(String id) {
			String output = "";

			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}

				// create a prepared statement
				String query = "delete from project where id=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, Integer.parseInt(id));

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
