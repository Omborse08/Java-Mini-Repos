package Libraly;
import java.util.*;

class Member extends LinkedList<Member> {
    private int memberid;
    private String name;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Book setBorrowedBooks(Book borrowedBooks) {
        this.borrowedBooks.add(borrowedBooks);
        return borrowedBooks;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public int getMemberid() {
        return memberid;
    }



    Member(int id,String name) {
        this.memberid = id;
        this.name = name;
    }
}
