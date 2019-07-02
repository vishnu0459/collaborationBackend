package com.vishnu.collaborationBack.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
	
	
	@Id
	private String blogName;
	private String title;
	private String owner;
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
}
