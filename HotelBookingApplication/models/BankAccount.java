package HotelBookingApplication.models;

public class BankAccount {
    private Integer ID;
    private static int IdCounter;
    private Account account;
    private double balance;

    public BankAccount(Account account, Double balance){
        this.ID=IdCounter++;
        this.account=account;
        this.balance=balance;
    }

    public Integer getId(){
        return this.ID;
    }

    public Account getAccount(){
        return this.account;
    }

    public double getBalance(){
        return this.balance;
    }

    public void addAmount(double amount){
        this.balance+=amount;
    }

    public void detectAmount(double amount){
        this.balance-=amount;
    }

    public String toString(){
        return "Account: "+account+" Balance: "+balance;
    }
}
