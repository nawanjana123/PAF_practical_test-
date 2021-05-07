package com.Research;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ResearchDAO {

	Connection con = null;
	
	public ResearchDAO(){
		
		String url = "jdbc:mysql://localhost:3306/research_research";
		String user = "root";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			System.out.println(e);
		}	
	}
	
	
	
	public List<Research> getResearches(){
		
		List<Research> reserches = new ArrayList<>();
		
		String sql = "select* from research";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Research a = new Research();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setAuthor1(rs.getString(3));
				a.setAutthor2(rs.getString(4));
				a.setAutthor3(rs.getString(5));
				a.setField(rs.getString(6));
				a.setPublisher(rs.getString(7));
				a.setPublishYear(rs.getString(8));
				a.setBudget(rs.getfloat(9));

				researches.add(a);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return researches;		
	}
	
	
	
	public Research getResearch(int id) {
			
		reserches a = new Research();
		
		String sql = "select* from item where id="+id;
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setAuthor1(rs.getString(3));
				a.setAutthor2(rs.getString(4));
				a.setAutthor3(rs.getString(5));
				a.setField(rs.getString(6));
				a.setPublisher(rs.getString(7));
				a.setPublishYear(rs.getString(8));
				a.setBudget(rs.getfloat(9));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return a;
	}

	
	
	
	public void create(Research a1) {
		
		String sql = "insert into reserch values (?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setString(3, a1.getAuthor1());
			st.setString(4, a1.getAuthor2());
			st.setString(5, a1.getAuthor3());
			st.setString(6, a1.getField());
			st.setString(7, a1.getPublisher());
			st.setString(8, a1.getPublishyear());
			st.setfloat(9, a1.getBudget());
		
			
			
			
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	
	
	public void update(Research a1) {
		
		String sql = "update reserch set name=?,author1=?, author2=?, author3=?, field=?, publisher=?, publishyear=?, budget=?, where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
				
			st.setString(1, a1.getName());
			st.setString(2, a1.getAuthor1());
			st.setString(3, a1.getAuthor2());
			st.setString(4, a1.getAuthor3());
			st.setString(5, a1.getField());
			st.setString(6, a1.getPublisher());
			st.setString(7, a1.getPublishyear());
			st.setfloat(8, a1.getBudget());
			st.setInt(9, a1.getId());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}

	public void delete(int id) {
		
		String sql = "delete from reserch where id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}

	
}
