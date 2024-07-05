package OnScreenTest2;

public class Rectangle extends Polygon {

    private double length;
    private double width;

    public Rectangle(double length, double width, String unitMeasure){
        super(4, unitMeasure);
        this.length = length;
        this.width = width;
        this.sideLengths[0] = length;
        this.sideLengths[1] = width;
        this.sideLengths[2] = length;
        this.sideLengths[3] = width;
    }

    @Override
    public double area(){
        return this.length*this.width;
    }
}
