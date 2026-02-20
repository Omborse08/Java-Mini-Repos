package Collection;
import java.util.*;

class Browser{
    private int count = 0;
    private LinkedList<String> history = new LinkedList<>();

    public void FirstPage() {
        history.addFirst("homepage.com");
    }

    boolean addLink(String url) {
        while (count < history.size() - 1) {
            history.removeLast();
        }
        if (count < history.size()) {
            history.addLast(url);
            count = history.size() - 1;
            return true;
        }
        history.set(count,url);
        return true;
    }

    boolean BackPage() {
        if (count > 0) {
            count--;
            return true;
        }
        return false;
    }

    boolean ForwardPage() {
        if (count < history.size()-1) {
            count++;
            return true;
        }
        return false;
    }

    void showCurrentPage() {
        System.out.println(history.get(count));
    }

    void showFullHistory() {
        for (int i=0;i<history.size();i++) {
            System.out.println(history.get(i));
        }
    }
}

class UI {
    static void showMenu() {
        System.out.println("1. Visit new page\n" +
                "2. Back\n" +
                "3. Forward\n" +
                "4. Show Current Page\n" +
                "5. Show Full History\n" +
                "6. Exit");
    }
    static void main(String[] args) {
        Browser browser = new Browser();
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        showMenu();
        browser.FirstPage();
        while (isRun) {
            System.out.print("Choose: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Web Name: ");
                    String name = sc.nextLine();
                    if (browser.addLink(name)) {
                        System.out.println("Move to "+name+" Page");
                        System.out.println("Current Page: "+name);
                    }
                    break;

                case 2:
                    System.out.println("Moving Back!");
                    browser.BackPage();
                    browser.showCurrentPage();
                    break;

                case 3:
                    System.out.println("Move Forward!");
                    browser.ForwardPage();
                    browser.showCurrentPage();
                    break;

                case 4:
                    System.out.print("Current Page: ");
                    browser.showCurrentPage();
                    break;

                case 5:
                    System.out.println("History!");
                    browser.showFullHistory(); 
                    break;

                case 6:
                    System.out.println("Thank You Bye!");
                    isRun = false;
                    break;

            }

        }

    }
}
