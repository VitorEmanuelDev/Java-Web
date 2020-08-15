package br.com.task.manager.servlet;

import java.util.Date;

public class Task {

	private Integer id;
	private String name;
	private Date deadline = new Date();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return name;
	}
	public void setContent(String name) {
		this.name = name;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public Date getDeadline() {
		return deadline;
	}
}
