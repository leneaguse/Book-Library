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
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;

public class BookLibraryTests {
	public static void main(String[] args) {
		System.out.println(testBookConstructorGetters());
		System.out.println(testBookReturnBook());
		System.out.println(testSubscriberCheckoutBook());
	}
	/**
	 * tests if the book constructors set the fields and get the fields correctly
	 * 
	 * @return boolean
	 */
	public static boolean testBookConstructorGetters() {
		boolean test1 = false;
		//creates a new book instance
		Book book = new Book("Hello", "hi");
		//gets the title
		String title = book.getTitle();
		//gets the author
		String author = book.getAuthor();
		//gets the borrower card for the book
		Integer borrowerCard = book.getBorrowerCardBarCode();
		//gets the id card for the book
		int idCard = book.getID();
		//ensures the fields are as they should be
		if (title.equals("Hello") && author.equals("hi") && borrowerCard == null && idCard == 1) {
			test1 = true;
		}
		return test1;
	}
	/**
	 * Tests if a book was correctly returned
	 * 
	 * @return boolean
	 */
	public static boolean testBookReturnBook() {
		ArrayList<Book> books = new ArrayList<Book>();
		boolean test2 = false;
		//initializes a new book
		Book book = new Book("Hi", "hello");
		//adds it to the book arraylist
		books.add(book);
		//creates a new subscriber
		Subscriber subscriber = new Subscriber("Josh", 1111, "Madison", "8951346432");
		//sets the borrower code for the book
		book.setBorrowerCardBarCode(subscriber.getCARD_BAR_CODE());
		//returns the book from the subscriber
		subscriber.returnBook(book);
		//checks to make sure book was returned
		if (book.getBorrowerCardBarCode() == null) {
			test2 = true;
		}

		return test2;
	}
	/**
	 * Tests the subscribers ability to check out
	 * 
	 * @return boolean
	 */
	public static boolean testSubscriberCheckoutBook() {
		boolean test3 = false;
		ArrayList<Book> books = new ArrayList<Book>();
		//initializes a new subscriber
		Subscriber subscriber = new Subscriber("Josh", 1111, "Madison", "8951346432");
		//initializes a new book
		Book book = new Book("Hi", "hello");
		//adds the book to the array
		books.add(book);
		//checks out the book
		subscriber.checkoutBook(book);
		//checks to make sure the book was checked out
		if (book.getBorrowerCardBarCode() != null) {
			test3 = true;
		}
		return test3;
	}

}
