package com.zzu.xingchen.se.entity;

public class MyInformation {
	
	Integer id;
	Integer typer;
	String title;
	String phoneNumber;
	String activeTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTyper() {
		return typer;
	}
	public void setTyper(Integer typer) {
		this.typer = typer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	public String getMyMessage() {
		return myMessage;
	}
	public void setMyMessage(String myMessage) {
		this.myMessage = myMessage;
	}
	String myMessage;
	public MyInformation(Integer id, Integer typer, String title,
			String phoneNumber, String activeTime, String myMessage) {
		super();
		this.id = id;
		this.typer = typer;
		this.title = title;
		this.phoneNumber = phoneNumber;
		this.activeTime = activeTime;
		this.myMessage = myMessage;
	}
	@Override
	public String toString() {
		return "MyInformation [id=" + id + ", typer=" + typer + ", title="
				+ title + ", phoneNumber=" + phoneNumber + ", activeTime="
				+ activeTime + ", myMessage=" + myMessage + "]";
	}

	
	
}
