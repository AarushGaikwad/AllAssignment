package com.sunbeam.cpmc;

public class BookPojo {
	private int id;
	private String name;
	private String author;
	private String subject;
	private Double price;
	
	public BookPojo() {
		
	}

	public BookPojo(int id, String name, String author, String subject, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price="
				+ price + "]";
	}
	
	
}
