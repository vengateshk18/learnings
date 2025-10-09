package HotelBookingApplication.models;

import java.time.LocalDateTime;

public class Booking {
    private int ID;
    private static int IdCounter=100;
    private Customer customer;
    private Hotel hotel;
    private PaymentInvoice payment;
    private LocalDateTime date;
    private Integer numberOfPersons;
    private Room room;
    private Integer numberOfdays;

    public Booking(Customer customer, Hotel hotel, PaymentInvoice payment, LocalDateTime date, Integer numOfPersons, Room room, Integer numOfDays){
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

    public PaymentInvoice getPaymentInvoice(){
        return this.payment;
    }

    public LocalDateTime gateDate(){
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

    public String toString(){
        return "Booking ID: "+ID+" \n Customer: "+customer+" \n Hotel: "+hotel+" \n Payment Invoice: "+payment+" \n DateTime: "+date+" \n Number of Persons: "+numberOfPersons+" \n Room: "+room+" \n Number of Days: "+numberOfdays;
    }
}
