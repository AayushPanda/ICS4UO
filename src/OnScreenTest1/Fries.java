package OnScreenTest1;

public class Fries extends Item{
    private String size;
    private boolean hasGravy;
    private boolean hasCheese;

    public Fries(String size, boolean hasGravy, boolean hasCheese){
        super("Fries", 2.0);
        this.size = size;
        this.hasGravy = hasGravy;
        this.hasCheese = hasCheese;
        
        if(hasCheese){
            this.price += 0.5;
        }
        if(hasGravy){
            this.price += 0.5;
        }
        if(size=="Large"){
            this.price += 1.0;
        }
    }

    @Override
    public double setPrice(double defaultPrice){
        this.price = defaultPrice;
        return this.price;
    }

    public String toString(){
        return super.toString() + "\nSize: " + this.size + "\nGravy: " + this.hasGravy + "\nCheese: " + this.hasCheese;
    }

    public boolean getGravyAndCheese(){
        return this.hasCheese&&this.hasGravy;
    }

}
