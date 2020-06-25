package books;

import java.util.ArrayList;

import general.Borrow;
import general.ReadInLibrary;
import members.LibraryMember;

public class Printed extends Book implements ReadInLibrary, Borrow {
	private int deadLine ;
	private boolean isExtended = false;
	
	public Printed(int bookID) {
		this.bookID = bookID;
		

	}

	public void returnBook(LibraryMember member) {
		if (this.whoHas == member) {
			member.getCurrent().remove(this);
			
			this.whoHas = null;
			this.isExtended = false;
			this.isTaken = false;

		}
	}

	@Override
	public void readBook(LibraryMember member) {
		whoHas = member;
		isTaken = true;
		member.getCurrent().add(this);
		member.getTheHistory().add(this);

	}

	@Override
	public void borrowBook(LibraryMember member, int tick) {
		
		boolean cantake = true;
		for (Book book : member.getCurrent())
			if (book instanceof Printed)
				if (((Printed) book).getDeadLine() <= tick) {
					cantake = false;
					break;
				}
		System.out.println("borrwoing book printed");
		if (!isTaken && (member.getCurrent().size() < member.getMaxNumberOfBooks()) && cantake) {

			isTaken = true;
			member.getTheHistory().add(this);
			member.getCurrent().add(this);
			whoHas = member;
			this.deadLine = tick + member.getTimeLimit();
			System.out.println(this.deadLine);
		}

	}

	@Override
	public void extend(LibraryMember member, int tick) {
		if (tick <= this.deadLine && this.whoHas == member && !this.isExtended) {
			isExtended = true;

			this.deadLine += member.getTimeLimit();

		}

	}

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}

	public boolean isExtended() {
		return isExtended;
	}

	public void setExtended(boolean isExtended) {
		this.isExtended = isExtended;
	}

	

}
