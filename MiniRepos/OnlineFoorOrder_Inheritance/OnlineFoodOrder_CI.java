class Order {
    private int orderId;
    protected String name;
    protected int price;
    protected int quantity;

    public void setID(int orderId) {
        this.orderId = orderId;
    }
    public int getId() {
        return orderId;
    }

    public Order(int id,String name,int price,int quantity) {
        this.orderId = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
class onlineOrder extends Order {
    int charges = 150;
    public onlineOrder(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }

    public void DisplayOrder() {
        System.out.println("Order Id: "+getId());
        System.out.println("Oder Name: "+name);
        System.out.println("Order Price: "+price);
        System.out.println("Order Quantity: "+quantity);
        System.out.println("Online Method!");
        System.out.println("Charges: "+charges);
        System.out.print("Total Bill: "+Bill());
    }
    public int Bill() {
        return charges+quantity*price;
    }
}

class dineInOrder extends Order {
    int charges = 50;
    public dineInOrder(int id,String name,int price, int quantity) {
        super(id,name,price,quantity);
    }
    public void DisplayOrder() {
        System.out.println("\n\nOrder Id: "+getId());
        System.out.println("Oder Name: "+name);
        System.out.println("Order Price: "+price);
        System.out.println("Order Quantity: "+quantity);
        System.out.println("Dine Method!");
        System.out.println("Charges: "+charges);
        System.out.print("Total Bill: "+Bill());
    }
    public int Bill() {
        return charges+quantity*price;
    }
}
public class OnlineFoodOrder_CI {
    public static void main(String[] args) {
        onlineOrder od = new onlineOrder(18,"Om",500,3);
        od.DisplayOrder();

        dineInOrder dd = new dineInOrder(20,"Ovi",1000,2);
        dd.DisplayOrder();

























//        dineInOrder dc = new dineInOrder();
//        dc.setOrderId(2);
//        dc.setName("Omii");
//        dc.setPrice(500);
//        dc.setQuantity(3);
//
//        System.out.println("\n\n");
//        System.out.println("Order Id: "+dc.getOrderId());
//        System.out.println("Order Name: "+dc.getName());
//        System.out.println("Order Price: "+dc.getPrice());
//        System.out.println("Order Quanitity: "+dc.getQuantity());
//        dc.dineInOrder1();



    }
}
