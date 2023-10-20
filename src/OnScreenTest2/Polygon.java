package OnScreenTest2;

import java.util.ArrayList;

public class Polygon {
    private int sides;
    private String unitMeasure;
    protected ArrayList<Double> sideLengths = new ArrayList<Double>();


    public Polygon(int sides, String unitMeasure){
        this.sides = sides;
        this.unitMeasure = unitMeasure;
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
        double[] sideLengths = new double[3];
        for(int i = 0; i < 3; i++){
            sideLengths[i] = this.sideLengths.get(i);
        }
        return sideLengths;
    }

    public String getUnitMeasure(){
        return this.unitMeasure;
    }

}

