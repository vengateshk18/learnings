package HotelBookingApplication.models;

public class BankAccount {
    private Integer ID;
    private static int IdCounter;
    private Account account;
    private double balace;

    public BankAccount(Account account, Double balance){
        this.ID=IdCounter++;
        this.account=account;
        this.balace=balace;
    }

    public Integer getId(){
        return this.ID;
    }

    public Account getAccount(){
        return this.account;
    }

    public double getBalance(){
        return this.balace;
    }

    public void addAmount(double amount){
        this.balace+=amount;
    }

    public void detectAmount(double amount){
        this.balace-=amount;
    }
}
