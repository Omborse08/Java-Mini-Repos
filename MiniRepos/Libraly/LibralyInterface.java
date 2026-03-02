package Libraly;
import java.util.*;
interface LibralyInterface{
    boolean addBook(Book book);
    boolean registerember(Member member);
    boolean borrowBook(int memberid, int bookid);
    int returnBook(int memberid, int bookid, int days);
    void showAvailableBooks();
    void showBorrowedBooks();
}

class Management implements LibralyInterface {
    HashMap<Integer,Book> books = new HashMap<>();
    HashMap<Integer,Member> members = new HashMap<>();
    HashMap<Integer, LinkedList<Member>> waitingQueue = new HashMap<>();

    @Override
    public boolean addBook(Book book) {
        if (book != null) {
            books.put(book.getBookid(),book);
            return true;
        }
        return false;
    }

    @Override
    public boolean registerember(Member member) {
        if (member != null) {
            members.put(member.getMemberid(),member);
            return true;
        }
        return false;
    }

    @Override
    public boolean borrowBook(int memberid, int bookid) {
        if (!members.containsKey(bookid) && !books.containsKey(bookid)) {
            return false;
        }
        if (books.get(bookid).isAvailable()) {
            members.get(memberid).setBorrowedBooks(books.get(bookid));
            books.get(bookid).NotAvailable();
            return true;
        }

        LinkedList<Member> queue = waitingQueue.get(bookid);

        if (queue == null) {
                queue = new LinkedList<>();
                waitingQueue.put(bookid,queue);
        }
        if (!queue.contains(members.get(memberid))) {
            queue.add(members.get(memberid));
            return true;
        }
        return false;
    }


    @Override
    public int returnBook(int memberid, int bookid, int days) {
        if (!books.containsKey(bookid) || !members.containsKey(memberid)) {
            return -1;
        }

        Book book = books.get(bookid);
        Member member = members.get(memberid);

        if (!member.getBorrowedBooks().contains(book)) {
            return -1;
        }

        member.getBorrowedBooks().remove(book);

        int pay = books.get(bookid).calculateLateFee(days);

        if (waitingQueue.containsKey(bookid)) {
            LinkedList<Member> queue = waitingQueue.get(bookid);

            if (!queue.isEmpty()) {
                queue.removeFirst().setBorrowedBooks(book);

                if (queue.isEmpty()) {
                    waitingQueue.remove(bookid);
                }
                return pay;
            }
        }
        book.YesAvailable();
        return pay;
    }

    @Override
    public void showAvailableBooks() {
        if (!books.isEmpty()) {
            for (int i: books.keySet()) {
                Book b = books.get(i);
                if (b.isAvailable()) {
                    System.out.println("ID: "+b.getBookid()+", Title: "+b.getTitle()+", Author: "+b.getAuthor());
                }
            }
        }
    }

    @Override
    public void showBorrowedBooks() {
        if (!books.isEmpty()) {
            for (int i: books.keySet()) {
                Book b = books.get(i);
                if (!b.isAvailable()) {
                    System.out.println("ID: "+b.getBookid()+", Title: "+b.getTitle()+", Author: "+b.getAuthor());
                }
            }
        }
    }

}
