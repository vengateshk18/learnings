package HotelBookingApplication.repositery;

import HotelBookingApplication.models.Account;
import HotelBookingApplication.models.Hotel;

public class HotelRepositery extends Repositery<Integer,Hotel>{
    @Override
    public void printAllObjects(){
        for(Hotel hotel:getAllObjects().values()){
            System.out.println(hotel);
        }
    }

    public Hotel getHotelByAccount(Account account){
        for(Hotel customer:getAllObjects().values()){
            if(customer.getAccount()==account){
                return customer;
            }
        }
        return null;
    }
}
