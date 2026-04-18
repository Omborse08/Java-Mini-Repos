package Instagram;

import java.util.*;

public class Instagram {
    static void showMenu(){
        System.out.println("1.Add User\n2.Post\n3.View Public Post\n4.Post By User\n5.Exit");
    }
    static void main(String[] args) {
        int UserID = 1;
        Scanner sc = new Scanner(System.in);
        Instagram_Manager manager = new Instagram_Manager();
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int choice;
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong choice");
                return;
            }
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter User Name: ");
                    String userName = sc.nextLine();
                    User user = new User(userName,UserID);
                    manager.addUser(user);
                    System.out.println("User has been added successfully");
                    System.out.println("User ID: " + UserID);
                    UserID++;
                    break;

                case 2:
                    System.out.print("Enter Public Post By: ");
                    int postBy;
                    try {
                        postBy = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Wrong ID");
                        return;
                    }
                    sc.nextLine();
                    System.out.print("Enter Post Here: ");
                    String postHere = sc.nextLine();
                    if (manager.addPost(postBy,postHere)) {
                        System.out.println("Post added successfully!");
                    } else  {
                        System.out.println("Post could not be added!");
                    }
                    break;

                case 3:
                    System.out.println("All Posts By Users");
                    manager.ViewPosts();
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int userID;
                    try {
                        userID = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Wrong ID");
                        return;
                    }
                    manager.PostByUser(userID);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    isRunning = false;
                    break;
            }
        }
    }
}
