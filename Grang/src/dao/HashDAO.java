package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.HashBean;


//import java.util.ArrayList;

public class HashDAO {
	Connection con; //데이터베이스에 접근할 수 있도록 설정
	PreparedStatement pstmt; //데이터 베이스에서 쿼리를 실행시켜주는 객체
	ResultSet rs; //데이터베이스의 테이블의 결과를 리턴받아 자바에 저장해주는 객체 
	
	private static HashDAO instance;
	public static HashDAO getInstance() {
		if(instance==null)instance=new HashDAO();
		return instance;
	}
	
	public HashDAO() {
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

	public void setHash(HashBean hashbean) {
		String sql="insert into hash values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, hashbean.getHashId());
			pstmt.setInt(2, hashbean.getBoardNum());
			pstmt.setString(3, hashbean.getHash());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean deleteHash(int boardNum) {
		String sql="delete from hash where boardNum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public void updateHash(String hash,int boardNum) {
		String sql="update hash set hash=? where boardNum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, hash);
			pstmt.setInt(2, boardNum);
			pstmt.executeUpdate();
			System.out.println(hash);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public boolean updateHash(String hash,int boardNum) {
		String sql="update hash set hash=? where boardNum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, hash);
			pstmt.setInt(2, boardNum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	*/
}
