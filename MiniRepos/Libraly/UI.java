package Libraly;
import java.util.*;
public class UI {
    static void showMenu() {
        System.out.println("1.Add Book\n2.Add Member\n3.Borrow Book\n4.Return Book\n5.Show Available Book\n6.Show Borrowed Books\n7.Exit");
    }
    static void main(String[] args) {
        int StartFromBookID = 101;
        int StartFromMemberId = 201;
        Scanner sc = new Scanner(System.in);
        Management management = new Management();
        boolean isRun = true;
        showMenu();
        while (isRun) {
            System.out.print("Choose Option: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("<+> Add Book In Libraly <+>");
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = sc.nextLine();
                    System.out.println("1.Fictional or 2.Academic");
                    int whichone = sc.nextInt();
                    Book book = null;
                    if (whichone == 1) {
                        book = new FictionBook(StartFromBookID, title, author);
                    } else if (whichone == 2) {
                        book = new AcademicBook(StartFromBookID, title, author);
                    }
                    if (management.addBook(book)) {
                        System.out.println("Book Added Succesfully!");
                        System.out.println("Book ID: " + StartFromBookID++);
                    } else {
                        System.out.println("Book is Not Added!");
                    }
                    break;

                case 2:
                    System.out.println("<+> Registred Member In Libraly <+>");
                    System.out.print("Enter Name Of Member: ");
                    String name = sc.nextLine();
                    Member member = new Member(StartFromMemberId, name);
                    if (management.registerember(member)) {
                        System.out.println("Member Added Successfully!");
                        System.out.println("Member ID: " + StartFromMemberId++);
                    } else {
                        System.out.println("Member is not Added!");
                    }
                    break;

                case 3:
                    System.out.println("<+> Member Can Borrow The Book! <+>");
                    System.out.print("Enter Member ID: ");
                    int memberid1 = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookid1 = sc.nextInt();
                    if (management.borrowBook(memberid1, bookid1)) {
                        System.out.println("Book Borrowed Successfully!");
                    } else {
                        System.out.println("Check Id And Try Again!");
                    }
                    break;

                case 4:
                    System.out.println("<+> Return Book To The Libraly <+>");
                    System.out.print("Enter Member ID: ");
                    int memberid2 = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookid2 = sc.nextInt();
                    System.out.print("Enter How Many Days Was It To You: ");
                    int days = sc.nextInt();
                    int pr = management.returnBook(memberid2, bookid2, days);
                    if (pr != -1) {
                        System.out.println("Book Returned Successfully!");
                        System.out.println("Your Bill IS: " + pr);
                    } else {
                        System.out.println("Check Your ID!");
                    }
                    break;

                case 5:
                    System.out.println("<+> Shows Available Books In Libraly <+>");
                    management.showAvailableBooks();
                    break;

                case 6:
                    System.out.println("<+> Shows Borrowed Books In Libraly <+>");
                    management.showBorrowedBooks();
                    break;

                case 7:
                    System.out.println("Thank You So Much Bye!");
                    isRun = false;
                    break;
            }
        }sc.close();
    }
}
