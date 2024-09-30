package com.Library;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LibraryCatalog catalog = new LibraryCatalog();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.println(
					"1.Add new book 2.Search for books by title 3.Search for books by author 4.List all Books 5.Exit");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter the Book id: ");
				int id = scanner.nextInt();

				System.out.println("Enter the Book title: ");
				String bname = scanner.next();

				System.out.println("Enter the Author Name: ");
				String author = scanner.next();

				System.out.println("Enter the publication year: ");
				int year = scanner.nextInt();

				System.out.println("Enter the Description: ");
				String description = scanner.next();

				catalog.addBook(id, bname, author, year, description);
				break;
			case 2:
				System.out.println("Enter the Book title: ");
				String searchTitle = scanner.next();
				catalog.searchByTitle(searchTitle);
				break;
			case 3:
				System.out.println("Enter the book author name: ");
				String author1 = scanner.nextLine();
				catalog.searchByAuthor(author1);
				break;
			case 4:
				catalog.listAllBooks();
				break;
			case 5:
				running = false;
				System.out.println("Exiting the system.GoodBye!");
				break;
			default:
				System.out.println("Invalid Choice! Please try again.");

			}
		}

	}

}
