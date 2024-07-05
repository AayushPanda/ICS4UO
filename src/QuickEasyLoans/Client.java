package QuickEasyLoans;

import java.lang.Math;


public class Client{
    private String firstName;
    private String lastName;
    private String clientID;
    private LLQueue<Purchase> debtQueue;

    public Client(String firstName, String lastName, String clientID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientID = clientID;
        this.debtQueue = new LLQueue<Purchase>();
    }

    public void advanceDays(int days, double interestRate) {
        LLQueue<Purchase> temp = new LLQueue<Purchase>();
        while (!this.debtQueue.isEmpty()) {
            Purchase p = this.debtQueue.remove();
            double d = (double) p.getCurrentDebt();
            d *= Math.pow((1 + interestRate), days);
            p.setCurrentDebt(d);
            temp.add(p);    
        }        
        this.debtQueue = temp;
    }

    public void clearPurchase(){
        this.debtQueue.remove();
    }

    public void addPurchase(Purchase p){
        this.debtQueue.add(p);
    }

    public void addPurchase(String purchaseName, double principal, String purchaseDate){
        this.debtQueue.add(new Purchase(purchaseName, principal, purchaseDate));
    }

    public double getDebt(){
        try{
            return this.debtQueue.getHead().getObject().getCurrentDebt();
        } catch (NullPointerException e){
            return 0.00;
        }
            
    }

    public Purchase getCurrentPurchase(){
        return this.debtQueue.getHead().getObject();
    }

}
