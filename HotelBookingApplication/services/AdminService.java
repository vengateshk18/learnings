package HotelBookingApplication.services;

import HotelBookingApplication.models.City;
import HotelBookingApplication.repositery.DataBase;

public class AdminService {
    private DataBase dataBase;

    public AdminService(DataBase dataBase){
        this.dataBase=dataBase;
    }

    public void addCity(String cityName, String stringDescription){
        City city=new City(cityName, stringDescription);
        this.dataBase.cityRepositery.addObject(city.getId(), city);
    }

    public void addCity(String cityName){
        City city=new City(cityName);
        this.dataBase.cityRepositery.addObject(city.getId(), city);
    }

    public void removeCity(String cityName){
        City city=this.dataBase.cityRepositery.searchCityByName(cityName);
        this.dataBase.cityRepositery.removeIfAvailable(city.getId());
    }

    public void renameCity(String currName, String newName){
        City city=this.dataBase.cityRepositery.searchCityByName(currName);
        city.setName(newName);
    }
}
