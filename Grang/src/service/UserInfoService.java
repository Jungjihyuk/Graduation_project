package service;

import dao.UserInfoDAO;
import model.UserInfoBean;

public class UserInfoService {

	private UserInfoDAO userinfodao;
	
	public UserInfoService() {
		userinfodao=UserInfoDAO.getInstance();
	}
	
	public void insertUserInfo(String id) {
		UserInfoBean userinfobean=new UserInfoBean();
		userinfobean.setUserId(id);
		userinfobean.setUserPhoto(null);
		userinfobean.setCategory(null);
		userinfodao.insertUserInfo(userinfobean);
	}
	public String selectCategory(String userId) {
		
		String category=null;
		category=userinfodao.selectCategory(userId);
		return category;
	}
	public void updateCategory(String interest, String userId) {
		userinfodao.updateCategory(interest, userId);
	}
	
}
