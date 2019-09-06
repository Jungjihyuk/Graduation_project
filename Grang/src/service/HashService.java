package service;

import model.HashBean;
import dao.HashDAO;

public class HashService {

	private HashDAO hashdao;
	
	public HashService() {
		hashdao=HashDAO.getInstance();
	}
	
	public HashBean uploadBoard(String hash, int boardNum) {
		HashBean hashbean=new HashBean();
		hashbean.setBoardNum(boardNum);
		hashbean.setHash(hash);
		hashdao.setHash(hashbean);
		return hashbean;
	}
	
	public boolean deleteHash(int boardNum) {
		hashdao.deleteHash(boardNum);
		return true;
	}
	
	public void updateHash(String hash, int boardNum) {
		hashdao.updateHash(hash, boardNum);
	}
	/*
	public boolean updateHash(String hash, int boardNum) {
		if(hashdao.updateHash(hash, boardNum)==true) {
			return true;
		}else {
			return false;
		}
	}
	*/
}
