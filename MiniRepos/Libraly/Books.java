package Libraly;

abstract class Book{
    private int bookid;
    private String title;
    private String author;
    private boolean isAvailable;

    Book(int bookid,String title,String author) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void NotAvailable() {
        this.isAvailable = false;
    }

    public void YesAvailable() {
        this.isAvailable = true;
    }

    public int getBookid() {
        return bookid;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    abstract int calculateLateFee(int day);
}

class FictionBook extends Book {
    static final int perDay = 10;

    FictionBook(int bookid,String title,String author) {
        super(bookid,title,author);
    }

    @Override
    int calculateLateFee(int day) {
        return day * perDay;
    }
}

class AcademicBook extends Book {
    static final int perDay = 5;

    AcademicBook(int bookid,String title,String author) {
        super(bookid,title,author);
    }

    @Override
    int calculateLateFee(int day) {
        return day * perDay;
    }
}



