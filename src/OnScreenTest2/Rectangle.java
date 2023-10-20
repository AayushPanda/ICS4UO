package OnScreenTest2;

public class Rectangle extends Polygon {

    private double length;
    private double width;

    public Rectangle(double length, double width, String unitMeasure){
        super(4, unitMeasure);
        this.length = length;
        this.width = width;
        this.sideLengths.add(length);
        this.sideLengths.add(width);
        this.sideLengths.add(length);
        this.sideLengths.add(width);
    }

    @Override
    public double area(){
        return this.length*this.width;
    }
}
