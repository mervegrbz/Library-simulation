package members;
import java.util.ArrayList;

import books.Book;

public  abstract class LibraryMember {
	protected int id;
	protected int maxNumberOfBooks;//depends only the member type
	private ArrayList<Book> current= new ArrayList<>();
	
	public ArrayList<Book> getCurrent() {
		return current;
	}
	public void setCurrent(ArrayList<Book> current) {
		this.current = current;
	}
	protected int timeLimit;
	protected ArrayList<Book>TheHistory=new ArrayList<>();
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public ArrayList<Book> getTheHistory() {
		return TheHistory;
	}
	public LibraryMember() {
		
	}
	public int getId() {
		return id;
	}
	public int getMaxNumberOfBooks() {
		return maxNumberOfBooks;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	
}
