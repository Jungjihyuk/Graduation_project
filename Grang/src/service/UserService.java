package service;

import dao.UserDAO;
import model.UserBean;

public class UserService {
	private UserDAO userdao;
	
	public UserService() {
		userdao=UserDAO.getInstance();
	}
	
	public boolean signup(String name, String id, String password, String passwordchk) {
		if(userdao.selectId(id)==0&&password.equals(passwordchk)==true){
			UserBean userbean=new UserBean();
			userbean.setUserName(name);
			userbean.setId(id);
			userbean.setPassword(password);
			userdao.insertUser(userbean);
			return true;
		}else {
			return false;
		}
	}
	public int login(String id, String password) {
		UserBean userbean=userdao.selectOne(id);
		if(userbean==null) {
			return 0; //존재하지 않는 아이디
		}else {
			if(userbean.getPassword().equals(password)) {
				return 1;//로그인 성공
			}else {
				return 2;//비밀번호가 틀린경우
			}
		}
	}
	
	public void updateCategory() {
		
	}
	
	public void updateMyphoto() {
		
	}
}
