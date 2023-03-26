package com.gumi.enjoytrip.hotplace.dto;

import java.sql.Date;

public class HotPlaceDTO {
	private int id;
	private String title;
	private String content;
	private int placetype;
	private Date date;
	private String user_id;
	private String latitude;
	private String longitude;

	public HotPlaceDTO() {
		super();
	}

	public HotPlaceDTO(int id, String title, String content, int placetype, Date date, String user_id, String latitude,
			String longitude) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.placetype = placetype;
		this.date = date;
		this.user_id = user_id;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public int getPlacetype() {
		return placetype;
	}

	public void setPlacetype(int placetype) {
		this.placetype = placetype;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
