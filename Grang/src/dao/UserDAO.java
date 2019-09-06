package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import model.UserBean;

public class UserDAO {
	Connection con; //데이터베이스에 접근할 수 있도록 설정
	PreparedStatement pstmt; //데이터 베이스에서 쿼리를 실행시켜주는 객체
	ResultSet rs; //데이터베이스의 테이블의 결과를 리턴받아 자바에 저장해주는 객체 
	
	private static UserDAO instance;
	
	public static UserDAO getInstance() {
		if(instance==null)instance=new UserDAO();
		return instance;
	}
	
	
	public UserDAO() {
		try {
			String dbURL="jdbc:mysql://localhost:3306/grangT?useSSL=false";
			String dbID="root";
			String dbPassword="root12345";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//selectId 수정 해야함.
	public int selectId(String id) {
		String sql="select userName from users where id=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return 1; // 있고
			} else {
				return 0; // 없고
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public UserBean selectOne(String id) {
		String sql="select *from users where id=?";
		UserBean userbean=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				userbean=new UserBean();
				userbean.setId(rs.getString("id"));
				userbean.setPassword(rs.getString("password"));
				userbean.setUserName(rs.getString("userName"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null && !pstmt.isClosed())pstmt.close();
				if(rs!=null&&!rs.isClosed())pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return userbean;
	}
	
	public void insertUser(UserBean userbean) {
		String sql="insert into users values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userbean.getId());
			pstmt.setString(2, userbean.getPassword());
			pstmt.setString(3, userbean.getUserName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null&&!pstmt.isClosed())pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
