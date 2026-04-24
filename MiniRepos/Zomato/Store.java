package Zomato;
import java.util.*;

class Store {
    private int storeId;
    private String storeName;
    private LinkedList<Product> products = new LinkedList<>();

    public Store(int storeId, String storeName) {
        this.storeId = storeId;
        this.storeName = storeName;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public LinkedList<Product> getProducts() {
        return products;
    }

    public void showProducts() {
        for (int i=0;i< products.size();i++) {
            Product p = products.get(i);
            System.out.println("ID: "+p.getId()+" , Name: "+p.getName()+" , Price: "+p.getPrice()+" , Quantity: "+p.getQuantity());
        }
    }
}
