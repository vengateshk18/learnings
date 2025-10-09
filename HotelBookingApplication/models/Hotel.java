package HotelBookingApplication.models;

import java.util.ArrayList;
import java.util.List;

import HotelBookingApplication.constants.RoomType;

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
        this.location=location;
        this.rooms=new ArrayList<>();
    }
    public Hotel(Account account,String name, int GSTNumber, Location location, BankAccount bankAccount){
        this.ID=IdCounter++;
        this.name=name;
        this.account=account;
        this.GSTNumber=GSTNumber;
        this.bankAccount=bankAccount;
        this.ratings=1;
        this.location=location;
        this.rooms=new ArrayList<>();
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
        return this.account;
    }

    public String getLinkedEmail(){
        return this.account.getEmail();
    }

    public void addRoom(Room room){
        this.rooms.add(room);
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

    public String toString(){
        return "Hotel Id: "+ID+" Hotel Name: "+this.name+" \n Account: "+account+" \n GST Number: "+getGstNumber()+" \n Location: "+location+" \n Bank Account: "+bankAccount+" Rating: \n"+ratings;
    }

    public double getPriceForRoomType(RoomType type){
        for(Room room:this.rooms){
            if(room.getRoomType()==type){
                return room.getPrice();
            }
        }
        return -1;
    }

    public Room getAvailableRoomBasedOnType(RoomType type){
        for(Room room:this.rooms){
            if(room.getRoomType()==type && room.getBookingStatus()==false){
                return room;
            }
        }
        return null;
    }

}
