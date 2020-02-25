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
public class Book {

// class/static fields
	private static int nextId = 1; // class variable that represents the identifier of the next
									// book
// Instance fields
	private final int ID; // unique identifier of this book
	private String author; // name of the author of this book
	private String title; // title of this book
	private Integer borrowerCardBarCode; // card bar code of the borrower of this book
											// When borrowerCardBarCode == null, the book is available
											// (no one has the book)

	/**
	 * Construct a new Book object and initialize its instance fields
	 */
	public Book(String title, String author) {
		// initializes field for instance book
		this.title = title;
		this.author = author;
		this.borrowerCardBarCode = null;
		this.ID = nextId;
		// increment the next ID
		nextId += 1;
	}

	/**
	 * Records the borrower's card bar code of this book if the book is available.
	 * If this book is not available, this method does nothing.
	 * 
	 * @return nothing
	 */
	public void borrowBook(Integer borrowerCardBarCode) {
		boolean canBorrow = isAvailable();
		if (canBorrow == true) {
			this.borrowerCardBarCode = borrowerCardBarCode;
		}
		// book not available
	}

	/**
	 * Retrieves the author name for the book instance
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Retrieves the Borrower Bar Code for the book instance
	 * 
	 * @return borrower bar code
	 */
	public Integer getBorrowerCardBarCode() {
		return this.borrowerCardBarCode;

	}

	/**
	 * Retrieves the ID number for the book instance
	 * 
	 * @return book ID
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * Retrieves the title of the book instance
	 * 
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Checks if the book is available to be checked out
	 * 
	 * @return boolean
	 */
	public boolean isAvailable() {
		boolean canBorrow = false;
		// checks if the borrowerBarCode is null and if yes, it can be checked out
		if (this.borrowerCardBarCode == null) {
			canBorrow = true;
		}
		return canBorrow;
	}

	/**
	 * Allows for a book to be returned
	 * 
	 * @return nothing
	 */
	public void returnBook() {
		// sets the borrowerCardBarCode to null, so that it becomes available
		this.borrowerCardBarCode = null;
	}

	/**
	 * Sets the title field of a book instance
	 * 
	 * @return nothing
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the Author field of a book instance
	 * 
	 * @return nothing
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Sets the Borrower Bar Code for the book instance
	 * 
	 * @return nothing
	 */
	public void setBorrowerCardBarCode(Integer borrowerCardBarCode) {
		this.borrowerCardBarCode = borrowerCardBarCode;

	}
}
