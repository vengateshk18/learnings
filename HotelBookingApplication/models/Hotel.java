package HotelBookingApplication.models;

import java.util.List;

public  class Hotel{
    private int ID;
    private static int IdCounter=100;
    private Account account;
    private String name;
    private List<Room> rooms;
    private int GSTNumber;
    private Location location;
    private BankAccount bankAccount;
    private double ratings;

    public Hotel(Account account,String name, Location location, BankAccount bankAccount){
        this.ID=IdCounter++;
        this.name=name;
        this.account=account;
        this.bankAccount=bankAccount;
        this.ratings=1;
    }
    public Hotel(Account account,String name, int GSTNumber, Location location, BankAccount bankAccount){
        this.ID=IdCounter++;
        this.name=name;
        this.account=account;
        this.GSTNumber=GSTNumber;
        this.bankAccount=bankAccount;
        this.ratings=1;
    }

    public int getId(){
        return this.ID;
    }

    public Location getLocation(){
        return this.location;
    }

    public int getGstNumber(){
        return this.GSTNumber;
    }

    public Account getAccount(){
        return this.getAccount();
    }

    public String getLinkedEmail(){
        return this.account.getEmail();
    }

    public String getLinkedPassword(){
        return this.account.getPassword();
    }

    public String getName(){
        return this.name;
    }

    public List<Room> getAllRooms(){
        return this.rooms;
    }

    public BankAccount getBankAccount(){
        return this.bankAccount;
    }

    public double getRatings(){
        return this.ratings;
    }

}
