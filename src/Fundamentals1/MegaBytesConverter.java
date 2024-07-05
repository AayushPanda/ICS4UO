package Fundamentals1;

public class MegaBytesConverter {
    public static int printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0){
            return -1;
        }
        System.out.println(kiloBytes + " KB = " + kiloBytes / 1024 + " MB and " + kiloBytes % 1024 + " KB");
        return 0;
    }
}
