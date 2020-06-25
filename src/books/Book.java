package books;
import general.ReadInLibrary;
import members.LibraryMember;

public abstract class Book implements ReadInLibrary{
	protected int bookID;
	protected String bookType;
	protected boolean isTaken;
	protected LibraryMember whoHas = null;
	
	public Book() {
		
	}
	public Book(int bookID, String bookType) {
		this.bookID = bookID;
		this.bookType = bookType;

	}


public abstract void returnBook(LibraryMember member) ;
	@Override	
	public String toString(){
	return this.bookID+"";
	}
		
	public int getBookID() {
		return bookID;
	}
	public String getBookType() {
		return bookType;
	}
	public boolean isTaken() {
		return isTaken;
	}
	public LibraryMember getWhoHas() {
		return whoHas;
	}
	

}
