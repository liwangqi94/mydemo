package com.njbdqn.mydemo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DbUtil {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/exps";
	private static final String U="root";
	private static final String P="106312";
	
	private Connection conn;
	
	private Connection getConnection()  {
		try {
			if(conn==null) {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, U, P);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public int update(String sql,Object[] params) {
		int count=0;
		try {
			PreparedStatement pstm = getConnection().prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstm.setObject(i+1, params[i]);
			}
			count = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public ResultSet query(String sql,Object[] params) {
		ResultSet rSet=null;
		try {
			PreparedStatement pstm = getConnection().prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstm.setObject(i+1, params[i]);
			}
			rSet = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rSet;
	}
	
	
}
