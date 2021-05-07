package com.Research;

import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class AddResearch
{

	public String getResearches() 
	{             
		String researchesGrid = null;             
		Connection con = null;             
		Statement st = null;             
		ResultSet rs = null;       
		
		try {       
			con = DBConnection.createConnection();     
			st = con.createStatement();    
			rs = st.executeQuery("select * from researches");     
			
			if (rs.first())       
			{ 
				researchesGrid = "<table border='1' cellspacing='1' cellpadding='1'>"
						+ "<tr>"
						+ "<th>ID</th>"
						+ "<th>ResearchName</th>"
						+ "<th>Author1</th>"
						+ "<th>Author2</th>"
						+ "<th>Author3</th>"
						+ "<th>Field</th>"
						+ "<th>Publisher</th>"
						+ "<th>PublishYear</th>"
						+ "<th>Budget</th>"
						+ "<th>Edit</th>"
						+ "<th>Delete</th>"
						+ "</tr>"; 
				rs.beforeFirst(); 
				
				while(rs.next())  
				{   
					researchesGrid = researchesGrid + "<tr><td>" + rs.getString(1) + 
							"</td>"      + "<td>" + rs.getString(2) + "</td>"     
							+ "<td>" + rs.getString(3) + "</td>"      
							+ "<td><input id=\"btnEdit\" type=\"button\" name=\"btnEdit\"  param=\"" 
							+ rs.getString(1) + "\" value=\"Edit\"</td>"      
							+ "<td>" + "<input id=\"btnRemove\" type=\"button\" name=\"btnRemove\" param=\"" 
							+ rs.getString(1) + "\" value=\"Remove\"</td></tr>";                        
				} 
				
			}                   
			else                         
				researchesGrid = "There are no Research Papers...";                   
			researchesGrid = researchesGrid + "</table></br>";             
			}             
		catch (SQLException e) 
		{                   
			e.printStackTrace();             
		}             
		
		return researchesGrid;       
		
		}       
	
		public String saveAResearch(String rname, String rauthor1, String rauthor2, String rauthor3, String rfield, String rpublisher, String rpublishyear, Float rbudget) 
		{
			String res = null;             
			String sql = null;            
			Connection con = null;             
			Statement st = null;             
			try 
			{                   
				con = DBConnection.createConnection();                  
				st = con.createStatement();                  
				sql = "insert into researches (namer, author1r, author2r, author3r, fieldr, publisherr, publishyearr, budgetr) values ('" + rname + "', '" + rauthor1 + "','" + rauthor2 + "','" + rauthor3 + "','" + rfield + "','" + rapublisher + "','" + rpublishyear + "','" + rbudget + "',)";                   
				st.executeUpdate(sql);                   
				res = "Successfully inserted...";             
			}             
			catch (SQLException e) 
			{                   
				e.printStackTrace();             
			}             
			
			return res;       
			
		}
}