package OnScreenTest2;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5, 0, 0, "cm");
        System.out.print("Area of triangle:");
        triangle.printArea();
        System.out.print("Perimeter of triangle:");
        triangle.printPerimeter();

        Rectangle rectangle = new Rectangle(3, 4, "cm");
        System.out.print("Area of rect: ");
        rectangle.printArea();
        System.out.print("Perimeter of rect: ");
        rectangle.printPerimeter();

        Prism prism = new Prism(rectangle, 5.0);
        System.out.print("Surface area of prism: ");
        prism.printSurfaceArea();
        System.out.print("Volume of prism: ");
        prism.printVolume();

        Pyramid pyramid = new Pyramid(rectangle, 5);
        System.out.print("Volume of pyramid: ");
        pyramid.printVolume();
    }
}
