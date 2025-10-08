package HotelBookingApplication.models;

import java.util.*;

public class City {
    private int ID;
    private static int IdCounter=100;
    private List<Hotel> hotels;
    private String cityName;
    private String cityDescription;

    public City(String cityName, String cityDescription){
        this.ID=IdCounter++;
        this.hotels=new ArrayList<Hotel>();
        this.cityName=cityName;
        this.cityDescription=cityDescription;
    }

    public City(String cityName){
        this.ID=IdCounter++;
        this.hotels=new ArrayList<Hotel>();
        this.cityName=cityName;
        this.cityDescription=null;
    }

    public int getId(){
        return this.ID;
    }

    public List<Hotel> getHotel(){
        return this.hotels;
    }

    public String getCityName(){
        return this.cityName;
    }

    public String getCityDescription(){
        return this.cityDescription;
    }

    public void setName(String name){
        this.cityName=name;
    }


    public void addHotel(Hotel hotel){
        this.hotels.add(hotel);
    }
}
