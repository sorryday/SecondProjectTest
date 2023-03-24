package com.gumi.enjoytrip.hotplaceDto;

import java.sql.Date;

public class HotPlaceDTO {
	private int id;
	private String title;
	private String content;
	private Date date;
	private String file_name;
	private String user_id;
	
	public HotPlaceDTO() {}
	public HotPlaceDTO(int id, String title, String content, Date date, String file_name, String user_id) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.file_name = file_name;
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
