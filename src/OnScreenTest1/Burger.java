package OnScreenTest1;

public class Burger extends Item{
    private String bun;
    private String topping1;
    private String topping2;
    private String topping3;
    private boolean hasCheese;
    private String type;

    public Burger(String type, String bun, String topping1, String topping2, String topping3, boolean hasCheese){
        super("Burger", 4.5);
        this.bun = bun;
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.hasCheese = hasCheese;
        this.type = type;

        if(type=="Chicken"){
            this.price = 5.0;
        } else if (type=="Veggie"){
            this.price = 6.0;
        }
        
        if(hasCheese){this.price += 0.5;}

        if(bun=="Sesame"){
            this.price += 0.25;
        } else if(bun=="Brioche"){
            this.price += 1.0;
        }

    }

    @Override
    public double setPrice(double defaultPrice){
        this.price=defaultPrice;
        return this.price;
    }

    public String toString(){
        return super.toString() + "\nBun: " + this.bun + "\nToppings: " + this.topping1 + ", " + this.topping2 + ", " + this.topping3 + "\nCheese: " + this.hasCheese;
    }

    public String getType(){
        return this.type;
    }
}
