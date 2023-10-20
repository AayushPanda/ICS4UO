package OnScreenTest1;

public class main {
    public static void main(String[] args) {
        Order order = new Order(new Item[]{
            new Drink("Large", "Sparkling Water"),
            new Fries("Large", true, true),
            new Drink("Small", "Smoothie"),
            new Fries("Small", false, false)
        });

        order.printOrder();
        
    }
}
