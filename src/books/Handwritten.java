package books;

import general.*;
import members.Academic;
import members.LibraryMember;

public class Handwritten extends Book implements ReadInLibrary {
	static String type = "H";

	public Handwritten(int bookID, String type) {
		super(bookID, type);

	}

	public Handwritten(int bookID) {
		super();
		this.bookID = bookID;
	}

	public void returnBook(LibraryMember member) {
		if (this.whoHas == member) 
		{
			member.getCurrent().remove(this);
			isTaken = false;
		whoHas = null;
		}

	}

	@Override
	public void readBook(LibraryMember member) {
		if (member instanceof Academic) {
			member.getCurrent().remove(this);
			member.getTheHistory().add(this);
			this.whoHas = member;
			this.isTaken = true;
		}

	}
}
