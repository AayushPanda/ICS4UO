package OOP1;

public class PhoneNumber {
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }
    
    public String toString() {
        return String.format("(%d) %d-%d", areaCode, prefix, lineNumber);
    }
}