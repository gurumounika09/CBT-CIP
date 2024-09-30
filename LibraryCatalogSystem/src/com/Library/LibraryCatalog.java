package com.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
	List<Book> books = new ArrayList<Book>();

	public void addBook(int id, String bname, String author, int year, String description) {
		books.add(new Book(id, bname, author, year, description));
		System.out.println("Book added Successfully!");
	}

	public void listAllBooks() {
		if (books.isEmpty()) {
			System.out.println("No books available in the catalog.");
		} else {
			for (Book book : books) {
				System.out.println(book);
			}
		}
	}

	public void searchByTitle(String searchTitle) {
		boolean found = false;
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(searchTitle)) {
				System.out.println(book);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No book found with the title: " + searchTitle);
		}

	}

	public void searchByAuthor(String author) {
		boolean found = false;
		for (Book book : books) {
			if (book.getAuthor().equalsIgnoreCase(author)) {
				System.out.println(book);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No book found with the title: " + author);
		}

	}

}
