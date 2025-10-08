package HotelBookingApplication.models;

public class Admin {
    private Integer ID;
    private int IdCounter=100;
    private Account account;

    public Admin(Account account){
        this.ID=IdCounter++;
        this.account=account;
    }

    public Integer getId(){
        return this.ID;
    }

    public Account getAccount(){
        return this.account;
    }

}
