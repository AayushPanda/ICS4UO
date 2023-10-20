package OnScreenTest2;

public class Prism {
    private Polygon basePolygon;
    private double depth;

    public Prism(Polygon basePolygon, double depth){
        this.basePolygon = basePolygon;
        this.depth = depth;
    }

    public static double surfaceArea(Polygon basePolygon, double depth){
        double area = 0;
        area += 2*basePolygon.area()*2;
        for(Double sideLength : basePolygon.getSideLengths()){
            area += sideLength*depth;
        }
        return area;
    }

    public double surfaceArea(){
        return surfaceArea(this.basePolygon, this.depth);
    }

    public static double volume(Polygon basePolygon, double depth){
        return basePolygon.area()*depth;
    }

    public double volume(){
        return volume(this.basePolygon, this.depth);
    }

    public void printSurfaceArea(){
        System.out.println(surfaceArea() + " " + this.basePolygon.getUnitMeasure() + "^2");
    }

    public void printVolume(){
        System.out.println(volume() + " " + this.basePolygon.getUnitMeasure() + "^3");
    }

}
