package QuickEasyLoans;


public class Purchase {
    private String purchaseName;
    private double principal;
    private double currentDebt;
    private String purchaseDate;
    
    public Purchase(String purchaseName, double principal, String purchaseDate){
        this.purchaseName = purchaseName;
        this.principal = principal;
        this.currentDebt = principal;
        this.purchaseDate = purchaseDate;
    }

    public String toString(){
        String principalString = String.format("%.2f", this.principal);
        String currentDebtString = String.format("%.2f", this.currentDebt);
        return "Purchase Name: " + this.purchaseName + "\nPrincipal: $" + principalString + "\nCurrent Debt: $" + currentDebtString + "\nPurchase Date: " + this.purchaseDate + "\n";
    }

    // Getters
    public String getPurchaseName() {
        return purchaseName;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getCurrentDebt() {
        return currentDebt;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    // Setters
    public void setCurrentDebt(double currentDebt) {
        this.currentDebt = currentDebt;
    }

}
