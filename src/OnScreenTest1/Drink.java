package OnScreenTest1;

public class Drink extends Item{
    private String size;
    private boolean isPremium;

    public Drink(String size, String type){
        super("Drink", 1.5);
        this.size = size;
        this.isPremium = type=="Sparkling Water" || type=="Smoothie";
        if (isPremium){
            this.price += 0.5;
        }
        if (size=="Large"){
            this.price += 1.0;
        }

    }

    @Override
    public double setPrice(double defaultPrice){
        this.price=defaultPrice;
        return price;
    }

    public String toString(){
        return super.toString() + "\nSize: " + this.size + "\nPremium: " + this.isPremium;
    }

    public boolean getIsPremium(){
        return this.isPremium;
    }

    public String getSize(){
        return this.size;
    }
}
