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
public class Librarian {
	// instance fields
	private String username; // librarian's username
	private String password; // librarian password to have access to this application
	
	/**
	 * Initializes the librarian and sets all of its fields
	 * 
	 */
	public Librarian(String username, String password) {
		this.username = username;
		this.password = password;
	}
	/**
	 * Validates that the password for the librarian is correct
	 * 
	 * @return boolean
	 */
	public boolean checkPassword(String password) {
		boolean isPassword = false;
		if(this.password.equals(password)) {
			isPassword = true;
		}
		return isPassword;
	}
	/**
	 * Retrieves the usesrname of the librarian
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}
}
