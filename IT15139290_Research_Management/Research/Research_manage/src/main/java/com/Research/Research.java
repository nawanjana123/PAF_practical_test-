package com.Research;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Research {

	private int id;
	private String Name;
	private String Author1;
	private String Author2;
	private String Author3;
	private String Field;
	private String Publisher;
	private String PublishYear;
	private Float Budget;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor1() {
		return Author1;
	}
	public void setAuthor1(String author1) {
		this.author1 = author1;
	}
	public String getAuthor2() {
		return author2;
	}
	public void setAuthor2(String author2) {
		this.author2 = author2;
	}
	public String getAuthor3() {
		return author3;
	}
	public void setAuthor3(String author3) {
		this.author3 = author3;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisheYear() {
		return publishyear;
	}
	public void setPublishYear(String publishyear) {
		this.publishyear = publishyear;
	}
	public Float getBudget() {
		return budget;
	}
	public void setBudget(Float budget) {
		this.budget = budget;
	}
}
