package service;

import java.util.ArrayList;
import java.util.Vector;

//import dao.UserDAO;
//import model.UserBean;
import dao.Viw_boardDAO;
import model.Viw_boardBean;

public class Viw_boardService {
	private Viw_boardDAO viw_boarddao;
	
	public Viw_boardService() {
		viw_boarddao=Viw_boardDAO.getInstance();
	}
	
	public Vector<Viw_boardBean> userBoard(String category) {
		Vector<Viw_boardBean> list=viw_boarddao.userBoard(category);
		return list;
	}
	public Vector<Viw_boardBean> selectAllBoard() {
		Vector<Viw_boardBean> list=viw_boarddao.selectAllBoard();
		return list;
	}
	public Vector<Viw_boardBean> myBoard(String userId) {
		Vector<Viw_boardBean> list=viw_boarddao.myBoard(userId);
		return list;
	}
	public void removeBoard() {
		
	}
	
	public Vector<Viw_boardBean> updateBoard(int boardNum) {
		Vector<Viw_boardBean> Ulist=viw_boarddao.showUpdateBoard(boardNum);
		return Ulist;
	}
	
	public Vector<Viw_boardBean> searchBoard(String hash) {
		Vector<Viw_boardBean> Slist=viw_boarddao.searchHashBoard(hash);
		return Slist;
	}
	public Vector<Viw_boardBean> categoryList() {		
		Vector<Viw_boardBean> list=viw_boarddao.categoryList();
		return list;
	}
	
}