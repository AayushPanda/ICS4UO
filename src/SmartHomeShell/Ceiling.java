package SmartHomeShell;

public class Ceiling {

    private int height;
    private int paintedColor;

    public Ceiling(int height, int paintedColor){
        this.height = height;
        this.paintedColor = paintedColor;
    }

    // Getters and Setters

    public int getHeight(){
        return this.height;
    }

    public int getPaintedColor(){
        return this.paintedColor;
    }

}