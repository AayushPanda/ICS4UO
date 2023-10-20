package OnScreenTest2;


public class Polygon {
    private int sides;
    protected double[] sideLengths;
    private String unitMeasure;

    public Polygon(int sides, String unitMeasure){
        this.sides = sides;
        this.unitMeasure = unitMeasure;
        this.sideLengths = new double[sides];
    }


    public double area(){
        return -1;
    }

    public double perimeter(){
        double perimeter = 0;
        for(Double sideLength : this.sideLengths){
            perimeter += sideLength;
        }
        return perimeter;
    }

    public void printArea(){
        System.out.println(area() + " " + this.unitMeasure + "^2");
    }

    public void printPerimeter(){
        System.out.println(perimeter() + " " + this.unitMeasure);
    }

    public double[] getSideLengths(){
        return sideLengths;
    }

    public String getUnitMeasure(){
        return this.unitMeasure;
    }

}

