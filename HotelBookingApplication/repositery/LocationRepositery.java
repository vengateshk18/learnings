package HotelBookingApplication.repositery;

import HotelBookingApplication.models.Location;
public class LocationRepositery extends Repositery<Integer,Location>{
    @Override
    public void printAllObjects(){
        for(Location lc:getAllObjects().values()){
            System.out.println(lc);
        }
    }
}
