package HotelBookingApplication.models;

import HotelBookingApplication.constants.RoomType;

public class Room {
    private int ID;
    private static int IdCounter;
    private boolean isBooked;
    private RoomType roomType;
    private double price;
    private Hotel hotel;

    public Room(RoomType type, double price, Hotel hotel){
        this.ID=IdCounter++;
        this.isBooked=false;
        this.roomType=type;
        this.price=price;
        this.hotel=hotel;
    }

    public int getId(){
        return this.ID;
    }

    public Boolean getBookingStatus(){
        return this.isBooked;
    }

    public double getPrice(){
        return this.price;
    }

    public Hotel getHotel(){
        return this.hotel;
    }

    public void setStatus(boolean status){
        this.isBooked=status;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public RoomType getRoomType(){
        return this.roomType;
    }

    public String toString(){
        return "Room ID: "+ID+" Is Booked: "+isBooked+" RoomType: "+roomType+" Price: "+price+" \n Hotel: "+hotel; 
    }
    
}
