package OnScreenTest2;

public class Pyramid {
    private Polygon basePolygon;
    private double depth;

    public Pyramid(Polygon basePolygon, double depth){
        this.basePolygon = basePolygon;
        this.depth = depth;
    }

    public double volume(){
        return Prism.volume(this.basePolygon, this.depth)/3.0;
    }

    public void printVolume(){
        System.out.println(volume() + " " + this.basePolygon.getUnitMeasure() + "^3");
    }
}
