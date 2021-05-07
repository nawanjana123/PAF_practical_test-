package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Research {

	//A common method to connect to the DB
			public Connection connect()
			 {
			 Connection con = null;
			 try
			 {
			 Class.forName("com.mysql.jdbc.Driver");

			 //Provide the correct details: DBServer/DBName, username, password 
			 
			
			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/research", "root", "1234");
			 
			//For testing
			 System.out.print("Successfully connected"); 
			 
			
			 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
			 }
			public String insertData(String rname, String rauthor1, String rauthor2, String rauthor3, String rfield, String rpublisher, String rpublishyear, String rbudget)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for inserting."; }
			 // create a prepared statement
			 String query = " insert into appointments(`ResearchName`,`Author1`,`Author2`,`Author3`,`ResearchField`,`Publisher`,`PublishYear`,`Budget`)"
					 + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					 PreparedStatement preparedStmt = con.prepareStatement(query);
					 // binding values
					 preparedStmt.setString(1, rname);
					 preparedStmt.setString(2, rauthor1);
					 preparedStmt.setString(3, rauthor2);
					 preparedStmt.setString(4, rauthor3);
					 preparedStmt.setString(5, rfield);
					 preparedStmt.setString(6, rpublisher);
					 preparedStmt.setString(7, rpublishyear);
					 preparedStmt.setString(8, rbudget);
					 
					// execute the statement
					 preparedStmt.execute();
					 con.close();
					 output = "Inserted successfully";
					 }
					 catch (Exception e)
					 {
					 output = "Error while inserting the Data.";
					 System.err.println(e.getMessage());
					 }
					 return output;
			 }
			
			public String readData()
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for reading."; }
			 // Prepare the html table to be displayed
			 output = "<table border=\"1\"><tr><th>Research ID</th><th>ResearchName</th><th>Author1</th><th>Author2</th><th>Author3e</th><th>ResearchField</th><th>Publisher</th><th>Publishyear</th><th>Budget</th><th>Update</th><th>Remove</th></tr>";
			 String query = "select * from appointments";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
				 String R_ResearchID = Integer.toString(rs.getInt("ResearchID"));
				 String R_ResearchName = rs.getString("ResearchName");
				 String R_Author1 = rs.getString("Author1");
				 String R_Author2 = rs.getString("Author2");		
				 String R_Author3= rs.getString("Author4");
				 String R_ResearchField = rs.getString("ResearchField");
				 String R_Publisher = rs.getString("Publisher");
				 String R_PublishYear= rs.getString("PublishYear");
				 String R_Budget= rs.getString("Budget");
				 
				 // Add into the html table
				 output += "<tr><td>" + R_ResearchID + "</td>";
				 output += "<td>" + R_ResearchName + "</td>";
				 output += "<td>" + R_Author1 + "</td>";
				 output += "<td>" + R_Author2 + "</td>";
				 output += "<td>" + R_Author3 + "</td>";
				 output += "<td>" + R_ResearchField + "</td>";
				 output += "<td>" + R_Publisher + "</td>";
				 output += "<td>" + R_PublishYear + "</td>";
				 output += "<td>" + R_Budget + "</td>";
				 
				// buttons
				 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"items.jsp\">" + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
				 + "<input name=\"R_ResearchID\" type=\"hidden\" value=\"" + R_ResearchID
				 + "\">" + "</form></td></tr>";
				 }
			 // Complete the html table
			 output += "</table>";
			 }
			 catch (Exception e)
			 {
			 output = "Error while reading the Data.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 } 
			
			public String updateData(String rid, String rname, String rauthor1, String rauthor2, String rauthor3, String rfield, String rpublisher, String rpublishyear, String rbudget)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE appointments SET ResearchName=?,Author1=?,Author2=?,Author3=?,ResearchField=?,Publisher=?,PublishYear=?,Budget=? WHERE ResearchID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, rname);
			 preparedStmt.setString(2, rauthor1);
			 preparedStmt.setString(3, rauthor2);
			 preparedStmt.setString(4, rauthor3);
			 preparedStmt.setString(5, rfield);
			 preparedStmt.setString(6, rpublisher);
			 preparedStmt.setString(7, rpublishyear);
			 preparedStmt.setString(8, rbudget);
			 preparedStmt.setInt(9, Integer.parseInt(rid));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Updated successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while updating the Data.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }

			public String deleteData(String R_ResearchID)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 // create a prepared statement
			 String query = "delete from appointments where ResearchID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(R_ResearchID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while deleting the Data.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 } 

					 
					 
					 
					 
					 
					 
					 
					 
					 
					 

					 
}
