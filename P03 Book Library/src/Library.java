
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Book.java
// Files:           N/A
// Course:          CS 300, Spring 2019
//
// Author:          Lenea Guse
// Email:           laguse@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:        	Mouna assisted me to find the Zybooks print out error
// Online Sources:  N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

// instance fields
	private String address; // Street address of this library
	private Librarian librarian; // this library's librarian. This library must have only ONE
									// librarian
	private ArrayList<Book> books; // list of the books in this library
	private ArrayList<Subscriber> subscribers; // list of this library's subscribers

	public Library(String address, String librarianUsername, String librarianLogin) {
		this.address = address;

		librarian = new Librarian(librarianUsername, librarianLogin);
		books = new ArrayList<Book>();
		subscribers = new ArrayList<Subscriber>();

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
		// create a new library object
		Library madisonLibrary = new Library("Madison, WI", "april", "abc");
		// read and process user command lines
		madisonLibrary.readProcessUserCommand(scanner);
		displayGoodByeLogoutMessage(); // display good bye message
		scanner.close();// close this scanner
	}

	/**
	 * Adds a book to the library
	 * 
	 * @return nothing
	 */
	public void addBook(String title, String author) {
		//creates a new book instance
		Book book = new Book(title, author);
		//adds the book to the book arraylist
		books.add(book);
	}
	/**
	 * Adds a new subscriber to the library system
	 * 
	 * @return nothing
	 */
	public void addSubscriber(String name, int pin, String address, String phoneNumber) {
		//initializes a new instance of a subscriber
		Subscriber sub = new Subscriber(name, pin, address, phoneNumber);
		//adding the subscriber to the subscriber arraylist
		subscribers.add(sub);
		System.out.print("Library card with bar code " + sub.getCARD_BAR_CODE()
				+ " is successfully issued to the new subscriber " + name + ".");
	}
	/**
	 * Prints out a list of books that are available in the library
	 * 
	 * @return nothing
	 */
	public static void displayBooks(ArrayList<Book> books) {
		// Traverse the list of books and display book id, title, author, and
		// availability of each book
		for (int i = 0; i < books.size(); i++) {
			System.out.print("<Book ID>: " + books.get(i).getID() + " ");
			System.out.print("<Title>: " + books.get(i).getTitle() + " ");
			System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
			System.out.println("<Is Available>: " + books.get(i).isAvailable());
		}
	}
	/**
	 * Searches for a specified book with the given book id
	 * 
	 * @return book
	 */
	public Book findBook(int bookId) {
		//scans through the book array
		for (int i = 0; i < books.size(); i++) {
			//finds the book that has the same id
			if (books.get(i).getID() == bookId) {
				return books.get(i);
			}
		}
		return null;

	}
	/**
	 * Scans through the array of books and returns a list of books
	 * that has the author that is being searched for
	 * 
	 * @return an arraylist of books
	 */
	public ArrayList<Book> findBookByAuthor(String author) {
		//creates a new arraylist to place the books in
		ArrayList<Book> authorList = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			//if the book at position i is the book being searched for
			if (books.get(i).getAuthor().equals(author)) {
				//adds the book to the created array
				authorList.add(books.get(i));
			}
		}
		return authorList;

	}
	/**
	 * Scans through the array of books to find books
	 * with the given title
	 * 
	 * @return an arraylist of books
	 */
	public ArrayList<Book> findBookByTitle(String title) {
		//creates a new arraylist to place the books in
		ArrayList<Book> titleList = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			//checks if the book at position i is the book being looked for
			if (books.get(i).getTitle() == title) {
				//adds the book to the arraylist
				titleList.add(books.get(i));
			}
		}
		return titleList;
	}
	/**
	 * Finds a subscriber with the given card barcode by scanning through
	 * an arraylist of subscribers
	 * 
	 * @return the subscriber
	 */
	public Subscriber findSubscriber(int cardBarCode) {
		for (int i = 0; i < subscribers.size(); i++) {
			//searches for the subscriber being searched for
			if (subscribers.get(i).getCARD_BAR_CODE() == cardBarCode) {
				//returns that subscriber once found
				return subscribers.get(i);
			}
		}
		return null;

	}
	/**
	 * Gets the address of the library
	 * 
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}
	/**
	 * Gets the librarian
	 * 
	 * @return nothing
	 */
	public Librarian getLibrarian() {
		return this.librarian;
	}
	/**
	 * Removes the specified book from the library
	 * 
	 * @return book
	 */
	public Book removeBook(int bookId) {
		//scans through the book arraylist
		for (int i = 0; i < books.size(); i++) {
			//checks if the book id is the same as the specified one
			if (books.get(i).getID() == bookId) {
				Book book = books.get(i);
				//removes book
				books.remove(i);
				return book;
			}
		}
		return null;

	}

	/**
	 * Reads and processes the user commands with respect to the menu of this
	 * application
	 * 
	 * @param scanner Scanner object used to read the user command lines
	 */
	public void readProcessUserCommand(Scanner scanner) {
		final String promptCommandLine = "ENTER COMMAND: ";
		displayMainMenu(); // display the library management system main menu
		System.out.print(promptCommandLine);
		String command = scanner.nextLine(); // read user command line
		String[] commands = command.trim().split(" "); // split user command
		while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
			switch (commands[0].trim().charAt(0)) {
			case '1': // login as librarian commands[1]: password
				if (this.librarian.checkPassword(commands[1])) {
					// read and process librarian commands
					readProcessLibrarianCommand(scanner);
				} else { // error password
					System.out.println("Error: Password incorrect!");
				}
				break;
			case '2': // login as subscriber commands[1]: card bar code
				Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
				if (subscriber != null) {
					if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
						// read and process subscriber commands
						readProcessSubscriberCommand(subscriber, scanner);
					else
						System.out.println("Error: Incorrect PIN.");
				}
				break;
			}
			// read and split next user command line
			displayMainMenu(); // display the library management system main menu
			System.out.print(promptCommandLine);
			command = scanner.nextLine(); // read user command line
			commands = command.trim().split(" "); // split user command line
		}
	}

	/**
	 * Reads and processes the librarian commands according to the librarian menu
	 * 
	 * @param scanner Scanner object used to read the librarian command lines
	 */
	private void readProcessLibrarianCommand(Scanner scanner) {
		final String promptCommandLine = "ENTER COMMAND: ";
		boolean a = true;
		while (a) {
			//display the menu
			displayLibrarianMenu();
			System.out.print(promptCommandLine);
			//take in command
			String command = scanner.nextLine();
			//seperate commands
			String[] commands = command.trim().split(" ");
			switch (commands[0].trim().charAt(0)) {
			case '1': // Add a new book [1]
				//adds a new book with the given title and author
				addBook(commands[1], commands[2]);
				System.out.println("Book with Title " + commands[1] + " is successfully added to the library.");
				break;
			case '2': // add a new subscriber [2]
				//parses the pin that was given
				int pin = Integer.parseInt(commands[2]);
				//adds subscribers with given info
				addSubscriber(commands[1], pin, commands[3], commands[4]);
				break;
			case '3': // checkout a book
				//parses the book id given
				int bookId = Integer.parseInt(commands[2]);
				//parses the borrow card number given
				Integer borrowCard = Integer.parseInt(commands[1]);
				//searches for book
				Book book = findBook(bookId);
				//finds the subscriber
				Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
				//checksout the book for the subscriber given
				subscriber.checkoutBook(book);
				//registers the book as taken
				book.borrowBook(borrowCard);
				break;
			case '4': // return a book
				//parses the book id given
				bookId = Integer.parseInt(commands[2]);
				//finds specified book
				book = findBook(bookId);
				//find the specified the subscriber
				subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
				//returns book
				subscriber.returnBook(book);
				break;
			case '5': // display personal info of a subscriber
				//finds specified subscriber
				subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
				//displays info about subscriber
				subscriber.displayPersonalInfo();
				break;
			case '6': // display books checked out by a subscriber
				//finds specified subscriber
				subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
				//displays checked out books for the subscriber
				subscriber.displayBooksCheckedOut();
				break;
			case '7': // display all books
				displayBooks(books);
				break;
			case '8': // remove a book
				//parses the book id given
				bookId = Integer.parseInt(commands[1]);
				//removes specified book
				removeBook(bookId);
				break;
			case '9': // logout
				a = false;
				break;
			}
		}
	}

	/**
	 * Reads and processes the subscriber commands according to the subscriber menu
	 * 
	 * @param subscriber Current logged in subscriber
	 * @param scanner    Scanner object used to read the librarian command lines
	 */
	private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
		final String promptCommandLine = "ENTER COMMAND: ";
		boolean a = true;
		while (a) {
			displaySubscriberMenu();
			System.out.print(promptCommandLine);
			//takes in user command
			String command = scanner.nextLine();
			//puts it into array to be interpreted
			String[] commands = command.trim().split(" ");
			switch (commands[0].trim().charAt(0)) {
			case '1': // checkout book
				//parses the book id given
				int bookId = Integer.parseInt(commands[1]);
				//finds specified book
				Book book = findBook(bookId);
				//checks out the book
				subscriber.checkoutBook(book);
				break;
			case '2': // return a book
				//parses the book id given
				bookId = Integer.parseInt(commands[1]);
				//finds specified book
				book = findBook(bookId);
				//returns book for subscriber
				subscriber.returnBook(book);
				break;
			case '3': // search a book by its title
				//creates a new arraylist for the titles being searched for
				ArrayList<Book> titleList = new ArrayList<Book>();
				//finds the books
				titleList = findBookByTitle(commands[1]);
				//displays the arraylist of books
				displayBooks(titleList);
				break;
			case '4': // search a book by its author
				//creates a new array list for the authors being searched for
				ArrayList<Book> authorList = new ArrayList<Book>();
				//find the books
				authorList = findBookByAuthor(commands[1]);
				//diplay the books found
				displayBooks(authorList);
				break;
			case '5': // print a list of books checked out
				subscriber.displayBooksCheckedOut();
				break;
			case '6': // print history of returned books
				subscriber.displayHistoryBooksReturned();
				break;
			case '7': // update address
				subscriber.setAddress(commands[1]);
				break;
			case '8': // update phone number
				subscriber.setPhoneNumber(commands[1]);
				break;
			case '9': // logout
				a = false;
				break;
			}
		}

	}

	/**
	 * Displays the main menu for this book library application
	 */
	private static void displayMainMenu() {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("     Welcome to our Book Library Management System");
		System.out.println("--------------------------------------------------------");
		System.out.println("Enter one of the following options:");
		System.out.println("[1 <password>] Login as a librarian");
		System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
		System.out.println("[3] Exit"); // Exit the application
		System.out.println("--------------------------------------------------------");
	}

	/**
	 * Displays the menu for a Subscriber
	 */
	private static void displaySubscriberMenu() {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("    Welcome to Subscriber's Space");
		System.out.println("--------------------------------------------------------");
		System.out.println("Enter one of the following options:");
		System.out.println("[1 <book ID>] Check out a book");
		System.out.println("[2 <book ID>] Return a book");
		System.out.println("[3 <title>] Search a Book by title");
		System.out.println("[4 <author>] Search a Book by author");
		System.out.println("[5] Print list of books checked out");
		System.out.println("[6] Print history of returned books");
		System.out.println("[7 <address>] Update address");
		System.out.println("[8 <phone number>] Update phone number");
		System.out.println("[9] Logout");
		System.out.println("--------------------------------------------------------");
	}

	/**
	 * Displays the menu for the Librarian
	 */
	private static void displayLibrarianMenu() {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("    Welcome to Librarian's Space");
		System.out.println("--------------------------------------------------------");
		System.out.println("Enter one of the following options:");
		System.out.println("[1 <title> <author>] Add new Book");
		System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
		System.out.println("[3 <card bar code> <book ID>] Check out a Book");
		System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
		System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
		System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
		System.out.println("[7] Display All Books");
		System.out.println("[8 <book ID>] Remove a Book");
		System.out.println("[9] Logout");
		System.out.println("--------------------------------------------------------");
	}

	/**
	 * Display the Application GoodBye and logout message.
	 */
	private static void displayGoodByeLogoutMessage() {
		System.out.println("\n--------------------------------------------------------");
		System.out.println("       Thanks for Using our Book Library App!!!!");
		System.out.println("--------------------------------------------------------");
	}
}
