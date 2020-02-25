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
public class Subscriber {
	// static fields
	private final static int MAX_BOOKS_CHECKED_OUT = 10; // maximum number of books to be checked out
	                                                     // one subscriber
	private static int nextCardBarCode = 2019000001; // class variable that represents the card bar
	                                                  // code of the next subscriber to be created
	// Instance fields
	private int pin; // 4-digits Personal Identification Number to verify the identity of this
	                 // subscriber
	private final Integer CARD_BAR_CODE; // card bar code of this subscriber
	 
	private String name; // name of this subscriber
	private String address; // address of this subscriber
	private String phoneNumber; // phone number of this subscriber
	 
	private ArrayList<Book> booksCheckedOut; // list of books checked out by this subscriber and not yet
	                                            // returned. A subscriber can have at most 10 checked out books
	private ArrayList<Book> booksReturned; // list of the books returned by this subscriber
	
	/**
	 * Constructs a new Subscriber object and initializes its instance fields
	 */
	public Subscriber (String name, int pin, String address, String phoneNumber) {
		this.name = name;
		this.pin = pin;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.CARD_BAR_CODE = nextCardBarCode;
		booksCheckedOut = new ArrayList<Book>();
		booksReturned = new ArrayList<Book>();
		nextCardBarCode += 1;
	}
	/**
	   * Checks if this subscriber booksCheckedOut list contains a given book
	   * @param book book to check if it is within this subscriber booksCheckedOut list
	   * @return true if booksCheckedOut contains book, false otherwise
	   */
	  public boolean isBookInBooksCheckedOut(Book book) {
	    return booksCheckedOut.contains(book);
	  }
	 
	  /**
	   * Displays the list of the books checked out and not yet returned
	   */
	  public void displayBooksCheckedOut() {
	    if (booksCheckedOut.isEmpty()) // empty list
	      System.out.println("No books checked out by this subscriber");
	    else
	      // Traverse the list of books checked out by this subscriber and display its content
	      for (int i = 0; i < booksCheckedOut.size(); i++) {
	        System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
	        System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
	        System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
	      }
	  }
	 
	  /**
	   * Displays the history of the returned books by this subscriber
	   */
	  public void displayHistoryBooksReturned() {
	    if (booksReturned.isEmpty()) // empty list
	      System.out.println("No books returned by this subscriber");
	    else
	      // Traverse the list of borrowed books already returned by this subscriber and display its
	      // content
	      for (int i = 0; i < booksReturned.size(); i++) {
	        System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
	        System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
	        System.out.println("Author: " + booksReturned.get(i).getAuthor());
	      }
	  }
	 
	  /**
	   * Displays this subscriber's personal information
	   */
	  public void displayPersonalInfo() {
	    System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
	    System.out.println("  Name: " + name);
	    System.out.println("  Address: " + address);
	    System.out.println("  Phone number: " + phoneNumber);
	  }
	  
	  public void checkoutBook(Book book) {
		  //checks if their number of books checked out is greater than the max allowed
		  if (this.booksCheckedOut.size() > MAX_BOOKS_CHECKED_OUT) {
			  System.out.print("Checkout Failed: You cannot check out more than "
					  + MAX_BOOKS_CHECKED_OUT + "books.");
			  return;
		  }
		  //checks if the book has already been checked out by the subscriber
		  if (this.booksCheckedOut.contains(book)) {
			  System.out.println("You have already checked out " + book.getTitle() + " book.");
			  return;
		  }
		  //checks if the book is available to be checked out
		  if(!(book.isAvailable())) {
			  System.out.println("Sorry, " + book.getTitle() + " is not available.");
			  return;
		  }
		  /**
			 * Sets the Borrower bar code 
			 * 
			 * @return nothing
			 */
		  book.setBorrowerCardBarCode(this.CARD_BAR_CODE);
		  this.booksCheckedOut.add(book);
		  return;
		  
	  }
	  /**
		 * Gets the address of the subscriber
		 * 
		 * @return address
		 */
	  public String getAddress() {
		  String address = "";
		  this.address = address;
		  return address;
	  }
	  /**
		 * Gets the Card Bar Code of the subscriber
		 * 
		 * @return bar code
		 */
	  public Integer getCARD_BAR_CODE() {
		  return this.CARD_BAR_CODE;
	  }
	  /**
		 * Gets the name of the subscriber
		 * 
		 * @return name
		 */
	  public String getName() {
		  return this.name;
	  }
	  /**
		 * Gets the phone number of the subscriber
		 * 
		 * @return phone number
		 */
	  public String getPhoneNumber() {
		  return this.phoneNumber;
	  }
	  /**
		 * Gets the pin of the subscriber
		 * 
		 * @return nothing
		 */
	  public int getPin() {
		  return this.pin;
	  }
	  /**
		 * Scans through the books returned arraylist to see if the user has returned a book
		 * 
		 * @return boolean
		 */
	  public boolean isBookInBooksReturned(Book book) {
		  boolean isReturned = false;
		  //searches for specified book in the books returned arraylist
		  if (this.booksReturned.contains(book)) {
			  isReturned = true;
		  }
		  return isReturned;
	  }
	  /**
		 * Returns a book that the user checked out
		 * 
		 * @return nothing
		 */
	  public void returnBook(Book book) {
		  //removes the specified book from the books checked out arraylist
		  this.booksCheckedOut.remove(book);
		  //adds the specified book to the returned book arraylist
		  this.booksReturned.add(book);
		  book.returnBook();
	  }
	  /**
		 * Sets address of subscriber
		 * 
		 * @return nothing
		 */
	  public void setAddress(String Address) {
		  Address = this.address;
	  }
	  /**
		 * Sets phone number of subscriber
		 * 
		 * @return nothing
		 */
	  public void setPhoneNumber(String phoneNumber) {
		  phoneNumber = this.phoneNumber;
	  }
}
