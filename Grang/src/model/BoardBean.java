package model;

import java.sql.Date;

public class BoardBean {

	private int boardNum;
	private String userId;
	private String category;
	private String photoName;
	private String photoRealName;
	private String content;
	private Date present;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public Date getPresent() {
		return present;
	}
	public void setPresent(Date present) {
		this.present = present;
	}	

}
