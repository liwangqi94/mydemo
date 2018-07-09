package com.njbdqn.mydemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.njbdqn.mydemo.db.DbUtil;
import com.njbdqn.mydemo.entity.Userinfos;

public class UserinfosDAO {
	private DbUtil util;

	public UserinfosDAO() {
		this.util = new DbUtil();
	}
	
	private List<Userinfos> resultToArray(String sql,Object[] params){
		ResultSet rSet = util.query(sql, params);
		List<Userinfos> uss = new ArrayList<Userinfos>();
		try {
			while(rSet.next()) {
				Userinfos userinfos = new Userinfos();
				userinfos.setId(rSet.getInt(1));
				userinfos.setUsername(rSet.getString("username"));
				userinfos.setBirthday(rSet.getDate("birthday"));
				uss.add(userinfos);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uss;
	}
	
	public List<Userinfos> findAll(){
		String sql="select * from userinfos";
		return resultToArray(sql, new Object[]{});
	}
	
	public List<Userinfos> findUserByName(String name) {
		String sql ="select * from userinfos where username like ?";
		return resultToArray(sql, new Object[]{"%"+name});
	}
}
