package dao;
import java.sql.Connection; //인터페이스 connection 객체
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import model.Viw_boardBean;


public class Viw_boardDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static Viw_boardDAO instance;
	
	public static Viw_boardDAO getInstance() {
		if(instance==null)instance=new Viw_boardDAO();
		return instance;
	}
	
	public Viw_boardDAO() {
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
	
	public Vector<Viw_boardBean> myBoard(String userId) {  //전체게시물 보여주기 
		Vector<Viw_boardBean> list=new Vector<Viw_boardBean>();
		String sql="select *from viw_board where userId=? order by present desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Viw_boardBean viw_boardBean=new Viw_boardBean();
				viw_boardBean.setBoardNum(rs.getInt(1));
				viw_boardBean.setUserName(rs.getString(2));
				viw_boardBean.setCategory(rs.getString(3));
				viw_boardBean.setPhotoName(rs.getString(4));
				viw_boardBean.setPhotoRealName(rs.getString(5));
				viw_boardBean.setContent(rs.getString(6));
				viw_boardBean.setHash(rs.getString(7));
				viw_boardBean.setUserId(rs.getString(8));
				viw_boardBean.setPresent(rs.getDate(9));
				list.add(viw_boardBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Vector<Viw_boardBean> userBoard(String category) {//category가 배열로 넘어 온다면? 
		Vector<Viw_boardBean> list=new Vector<Viw_boardBean>();
		String sql="select *from viw_board where category=? order by present desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Viw_boardBean viw_boardBean=new Viw_boardBean();
				viw_boardBean.setBoardNum(rs.getInt(1));
				viw_boardBean.setUserName(rs.getString(2));
				viw_boardBean.setCategory(rs.getString(3));
				viw_boardBean.setPhotoName(rs.getString(4));
				viw_boardBean.setPhotoRealName(rs.getString(5));
				viw_boardBean.setContent(rs.getString(6));
				viw_boardBean.setHash(rs.getString(7));
				viw_boardBean.setUserId(rs.getString(8));
				viw_boardBean.setPresent(rs.getDate(9));
				list.add(viw_boardBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Vector<Viw_boardBean> selectAllBoard() {  //전체게시물 보여주기 
		Vector<Viw_boardBean> list=new Vector<Viw_boardBean>();
		String sql="select *from viw_board order by present desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Viw_boardBean viw_boardBean=new Viw_boardBean();
				viw_boardBean.setBoardNum(rs.getInt(1));
				viw_boardBean.setUserName(rs.getString(2));
				viw_boardBean.setCategory(rs.getString(3));
				viw_boardBean.setPhotoName(rs.getString(4));
				viw_boardBean.setPhotoRealName(rs.getString(5));
				viw_boardBean.setContent(rs.getString(6));
				viw_boardBean.setHash(rs.getString(7));
				viw_boardBean.setUserId(rs.getString(8));
				viw_boardBean.setPresent(rs.getDate(9));
				list.add(viw_boardBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public Vector<Viw_boardBean> searchHashBoard(String hash) {
		Vector<Viw_boardBean> Slist=new Vector<Viw_boardBean>();
		String sql="select *from viw_board where hash like ? order by present desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+hash+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Viw_boardBean viw_boardBean=new Viw_boardBean();
				viw_boardBean.setBoardNum(rs.getInt(1));
				viw_boardBean.setUserName(rs.getString(2));
				viw_boardBean.setCategory(rs.getString(3));
				viw_boardBean.setPhotoName(rs.getString(4));
				viw_boardBean.setPhotoRealName(rs.getString(5));
				viw_boardBean.setContent(rs.getString(6));
				viw_boardBean.setHash(rs.getString(7));
				viw_boardBean.setUserId(rs.getString(8));
				viw_boardBean.setPresent(rs.getDate(9));
				Slist.add(viw_boardBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Slist;
	}
	
	public Vector<Viw_boardBean> categoryList() {
		Vector<Viw_boardBean> list=new Vector<Viw_boardBean>();
		String sql="select distinct category from viw_board";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Viw_boardBean viw_boardBean=new Viw_boardBean();
				viw_boardBean.setCategory(rs.getString(1));
				list.add(viw_boardBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Vector<Viw_boardBean> showUpdateBoard(int boardNum) {  //수정 게시물 보여주기 
		Vector<Viw_boardBean> list=new Vector<Viw_boardBean>();
		String sql="select *from viw_board where boardNum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Viw_boardBean viw_boardBean=new Viw_boardBean();
				viw_boardBean.setBoardNum(rs.getInt(1));
				viw_boardBean.setUserName(rs.getString(2));
				viw_boardBean.setCategory(rs.getString(3));
				viw_boardBean.setPhotoName(rs.getString(4));
				viw_boardBean.setPhotoRealName(rs.getString(5));
				viw_boardBean.setContent(rs.getString(6));
				viw_boardBean.setHash(rs.getString(7));
				viw_boardBean.setUserId(rs.getString(8));
				viw_boardBean.setPresent(rs.getDate(9));
				list.add(viw_boardBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}