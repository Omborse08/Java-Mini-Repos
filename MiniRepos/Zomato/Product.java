package Zomato;

class Product {
    private String name;
    private int price;
    private int quantity;
    private int id;

    public Product(String name, int price, int quantity, int id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public void getPros() {
        quantity--;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
