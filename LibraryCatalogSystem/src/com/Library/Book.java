package com.Library;

public class Book {
	private int id;
	private String title;
	private String author;
	private int year;
	private String description;

	public Book(int id, String title, String author, int year, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.description = description;
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

	public void setbName(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bName=" + title + ", author=" + author + ", year=" + year + ", description="
				+ description + "]";
	}


}
