package Zomato;
import java.util.*;

class Zomato_Stores_Manager {
    Scanner sc = new Scanner(System.in);
    private HashMap<Integer,Store> stores = new HashMap<>();
    private int StoreId = 101;
    Cart cart = new Cart();


    public void addStore(String name) {
        Store store = new Store(StoreId,name);
        stores.put(store.getStoreId(),store);
        System.out.println("Store Added Successfully!");
        System.out.println("Store ID: "+StoreId);
        StoreId++;
    }

    public void addProductInStore(int id,Product product){
        if (!stores.containsKey(id)) {
            System.out.println("There is No Such Store!");
            return;
        }
        stores.get(id).addProduct(product);
        System.out.println("Product Added Successfully!");
    }

    public void viewProducts() {
        for (int i: stores.keySet()) {
            Store s = stores.get(i);
            if (stores.get(i).getProducts().isEmpty()) {}
            else {
                System.out.println("Store Name: "+s.getStoreName()+"        ID: "+s.getStoreId());
                s.showProducts();
                System.out.println("---------------------------------------------------------------------");
            }
        }
    }

    public void addProductCart(int id) {
        for (int i: stores.keySet()) {
            Store s = stores.get(i);
            for (int j=0;j<s.getProducts().size();j++) {
                if (s.getProducts().get(j).getId() == id) {
                    cart.addCart(s.getProducts().get(j));
                    s.getProducts().get(j).getPros();
                }
                else {
                    System.out.println("No Product Available!");
                }
            }
        }
    }

    public void viewCart() throws Exception {
        cart.viewCart();
        System.out.println("1.Confirmed\n2.Decline");
        System.out.print("Choose: ");
        int choose = sc.nextInt();
        if (choose == 1) {
            cart.liveLoc();
        }
        else {
            System.out.println("Order Cancelled!");
            cart.getProducts().clear();
        }
    }

    public void viewLiveLocation() {
        System.out.println("Delivery Boy Status: "+cart.getLive());
    }

}
