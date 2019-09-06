package model;

import java.sql.Date;

public class Viw_boardBean {
	private int boardNum;
	private String userName;
	private String category;
	private String photoName;
	private String photoRealName;
	private String content;
	private String hash;
	private String userId;
	private Date present;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoRealName() {
		return photoRealName;
	}
	public void setPhotoRealName(String photoRealName) {
		this.photoRealName = photoRealName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Date getPresent() {
		return present;
	}
	public void setPresent(Date present) {
		this.present = present;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
