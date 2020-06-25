package general;

import java.util.*;

import books.*;

import members.*;

public class Library {
	private Book[] books = new Book[(int) Math.pow(10, 6)];
	public LibraryMember[] members = new LibraryMember[(int) Math.pow(10, 6)];
	public int totalFee;// number of fee
	Scanner input;

	private int numberOfBook = 0;
	private int numberOfMember = 0;

	public Library(Scanner input) {
		this.input = input;

	}

	public void addBook() {
		String bookType = input.next();
		if (bookType.equals("H"))
			books[numberOfBook] = new Handwritten(numberOfBook+1, bookType);
		else
			books[numberOfBook] = new Printed(numberOfBook+1);
		numberOfBook +=1;

	}

	public void addMember() {
		String memberType = input.next();
		if (memberType.equals("A"))
			members[numberOfMember++] = new Academic(numberOfMember+1);
		else {
			members[numberOfMember++] = new Student(numberOfMember+1);

		}

	}

	public void borrowBook(int tick) {
		int Id_of_book = input.nextInt();
		int id_of_member = input.nextInt();
		LibraryMember member = members[id_of_member-1];
		Book borrowedBook = books[Id_of_book-1];
		if (member != null && borrowedBook != null) {
			if (borrowedBook instanceof Handwritten) return;
			((Printed) borrowedBook).borrowBook(member, tick);
		}
	}

	public void returnBook(int tick) {
		int Id_of_book = input.nextInt();
		int id_of_member = input.nextInt();
		LibraryMember member = members[id_of_member-1];
		Book returnedBook = books[Id_of_book-1];
		if (member != null && returnedBook != null) {
			if (returnedBook instanceof Handwritten)
				((Handwritten) returnedBook).returnBook(member);
			else {

				if (  tick > ((Printed) returnedBook).getDeadLine()) {
					int fee = tick -((Printed) returnedBook).getDeadLine() ;
					
					totalFee += fee;

				}
				((Printed) returnedBook).returnBook(member);

			}
		}

	}

	public void extendBook(int tick) {
		int Id_of_book = input.nextInt();
		int id_of_member = input.nextInt();
		LibraryMember member = members[id_of_member-1];
		Book extendBook = books[Id_of_book-1];
		if (member != null && extendBook != null) {
			if (extendBook instanceof Printed)
				((Printed) extendBook).extend(member, tick);
		}

	}

	public void readInLibrary() {
		int Id_of_book = input.nextInt();
		int id_of_member = input.nextInt();
		LibraryMember member = members[id_of_member-1];
		Book readBook = books[Id_of_book-1];
		if(member!=null&& readBook!=null) {
			readBook.readBook(member);
/*
			if (readBook instanceof Handwritten) {
			((Handwritten) readBook).readBook(member);
		} else {
			((Printed) readBook).readBook(member);
		}
		*/
		}

	}

	public int getTotalFee() {
		return totalFee;
	}

	public int getNumberOfBook() {
		return numberOfBook;
	}

	public void setNumberOfBook(int numberOfBook) {
		this.numberOfBook = numberOfBook;
	}

	public int getNumberOfMember() {
		return numberOfMember;
	}

	public void setNumberOfMember(int numberOfMember) {
		this.numberOfMember = numberOfMember;
	}

}
