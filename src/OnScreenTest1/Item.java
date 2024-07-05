package OnScreenTest1;

public class Item {
    protected String name;
    protected double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double setPrice(double defaultPrice){
        this.price = defaultPrice;
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String toString(){
        return this.name + ": $" + String.format("%.2f", this.price);
    }
}
