package Zomato;
import java.util.*;

class Cart {
    private ArrayList<Product> products = new ArrayList<>();
    private Live live = Live.PENDING;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Live getLive() {
        return live;
    }

    public void setLive(Live live) {
        this.live = live;
    }

    public void addCart(Product product) {
        products.add(product);
    }

    public void viewCart() {
        int total = 0;
        if (products.isEmpty()) {
            System.out.println("            [None]          ");
            return;
        }
        for (int i = 0;i< products.size();i++) {
            System.out.println("Name: "+products.get(i).getName()+" , Price: "+products.get(i).getPrice());
            total += products.get(i).getPrice();
        }
        System.out.println("Total Price: "+total);
        System.out.println("----------------------------------------------");
    }

    public void liveLoc() throws Exception{
        Thread.sleep(1000);
        setLive(Live.ONROAD);
        Thread.sleep(1000);
        setLive(Live.ARRIVE);
    }
}
