package HotelBookingApplication.repositery;

import HotelBookingApplication.models.City;

public class CityRepositery extends Repositery<Integer,City>{
    @Override
    public void printAllObjects(){
        for(City ct:getAllObjects().values()){
            System.out.println(ct);
        }
    }

    public City searchCityByName(String cityName){
        for(City ct:getAllObjects().values()){
            if(ct.getCityName().toLowerCase().equals(cityName)){
                return ct;
            }
        }
        return null;
    }
}
