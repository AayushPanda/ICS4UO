package OnScreenTest2;

import java.io.InvalidClassException;
import java.util.Arrays;

public class Triangle extends Polygon{

    private double sideA;
    private double sideB;
    private double sideC;
    private double base;
    private double height;
    private boolean isTriangle = true;

    public Triangle(double sideA, double sideB, double sideC, double base, double height, String unitMeasure){
        super(3, unitMeasure);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideLengths.add(sideA);
        this.sideLengths.add(sideB);
        this.sideLengths.add(sideC);
        this.base = base;
        this.height = height;

        this.isTriangle = testTriangleInequality(sideA, sideB, sideC);
    }

    @Override
    public double area(){
        return area(this.sideA, this.sideB, this.sideC);
    }
    public static double area(double sideA, double sideB, double sideC){
        if(testTriangleInequality(sideA, sideB, sideC)){
            double s = (sideA+sideB+sideC)/2;
            return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
        }
        else{
            return -1;
        }
    }

    public static boolean testTriangleInequality(double sideA, double sideB, double sideC){
        boolean isTriangle = true;
        if(sideA+sideB<=sideC || sideB+sideC<=sideA || sideA+sideC<=sideB){
            isTriangle = false;
        }
        return isTriangle;
    }

    public boolean testTriangleInequality(){
        this.isTriangle = testTriangleInequality(this.sideA, this.sideB, this.sideC);
        return testTriangleInequality(this.sideA, this.sideB, this.sideC);
    }
}
