package com.psci.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MySQLDatabaseUtil {
	
	public Connection conn;
	public String mysqlDriver;
	public String url;
	public String databaseName;
	public String username;
	public String password;
	
	MySQLDatabaseUtil()
	{
		
		mysqlDriver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://50.115.123.196:3306/";
		databaseName = "vitreos_cms_demo";
		username = "psci";
		password = "psci";
		
	}
		
	public void retrieveData()
	{
		
		try 
		{
			System.out.println(mysqlDriver);
			//System.out.println(url);
			
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url+databaseName, username, password);
			//System.out.println("conn...." + conn);
			
			Statement ste = conn.createStatement();
			ResultSet rs = ste.executeQuery("Select * from dimensions_list");
			
			//System.out.println(rs.getClass());
			
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getString(6) + "\t");
				System.out.print(rs.getString(7) + "\t");
				System.out.print(rs.getString(8) + "\t");
				System.out.print(rs.getString(9) + "\t");
				System.out.print(rs.getString(10) + "\t");
				System.out.print(rs.getString(11) + "\t");
				System.out.print(rs.getString(12) + "\t");
				System.out.print(rs.getString(13) + "\t");
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch(SQLException e){
			e.printStackTrace();
			
		} catch(Exception e){
			e.printStackTrace();
			
		} finally{
			
			if(conn!=null){
				conn=null;
				//conn.close();
				
			}
		}
		
	}
	
	public static void main(String[] args){
		
		//retrieveData();
		
		MySQLDatabaseUtil data = new MySQLDatabaseUtil();
		data.retrieveData();
		
		
	}

}


