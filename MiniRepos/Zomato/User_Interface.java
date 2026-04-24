package Zomato;
import java.util.*;

public class User_Interface {
    static void showMenu() {
        System.out.println("1.Add Store\n2.Add Product In Store\n3.View Products\n4.Add In Cart\n5.View Cart\n6.Live Location\n7.Exit");
    }
    static void main(String[] args) throws Exception {
        boolean isAppOn = true;
        int P_ID = 1;
        Scanner sc = new Scanner(System.in);
        Zomato_Stores_Manager manager = new Zomato_Stores_Manager();
        showMenu();
        while(isAppOn) {
            System.out.print("Choose Option: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Enter Store Name: ");
                    String storeName = sc.nextLine();
                    manager.addStore(storeName);
                    break;

                case 2:
                    System.out.print("Enter Store Id: ");
                    int store_id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String p_name = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    int p_price = sc.nextInt();
                    System.out.print("Enter Product Quantity: ");
                    int p_quantity = sc.nextInt();
                    Product product = new Product(p_name,p_price,p_quantity,P_ID);
                    manager.addProductInStore(store_id,product);
                    System.out.println("Product ID: "+P_ID);
                    P_ID++;
                    break;

                case 3:
                    System.out.println("============== Available Products ==============");
                    manager.viewProducts();
                    break;

                case 4:
                    System.out.print("Enter Product Id: ");
                    int id = sc.nextInt();
                    manager.addProductCart(id);
                    break;

                case 5:
                    System.out.println("=============== Products In Cart ===============");
                    manager.viewCart();
                    break;

                case 6:
                    manager.viewLiveLocation();
                    break;

                case 7:
                    System.out.println("Thank You For Using Zomato!");
                    isAppOn = false;
                    break;
            }
        }
    }
}
