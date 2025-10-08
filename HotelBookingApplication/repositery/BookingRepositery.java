package HotelBookingApplication.repositery;

import HotelBookingApplication.models.Booking;

public class BookingRepositery extends Repositery<Integer,Booking>{
    @Override
    public void printAllObjects(){
        for(Booking bc:getAllObjects().values()){
            System.out.println(bc);
        }
    }
}
