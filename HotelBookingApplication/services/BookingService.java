package HotelBookingApplication.services;

import HotelBookingApplication.constants.PaymentStatus;
import HotelBookingApplication.constants.PaymentType;
import HotelBookingApplication.constants.RoomType;
import HotelBookingApplication.models.Customer;
import HotelBookingApplication.models.Hotel;
import HotelBookingApplication.models.PaymentInvoice;
import HotelBookingApplication.models.Room;
import HotelBookingApplication.repositery.DataBase;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import HotelBookingApplication.models.Booking;

public class BookingService {
    private DataBase dataBase;

    public BookingService(DataBase dataBase){
        this.dataBase=dataBase;
    }

    public String bookHotelRoom(Integer HotelId, Customer customer, RoomType roomType,PaymentType paymentType, int numberOfPersons, int numberOfDays){
        Hotel bookingHotel=this.dataBase.hotelRepositery.getObject(HotelId);
        if(bookingHotel==null){
            return "Hotel Can't be Identified, Please try different Hotel";
        }
        Room bookingRoom=bookingHotel.getAvailableRoomBasedOnType(roomType);
        if(bookingRoom==null){
            return "Hotel Room is not available, try diferrent room";
        }
        Double perDayPrice=bookingRoom.getPrice();
        Double totalPrice=perDayPrice*numberOfDays;
        LocalDateTime datetime=LocalDateTime.now();
        PaymentService paymentService=new PaymentService(this.dataBase);
        PaymentFactory factory=new PaymentFactory();
        PaymentInvoice invoice=paymentService.initiatePayment(customer, bookingHotel,PaymentFactory.createPayment(paymentType, customer.getBankAccount()), totalPrice);
        Booking booking=new Booking(customer, bookingHotel, invoice, datetime, numberOfPersons, bookingRoom, numberOfDays);
        this.dataBase.bookingRepositery.addObject(booking.getId(), booking);
        this.dataBase.paymentRepositery.addObject(invoice.getId(), invoice);
        if(invoice.getStatus()==PaymentStatus.SUCCESS){
            return "Room Booked"+" Invoice: "+invoice;
        }
        bookingRoom.setStatus(true);
        return "Room Not Booked"+invoice;
    }


    public List<Booking> getAllBookings(Customer customer){
        List<Booking> bookings=new ArrayList<>();

        for(Booking booking:dataBase.bookingRepositery.getAllObjects().values()){
            if(booking.getCustomer()==customer){
                bookings.add(booking);
            }
        }
        return bookings;

    }

    public boolean cancelBooking(Customer customer, Integer bookingId){
        Booking bookings=null;
        for(Booking booking:dataBase.bookingRepositery.getAllObjects().values()){
            if(booking.getId()==bookingId && booking.getCustomer()==customer){
                bookings=booking;
            }
        }
        if(bookings==null){
            return false;
        }
        dataBase.bookingRepositery.removeIfAvailable(bookingId);
        return true;
        
    }
}
