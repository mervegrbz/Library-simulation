package general;
import members.LibraryMember;

public interface Borrow {
	public void borrowBook(LibraryMember member,int tick);
	public void extend(LibraryMember member, int tick);
	
}
