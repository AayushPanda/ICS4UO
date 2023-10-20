package SmartHomeShell;

public class Bedroom {

    private String name;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    public Bedroom(String name, Wall wall1, Wall wall2, Wall wall3, Wall wall4, Ceiling ceiling, Bed bed, Lamp lamp){
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public Lamp getLamp(){
        return this.lamp;
    }

    public void makeBed(){
        System.out.println("Bedroom: Making bed");
        bed.make();
    }

    // Getters and Setters

    public String getName(){
        return this.name;
    }

    public Wall getWall1(){
        return this.wall1;
    }

    public Wall getWall2(){
        return this.wall2;
    }

    public Wall getWall3(){
        return this.wall3;
    }

    public Wall getWall4(){
        return this.wall4;
    }

    public Ceiling getCeiling(){
        return this.ceiling;
    }

    public Bed getBed(){
        return this.bed;
    }

}