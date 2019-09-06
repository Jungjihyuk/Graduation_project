package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.UserInfoBean;

public class UserInfoDAO {
	Connection con; 
	PreparedStatement pstmt; 
	ResultSet rs; 
	
private static UserInfoDAO instance;
	
	public static UserInfoDAO getInstance() {
		if(instance==null)instance=new UserInfoDAO();
		return instance;
	}
	
	public UserInfoDAO() {
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
	
	public void insertUserInfo(UserInfoBean userinfobean) {
		String sql="insert into userinfo values(?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNull(1, userinfobean.getInfoNum());
			pstmt.setString(2, userinfobean.getUserId());
			pstmt.setString(3, userinfobean.getUserPhoto());
			pstmt.setString(4, userinfobean.getCategory());
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
	
	public String selectCategory(String userid) {//해당 아이디가 갖고 있는 카테고리 모두 반환
		String sql="select category from userinfo where userId=?";
		String category=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				category=rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	//아직 미완성
	public void updateCategory(String interest, String userId) {
		String sql="update userinfo set category=? where userid=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, interest);
			pstmt.setString(2, userId);
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
