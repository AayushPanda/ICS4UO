package OnScreenTest1;

public class Order {

    private Item[] items;

    public Order(Item[] items){
        this.items = items;
    }

    public void printOrder(){
        for (Item item : items){
            System.out.println(item.toString() + "\n");
        }
        System.out.print("--------");
        System.out.println("Total cost: $" + String.format("%.2f", calculatePrice()));
    }

    public void printReceipt(){
        this.printOrder();
    }

    public double calculatePrice(boolean combo){
        double totalPrice = 0;
        if(!combo){
            for (Item item : items){
                totalPrice += item.getPrice();
            }
        }
        return totalPrice;
    }

}
