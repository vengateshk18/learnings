package HotelBookingApplication.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Integer ID;
    private static int IdCounter=100;
    private Account account;
    private String aadhar;
    private List<Booking> bookings;
    private BankAccount bankAccount;

    public Customer(Account account, String aaadhar,BankAccount bankAccount){
        this.ID=IdCounter;
        this.aadhar=aaadhar;
        this.bookings=new ArrayList<>();
        this.account=account;
        this.bankAccount=bankAccount;
    }

    public Customer(Account account,BankAccount bankAccount){
        this.ID=IdCounter;
        this.aadhar=null;
        this.bookings=new ArrayList<>();
        this.account=account;
    }

    public Integer getId(){
        return this.ID;
    }

    public Account getAccount(){
        return this.account;
    }

    public String getAadhar(){
        return this.aadhar;
    }

    public List<Booking> getAllBookings(){
        return this.bookings;
    }

    public BankAccount getBankAccount(){
        return this.bankAccount;
    }

    public String toString(){
        return "Customer ID: "+ID+" \n Account: "+account+" \n Aadhar: "+aadhar+" \n Bank Account"+bankAccount;
    }
}

