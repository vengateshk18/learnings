package HotelBookingApplication.repositery;

import HotelBookingApplication.models.Room;
public class RoomRepositery extends Repositery<Integer,Room>{
    @Override
    public void printAllObjects(){
        for(Room room:getAllObjects().values()){
            System.out.println(room);
        }
    }
}
