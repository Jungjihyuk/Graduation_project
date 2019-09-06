package service;

//import dao.UserDAO;
//import model.UserBean;
import dao.BoardDAO;
import dao.HashDAO;
import model.BoardBean;
//import dao.HashDAO;
//import model.HashBean;
//import model.UserBean;

public class BoardService {
	private BoardDAO boarddao;
	private HashDAO hashdao;
	
	public BoardService() {
		boarddao=BoardDAO.getInstance();
		hashdao=HashDAO.getInstance();
	}
	
	public int uploadBoard(String content, String fileName, String fileRealName, String category, String userId) {
		if(content!=null) {
			BoardBean boardbean=new BoardBean();
			boardbean.setContent(content);
			boardbean.setPhotoName(fileName);
			boardbean.setPhotoRealName(fileRealName);
			boardbean.setUserId(userId);
			boardbean.setCategory(category);
			boarddao.insertBoard(boardbean);
			return 1;
		}else{
			return 0;
		}
		
	}
	
	public void removeBoard(int boardNum) {
		if(hashdao.deleteHash(boardNum)==true) {
			boarddao.deleteBoard(boardNum);
		}
	}
	
	public void updateBoard(BoardBean boardbean, int boardNum) {
		boarddao.updateBoard(boardbean, boardNum);
	}
	
	/*
	public boolean updateBoard(BoardBean boardbean, int boardNum) {
		boolean result;
		result=boarddao.updateBoard(boardbean, boardNum);
		if(result==true) {
			return true;
		}else {
			return false;
		}
	}
	*/
}
