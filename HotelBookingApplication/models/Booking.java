package HotelBookingApplication.models;

import java.util.Date;

public class Booking {
    private int ID;
    private static int IdCounter=100;
    private Customer customer;
    private Hotel hotel;
    private Payment payment;
    private Date date;
    private Integer numberOfPersons;
    private Room room;
    private Integer numberOfdays;

    public Booking(Customer customer, Hotel hotel, Payment payment, Date date, Integer numOfPersons, Room room, Integer numOfDays){
        this.ID=IdCounter;
        this.customer=customer;
        this.hotel=hotel;
        this.payment=payment;
        this.date=date;
        this.numberOfPersons=numOfPersons;
        this.room=room;
        this.numberOfdays=numOfDays;
    }

    public int getId(){
        return this.ID;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Hotel getHotel(){
        return this.hotel;
    }

    public Payment getPayment(){
        return this.payment;
    }

    public Date gateDate(){
        return this.date;
    }

    public int getNumberOfPersons(){
        return this.numberOfPersons;
    }

    public Room getRoom(){
        return this.room;
    }

    public int getNumberOfdays(){
        return this.numberOfdays;
    }
}
